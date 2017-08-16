package com.pikai.book.chapter02;

import java.net.*;
import java.io.*;

/**

$ javac  -encoding UTF-8  com/pikai/book/chapter02/ConnectTester.java

$ java com/pikai/book/chapter02/ConnectTester  www.baidu.com 80
www.baidu.com/61.135.169.121:80 : Local address and port can't be binded

 **/
public class ConnectTester {
    public static void main(String args[]) {
        String host = "localhost";
        int port = 25;
        if (args.length > 1) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
//        www.javathinker.org 80
//        new ConnectTester().connect("www.javathinker.org", 80);
        new ConnectTester().connect(host, port);
    }

    public void connect(String host, int port) {
        SocketAddress remoteAddr = new InetSocketAddress(host, port);
        Socket socket = null;
        String result = "";
        try {
            long begin = System.currentTimeMillis();
            socket = new Socket();
            socket.connect(remoteAddr, 1000);  //超时时间为1秒钟
            long end = System.currentTimeMillis();
            result = (end - begin) + "ms";  //计算连接所花时间
//            result = "Local address and port can't be binded";
        } catch (UnknownHostException e) {
            result = "Unknown Host";
        } catch (ConnectException e) {
            result = "Connection Refused";
        } catch (SocketTimeoutException e) {
            result = "TimeOut";
        } catch (IOException e) {
            result = "failure";
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(remoteAddr + " : " + result);
    }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
