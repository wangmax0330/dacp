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
 * 类描述：设置响应头，服务器通过 Location这个头，来告诉浏览器跳到哪里，这就是所谓的请求重定向
 * 创建人:   沃特
 * 创建时间：2016/10/2016/10/20 16:04
 */
@WebServlet(name = "ContentHeaderRedirectServlet", urlPatterns = {"/ContentHeaderRedirectServlet"})
public class ContentHeaderRedirectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(302);//设置服务器的响应状态码
        /**
         *设置响应头，服务器通过 Location这个头，来告诉浏览器跳到哪里，这就是所谓的请求重定向
         */
        response.setHeader("Location", "/dacp-servlet/redirect.html");
        //这个页面是不会跳转的
        request.getRequestDispatcher("page.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}