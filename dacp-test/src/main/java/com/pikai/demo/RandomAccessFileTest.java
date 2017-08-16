package com.pikai.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by wangm on 2017/7/28.
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("c:\\data\\file.txt", "rw");

            file.seek(200);
            long pointer = file.getFilePointer();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
