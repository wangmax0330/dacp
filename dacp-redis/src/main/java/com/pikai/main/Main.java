package com.pikai.main;

import com.pikai.util.JedisClientSingle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 项目名称：dacp
 * 包名： com.pikai.main
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/03/2017/3/24 16:29
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/config/applicationContext-jedis.xml");
//        RedisUtil redisUtil = (RedisUtil) applicationContext.getBean("redisUtil");
//        System.out.println(redisUtil);
//        System.out.println(redisUtil.get("EbsData2OpeData"));
//        System.out.println(redisUtil.get("privilege_659bc9e6-7470-41f9-8741-299052c86566"));

//        long expire=10l;
//        redisUtil.set("abcd_methew", "测试时间", expire);
//        System.out.println("begin:    " + System.currentTimeMillis());
//
//        while (redisUtil.get("abcd_methew") != null) {
//            System.out.println(redisUtil.get("abcd_methew"));
//            System.out.println(expire--);
//            try {
//                Thread.sleep(1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("end:    " + System.currentTimeMillis());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/config/applicationContext-jedis2.xml"        );
        JedisClientSingle redisUtil =  (JedisClientSingle) applicationContext.getBean("jedisClient");

        long expire=240l;
        while (redisUtil.get("privilege_f662515b-894f-4d52-997a-70c602ea2151") != null) {
            //获取过期时间
            System.out.println(redisUtil.ttl("privilege_f662515b-894f-4d52-997a-70c602ea2151"));
            System.out.println(redisUtil.get("privilege_f662515b-894f-4d52-997a-70c602ea2151"));
//            try {
//                Thread.sleep(1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }


    }
}