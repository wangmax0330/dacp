package com.pikai.demo;

import java.io.IOException;

/**
 * Created by wangm on 2017/7/28.
 */
public class MyException extends RuntimeException  {
    public MyException(IOException exception,IOException e,String msg) {

    }
    public MyException(IOException exception,String msg) {

    }
    public MyException(IOException exception) {

    }
}
