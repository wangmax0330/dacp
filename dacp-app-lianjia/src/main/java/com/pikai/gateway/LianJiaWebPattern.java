package com.pikai.gateway;

import com.pikai.domain.HouseDomain;
import com.pikai.http.MyHttpClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目名称：dacp
 * 包名： com.pikai.gateway
 * 类名称：
 * 类描述：链家网网页正则表达式
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/6 17:10
 */
public class LianJiaWebPattern {
    private static Logger logger = LoggerFactory.getLogger(LianJiaWebPattern.class);

    static String cityIndexUrl = "http://${city}.lianjia.com/ershoufang/";
    static String cityAreaIndexUrl = "http://${city}.lianjia.com/ershoufang/${area}/";

    //二手房列表页
    static String firstPageAreasUrl = "http://cd.lianjia.com/ershoufang/${area}/";
    static String pageAreasUrl = "http://cd.lianjia.com/ershoufang/${area}/pg${pageNo}/";

    //二手房成交列表页
    static String firstChenjiaoPageAreasUrl = "http://cd.lianjia.com/chengjiao/${area}/";
    static String chengjiaoPageAreasUrl = "http://cd.lianjia.com/chengjiao/${area}/";

    static Pattern houseUrlInPageWebPattern = Pattern.compile("http://cd.lianjia.com/ershoufang/[0-9]+.html");
    static Pattern chengjiaoHouseUrlInPageWebPattern = Pattern.compile("http://cd.lianjia.com/chengjiao/[0-9]+.html");

    static Pattern totalPageNoInPageWebPattern = Pattern.compile("\"totalPage\":([0-9]+)");

    //解析正则的结果
    private static Matcher matcher = null;

    //流量异常验证表达式
    static Pattern exceptionVerificationPatter=Pattern.compile("<p id=\"authType\">您所在的IP(.*?)流量异常");
    //图片资源大小
    static String imageUrlDemo = "http://image1.ljcdn.com/510100-inspection/64a9f418-37f4-43d0-af6d-6b00806c6867.jpg.1000x800.jpg";

    static Pattern totalHosePattern = Pattern.compile("共找到<span>(\\d+)</span>套([\\u4e00-\\u9fa5]+)二手房");


    //在售详细信息=======================================begin
    static Pattern titlePattern = Pattern.compile("class=\"main\" title=\"(.*?)\"");
    static Pattern subTitlePattern = Pattern.compile("class=\"sub\" title=\"(.*?)\"");

    //关注人数
    static Pattern favCountPattern = Pattern.compile("id=\"favCount\" class=\"count\">([0-9]+)<");
    //看过次数
    static Pattern cartCountPattern = Pattern.compile("id=\"cartCount\" class=\"count\">([0-9]+)<");

    static Pattern pricePattern = Pattern.compile("span class=\"total\">(\\d+(\\.\\d+)?)</span>");
    static Pattern unitPricePattern = Pattern.compile("class=\"unitPriceValue\">(\\d+(\\.\\d+)?)<");

    static Pattern firstPayPricePattern = Pattern.compile("首付(\\d+(\\.\\d+)?)万");
    static Pattern taxPricePattern = Pattern.compile("id=\"PanelTax\">(\\d+(\\.\\d+)?)<");
    static Pattern removedPattern = Pattern.compile("<span>已下架</span>");

    static Pattern roomMainAndSubInfoPattern = Pattern.compile("div class=\"room\"><div class=\"mainInfo\">(.*?)</div><div class=\"subInfo\">(.*?)</div></div>");
    static Pattern roomMainAndSubTypePattern = Pattern.compile("<div class=\"type\"><div class=\"mainInfo\" title=\".*?\">(.*?)</div><div class=\"subInfo\">(.*?)</div></div>");
    static Pattern areaMainAndSubInfoPattern = Pattern.compile("<div class=\"area\"><div class=\"mainInfo\">(.*?)</div><div class=\"subInfo\">(.*?)</div></div>");

    static Pattern communityNamePattern = Pattern.compile("<div class=\"communityName\"><i></i><span class=\"label\">.*?><a.*?>(.*?)</a>");
    static Pattern areaNameHtmlPattern = Pattern.compile("<div class=\"areaName\"><i></i><span class=\"label\">所在区域</span><span class=\"info\">(.*?)</span>");
    static Pattern areaNameHtmlPattern_1 = Pattern.compile("<a.*?>(.*?)</a>");

    static Pattern schoolNamePattern = Pattern.compile("<.*?>对口学校.*?title=\"(.*?)\">");

    static Pattern baseContentPattern = Pattern.compile("<div class=\"base\"><div class=\"name\">基本属性</div><div class=\"content\"><ul><li><span class=\"label\">房屋户型</span>(.*?)</li><li><span class=\"label\">所在楼层</span>(.*?)</li><li><span class=\"label\">建筑面积</span>(.*?)</li><li><span class=\"label\">户型结构</span>(.*?)</li><li><span class=\"label\">套内面积</span>(.*?)</li><li><span class=\"label\">建筑类型</span>(.*?)</li><li><span class=\"label\">房屋朝向</span>(.*?)</li><li><span class=\"label\">建筑结构</span>(.*?)</li><li><span class=\"label\">装修情况</span>(.*?)</li><li><span class=\"label\">梯户比例</span>(.*?)</li><li><span class=\"label\">配备电梯</span>(.*?)</li><li><span class=\"label\">产权年限</span>(.*?)</li></ul></div></div>");
    static Pattern transactionContentPattern = Pattern.compile("<div class=\"transaction\"><div class=\"name\">交易属性</div><div class=\"content\"><ul><li><span class=\"label\">挂牌时间</span>(.*?)</li><li><span class=\"label\">交易权属</span>(.*?)</li><li><span class=\"label\">上次交易</span>(.*?)</li><li><span class=\"label\">房屋用途</span>(.*?)</li><li><span class=\"label\">房屋年限</span>(.*?)</li><li><span class=\"label\">产权所属</span>(.*?)</li>(.*?)<li><span class=\"label\">抵押信息</span>(.*?)</li><li><span class=\"label\">房本备件</span>(.*?)</li></ul></div></div>");
    static Pattern tagsHtmlPattern = Pattern.compile("<div class=\"name\">房源标签</div><div class=\"content\">(.*?)</div>");
    static Pattern tagsHtmlPattern_1 = Pattern.compile("<a class=\"tag\".*?>(.*?)</a>");
    static Pattern decoratingDescPattern = Pattern.compile("<div class=\"name\">装修描述</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern houseTypeDescPattern = Pattern.compile("<div class=\"name\">户型介绍</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern investmentDescPattern = Pattern.compile("<div class=\"name\">投资分析</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern villageDescPattern = Pattern.compile("<div class=\"name\">小区介绍</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern schoolDescPattern = Pattern.compile("<div class=\"name\">学校介绍</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern sellingPointDescPattern = Pattern.compile("<div class=\"name\">核心卖点</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern reason4saleDescPattern = Pattern.compile("<div class=\"name\">售房原因</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern supportingDescPattern = Pattern.compile("<div class=\"name\">周边配套</div><div class=\"content\">((.|\n|\r)*?)</div>");
    static Pattern trafficDescPattern = Pattern.compile("<div class=\"name\">交通出行</div><div class=\"content\">((.|\n|\r)*?)</div>");
//在售详细信息=======================================end


    //已成交=======================================begin

    static Pattern chengjiaoTitlePattern = Pattern.compile("<div class=\"house-title\"><div class=\"wrapper\">(.*?)<span>");
    static Pattern chengjiaoPrice = Pattern.compile("<span class=\"dealTotalPrice\"><i>(\\d+(\\.\\d+)?)" +
            "</i>万</span><b>(\\d+(\\.\\d+)?)</b>");
    static Pattern t1 = Pattern.compile("class=\"sp01\"><label>(.*?)</label>(.*?)</span>"); //<span class="sp01"><label>1室1厅</label>高楼层(共27层)</span>
    static Pattern t2 = Pattern.compile("class=\"sp02\"><label>(.*?)</label>"); //<span
    // <span class="sp02"><label>东</label>暂无数据</span>
    static Pattern t3 = Pattern.compile("class=\"sp03\"><label>(.*?)</label>(.*?)</span>");//<span
    // class="sp03"><label>44平米</label>2008年建塔楼</span>
    static Pattern t4 = Pattern.compile("-<a .*?>(.*?)</a><a .*?>(.*?)</a>");
    //-<a href="/chengjiao/tianhe/">天河</a><a href="/chengjiao/chebei/">车陂</a>

    //已成交=======================================end


    public static HouseDomain getAndGenChengjiaoHouseObject(String houseUrl, String houseHtml) {

        return null;
    }


    /**
     *生成各个城市的区域sql
     * 上海需要特殊处理
     */
    static public void fetchArea(String cityCode,String cityName){
//        String name = "北京";
//        String city = "bj";
        String cityId = "1";
        String basesql = "insert into area ( `name`,`code`,`parentsId`) values ('${name}','${code}',${cityId});";
        String cityIndexUr =   cityIndexUrl.replace("${city}",cityCode);
        String result = MyHttpClient.get(cityIndexUr);
        String reg = ">\\s+([^\\s<]*)\\s+<";
        result = result.replaceAll(reg, ">$1<");
        //System.out.println(result);
        Pattern tempPattern = Pattern.compile("<div data-role=\"ershoufang\" ><div>(.*?)</div></div>");
        Matcher matcher = tempPattern.matcher(result);
        String tempResult = "";
        if (matcher.find()) {
            tempResult = matcher.group(1);
        }
        tempPattern = Pattern.compile("<a href=\"/ershoufang/(.*?)/\"  title=\""+cityName+"(.*?)在售二手房 \">");
        matcher = tempPattern.matcher(tempResult);
        while (matcher.find()) {
            System.out.println(basesql.replace("${code}",matcher.group(1)).replace("${name}",matcher.group(2)).replace("${cityId}",cityId) );
        }
    }

    /**
     * 获取某个区域下面中分页数
     * @param area
     * @return
     */
    public static int fetchAreaTotalPageNo(String area){
        String pageUrl = firstPageAreasUrl.replace("${area}", area);
        logger.info(area+"  区域请求链接:  "+pageUrl);
        int totalPage=0;
        String result = MyHttpClient.get(pageUrl);
        Matcher exceptiuonMatcher =exceptionVerificationPatter.matcher(result);
        if(exceptiuonMatcher.find()){
            logger.error("fetchAreaTot" +
                    "alPageNo*********************您所在的IP"+exceptiuonMatcher.group(1)+"流量异常，请选出以下倒置的房屋图片*********************");
            return 0;
        }
        if(StringUtils.isBlank(result)){
            logger.warn("fetchAreaTotalPageNo error");
        }
        Matcher matcher = totalPageNoInPageWebPattern.matcher(result);
        while (matcher.find()) {
            totalPage=Integer.parseInt(matcher.group(1));
        }
        logger.info("start fetching area=" + area + ",totalPageNo="+totalPage);
        return totalPage;
    }

    /**
     * 获取某个区域下面的某个分页里面所有的房屋地址
     * @param area 区域地质
     * @param pageNo 分页大小
     * @return
     */
    public static Set<String> fetchAreaHouseUrls(String area, int pageNo) {

        Set<String> urls = new HashSet<>();

        logger.info("start fetching area=" + area + ",pageNo="+pageNo);
        String pageUrl = null;

        String result = "";
        if (pageNo == 1) {
            pageUrl = firstPageAreasUrl.replace("${area}", area);
            result = MyHttpClient.get(pageUrl);
        } else {
            pageUrl = pageAreasUrl.replace("${area}", area).replace("${pageNo}", pageNo + "");
            result = MyHttpClient.get(pageUrl);
        }

        Matcher exceptiuonMatcher =exceptionVerificationPatter.matcher(result);
        if(exceptiuonMatcher.find()){
            logger.error("fetchAreaTotalPageNo*********************您所在的IP"+exceptiuonMatcher.group(1)+"流量异常，请选出以下倒置的房屋图片*********************");
            return null;
        }

        Matcher matcher = houseUrlInPageWebPattern.matcher(result);
        while (matcher.find()) {
            String fangUrl = matcher.group();
            //logger.info(fangUrl);
            urls.add(fangUrl);
//            logger.info("爬取到的房屋地址: "+fangUrl);
        }
        logger.info("area=" + area + " size : "+urls.size());
        return urls;
    }

    /**
     *获取成交记录某个区域下面的某个分页里面所有的房屋地址
     * @param area
     * @param pageNo
     * @return
     */
    public static Set<String> fetchAreaChenjiaoHouseUrls(String area, int pageNo) {

        Set<String> urls = new HashSet<>();

        logger.info("start fetching chengjiao area=" + area + ",pageNo="+pageNo);
        String pageUrl = null;

        String result = "";
        if (pageNo == 1) {
            pageUrl = firstChenjiaoPageAreasUrl.replace("${area}", area);
            result = MyHttpClient.get(pageUrl);
        } else {
            pageUrl = chengjiaoPageAreasUrl.replace("${area}", area).replace("${pageNo}", pageNo + "");
            result = MyHttpClient.get(pageUrl);
        }
        Matcher matcher = chengjiaoHouseUrlInPageWebPattern.matcher(result);
        while (matcher.find()) {
            String fangUrl = matcher.group();
            //logger.info(fangUrl);
            urls.add(fangUrl);
        }
        logger.info("area=" + area + " size : "+urls.size());
        return urls;
    }
    /**
     * 获取房屋的详细信息
     *
     * @param houseUrl
     * @param houseHtml
     * @return
     */
    public static HouseDomain getAndGenHouseObject(String houseUrl, String houseHtml) {

//        if(houseUrl.indexOf("chengjiao")>-1)
//            return getAndGenChengjiaoHouseObject(houseUrl, houseHtml);

        String reg = ">\\s+([^\\s<]*)\\s+<";
        String result = "";
        houseHtml = houseHtml.replaceAll(reg, ">$1<");
        HouseDomain houseDomain = new HouseDomain();
        houseDomain.setUrl(houseUrl);
        houseDomain.setHtml(houseHtml);
        houseDomain.setCreateTime(new Date());
        matcher = titlePattern.matcher(houseHtml);
        if(matcher.find()) {
            houseDomain.setTitle(matcher.group(1));
        }

        matcher = subTitlePattern.matcher(houseHtml);
        if(matcher.find()) {
            houseDomain.setSubtitle(matcher.group(1));
        }
        matcher = favCountPattern.matcher(houseHtml);
        if (matcher.find()) {
            result = (matcher.group(1));
            houseDomain.setFavCount(Integer.parseInt(result));
//            System.out.println(matcher.group(2));
        }
        matcher = cartCountPattern.matcher(houseHtml);
        if (matcher.find()) {
            result = (matcher.group(1));
            houseDomain.setCartCount(Integer.parseInt(matcher.group(1)));
//            System.out.println(matcher.group(2));
        }
        matcher = pricePattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setPrice(new BigDecimal(matcher.group(1)));
        }

        matcher = unitPricePattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setUnitPrice(new BigDecimal(matcher.group(1)));
        }

        matcher = firstPayPricePattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setFirstPayPrice(new BigDecimal(matcher.group(1)));
        }

        matcher = taxPricePattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setTaxPrice(new BigDecimal(matcher.group(1)));
        }

        matcher = roomMainAndSubInfoPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setRoomMainInfo(matcher.group(1));
            houseDomain.setRoomSubInfo(matcher.group(2));
        }

        matcher = roomMainAndSubTypePattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setRoomMainType(matcher.group(1));
            houseDomain.setRoomSubType(matcher.group(2));
        }

        matcher = areaMainAndSubInfoPattern.matcher(houseHtml);
        if (matcher.find()) {
            String temp = matcher.group(1);
            houseDomain.setAreaMainInfo(temp);
            houseDomain.setRoomSize(Double.parseDouble(temp.replaceAll("平米", "")));
            houseDomain.setAreaSubInfo(matcher.group(2));
        }

        matcher = communityNamePattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setCommunityName(matcher.group(1));
        }

        matcher = areaNameHtmlPattern.matcher(houseHtml);
        if (matcher.find()) {
            String r = matcher.group(1);
            Matcher tmatcher = areaNameHtmlPattern_1.matcher(r);
            StringBuffer sb = new StringBuffer();
            while (tmatcher.find()) {
                sb.append(" ").append(tmatcher.group(1));
            }
            houseDomain.setAreaName(sb.toString());
        }

//        matcher = schoolNamePattern.matcher(houseHtml);
//        if(matcher.find()) {
//            houseDomain.setSchoolName(matcher.group(1));
//        }

        matcher = baseContentPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setBaseContent1(matcher.group(1));
            houseDomain.setBaseContent2(matcher.group(2));
            houseDomain.setBaseContent3(matcher.group(3));
            houseDomain.setBaseContent4(matcher.group(4));
            houseDomain.setBaseContent5(matcher.group(5));
            houseDomain.setBaseContent6(matcher.group(6));
            houseDomain.setBaseContent7(matcher.group(7));
            houseDomain.setBaseContent8(matcher.group(8));
            houseDomain.setBaseContent9(matcher.group(9));
            houseDomain.setBaseContent10(matcher.group(10));
            houseDomain.setBaseContent11(matcher.group(11));
            houseDomain.setBaseContent12(matcher.group(12));
        }

        matcher = transactionContentPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setTransactionContent1(matcher.group(1));
            houseDomain.setTransactionContent2(matcher.group(2));
            houseDomain.setTransactionContent3(matcher.group(3));
            houseDomain.setTransactionContent4(matcher.group(4));
            houseDomain.setTransactionContent5(matcher.group(5));
            houseDomain.setTransactionContent6(matcher.group(6));
            houseDomain.setTransactionContent7(matcher.group(7));
            houseDomain.setTransactionContent8(matcher.group(8));
//            houseDomain.setTransactionContent9(matcher.group(9));
//            houseDomain.setTransactionContent10(matcher.group(10));
            //System.out.println(matcher.group(11));
            //System.out.println(matcher.group(12));

        }


        matcher = tagsHtmlPattern.matcher(houseHtml);
        if (matcher.find()) {
            String tagsHtml = matcher.group(1);
            Matcher tmatcher = tagsHtmlPattern_1.matcher(tagsHtml);
            StringBuffer tagsb = new StringBuffer();
            while ((tmatcher.find())) {
                tagsb.append(" ").append(tmatcher.group(1));
            }
            houseDomain.setTags(tagsb.toString());
        }

        matcher = decoratingDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setDecoratingDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        matcher = houseTypeDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setHouseTypeDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        matcher = investmentDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setInvestmentDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        matcher = villageDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setVillageDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        matcher = schoolDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setSchoolDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        matcher = sellingPointDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setSellingPointDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }


        matcher = reason4saleDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setReason4saleDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }


        matcher = supportingDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setSupportingDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        matcher = trafficDescPattern.matcher(houseHtml);
        if (matcher.find()) {
            houseDomain.setTrafficDesc(matcher.group(1).replace("  ", "").replaceAll("\n|\r", ""));
        }

        return houseDomain;
    }


    public static void main(String[] args) {
//        fetchArea("cd","成都");
//        //获取该城市里,某个区域符合条件的记录数
//        int totalPage=fetchAreaTotalPageNo("jinjiang");
//        //获取该城市里,某个分页里面所有的房屋详情url地址
//        Set<String> houseUrls=fetchAreaHouseUrls("jinjiang",1);
//        //注意一次不要执行太多,有反爬虫的
//        for(int i=1;i<2;i++){
//            for(String url:houseUrls){
//                String houseDetailHtml= MyHttpClient.get(url);
//                HouseDomain houseDomain = getAndGenHouseObject(url, houseDetailHtml);
//            }
//        }

        //解析房屋详情里面的信息
        // HouseDomain houseDomain = getAndGenHouseObject(htmlDetailPath, houseDetailHtml);

        //保存房屋信息到数据库

//        //调试房屋详情页面
//        String htmlDetailPath = LianJiaWebPattern.class.getClassLoader().getResource("houseDetail.html").getPath();
//        String houseDetailHtml = readHtmlFromFile(htmlDetailPath);
//        HouseDomain houseDomain = getAndGenHouseObject(htmlDetailPath, houseDetailHtml);
//        System.out.println(houseDomain);
//
        //调试房屋列表页面
        String htmlListPath = LianJiaWebPattern.class.getClassLoader().getResource("houseChengJiaoList.html").getPath();
        String houseListHtml = readHtmlFromFile(htmlListPath);
        HouseDomain houseDomain = getAndGenHouseObject(htmlListPath, houseListHtml);
        System.out.println(houseDomain);
    }

    public static String readHtmlFromFile(String fileUrl) {
        File file = new File(fileUrl);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
