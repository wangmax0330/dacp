package com.pikai.server;

import com.pikai.hander.HelloHandler;
import org.eclipse.jetty.server.Server;

/**
 * 项目名称：dacp-parent
 * 包名： com.pikai.server
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 11:56
 */
public class SimpleServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }
}
