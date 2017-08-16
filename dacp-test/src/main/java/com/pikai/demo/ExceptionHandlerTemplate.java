package com.pikai.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wangm on 2017/7/28.
 */
public class ExceptionHandlerTemplate {
    public static void main(String[] args) {
        String fileName = "";
        InputStream input = null;
        IOException processException = null;
        try {
            input = new FileInputStream(fileName);

            //...process input stream...
        } catch (IOException e) {
            processException = e;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    if (processException != null) {
                        throw new MyException(processException, e, "Error message..." + fileName);
                    } else {
                        throw new MyException(e, "Error closing InputStream for file " + fileName);
                    }
                }
            }
            if (processException != null) {
                throw new MyException(processException,"Error processing InputStream for file " + fileName);
            }
        }
    }
}
