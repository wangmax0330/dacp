package com.pikai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gacl
 *         服务器端接收到验证码后的处理
 */

@WebServlet(name = "CheckServlet", urlPatterns = {"/CheckServlet"})
public class CheckServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clientCheckcode = request.getParameter("validateCode");//接收客户端浏览器提交上来的验证码

        String[] checkCode=request.getParameterValues("validateCode");

        System.out.println(checkCode);


        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码


        if (clientCheckcode.equals(serverCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            System.out.println("验证码验证通过！");
        } else {
            System.out.println("验证码验证失败！");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}