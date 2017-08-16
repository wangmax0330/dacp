package com.pikai.book.chapter02;

import java.net.*;
import java.io.*;

public class PortScanner {
    public static void main(String args[]) {
        String host = "192.168.1.127";
        if (args.length > 0) host = args[0];
        new PortScanner().scan(host);
    }

    public void scan(String host) {
        Socket socket = null;
        for (int port = 1; port < 1024; port++) {
            try {
//                socket = new Socket(host, port);
                socket = new Socket();
                SocketAddress remoteAddr=new InetSocketAddress(host,port);
                socket.connect(remoteAddr,60000);
                System.out.println("There is a server on port " + port);
            } catch (IOException e) {
                System.out.println("Can't connect to port " + port);
            } finally {
                try {
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
