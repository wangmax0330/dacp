package com.manzz.dtdp.common.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.util.AlipayNotify;
import com.manzz.dtdp.domain.PsRefund;
import com.manzz.dtdp.module.ps.service.PsOrderDetailService;
import com.manzz.dtdp.module.ps.service.PsRefundService;

/**
 * 功能：支付宝异步消息接口
 * @author WJK
 * @version:2015-02
 */
@Controller
public class AlipayController {
    
    private static transient Log logger = LogFactory.getLog(AlipayController.class);
    @Autowired
    private PsOrderDetailService orderDetailService;
    @Autowired
    private PsRefundService refundService;
    
    /** 
     * 功能：接收并处理支付宝服务器异步推送的交易通知
     * @throws IOException 
     */
    @RequestMapping(value = "/alipay_notify", method = {RequestMethod.POST})
    public void tradeNodify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            
            logger.debug("name="+name+" valueStr="+valueStr);
            params.put(name, valueStr);
        }

        //商户订单号
        String payCode = params.get("out_trade_no");
        //支付宝交易号
        String tradeCode = params.get("trade_no");
        //交易状态
        String tradeStatus = params.get("trade_status");
        String watchParam = ("payCode="+payCode+" tradeCode="+tradeCode+" tradeStatus="+tradeStatus);
        if(AlipayNotify.verifyTrade(params)){//验证支付宝发出的交易消息的合法性
            if ("TRADE_SUCCESS".equals(tradeStatus)){
                logger.debug("交易成功！"+watchParam);
                orderDetailService.updateOrderDetailStatus(payCode, tradeCode);
            }else{
                logger.debug("交易尚未完成！"+watchParam);
            }

            //通知支付宝程序,验证成功
            response.getWriter().println("success"); 
        }else{
            //记录日志，后台不做数据变更处理
            logger.error("非法请求！"+watchParam);
            //通知支付宝程序,验证失败
            response.getWriter().println("fail");
        }
    }
    
    /** 
     * 功能：接收并处理支付宝服务器异步推送的退款通知
     * @throws IOException 
     */
    @RequestMapping(value = "/alipay_refund_notify", method = {RequestMethod.POST})
    public void refundNodify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        logger.warn("接收到异步退款通知");
        
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            
            logger.debug("name="+name+" valueStr="+valueStr);
            params.put(name, valueStr);
        }
        if(AlipayNotify.verifyRefund(params)){
            //退款批次号
            String batchNo = new String(request.getParameter("batch_no"));
            //退款成功总数
            String successNum = new String(request.getParameter("success_num"));
            /*
             * 退款结果明细,单条数据格式：：交易号^退款金额^处理结果$退费账号^退费账户ID^退费金额^处理结果，多条数据以#分隔
             * "2015021006250066^0.01^SUCCESS$yayaxueche@manzz.com^2088411586220692^0.00^SUCCESS#2015021006152966^0.01^SUCCESS$yayaxueche@manzz.com^2088411586220692^0.00^SUCCESS";
             */
            String resultDetails = new String(request.getParameter("result_details"));
            PsRefund refund = new PsRefund();
            refund.setBatchNo(batchNo);
            refund.setSuccessNum(Integer.parseInt(successNum));
            refund.setResultDetails(resultDetails);
            logger.debug("退款完成！batch_no="+batchNo+" success_num="+successNum+" result_details"+resultDetails);

            refundService.doRefund(refund);

            //通知支付宝程序,验证成功
            response.getWriter().println("success"); 
        }else{
            //通知支付宝程序,验证失败
            logger.error("请求验证失败！");
            
            //通知支付宝程序,验证失败
            response.getWriter().println("fail");
        }
    }
}
