package com.pikai.server;

import com.pikai.hander.DispatchHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 * 项目名称：dacp-parent
 * 包名： com.pikai.server
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 15:22
 */
public class ProgrammableServer {
    public static void main(String[] args) throws Exception {
        // 创建Server
        Server server = new Server();

        // 添加ThreadPool
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool();
        queuedThreadPool.setName("queuedTreadPool");
        queuedThreadPool.setMinThreads(10);
        queuedThreadPool.setMaxThreads(200);

        server.setThreadPool(queuedThreadPool);

        // 添加Connector
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(8888);
        connector.setAcceptors(4);
        connector.setMaxBuffers(2048);
        connector.setMaxIdleTime(10000);

        server.addConnector(connector);

        // 添加Handler
        ContextHandlerCollection context = new ContextHandlerCollection();
        ContextHandler contextHandler = context.addContext("/", "/");
        contextHandler.setHandler(new DispatchHandler());

        Handler defaults = new DefaultHandler();

        HandlerCollection collection = new HandlerCollection();
        collection.setHandlers(new Handler[]{context, defaults});

        server.setHandler(collection);

        // 启动服务
        server.start();
        while (server.isStarted()) {
            System.out.println("server starting...");
            break;
        }
        System.out.println("server stared...");
        System.out.println("ContextHandlerCollectio.getServer() = "
                + context.getServer().hashCode());
        System.out.println("Server:" + server.hashCode());
        server.join();
    }
}
