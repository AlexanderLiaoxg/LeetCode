package com.cbry.heap;

import java.util.ArrayList;
import java.util.List;

/*
 * Xmx8m，演示java.lang.OutOfMemoryError: Java heap space
 * */

public class heapDemo {
public static void main(String[] args) {
	int i=0;
	try {
		List<String> list =  new ArrayList<>();
		String a = "hello";
		while (true) {Thread.sleep(5000);
			list.add(a);
			a=a+a;
			i++;
		}
	} catch (Throwable e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("执行次数：" + i);
	}
}
}
