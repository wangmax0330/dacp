package com.pikai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2016/10/2016/10/20 20:53
 */
@WebServlet(name = "ContentHeaderRefreServlet", urlPatterns = {"/ContentHeaderRefreServlet"})
public class ContentHeaderRefreServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 设置refresh响应头，让浏览器每隔3秒定时刷新
         */
        // response.setHeader("refresh", "3");
        /**
         * 设置refresh响应头，让浏览器3秒后跳转到http://www.baidu.com
         */
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setHeader("refresh", "3;url='/dacp-servlet/ContentHeaderRefreServlet'");
        response.getWriter().write("3秒后跳转页面....<br />");
        response.getWriter().write("3秒后跳转页面....");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
