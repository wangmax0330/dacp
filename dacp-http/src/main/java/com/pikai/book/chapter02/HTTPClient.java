package com.pikai.book.chapter02;

import java.net.*;
import java.io.*;

public class HTTPClient {
    String host = "www.javathinker.org";
    int port = 80;
    Socket socket;

    public void createSocket() throws Exception {
        socket = new Socket("www.javathinker.org", 80);
    }


    public void communicate() throws Exception {
        StringBuffer sb = new StringBuffer("GET " + "/index.jsp" + " HTTP/1.1\r\n");
        sb.append("Host: www.javathinker.org\r\n");
        sb.append("Accept: */*\r\n");
        sb.append("Accept-Language: zh-cn\r\n");
        sb.append("Accept-Encoding: gzip, deflate\r\n");
        sb.append("User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)\r\n");
        sb.append("Connection: Keep-Alive\r\n\r\n");
        //发送Http请求
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(sb.toString().getBytes());
        socket.shutdownOutput();  //关闭输出流

        //接受响应结果
        InputStream socketIn = socket.getInputStream();

//        ByteArrayOutputStream 包含一个内部缓冲区，该缓冲区包含从流中读取的字节。内部计数器跟踪 read 方法要提供的下一个字节。
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = socketIn.read(buff)) != -1) {
            buffer.write(buff, 0, len);
        }

        System.out.println(new String(buffer.toByteArray()));  //把字节数组转换为字符串

//如果网页数据量太大,把数据全部保存到ByteArrayOutputStream缓存中会浪费大量的内存,更有效的方法是利用BUfferedReader
/*
    InputStream socketIn=socket.getInputStream();
    BufferedReader br=new BufferedReader(new InputStreamReader(socketIn));
    String data;
    while((data=br.readLine())!=null){
      System.out.println(data);
    }
*/
        socket.close();
    }

    public static void main(String args[]) throws Exception {
        HTTPClient client = new HTTPClient();
        client.createSocket();
        client.communicate();
    }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
