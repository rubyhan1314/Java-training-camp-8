package com.coding.util;

public class AddDaily {
	private String addcon_new;//累计确诊，较昨日
	private String adddeath_new;//累计死亡，较昨日
	private String addcure_new;//累计治愈，较昨日
	private String wjw_addsus_new;//现存疑似，较昨日
	private String addecon_new;//现存确诊，较昨日
	private String addhecon_new;//现存确诊重症，较昨日
	public String getAddcon_new() {
		return addcon_new;
	}
	public void setAddcon_new(String addcon_new) {
		this.addcon_new = addcon_new;
	}
	public String getAdddeath_new() {
		return adddeath_new;
	}
	public void setAdddeath_new(String adddeath_new) {
		this.adddeath_new = adddeath_new;
	}
	public String getAddcure_new() {
		return addcure_new;
	}
	public void setAddcure_new(String addcure_new) {
		this.addcure_new = addcure_new;
	}
	public String getWjw_addsus_new() {
		return wjw_addsus_new;
	}
	public void setWjw_addsus_new(String wjw_addsus_new) {
		this.wjw_addsus_new = wjw_addsus_new;
	}
	public String getAddecon_new() {
		return addecon_new;
	}
	public void setAddecon_new(String addecon_new) {
		this.addecon_new = addecon_new;
	}
	public String getAddhecon_new() {
		return addhecon_new;
	}
	public void setAddhecon_new(String addhecon_new) {
		this.addhecon_new = addhecon_new;
	}
	@Override
	public String toString() {
		return "AddDaily [addcon_new=" + addcon_new + ", adddeath_new=" + adddeath_new + ", addcure_new=" + addcure_new
				+ ", wjw_addsus_new=" + wjw_addsus_new + ", addecon_new=" + addecon_new + ", addhecon_new="
				+ addhecon_new + "]";
	}
	
	
}
