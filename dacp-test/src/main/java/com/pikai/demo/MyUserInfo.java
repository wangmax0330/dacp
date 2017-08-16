package com.pikai.demo;

import com.jcraft.jsch.UserInfo;

/**
 * 项目名称：dacp
 * 包名： com.pikai.demo
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/11 18:03
 */
public class MyUserInfo implements UserInfo {

    @Override
    public String getPassphrase() {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.getPassphrase()");
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.getPassword()");
        return null;
    }

    @Override
    public boolean promptPassphrase(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.promptPassphrase()");
        System.out.println(arg0);
        return false;
    }

    @Override
    public boolean promptPassword(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.promptPassword()");
        System.out.println(arg0);
        return false;
    }

    @Override
    public boolean promptYesNo(String arg0) {
        // TODO Auto-generated method stub'
        System.out.println("MyUserInfo.promptYesNo()");
        System.out.println(arg0);
        if (arg0.contains("The authenticity of host")) {
            return true;
        }
        return true;
    }

    @Override
    public void showMessage(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.showMessage()");
    }

}