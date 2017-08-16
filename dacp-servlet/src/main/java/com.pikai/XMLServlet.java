package com.pikai;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 18:01
 */
@WebServlet(name = "XMLServlet", urlPatterns = {"/XMLServlet"})
public class XMLServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String xml = "<xml><title>Test Title</title></xml>";//XML文本字符串
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("Cache-control", "no-cache");
        PrintWriter out = response.getWriter();
        out.println(xml);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }
}
