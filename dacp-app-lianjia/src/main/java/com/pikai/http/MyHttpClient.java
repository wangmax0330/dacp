package com.pikai.http;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * 项目名称：dacp
 * 包名： com.pikai.http
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/6 16:47
 */
public class MyHttpClient {
    private static Logger logger = LoggerFactory.getLogger(MyHttpClient.class);

    public static String get(String url) {
        return get(url, null);
    }

    private static String get(String url, HttpProxyConfig httpProxyConfig) {
        StringBuilder sb = new StringBuilder();
        Proxy proxy = null;
        // /创建代理服务器
        if (httpProxyConfig != null && !StringUtils.isEmpty(httpProxyConfig.getHost())) {
            InetSocketAddress addr = new InetSocketAddress(httpProxyConfig.getHost(), httpProxyConfig.getPort());
            if (httpProxyConfig.getType() == 1)
                proxy = new Proxy(Proxy.Type.SOCKS, addr); // Socket 代理
            else
                proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理
            // Authenticator.setDefault(new MyAuthenticator(httpProxyConfig.getUsername(), httpProxyConfig.getPassword()));// 设置代理的用户和密码
        }
        HttpURLConnection connection = null;// 设置代理访问
        InputStream is = null;
        try {
            URL tempUrl = new URL(url);
            //如果有host 则走代理,没有就不走
            if (httpProxyConfig == null || StringUtils.isEmpty(httpProxyConfig.getHost())) {
                connection = (HttpURLConnection) tempUrl.openConnection();
            } else {
                connection = (HttpURLConnection) tempUrl.openConnection(proxy);
            }
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Charsert", "UTF-8");
            connection.setRequestProperty("Host", "ajax.api.lianjia.com");
            connection.setRequestProperty("Cookie","lianjia_uuid=e52e71a5-d4d1-4c36-8430-6db3b1c453f1; lianjia_token=2.002fec7eda56a2d5c23e4157eba48582ed; ubta=2299869246.3007507272.1494061920148.1494062002062.1494062004931.2; select_city=510100; all-lj=138f1e66bf8c368d8c8b328e9ff033b4; _smt_uid=58cce377.19459cf7; lianjia_ssid=de0f4579-cd95-4273-9072-fda6822c5e9c");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");

            //Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
            //Accept-Encoding:gzip, deflate, sdch
            //Accept-Language:en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4
            //Connection:keep-alive
            //Cookie:lianjia_uuid=e52e71a5-d4d1-4c36-8430-6db3b1c453f1; lianjia_token=2.002fec7eda56a2d5c23e4157eba48582ed; _smt_uid=58cce377.19459cf7; ubta=2299869246.3007507272.1494061920148.1494062002062.1494062004931.2; all-lj=c28812af28ef34a41ba2474a2b5c52c2; select_city=510100; lianjia_ssid=cd0876f3-d42a-4a61-933d-df7fa756c7cd
            //Host:cd.lianjia.com
            //Referer:http://cd.lianjia.com/ershoufang/
            //Upgrade-Insecure-Requests:1
            //User-Agent:Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36

            is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String inputLine = "";
            while ((inputLine = reader.readLine()) != null) {
                sb.append(inputLine).append("\n");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "error";
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return sb.toString();
    }


}
