package com.pikai;

import com.pikai.domain.HouseDomain;
import com.pikai.gateway.LianJiaWebPattern;
import com.pikai.http.MyHttpClient;
import com.pikai.jdbc.SpringJdbcTemplate;
import com.pikai.service.HouseService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;
import java.util.Timer;

/**
 * 项目名称：dacp
 * 包名： com.pikai.util
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/13 09:47
 */
public class MultiThreadMain {
    private static Logger logger = LoggerFactory.getLogger(MultiThreadMain.class);
    static ApplicationContext factory = null;
    static HouseService houseService = null;
    static int number = 0;
static int repeatNumber=0;

    public static void main(String[] args) {

        factory = new ClassPathXmlApplicationContext("classpath*:config/serverContext-datasource.xml");
        houseService = factory.getBean(HouseService.class);
        SpringJdbcTemplate springJdbcTemplate = factory.getBean(SpringJdbcTemplate.class);
        //获取成都所有的区
        // LianJiaWebPattern.fetchArea("cd","成都");
        //
        String[] areaArrays = { "jinjiang", "qingyang", "wuhou", "gaoxin7", "chenghua", "jinniu", "tianfuxinqu", "shuangliu","wenjiang", "pidou", "longquanyi", "xindou", "gaoxinxi1"};
        Timer timer = new Timer();
        try {
            for (String area : areaArrays) {
                //一个地区开启一个线程
                FetchEachAreaHouseInfoThread fetchEachAreaHouseInfoThread = new FetchEachAreaHouseInfoThread(area);
                Thread th = new Thread(fetchEachAreaHouseInfoThread);
                th.start();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    static class FetchEachAreaHouseInfoThread implements Runnable {
        private String areaName;
        private int continueNumber = 0;
        private int verifyTimes=0;  //验证时间
        public FetchEachAreaHouseInfoThread(String areaName) {
            this.areaName = areaName;
        }

        @Override
        public void run() {
            try {
                int totalPage = LianJiaWebPattern.fetchAreaTotalPageNo(areaName);
                for (int i = 1; i <= totalPage; i++) {
                    Set<String> houseUrls=null;
                    try {
                        houseUrls = LianJiaWebPattern.fetchAreaHouseUrls(areaName, i);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }

                    boolean continueFLag2=(houseUrls==null)?true:false;
                    while (continueFLag2) {
                        Thread.sleep(10000);//休眠2s
                        houseUrls = LianJiaWebPattern.fetchAreaHouseUrls(areaName, i);
                        if (houseUrls==null) {
                            continueFLag2 = false;
                        }else{
                            logger.error("-------没有进行图片验证,正等待恢复:");
                        }
                    }

                    for (String url : houseUrls) {
                        logger.error(areaName+"爬取到的房屋地址:  " + url);
                        //检查地址是否在数据库已经保存了
                        HouseDomain houseDomainCondition = new HouseDomain();
                        houseDomainCondition.setUrl(url);
                        List<HouseDomain> resultList = houseService.selectByCondition(houseDomainCondition);
                        if (resultList.size() == 0) {
                            String houseDetailHtml = MyHttpClient.get(url);
                            HouseDomain houseDomain = LianJiaWebPattern.getAndGenHouseObject(url, houseDetailHtml);
                            if (StringUtils.isNotBlank(houseDomain.getTitle()) && StringUtils.isNotBlank(houseDomain.getAreaSubInfo())) {
                                houseService.insert(houseDomain);
                                logger.error(areaName+"-------成功插入记录数:  " + number++);
                            } else {
                                logger.error("区域:  " + areaName + "     总页数:" + totalPage + " 当前爬取页数:  " + i + "-------插入失败,系统休眠10s:  " + url);
                                boolean continueFLag = true;
                                while (continueFLag) {
                                    Thread.sleep(10000);//休眠2s
                                    String houseDetailHtml2 = MyHttpClient.get(url);
                                    HouseDomain houseDomain2 = LianJiaWebPattern.getAndGenHouseObject(url, houseDetailHtml2);
                                    if (StringUtils.isNotBlank(houseDomain2.getTitle()) && StringUtils.isNotBlank(houseDomain2.getAreaSubInfo())) {
                                        continueFLag = false;
                                    } else {
                                        logger.error(areaName+"-------没有进行图片验证,正等待恢复:  " + verifyTimes++);
                                    }
                                }
                                verifyTimes=0;

                                if (!continueFLag) {
                                    String houseDetailHtml3 = MyHttpClient.get(url);
                                    HouseDomain houseDomain3 = LianJiaWebPattern.getAndGenHouseObject(url, houseDetailHtml3);
                                    houseService.insert(houseDomain3);
                                }
                                logger.error(areaName+"-------插入失败后重新插入记录:  " + continueNumber++);
                            }
                        } else {
                            logger.error(areaName+"-------数据库找到重复的地址:  " + url+"--------------"+repeatNumber++);
                        }
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}


