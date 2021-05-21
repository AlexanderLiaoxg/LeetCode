package com.cbry.classs;

public class SynchronizedClasss {
public static void main(String[] args) {
	Object obj = new Object();
	synchronized (obj) {
		System.out.println("Hello JVM");
	}
}
}
