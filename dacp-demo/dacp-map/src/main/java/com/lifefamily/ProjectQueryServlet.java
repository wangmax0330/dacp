package com.lifefamily;

import com.domain.CstResidentialArea;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProjectQueryServlet", urlPatterns = {"/query"})
public class ProjectQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            //String sqlpaper = " SELECT id,provide,city,area,address,name,longitude,latitude FROM cst_residential_area order by id desc " + "LIMIT " + start + "," + limit;
            String sqlpaper = " SELECT cr.id, cr.provide, cr.city, cr.area, cr.address , cr.name, cr.longitude, cr.latitude FROM ykee_biz.trc_track tr LEFT JOIN ykee_biz.cst_customer cu ON cu.id = tr.customer_id LEFT JOIN ykee_biz.cst_house_info ch ON tr.house_id = ch.id LEFT JOIN ykee_biz.cst_residential_area cr ON cr.id = ch.building_id LEFT JOIN ykee_bid.bid_contract bc ON bc.track_id = tr.id AND bc.remove_flag = 0 AND bc.contract_status = 1 LEFT JOIN ykee_xsimple.kn_bc_dictionary bcd ON bcd.id = tr.status_dic_id LEFT JOIN ykee_biz.trc_sales_team tat1 ON tat1.track_id = tr.id AND tat1.role_code IN ('A001', 'A005') AND tat1.remove_flag = 0 AND tat1.non_sales = 0 LEFT JOIN ykee_xsimple.kn_employee kn ON tat1.seller_id = kn.id LEFT JOIN ykee_xsimple.kn_employee_organization keo ON keo.emp_id = kn.id LEFT JOIN ykee_xsimple.kn_organization ko ON ko.id = keo.org_id LEFT JOIN ykee_xsimple.kn_user_role kur ON kur.user_id = kn.id LEFT JOIN ykee_xsimple.kn_role kr ON kr.id = kur.role_id LEFT JOIN ykee_biz.trc_sales_team tat3 ON tat3.track_id = tr.id AND tat3.role_code = 'A003' AND tat3.remove_flag = 0 LEFT JOIN ykee_xsimple.kn_employee kn3 ON tat3.seller_id = kn3.id LEFT JOIN ykee_xsimple.kn_employee_organization keo3 ON keo3.emp_id = kn3.id LEFT JOIN ykee_xsimple.kn_organization ko3 ON ko3.id = keo3.org_id LEFT JOIN ykee_xsimple.kn_user_role kur3 ON kur3.user_id = kn3.id LEFT JOIN ykee_xsimple.kn_role kr3 ON kr3.id = kur3.role_id LEFT JOIN ykee_biz.trc_sales_team tat5 ON tat5.track_id = tr.id AND tat5.remove_flag = 0 AND tat5.non_sales = 1 LEFT JOIN ykee_xsimple.kn_employee kn5 ON tat5.seller_id = kn5.id LEFT JOIN ykee_xsimple.kn_employee_organization keo5 ON keo5.emp_id = kn5.id LEFT JOIN ykee_xsimple.kn_organization ko5 ON ko5.id = keo5.org_id LEFT JOIN ykee_xsimple.kn_user_role kur5 ON kur5.user_id = kn5.id LEFT JOIN ykee_xsimple.kn_role kr5 ON kr5.id = kur5.role_id WHERE tr.org_id = 84" +
                    " AND cu.first_date < \"2017-06-01 00:00:00\" AND cu.first_date >= \"2017-05-01 00:00:00\" group by name order by id desc  "
                    + "LIMIT " + start + "," + limit;

            ResultSet rs = st.executeQuery(sqlpaper);
            List<CstResidentialArea> list = new ArrayList<CstResidentialArea>();
            while (rs.next()) {
                Long id = null;
                String address = null;
                String provide = null;
                String city = null;
                String area = null;
                String name = null;
                BigDecimal longitude = null;
                BigDecimal latitude = null;
                id = rs.getLong("id");
                address = rs.getString("address");
                provide = rs.getString("provide");
                city = rs.getString("city");
                area = rs.getString("area");
                name = rs.getString("name");
                longitude = rs.getBigDecimal("latitude");
                latitude = rs.getBigDecimal("longitude");
                CstResidentialArea cstResidentialArea = new CstResidentialArea(id, address, provide, city, area, name, longitude, latitude);
                list.add(cstResidentialArea);
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(JSONArray.fromObject(list).toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

