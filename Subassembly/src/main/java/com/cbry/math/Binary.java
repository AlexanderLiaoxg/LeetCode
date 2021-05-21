package com.cbry.math;

public class Binary {
public static void main(String[] args) {
	String num = "8";
	String result;
	int t = 0;
	String binaryString = String.valueOf(Integer.toBinaryString(Integer.valueOf(num))); //String s, int radix进制
	System.out.println(num + "转换为二进制为：" + binaryString);
	for (char binaryChar : binaryString.toCharArray()) {
		t = t + Integer.parseInt(String.valueOf(binaryChar));
	}
	result=(t==1)?"true":"false";
	System.out.println("是否为二的次幂数：" + result);
	
	//与运算
	int intNum = Integer.valueOf(num);
	result=(  (intNum & (intNum-1)) ==0)?"true":"false";
	System.out.println("与  的方法运算结果：" + result);
}
}
