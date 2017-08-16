package com.pikai.http;

/**
 * 项目名称：dacp
 * 包名： com.pikai.http
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/6 16:52
 */
public  class HttpProxyConfig {
    int id;
    String host;
    int port;
    String username;
    String password;
    int status=0; //0:暂停使用；1:使用中
    int type = 0;//0:http proxy; 1:socket proxy

    public HttpProxyConfig(){

    }

    public HttpProxyConfig(int id,String host, int port, String username, String password) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.status=1;
        this.type = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}