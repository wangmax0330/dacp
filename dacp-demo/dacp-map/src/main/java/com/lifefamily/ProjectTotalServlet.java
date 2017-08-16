package com.lifefamily;

import com.domain.CstResidentialArea;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProjectTotalServlet", urlPatterns = {"/queryTotal"})
public class ProjectTotalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String start = request.getParameter("pageStart");
            String limit = request.getParameter("pageLimit");
            String url = "jdbc:mysql://:3306/?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
            String user = "";
            String password = "";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);//加载数据库驱动
            Connection conn = DriverManager.getConnection(url, user, password);//建立数据库连接
            Statement st = conn.createStatement();
            String sqlpaper = "SELECT count(1) as total FROM cst_residential_area";
            ResultSet rs = st.executeQuery(sqlpaper);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt("total");
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            JSONObject jsonObjet = new JSONObject();
            jsonObjet.put("success", 1);
            jsonObjet.put("total", total);
            out.println(jsonObjet.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }


}

