package com.pikia.system.domain;

import java.util.Date;

import com.pikia.component.base.BaseDomain;

public class SystemUserDomain extends BaseDomain {
	private String userName;
	private String password;
	private Integer role;
	private Date createTime;
	private String email;
	private String mobile;
	private String photo;

	public SystemUserDomain() {

	}

	public SystemUserDomain(Long id) {
		super(id);
	}

	public boolean isAdmin() {
		if (this.role!=null)
		if (this.role == 1) return true;
		return false;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
