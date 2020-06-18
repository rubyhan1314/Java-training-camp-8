package com.coding.util;
/**
 * 省份
 * @author ruby
 *
 */
public class Province {
	private String name;//省份名
	private String ename;//英文名
	private String value;//确诊
	private String conadd;//新增确诊
	private String econNum;//现存确诊
	private String susNum;//疑似
	private String deathNum;//死亡
	private String cureNum;//治愈
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getConadd() {
		return conadd;
	}
	public void setConadd(String conadd) {
		this.conadd = conadd;
	}
	public String getEconNum() {
		return econNum;
	}
	public void setEconNum(String econNum) {
		this.econNum = econNum;
	}
	public String getSusNum() {
		return susNum;
	}
	public void setSusNum(String susNum) {
		this.susNum = susNum;
	}
	public String getDeathNum() {
		return deathNum;
	}
	public void setDeathNum(String deathNum) {
		this.deathNum = deathNum;
	}
	public String getCureNum() {
		return cureNum;
	}
	public void setCureNum(String cureNum) {
		this.cureNum = cureNum;
	}
	@Override
	public String toString() {
		return "Province [name=" + name + ", ename=" + ename + ", value=" + value + ", conadd=" + conadd + ", econNum="
				+ econNum + ", susNum=" + susNum + ", deathNum=" + deathNum + ", cureNum=" + cureNum + "]";
	}
	
}
