package com.pikai.url;

/**URL类解析url
 * Created by wangm on 2017/8/4.
 */
import java.net.*;
import java.io.*;

public class URLDemo
{
    public static void main(String [] args)
    {
        try
        {
            URL url = new URL("http://www.runoob.com/index.html?language=cn&account=8003068#j2se#111");
            System.out.println("URL 为：" + url.toString());
            System.out.println("协议为：" + url.getProtocol());
            System.out.println("验证信息：" + url.getAuthority());
            System.out.println("文件名及请求参数：" + url.getFile());
            System.out.println("主机名：" + url.getHost());
            System.out.println("路径：" + url.getPath());
            System.out.println("端口：" + url.getPort());
            System.out.println("默认端口：" + url.getDefaultPort());
            System.out.println("请求参数：" + url.getQuery());
            System.out.println("定位位置：" + url.getRef());
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}