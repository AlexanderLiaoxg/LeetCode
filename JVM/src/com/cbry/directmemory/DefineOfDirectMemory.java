package com.cbry.directmemory;

import java.io.IOException;
import java.nio.ByteBuffer;

public class DefineOfDirectMemory {
public static void main(String[] args) throws IOException {
	ByteBuffer bb = ByteBuffer.allocateDirect(1024*1024*1000);	//����1000m�ڴ�
	System.out.println("�����ڴ�...");
	System.in.read();
	System.out.println("����JVM���ն���bb���ڴ棩");
	bb = null;
	System.gc();	//ִ����������
	System.in.read();
}
}
