package com.pikai.druid;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：dacp
 * 包名： com.pikai.druid
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/02/2017/2/24 11:22
 */
public class Main {
    public static void main(String[] args) {
        String str="13983470414";
        System.out.println(str.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        Map map=new HashMap();
    }
}
