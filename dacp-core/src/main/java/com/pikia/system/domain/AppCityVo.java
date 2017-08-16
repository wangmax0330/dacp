package com.pikia.system.domain;

import java.util.List;

import net.sf.ezmorph.bean.MorphDynaBean;

public class AppCityVo {
	private String name;
	private List<AppDistrictVo> district;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppDistrictVo> getDistrict() {
		return district;
	}

	public void setDistrict(List<AppDistrictVo> district) {
		this.district = district;
	}
}
