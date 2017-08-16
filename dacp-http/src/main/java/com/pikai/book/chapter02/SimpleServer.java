package com.pikai.book.chapter02;

import java.io.*;
import java.net.*;
public class SimpleServer {
  public static void main(String args[])throws Exception {
    //连接请求队列的长度为2,如果队列中的连接请求已满,服务器就会拒绝其余的连接请求.
    ServerSocket serverSocket = new ServerSocket(8000,2);
    Thread.sleep(360000);   //睡眠6分钟
  }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
