package com.pikai.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 项目名称：dacp
 * 包名： com.pikai.demo
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2016/11/2016/11/26 03:27
 */
public class Demo {

    public static void main(final String[] args) throws IOException {
        try (InputStream inputstream = new FileInputStream("file.txt")) {
            int data = inputstream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputstream.read();
            }
        }
    }
}
