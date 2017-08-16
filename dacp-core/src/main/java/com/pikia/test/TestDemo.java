package com.pikia.test;

import java.net.URL;
import java.util.Date;

import com.pikia.component.web.util.DateUtils;
import com.pikia.component.web.util.MD5Util;

public class TestDemo {
	public static void main(String[] args) {
		System.out.println(DateUtils.date2Str(new Date(), "yyyy-MM") + "-01 00:00:00");
		System.out.println(DateUtils.date2Str(new Date()));
		String str = "2我的心情 121212313123<hr />12121";
		System.out.println(str.indexOf("<hr />"));
		System.out.println(str.substring(0, str.indexOf("<hr />")));
		//E00ACC3949AA59AAAE56E057E20F883E
		System.out.println(MD5Util.getMD5ofStr("123456"));
		System.out.println(MD5Util.getMD5ofStr("DandanJun@158180"));
		URL root = TestDemo.class.getClass().getResource("/");
		URL current1 = TestDemo.class.getClass().getResource("");
		URL current2 = TestDemo.class.getClass().getResource(".");
		URL parent = TestDemo.class.getClass().getResource("..");
		URL self1 = TestDemo.class.getClass().getResource("TestDemo.class");
		URL self2 = TestDemo.class.getClass().getResource("./TestDemo.class");
		URL brother = TestDemo.class.getClass().getResource("../TestDemo.class");

		System.out.println("root = " + root);
		System.out.println("current1 = " + current1);
		System.out.println("current2 = " + current2);
		System.out.println("parent = " + parent);
		System.out.println("self1 = " + self1);
		System.out.println("self2 = " + self2);
		System.out.println("brother = " + brother);
		String zero = "0";
		System.out.println(zero == "0");
		System.out.println(zero != "0");
	}
}
