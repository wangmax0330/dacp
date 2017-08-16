package com.pikai.demo;

import java.io.*;

/**
 * Created by wangm on 2017/7/27.
 */
public class FileInputStreamDemo {
    public static void main(final String[] args) throws IOException {

        String str = "你好吗,笨蛋";
        byte[] bytes = str.getBytes();//new byte[1024];

        //write data into byte array...
        InputStream input = new ByteArrayInputStream(bytes);
        //read first byte
        int data = input.read();
        while (data != -1) {
            //do something with data
            //read next byte
            data = input.read();
            System.out.println(data);

        }
        System.out.println("----------------------");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write("This text is converted to bytes".getBytes("UTF-8"));
        byte[] bytes2 = output.toByteArray();
        System.out.println("----------------------");


//        ##替换系统流
        OutputStream output2 = new FileOutputStream("d:\\system.out.txt");
        PrintStream printOut = new PrintStream(output2);
        System.setOut(printOut);
        System.out.println("----------------------");
    }
}
