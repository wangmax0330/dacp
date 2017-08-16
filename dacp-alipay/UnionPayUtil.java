package com.manzz.framework.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.manzz.dtdp.common.iconstants.IDtdpConstants;
import com.manzz.framework.core.common.Constants;
import com.unionpay.acp.sdk.HttpClient;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKConstants;
import com.unionpay.acp.sdk.SDKUtil;

/**
 * 功能：银联接口工具类 
 * @author WJK
 * @version 2015-04-22
 */
public class UnionPayUtil {
    private static transient Log logger = LogFactory.getLog(UnionPayUtil.class);
    /** 编号 */
    public final static String ENCODING = Constants.DEFAULT_WEB_ENCODING;
    /** 银联接口版本 */
    public final static String VERSION = "5.0.0";
    /** 商户号 */
    public final static String MERCHANT_ID = CommonUtils.readResource("unionpay.merchant.id");
    /** 支付超时时间，单位毫秒 N1..10 */
    public final static int ORDER_TIMEOUTE = IDtdpConstants.ORDER_DETAIL_EXPIRE_TIME * 1000;
    
//  /** 前台通知URL */
//  public static String FRONT_URL = CommonUtils.readResource("unionpay.front.url");
    /** 交易后台通知URL */
    public final static String TRADE_BACK_URL = CommonUtils.readResource("unionpay.trade.back.url");
    /** 交易撤销通知URL */
    public final static String CANCEL_BACK_URL = CommonUtils.readResource("unionpay.cancel.back.url");
    /** 退款后台通知URL */
    public final static String REFUND_BACK_URL = CommonUtils.readResource("unionpay.refund.back.url");
    
    /**
     * 功能: 获取银联请求的基本封装参数
     * @param payCode 订单号(8-40位数字字母)
     * @param txnAmt  交易金额（单位：分）
     * @return
     */
    private static Map<String, String> getBasicParamMap(String payCode,Integer txnAmt){
        Map<String, String> param = new HashMap<String, String>();
        // 商户订单号，8-40位数字字母
        param.put("orderId", payCode);
        // 交易金额，单位分
        //param.put("txnAmt", txnAmt.toString());
        // TODO 配合测试，暂定所有交易仅需1分钱！！！！！！！！！！！！！！
        param.put("txnAmt", "1");
        // 版本号
        param.put("version", VERSION);
        // 字符集编码 默认"UTF-8"
        param.put("encoding", ENCODING);
        // 商户号码
        param.put("merId", MERCHANT_ID);
        // 签名方法 01 RSA
        param.put("signMethod", "01");
        // 业务类型 000201-B2C网关支付
        param.put("bizType", "000201");
        // 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
        param.put("accessType", "0");
        // 交易币种，默认取值：156（人民币）
        param.put("currencyCode", "156");
        // 渠道类型，07-PC，08-手机
        param.put("channelType", "08");
        // 订单发送时间，取系统时间
        param.put("txnTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        return param;
    }
    
    /**
     * 功能: 获取银联TN号
     * @param payCode 订单号(8-40位数字字母)
     * @param txnAmt  交易金额（单位：分）
     * @return
     */
    public static String getUnionPayTN(String payCode,Integer txnAmt) {
        Map<String, String> data = getBasicParamMap(payCode, txnAmt);
        // 后台通知地址
        data.put("backUrl", TRADE_BACK_URL);
        // 支付超时时间
        data.put("payTimeout", DateUtils.toFormatDateString(DateUtils.addSeconds(new Date(), ORDER_TIMEOUTE), "yyyyMMddHHmmss"));
        // 交易类型 01-消费
        data.put("txnType", "01");
        // 交易子类型 01:自助消费 02:订购 03:分期付款
        data.put("txnSubType", "01");
        // 订单描述，可不上送，上送时控件中会显示该信息
        // data.put("orderDesc", "订单描述");
        data = signData(data);
        // 交易请求url 从内存读取 #see com.manzz.dtdp.common.cache.Cache --> method init()
        Map<String, String> resmap = submitUrl(data, SDKConfig.getConfig().getAppRequestUrl());
        return resmap == null ? "" : resmap.get(SDKConstants.param_tn);
    }
    
    /**
     * 功能: 消费撤销(当天全额)
     * @param tradeCode 银联系统查询号
     * @param txnAmt  交易金额（单位：分）
     * @return 是否执行成功
     */
    @Deprecated
    public static boolean undoConsume(String tradeCode,Integer txnAmt){
        //商户订单号，8-40位数字字母，重新产生，不同于原消费
        String payCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Map<String, String> data = getBasicParamMap(payCode, txnAmt);
        // 交易类型 31-交易撤销
        data.put("txnType", "31");
        // 交易子类型 
        data.put("txnSubType", "00");
        // 后台通知地址
        data.put("backUrl", CANCEL_BACK_URL);
        //原消费的queryId，可以从查询接口或者通知接口中获取
        data.put("origQryId", tradeCode);

        data = signData(data);
        
        // 交易请求url 从内存读取 #see com.manzz.dtdp.common.cache.Cache --> method init()
        Map<String, String> resmap = submitUrl(data, SDKConfig.getConfig().getBackRequestUrl());
        return resmap == null ? false : "00".equals(resmap.get(SDKConstants.param_respCode));
    }
    
    /**
     * 功能: 发起退款申请(可隔天，可多次退，金额不能大于原金额)
     * @param tradeCode 银联系统查询号
     * @param txnAmt  交易金额（单位：分）
     * @return 是否执行成功
     */
    public static boolean applyRefund(String tradeCode,Integer txnAmt) {
        //商户订单号，8-40位数字字母，重新产生，不同于原消费
        String payCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Map<String, String> data = getBasicParamMap(payCode, txnAmt);
        // 后台通知地址
        data.put("backUrl", REFUND_BACK_URL);
        // 交易类型 
        data.put("txnType", "04");
        // 交易子类型 
        data.put("txnSubType", "00");
        //原消费的queryId，可以从查询接口或者通知接口中获取
        data.put("origQryId", tradeCode);

        data = signData(data);

        // 交易请求url 从内存读取 #see com.manzz.dtdp.common.cache.Cache --> method init()
        Map<String, String> resmap= submitUrl(data, SDKConfig.getConfig().getBackRequestUrl());
        return resmap == null ? false : "00".equals(resmap.get(SDKConstants.param_respCode));
    }
    
    /**
     * 构造HTTP POST交易表单的方法示例
     * @param action 表单提交地址
     * @param hiddens 以MAP形式存储的表单键值
     * @return 构造好的HTTP POST交易表单
     */
    public static String createHtml(String action, Map<String, String> hiddens) {
        StringBuffer sf = new StringBuffer();
        sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>");
        sf.append("<form id = \"pay_form\" action=\"" + action + "\" method=\"post\">");
        if (null != hiddens && 0 != hiddens.size()) {
            Set<Entry<String, String>> set = hiddens.entrySet();
            Iterator<Entry<String, String>> it = set.iterator();
            while (it.hasNext()) {
                Entry<String, String> ey = it.next();
                String key = ey.getKey();
                String value = ey.getValue();
                sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + value + "\"/>");
            }
        }
        sf.append("</form>");
        sf.append("</body>");
        sf.append("<script type=\"text/javascript\">");
        sf.append("document.all.pay_form.submit();");
        sf.append("</script>");
        sf.append("</html>");
        return sf.toString();
    }

    /**
     * java main方法 数据提交 　　 对数据进行签名
     * @param contentData
     * @return　签名后的map对象
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> signData(Map<String, ?> contentData) {
        Entry<String, String> obj = null;
        Map<String, String> submitFromData = new HashMap<String, String>();
        for (Iterator<?> it = contentData.entrySet().iterator(); it.hasNext();) {
            obj = (Entry<String, String>) it.next();
            String value = obj.getValue();
            if (StringUtils.isNotBlank(value)) {
                // 对value值进行去除前后空处理
                submitFromData.put(obj.getKey(), value.trim());
                logger.debug(obj.getKey() + "-->" + String.valueOf(value));
            }
        }
        /** 签名  */
        SDKUtil.sign(submitFromData, ENCODING);

        return submitFromData;
    }

    /**
     * java main方法 数据提交 提交到后台
     * @param contentData
     * @return 返回报文 map
     */
    public static Map<String, String> submitUrl(Map<String, String> submitFromData, String requestUrl) {
        String resultString = "";
        logger.debug("requestUrl====" + requestUrl);
        logger.debug("submitFromData====" + submitFromData.toString());
        /**
         * 发送
         */
        HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
        try {
            int status = hc.send(submitFromData, ENCODING);
            if (200 == status) {
                resultString = hc.getResult();
            }else{
                logger.error("status========="+status+" message========="+hc.getResult());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        Map<String, String> resData = new HashMap<String, String>();
        /**
         * 验证签名
         */
        if (null != resultString && !"".equals(resultString)) {
            // 将返回结果转换为map
            resData = SDKUtil.convertResultStringToMap(resultString);
            if (SDKUtil.validate(resData, ENCODING)) {
                logger.debug("验证签名成功");
            } else {
                logger.debug("验证签名失败");
            }
            // 打印返回报文
            logger.debug("打印返回报文：" + resultString);
        }
        return resData;
    }

    /**
     * java main方法 数据提交　 数据组装进行提交 包含签名
     * @param contentData
     * @return 返回报文 map
     */
    public static Map<String, String> submitData(Map<String, ?> contentData, String requestUrl) {
        Map<String, String> submitFromData = (Map<String, String>) signData(contentData);
        return submitUrl(submitFromData, requestUrl);
    }

//    /**
//     * 解析返回文件
//     */
//    public static void deCodeFileContent(Map<String, String> resData) {
//        // 解析返回文件
//        String fileContent = resData.get(SDKConstants.param_fileContent);
//        if (null != fileContent && !"".equals(fileContent)) {
//            try {
//                byte[] fileArray = SecureUtil.inflater(SecureUtil.base64Decode(fileContent.getBytes(ENCODING)));
//                String root = "D:\\";
//                String filePath = null;
//                if (SDKUtil.isEmpty(resData.get("fileName"))) {
//                    filePath = root + File.separator + resData.get("merId") + "_" + resData.get("batchNo") + "_" + resData.get("txnTime") + ".txt";
//                } else {
//                    filePath = root + File.separator + resData.get("fileName");
//                }
//                File file = new File(filePath);
//                if (file.exists()) {
//                    file.delete();
//                }
//                file.createNewFile();
//                FileOutputStream out = new FileOutputStream(file);
//                out.write(fileArray, 0, fileArray.length);
//                out.flush();
//                out.close();
//
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}