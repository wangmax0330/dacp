package com.pikai;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 项目名称：dacp
 * 包名： com.pikai
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 16:39
 */
public class EntryServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    /**
     * myreq.cg?param1=param
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ServletContext serv = getServletContext();
        //获得request 相关信息
        String Contextpath = req.getContextPath();
        String CharacterEncoding = req.getCharacterEncoding();
        String ContentType = req.getContentType();
        String LocalAddr = req.getLocalAddr();
        String LocalName = req.getLocalName();
        String Method = req.getMethod();
        String Parameter = req.getParameter("param");
        String Protocol = req.getProtocol();
        String ServerName = req.getServerName();
        Cookie[] Cookies = req.getCookies();
        String ServletPath = req.getServletPath();
        String RemoteAddr = req.getRemoteAddr();
        String RemoteHost = req.getRemoteHost();
        String RequestURI = req.getRequestURI();
        String RequestedSessionId = req.getRequestedSessionId();
        req.setCharacterEncoding("utf-8");
        req.setAttribute("oneattr", "setted");

        //response响应请求，输出请求的一些内容
        resp.setContentType("text/html;charset=utf-8");  //设置响应页面字符编码
        PrintWriter out = resp.getWriter();
        out.println("<font color=red ><h1>这是一个Servlet!!!!!</h1></font>");
        out.println("<div>" + "现在用response输出请求相关信息如下：");
        out.println("<li>" + "发送请求服务器ip--RemoteAddr=" + RemoteAddr + "</li>");
        out.println("<li>" + "发送请求服务器主机--RemoteHost=" + RemoteHost + "</li>");
        out.println("<li>" + "请求的URI--RequestURI=" + RequestURI + "</li>");
        out.println("<li>" + "发送请求的方法--Method=" + Method + "</li>");
        out.println("<li>" + "发送请求的协议--Protocol=" + Protocol + "</li>");
        out.println("<li>" + "请求内容的编码--CharacterEncoding=" + CharacterEncoding + "</li>");
        out.println("<li>" + "请求的内容类型--ContentType=" + ContentType + "</li>");
        out.println("<p>");
        out.println("<li>" + "当前服务器ip--LocalAddr=" + LocalAddr + "</li>");
        out.println("<li>" + "服务器主机名--LocalName=" + LocalName + "</li>");
        out.println("<li>" + "context容器路径---contextpath=" + Contextpath + "</li>");
        out.println("<li>" + "Server容器名--ServerName=" + ServerName + "</li>");
        out.println("<li>" + "处理请求Servlet对应的url--ServletPath=" + ServletPath + "</li>");
        out.println("<li>" + "请求的附加参数--param=" + Parameter + "</li>");
        out.println("</div>");
        out.close();

        //当此Servlet得到这个请求，可以选择自己处理，或者调用其他页面进行处理
        //这里此Servlet将请求内容转给dealpage.jsp这个页面去处理请求。
        //相当于本来表单提交给此servlet处理的，现在相当于做一个转向，让提交的表单给dealpage.jsp处理

        //RequestDispatcher dispatcher = req.getRequestDispatcher("dealpage.jsp");
        //dispatcher.forward(req, resp);

        //super.doGet(req, resp);
    }
}
