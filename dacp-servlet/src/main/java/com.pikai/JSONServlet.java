package com.pikai;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 18:01
 */
@WebServlet(name = "JSONServlet", urlPatterns = {"/JSONServlet"})
public class JSONServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject json=new JSONObject();
        json.put("Date",new Date());
        //json给值省略
        response.getWriter().println(json.toString());

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }
}
