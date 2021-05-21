package com.cbry.method;

/*
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * +是打开开关 -是关闭开关
 * */
public class MethondGC {
public static void main(String[] args) {
	int i = 0;
	try {
		for (int j = 0; j < 100000; j++) {
			String.valueOf(j).intern();
		}
	} catch (Throwable e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		System.out.println(i);
	}
}
}
