package com.pikai.book.chapter02;

import java.io.*;
import java.net.*;
public class SimpleClient {
  public static void main(String args[])throws Exception {
    Socket s1 = new Socket("localhost",8000);
    System.out.println("第一次连接成功");
    Socket s2 = new Socket("localhost",8000);
    System.out.println("第二次连接成功");
    Socket s3 = new Socket("localhost",8000);
    System.out.println("第三次连接成功");
  }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
