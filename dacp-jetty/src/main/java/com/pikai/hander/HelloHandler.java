package com.pikai.hander;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 项目名称：dacp-parent
 * 包名： com.pikai.hander
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 14:22
 */

public class HelloHandler extends AbstractHandler {

    /**
     * @param target      The target of the request which is either a URI or a name from a named dispatcher.
     * @param baseRequest The Jetty mutable request object, which is always unwrapped.
     * @param request     The immutable request object, which may have been wrapped.
     * @param response    The response that may have been wrapped.
     * @throws IOException
     * @throws ServletException
     */
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println(target);
//        response.setContentType("text/html;charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_OK);
//        baseRequest.setHandled(true);
//        response.getWriter().println("<h1>Hello World</h1>");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<h3>This is a HelloHandler and contextPath is '/hello'.</h3>");
        out.flush();
        out.close();
    }
}
