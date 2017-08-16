package com.pikai.domain;

import com.pikai.base.BaseDomain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目名称：dacp
 * 包名： com.pikai.domain
 * 类名称：
 * 类描述：  房屋信息描述类
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/8 23:25
 */
public class HouseDomain extends BaseDomain {
    private Long id;

    private String code;

    private String url;

    private String title;

    private String subtitle;

    private Integer favCount;

    private Integer cartCount;

    private BigDecimal price;

    private BigDecimal unitPrice;

    private BigDecimal firstPayPrice;

    private BigDecimal taxPrice;

    private String roomMainInfo;

    private String roomMainType;

    private String roomSubType;

    private String areaMainInfo;

    private String areaSubInfo;

    private String communityName;

    private String areaName;

    private String schoolName;

    private String tags;

    private String decoratingDesc;

    private String houseTypeDesc;

    private String investmentDesc;

    private String villageDesc;

    private String schoolDesc;

    private String sellingPointDesc;

    private String reason4saleDesc;

    private String supportingDesc;

    private String trafficDesc;

    private Date createTime;

    private String baseContent1;

    private String baseContent2;

    private String baseContent3;

    private String baseContent4;

    private String baseContent5;

    private String baseContent6;

    private String baseContent7;

    private String baseContent8;

    private String baseContent9;

    private String baseContent10;

    private String baseContent11;

    private String baseContent12;

    private String transactionContent1;

    private String transactionContent2;

    private String transactionContent3;

    private String transactionContent4;

    private String transactionContent5;

    private String transactionContent6;

    private String transactionContent7;

    private String transactionContent8;

    private String transactionContent9;

    private String transactionContent10;

    private String html;

    private BigDecimal chengjiaoPrice;

    private String roomSubInfo;

    private Double roomSize;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    public Integer getCartCount() {
        return cartCount;
    }

    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getFirstPayPrice() {
        return firstPayPrice;
    }

    public void setFirstPayPrice(BigDecimal firstPayPrice) {
        this.firstPayPrice = firstPayPrice;
    }

    public BigDecimal getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(BigDecimal taxPrice) {
        this.taxPrice = taxPrice;
    }

    public String getRoomMainInfo() {
        return roomMainInfo;
    }

    public void setRoomMainInfo(String roomMainInfo) {
        this.roomMainInfo = roomMainInfo == null ? null : roomMainInfo.trim();
    }

    public String getRoomMainType() {
        return roomMainType;
    }

    public void setRoomMainType(String roomMainType) {
        this.roomMainType = roomMainType == null ? null : roomMainType.trim();
    }

    public String getRoomSubType() {
        return roomSubType;
    }

    public void setRoomSubType(String roomSubType) {
        this.roomSubType = roomSubType == null ? null : roomSubType.trim();
    }

    public String getAreaMainInfo() {
        return areaMainInfo;
    }

    public void setAreaMainInfo(String areaMainInfo) {
        this.areaMainInfo = areaMainInfo == null ? null : areaMainInfo.trim();
    }

    public String getAreaSubInfo() {
        return areaSubInfo;
    }

    public void setAreaSubInfo(String areaSubInfo) {
        this.areaSubInfo = areaSubInfo == null ? null : areaSubInfo.trim();
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getDecoratingDesc() {
        return decoratingDesc;
    }

    public void setDecoratingDesc(String decoratingDesc) {
        this.decoratingDesc = decoratingDesc == null ? null : decoratingDesc.trim();
    }

    public String getHouseTypeDesc() {
        return houseTypeDesc;
    }

    public void setHouseTypeDesc(String houseTypeDesc) {
        this.houseTypeDesc = houseTypeDesc == null ? null : houseTypeDesc.trim();
    }

    public String getInvestmentDesc() {
        return investmentDesc;
    }

    public void setInvestmentDesc(String investmentDesc) {
        this.investmentDesc = investmentDesc == null ? null : investmentDesc.trim();
    }

    public String getVillageDesc() {
        return villageDesc;
    }

    public void setVillageDesc(String villageDesc) {
        this.villageDesc = villageDesc == null ? null : villageDesc.trim();
    }

    public String getSchoolDesc() {
        return schoolDesc;
    }

    public void setSchoolDesc(String schoolDesc) {
        this.schoolDesc = schoolDesc == null ? null : schoolDesc.trim();
    }

    public String getSellingPointDesc() {
        return sellingPointDesc;
    }

    public void setSellingPointDesc(String sellingPointDesc) {
        this.sellingPointDesc = sellingPointDesc == null ? null : sellingPointDesc.trim();
    }

    public String getReason4saleDesc() {
        return reason4saleDesc;
    }

    public void setReason4saleDesc(String reason4saleDesc) {
        this.reason4saleDesc = reason4saleDesc == null ? null : reason4saleDesc.trim();
    }

    public String getSupportingDesc() {
        return supportingDesc;
    }

    public void setSupportingDesc(String supportingDesc) {
        this.supportingDesc = supportingDesc == null ? null : supportingDesc.trim();
    }

    public String getTrafficDesc() {
        return trafficDesc;
    }

    public void setTrafficDesc(String trafficDesc) {
        this.trafficDesc = trafficDesc == null ? null : trafficDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBaseContent1() {
        return baseContent1;
    }

    public void setBaseContent1(String baseContent1) {
        this.baseContent1 = baseContent1 == null ? null : baseContent1.trim();
    }

    public String getBaseContent2() {
        return baseContent2;
    }

    public void setBaseContent2(String baseContent2) {
        this.baseContent2 = baseContent2 == null ? null : baseContent2.trim();
    }

    public String getBaseContent3() {
        return baseContent3;
    }

    public void setBaseContent3(String baseContent3) {
        this.baseContent3 = baseContent3 == null ? null : baseContent3.trim();
    }

    public String getBaseContent4() {
        return baseContent4;
    }

    public void setBaseContent4(String baseContent4) {
        this.baseContent4 = baseContent4 == null ? null : baseContent4.trim();
    }

    public String getBaseContent5() {
        return baseContent5;
    }

    public void setBaseContent5(String baseContent5) {
        this.baseContent5 = baseContent5 == null ? null : baseContent5.trim();
    }

    public String getBaseContent6() {
        return baseContent6;
    }

    public void setBaseContent6(String baseContent6) {
        this.baseContent6 = baseContent6 == null ? null : baseContent6.trim();
    }

    public String getBaseContent7() {
        return baseContent7;
    }

    public void setBaseContent7(String baseContent7) {
        this.baseContent7 = baseContent7 == null ? null : baseContent7.trim();
    }

    public String getBaseContent8() {
        return baseContent8;
    }

    public void setBaseContent8(String baseContent8) {
        this.baseContent8 = baseContent8 == null ? null : baseContent8.trim();
    }

    public String getBaseContent9() {
        return baseContent9;
    }

    public void setBaseContent9(String baseContent9) {
        this.baseContent9 = baseContent9 == null ? null : baseContent9.trim();
    }

    public String getBaseContent10() {
        return baseContent10;
    }

    public void setBaseContent10(String baseContent10) {
        this.baseContent10 = baseContent10 == null ? null : baseContent10.trim();
    }

    public String getBaseContent11() {
        return baseContent11;
    }

    public void setBaseContent11(String baseContent11) {
        this.baseContent11 = baseContent11 == null ? null : baseContent11.trim();
    }

    public String getBaseContent12() {
        return baseContent12;
    }

    public void setBaseContent12(String baseContent12) {
        this.baseContent12 = baseContent12 == null ? null : baseContent12.trim();
    }

    public String getTransactionContent1() {
        return transactionContent1;
    }

    public void setTransactionContent1(String transactionContent1) {
        this.transactionContent1 = transactionContent1 == null ? null : transactionContent1.trim();
    }

    public String getTransactionContent2() {
        return transactionContent2;
    }

    public void setTransactionContent2(String transactionContent2) {
        this.transactionContent2 = transactionContent2 == null ? null : transactionContent2.trim();
    }

    public String getTransactionContent3() {
        return transactionContent3;
    }

    public void setTransactionContent3(String transactionContent3) {
        this.transactionContent3 = transactionContent3 == null ? null : transactionContent3.trim();
    }

    public String getTransactionContent4() {
        return transactionContent4;
    }

    public void setTransactionContent4(String transactionContent4) {
        this.transactionContent4 = transactionContent4 == null ? null : transactionContent4.trim();
    }

    public String getTransactionContent5() {
        return transactionContent5;
    }

    public void setTransactionContent5(String transactionContent5) {
        this.transactionContent5 = transactionContent5 == null ? null : transactionContent5.trim();
    }

    public String getTransactionContent6() {
        return transactionContent6;
    }

    public void setTransactionContent6(String transactionContent6) {
        this.transactionContent6 = transactionContent6 == null ? null : transactionContent6.trim();
    }

    public String getTransactionContent7() {
        return transactionContent7;
    }

    public void setTransactionContent7(String transactionContent7) {
        this.transactionContent7 = transactionContent7 == null ? null : transactionContent7.trim();
    }

    public String getTransactionContent8() {
        return transactionContent8;
    }

    public void setTransactionContent8(String transactionContent8) {
        this.transactionContent8 = transactionContent8 == null ? null : transactionContent8.trim();
    }

    public String getTransactionContent9() {
        return transactionContent9;
    }

    public void setTransactionContent9(String transactionContent9) {
        this.transactionContent9 = transactionContent9 == null ? null : transactionContent9.trim();
    }

    public String getTransactionContent10() {
        return transactionContent10;
    }

    public void setTransactionContent10(String transactionContent10) {
        this.transactionContent10 = transactionContent10 == null ? null : transactionContent10.trim();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    public BigDecimal getChengjiaoPrice() {
        return chengjiaoPrice;
    }

    public void setChengjiaoPrice(BigDecimal chengjiaoPrice) {
        this.chengjiaoPrice = chengjiaoPrice;
    }

    public String getRoomSubInfo() {
        return roomSubInfo;
    }

    public void setRoomSubInfo(String roomSubInfo) {
        this.roomSubInfo = roomSubInfo == null ? null : roomSubInfo.trim();
    }

    public Double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Double roomSize) {
        this.roomSize = roomSize;
    }


}
