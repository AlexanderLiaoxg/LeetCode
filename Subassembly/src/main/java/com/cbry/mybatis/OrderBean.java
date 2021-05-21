package com.cbry.mybatis;

public class OrderBean {
	String orderId;
	String orderName;
	String orderCity;
	double orderPrice;
	CustomerBean customer;
	public OrderBean(String orderId, String orderName, String orderCity, double orderPrice, CustomerBean customer) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderCity = orderCity;
		this.orderPrice = orderPrice;
		this.customer = customer;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderCity() {
		return orderCity;
	}
	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public CustomerBean getcustomer() {
		return customer;
	}
	public void setcustomer(CustomerBean customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", orderName=" + orderName + ", orderCity=" + orderCity
				+ ", orderPrice=" + orderPrice + ", customer=" + customer + "]";
	}
	
}
