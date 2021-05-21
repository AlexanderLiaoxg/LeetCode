package com.cbry.classs;

import java.io.IOException;

public class ExceptionClasss {
	
	public void exceptionDemo() {
		int i = 6;
		try {
			i = 10;
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			// TODO: handle exception
			i = 10;
		} finally {
			i = 11;
		}
	}
	
	public int finallyDemo() {
		int i = 10;
		try {
			return i;
		}finally {
			i = 20;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new ExceptionClasss().finallyDemo());
	}
}
