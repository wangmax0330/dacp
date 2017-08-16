package com.pikai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：  这个小程序是用来演示以下两个小知识点
 * 1、使用GZIPOutputStream流来压缩数据
 * 2、设置响应头Content-Encoding来告诉浏览器，服务器发送回来的数据压缩后的格式
 * 创建人:   沃特
 * 创建时间：2016/10/2016/10/20 20:25
 */
@WebServlet(name = "ContentHeaderEncodingServlet", urlPatterns = {"/ContentHeaderEncodingServlet"})
public class ContentHeaderEncodingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = "abcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
        System.out.println("原始数据的大小为：" + data.getBytes().length);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream gout = new GZIPOutputStream(bout); //buffer
        gout.write(data.getBytes());
        gout.close();
        //得到压缩后的数据
        byte g[] = bout.toByteArray();
        System.out.println("压缩后的数据的大小为：" + g.length);
//        response.setHeader("Content-Encoding", "gzip");
//        response.setHeader("Content-Length", g.length + "");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("原始数据的大小为：" + data.getBytes().length);
        out.print("<hr />");
//        out.println("压缩后的数据的大小为：" + g.length);
        out.println("  </BODY>");
        out.println("</HTML>");
//        response.getOutputStream().write(g);
//        response.getOutputStream().print("<hr/>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
