package com.cbry.classs;

public class MethodClasss {
	//空构造方法
	public MethodClasss() {}
	
	private void method1() {}
	
	public final void method2() {}
	
	public void method3() {}
	
	private static void method4() {}
	
	public static void main(String[] args) {
		MethodClasss mc = new MethodClasss();
		mc.method1();
		mc.method2();
		mc.method3();
		mc.method4();
		MethodClasss.method4();
	}
	
}
