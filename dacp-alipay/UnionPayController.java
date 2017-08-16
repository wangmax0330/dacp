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

import com.manzz.dtdp.domain.PsRefund;
import com.manzz.dtdp.module.ps.service.PsOrderDetailService;
import com.manzz.dtdp.module.ps.service.PsRefundService;
import com.manzz.dtdp.module.ps.service.PsSerialService;
import com.unionpay.acp.sdk.SDKConstants;
import com.unionpay.acp.sdk.SDKUtil;

/**
 * 功能：银联异步消息接口
 * @author WJK
 * @version:2015-04
 */
@Controller
public class UnionPayController {
    
    private static transient Log logger = LogFactory.getLog(UnionPayController.class);
    @Autowired
    private PsSerialService serialService;
    @Autowired
    private PsOrderDetailService orderDetailService;
    @Autowired
    private PsRefundService refundService;
    
    /** 
     * 功能：接收并处理银联服务器异步推送的交易通知
     * @throws IOException 
     */
    @RequestMapping(value = "/unionpay_trade_notify", method = {RequestMethod.POST})
    public void tradeNodify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取银联POST过来异步通知信息
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
        String payCode = params.get(SDKConstants.param_orderId);
        //查询号
        String tradeCode = params.get(SDKConstants.param_queryId);
        //交易状态(应答码)
        String respCode = params.get(SDKConstants.param_respCode);
        //请求编码
        String encoding = params.get(SDKConstants.param_encoding);
        String watchParam = ("payCode="+payCode+" respCode="+respCode);
        
        if(SDKUtil.validate(params, encoding)){// 服务器签名验证成功
            if ("00".equals(respCode)) {
                // 交易处理成功
                logger.debug("交易成功！"+watchParam);
                orderDetailService.updateOrderDetailStatus(payCode, tradeCode);
            } else {
                logger.debug("交易尚未完成！"+watchParam);
            }
        }else{// 服务器签名验证失败
            //记录日志，后台不做数据变更处理
            logger.error("非法请求！"+watchParam);
        }
    }
    
    /** 
     * 功能：接收并处理银联服务器异步推送的退款通知
     * @throws IOException 
     */
    @RequestMapping(value = "/unionpay_refund_notify", method = {RequestMethod.POST})
    public void refundNodify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        logger.warn("接收到异步退款通知");
        
        //获取银联POST过来反馈信息
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
        String payCode = params.get(SDKConstants.param_orderId);
//        //查询号
//        String tradeCode = params.get(SDKConstants.param_origQryId);
        //交易状态(应答码)
        String respCode = params.get(SDKConstants.param_respCode);
        //请求编码
        String encoding = params.get(SDKConstants.param_encoding);
        String watchParam = ("payCode="+payCode+" respCode="+respCode);
        if(SDKUtil.validate(params, encoding)){// 服务器签名验证成功
            if ("00".equals(respCode)) {
                // 交易处理成功
                logger.debug("退款成功！"+watchParam);
                //退款查询号
                String batchNo = params.get(SDKConstants.param_queryId);
                PsRefund refund = new PsRefund();
                refund.setBatchNo(batchNo);
                refund.setSuccessNum(1);
                refund.setResultDetails("");
                logger.debug("退款完成！batch_no="+batchNo);

                refundService.doRefund(refund);

                //通知银联程序,验证成功
                response.getWriter().println("success"); 
            } else {
                logger.debug("交易尚未完成！"+watchParam);
            }
        }else{
            //通知银联程序,验证失败
            logger.error("非法请求！");
            
            //通知银联程序,验证失败
            response.getWriter().println("fail");
        }
    }
}
