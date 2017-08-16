package com.pikai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 17:09
 */
@WebServlet(name = "PropertiesServlet", urlPatterns = {"/PropertiesServlet"})
public class PropertiesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * response.setContentType("text/html;charset=UTF-8");目的是控制浏览器用UTF-8进行解码；
         * 这样就不会出现中文乱码了
         */
        response.setHeader("content-type", "text/html;charset=UTF-8");
        readSrcDirPropCfgFile(response);//读取resource目录下的properties配置文件
        response.getWriter().println("<hr/>");
        readWebRootDirPropCfgFile(response);//读取WEB-INF目录下的properties配置文件

    }



    /**
     * 通过ServletContext对象读取WEB-INF目录下的properties配置文件
     *
     * @param response
     * @throws IOException
     */
    private void readWebRootDirPropCfgFile(HttpServletResponse response)
            throws IOException {
        /**
         * 通过ServletContext对象读取WebRoot目录下的properties配置文件
         * “/”代表的是项目根目录
         */
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/log4j.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("log4j.rootLogger");
        String url = prop.getProperty("log4j.logger.com.pikia");
        String username = prop.getProperty("log4j.logger.java.sql.Connection");
        response.getWriter().println("读取WebRoot目录下的db2.properties配置文件：");
        response.getWriter().print(
                MessageFormat.format(
                        "log4j.rootLogger={0},log4j.logger.com.pikia={1},log4j.logger.java.sql.Connection={2},password={3}",
                        driver, url, username, null));
    }

    /**
     * 通过ServletContext对象读取resource目录下的properties配置文件
     *
     * @param response
     * @throws IOException
     */
    private void readSrcDirPropCfgFile(HttpServletResponse response) throws IOException {
        /**
         * 通过ServletContext对象读取src目录下的db1.properties配置文件
         */
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/config/db4.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("读取src目录下的db1.properties配置文件：");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}",
                        driver, url, username, password));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
