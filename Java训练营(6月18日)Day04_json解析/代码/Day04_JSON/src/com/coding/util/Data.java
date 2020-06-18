package com.coding.util;

import java.util.List;

/**
 * 疫情的数据：Data
 * @author ruby
 *
 */
public class Data {
	private String times;//事件
	private String mtime;//最后修改事件
	private String cachetime;//缓存事件
	private String gntotal;//累计确诊
	private String deathtotal;//死亡人数
	private String sustotal;//疑似病例
	private String curetotal;//治愈人数
	private String econNum;//现存确诊
	private String heconNum;//现存确诊重症
	private AddDaily add_daily;//每日新增
	
	private List<Province> provinceList;//省份列表
	
	//此处还缺国外的数据
	
	
	
	public List<Province> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}
	public AddDaily getAdd_daily() {
		return add_daily;
	}
	public void setAdd_daily(AddDaily add_daily) {
		this.add_daily = add_daily;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getCachetime() {
		return cachetime;
	}
	public void setCachetime(String cachetime) {
		this.cachetime = cachetime;
	}
	public String getGntotal() {
		return gntotal;
	}
	public void setGntotal(String gntotal) {
		this.gntotal = gntotal;
	}
	public String getDeathtotal() {
		return deathtotal;
	}
	public void setDeathtotal(String deathtotal) {
		this.deathtotal = deathtotal;
	}
	public String getSustotal() {
		return sustotal;
	}
	public void setSustotal(String sustotal) {
		this.sustotal = sustotal;
	}
	public String getCuretotal() {
		return curetotal;
	}
	public void setCuretotal(String curetotal) {
		this.curetotal = curetotal;
	}
	public String getEconNum() {
		return econNum;
	}
	public void setEconNum(String econNum) {
		this.econNum = econNum;
	}
	public String getHeconNum() {
		return heconNum;
	}
	public void setHeconNum(String heconNum) {
		this.heconNum = heconNum;
	}
	@Override
	public String toString() {
		return "Data [times=" + times + ", mtime=" + mtime + ", cachetime=" + cachetime + ", gntotal=" + gntotal
				+ ", deathtotal=" + deathtotal + ", sustotal=" + sustotal + ", curetotal=" + curetotal + ", econNum="
				+ econNum + ", heconNum=" + heconNum + "]";
	}
	
	
	
	
}
