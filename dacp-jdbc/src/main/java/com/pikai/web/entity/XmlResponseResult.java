package com.pikai.web.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class XmlResponseResult {
	private boolean success;
	private String code;
	private String msg;
	private Object data;

	@XmlElement
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@XmlElement
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public XmlResponseResult(boolean success, String code, String msg, Object data) {
		this.success = success;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public XmlResponseResult() {
	}
}
