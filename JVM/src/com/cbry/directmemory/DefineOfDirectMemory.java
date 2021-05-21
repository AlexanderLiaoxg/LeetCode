package com.cbry.directmemory;

import java.io.IOException;
import java.nio.ByteBuffer;

public class DefineOfDirectMemory {
public static void main(String[] args) throws IOException {
	ByteBuffer bb = ByteBuffer.allocateDirect(1024*1024*1000);	//分配1000m内存
	System.out.println("分配内存...");
	System.in.read();
	System.out.println("尝试JVM回收对象bb（内存）");
	bb = null;
	System.gc();	//执行垃圾回收
	System.in.read();
}
}
