package com.cbry.classs;

public class InitClasss {
	private int a = 0;
	
	{
		a = 1;
	}

	public InitClasss(int arg0) {
		this.a = arg0;
	}
	
	public static void main(String[] args) {
		InitClasss ic = new InitClasss(2);
		System.out.println(ic.a);
	}
}
