package com.domain;
import java.io.Serializable;
import java.math.BigDecimal;
public class CstResidentialArea implements Serializable {
	private static final long serialVersionUID = 5042158890705211080L;
	private  Long id;
    private String address;
    private String provide;
    private String city;
    private String area;
    private String name;
    private BigDecimal longitude;
    private BigDecimal latitude;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvide() {
		return provide;
	}
	public void setProvide(String provide) {
		this.provide = provide;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "CstResidentialArea [id=" + id + ", address=" + address + ", provide=" + provide + ", city=" + city
				+ ", area=" + area + ", name=" + name + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public CstResidentialArea(Long id, String address, String provide, String city, String area, String name,
			BigDecimal longitude, BigDecimal latitude) {
		super();
		this.id = id;
		this.address = address;
		this.provide = provide;
		this.city = city;
		this.area = area;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public CstResidentialArea() {
		super();
	}
}
