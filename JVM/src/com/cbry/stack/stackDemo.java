package com.cbry.stack;

public class stackDemo {
	
	//-Xss256k
	
	static int count = 0;
	
	static void stackOverflowErrorDemo(){
		count++;
		stackOverflowErrorDemo();
	}
	
	public static void main(String[] args) {
		try {
			stackOverflowErrorDemo();
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("调用方法数量:" + count);
		}
	}
}
