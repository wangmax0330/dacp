package com.pikai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 设置content-disposition响应头，让浏览器下载文件
 */
@WebServlet(name = "ContentHeaderDisposition", urlPatterns = {"/ContentHeaderDisposition"})
public class ContentHeaderDisposition extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 设置content-disposition响应头，让浏览器下载文件
         */
        response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
        InputStream in = this.getServletContext().getResourceAsStream("/image/walter.jpg");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
