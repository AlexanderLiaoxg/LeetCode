package com.cbry.mybatis;

public class CustomerBean {
	String cId;
	String cName;
	int cAge;
	public CustomerBean(String cId, String cName, int cAge) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAge = cAge;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcAge() {
		return cAge;
	}
	public void setcAge(int cAge) {
		this.cAge = cAge;
	}
	@Override
	public String toString() {
		return "CustorBean [cId=" + cId + ", cName=" + cName + ", cAge=" + cAge + "]";
	}
}
