package com.pikai.jdbc;

import com.pikai.domain.HouseDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 项目名称：dacp
 * 包名： com.pikai.jdbc
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/10 14:26
 */
public class SpringJdbcTemplate {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<HouseDomain> test(){
        final String sql = "Select * from house ";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(HouseDomain.class));
//        return getJdbcTemplate().query(sql, new RowMapper(){
//
//            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                HouseDomain admin = new HouseDomain();
//                admin.setId(rs.getInt(""));
//                admin.setUsername(rs.getString(""));
//                admin.setPassword(rs.getString(""));
//                return admin;
//            }
//
//        });
    }
    public void saveHouseInfo(){
        String sql="insert into user (name,deptid) values (?,?)";
        int count= jdbcTemplate.update(sql, new Object[]{"caoyc",3});
    }
}
