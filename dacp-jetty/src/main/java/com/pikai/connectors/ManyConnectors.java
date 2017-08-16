package com.pikai.connectors;

import com.pikai.hander.HelloHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 * 项目名称：dacp-parent
 * 包名： com.pikai.connectors
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 14:27
 */
public class ManyConnectors {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        SelectChannelConnector connector0 = new SelectChannelConnector();
        connector0.setPort(8080);
        connector0.setMaxIdleTime(30000);
        connector0.setRequestHeaderSize(8192);

        SelectChannelConnector connector1 = new SelectChannelConnector();
        connector1.setHost("127.0.0.1");
        connector1.setPort(8888);
        connector1.setThreadPool(new QueuedThreadPool(20));
        connector1.setName("admin");

        SslSelectChannelConnector ssl_connector = new SslSelectChannelConnector();
        String jetty_home = System.getProperty("jetty.home", "../jetty-distribution/target/distribution");
        System.setProperty("jetty.home", jetty_home);
        ssl_connector.setPort(8443);
        ssl_connector.setKeystore(jetty_home + "/etc/keystore");
        ssl_connector.setPassword("OBF:1vny1zlo1x8e1vnw1vn61x8g1zlu1vn4");
        ssl_connector.setKeyPassword("OBF:1u2u1wml1z7s1z7a1wnl1u2g");
        server.addConnector(ssl_connector);

        server.setConnectors(new Connector[]{connector0, connector1, ssl_connector});

        server.setHandler(new HelloHandler());

        server.start();
        server.join();
    }
}
