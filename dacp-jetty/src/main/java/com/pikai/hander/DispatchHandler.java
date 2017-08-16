package com.pikai.hander;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：dacp-parent
 * 包名： com.pikai.hander
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 15:24
 */
public class DispatchHandler extends AbstractHandler {

    public void handle(String target, Request baseRequest,
                       HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        /**
         * 这里将是根据不同的请求来分发给不同的Handler来处理
         */
        if (target.equals("/index")) {
            new IndexHandler().handle(target, baseRequest, request, response);
        } else {
            new HelloHandler().handle(target, baseRequest, request, response);
        }
    }
}
