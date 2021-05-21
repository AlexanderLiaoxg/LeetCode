package com.cbry.mybatis;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
	public OrderBean findSimpleOrderInfo(String orderId);
	public OrderBean findOrderInfo(String orderId);
	public CustomerBean findCustomerById(String customerId);
	
	//UU&Snow&AutoIncreasing
	public int insertOrderInfo(Map<String , String> customerInfo);
}
