package com.pikia.system.domain;

import java.util.List;

import net.sf.ezmorph.bean.MorphDynaBean;

public class AppProvinceVo {
	// public static String provinceName =
	// "[请选择, 北京, 广东, 上海, 天津, 重庆, 辽宁, 江苏, 湖北, 四川, 陕西, 河北, 山西, 河南, 吉林, 黑龙江, 内蒙古, 山东, 安徽, 浙江, 福建, 湖南, 广西, 江西, 贵州, 云南, 西藏, 海南, 甘肃, 宁夏, 青海, 新疆, 香港, 澳门, 台湾, 海外, 其他]";
	private String name;
	private List<MorphDynaBean> sub;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MorphDynaBean> getSub() {
		return sub;
	}

	public void setSub(List<MorphDynaBean> city) {
		this.sub = city;
	}
}
