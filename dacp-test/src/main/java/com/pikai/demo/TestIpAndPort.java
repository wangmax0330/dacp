package com.pikai.demo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 项目名称：dacp
 * 包名： com.pikai.demo
 * 类名称：
 * 类描述： 测试某个IP地址上面某个端口是否可用
 * 创建人:   沃特
 * 创建时间：2017/03/2017/3/24 10:13
 */
public class TestIpAndPort {
    /**
     * 判断ip、端口是否可连接
     * @param host
     * @param port
     * @return
     */
    public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 判断ip是否可以连接 timeOut是超时时间
     * @param host
     * @param timeOut
     * @return
     */
    public static boolean isHostReachable(String host, Integer timeOut) {
        try {
            return InetAddress.getByName(host).isReachable(timeOut);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isHostConnectable("192.168.152.131", 9876));

        System.out.println(isHostReachable("192.168.152.131", 100));
    }
}
