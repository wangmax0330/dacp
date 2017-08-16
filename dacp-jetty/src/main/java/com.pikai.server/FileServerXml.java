package com.pikai.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;

/**
 * 项目名称：dacp
 * 包名： com.pikai.server
 * 类名称：
 * 类描述：
 * 创建人：生活家.沃特
 * 创建时间：2016/10/2016/10/19 15:45
 */
public class FileServerXml {
    public static void main(String[] args) throws Exception {
        Resource fileserver_xml = Resource.newSystemResource("/etc/fileserver.xml");
        XmlConfiguration configuration = new XmlConfiguration(fileserver_xml.getInputStream());
        Server server = (Server) configuration.configure();
        server.start();
        server.join();
    }
}