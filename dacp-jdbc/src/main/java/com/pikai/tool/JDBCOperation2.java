package com.pikai.tool;

import java.sql.*;

/**
 * 项目名称：dacp
 * 包名： com.pikai.tool
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2016/12/2016/12/31 17:11
 */
public class JDBCOperation2 {
    public static void main(String args[]) {
        String url = "jdbc:mysql://192.168.1.189:3306/ykee_biz?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        String user = "root";
        String password = "shj2016";
        String driver = "com.mysql.jdbc.Driver";
        Connection conn = null;//建立数据库连接
        Long start=0l;
        Long limit=100l;
        try {
            Class.forName(driver);//加载数据库驱动
            conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            String sqlpaper = " select  * FROM ykee_biz.start_work_apply order by id desc " + "LIMIT " + start + "," + limit;
            ResultSet rs = st.executeQuery(sqlpaper);
//        List<CstResidentialArea> list = new ArrayList<CstResidentialArea>();
            while (rs.next()) {
                Long id = null;
                Long customerId = null;
                Long orgId = null;
                Long deptId = null;
                id = rs.getLong("id");
                customerId = rs.getLong("customer_id");
                orgId = rs.getLong("org_id");
                if (rs.wasNull()) {
//                    resultVO.setTaskId(null);
                }
                deptId = rs.getLong("dept_id");
                System.out.println(id+"-----------"+customerId+"-----------"+orgId+"-----------"+deptId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
