//package com.pikai.server;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.webapp.WebAppContext;
//import com.zhongsou.appserver.conf.Config;
//import com.zhongsou.appserver.log.AbstractLog;
//
//
///**
// * 项目名称：dacp-parent
// * 包名： com.pikai.server
// * 类名称：
// * 类描述：
// * 创建人：生活家.沃特
// * 创建时间：2016/10/2016/10/19 14:32
// */
//public class JettyServer extends AbstractLog {
//
//    private Server server;
//
//    @Override
//    public boolean init(Config conf) {
//        try {
//            server = new Server(conf.getJetty().getPort());
//
//            WebAppContext webapp = new WebAppContext();
//            webapp.setContextPath("/");
//
//            webapp.setResourceBase(System.getProperty("JettyWebRoot", "./webapps"));
//            server.setHandler(webapp);
//        } catch (Exception e) {
//            logger.error("JettyServer init", e);
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean start() {
//        try {
//            server.start();
//            return true;
//        } catch (Exception e) {
//            logger.error("JettyServer start", e);
//            return false;
//        }
//    }
//}
