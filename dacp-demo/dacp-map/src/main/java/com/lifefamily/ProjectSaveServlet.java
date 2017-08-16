package com.lifefamily;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by Administrator on 2016/10/22.
 */
@WebServlet(name = "ProjectSaveServlet", urlPatterns = {"/save"})
public class ProjectSaveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
int aaaaa=0;
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String lng = request.getParameter("lng");
            String lat = request.getParameter("lat");
            updateFrom(Long.parseLong(id), lng, lat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateFrom(Long id, String lng, String lat) throws Exception {
        System.out.println(id + " 开始保存数据...");
        boolean flag = false;
        String url = "jdbc:mysql://:3306/?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        String user = "";
        String password = "";
        Connection conn = DriverManager.getConnection(url, user, password);//建立数据库连接
        String sql = "UPDATE  cst_residential_area a SET  a.longitude= "+new BigDecimal(lng)+",a.latitude= "+new BigDecimal(lat)+"  WHERE a.id="+id;
        PreparedStatement ps=null;
        try {
          ps=(PreparedStatement) conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            if (i != 0) {
                flag = true;
            }
            aaaaa++;
            System.out.println(aaaaa+"        ++++      "+id + " 保存数据成功:  "+ lng +"     ------------     "+lat);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();

        }
        return flag;
    }
}
