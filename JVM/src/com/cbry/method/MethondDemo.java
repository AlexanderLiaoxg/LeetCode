package com.cbry.method;

import java.util.HashSet;
import java.util.Set;

import jdk.internal.org.objectweb.asm.*;

public class MethondDemo extends ClassLoader{
	
	void before8() {
		int j = 0;
		try {
			MethondDemo test = new MethondDemo();
			for (int i = 0; i < 10000; i++) {
				//Classwriter ������������Ķ������ֽ���
				ClassWriter cw = new ClassWriter();
				//�汾�ţ�public�����������������࣬�ӿ�
				cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
				
				//����Byte[]
				byte[] code = cw.toByteArray();
				test.defineClass("Class" + i, code, 0 ,code.length);
				
			}
		} finally {
			// TODO: handle finally clause
		}
	}

	void after8(){
		int j = 0;
		try {
			MethondDemo test = new MethondDemo();
			for (int i = 0; i < 10000; i++) {
				//Classwriter ������������Ķ������ֽ���
				ClassWriter cw = new ClassWriter();
				//�汾�ţ�public�����������������࣬�ӿ�
				cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
				
				//����Byte[]
				byte[] code = cw.toByteArray();
				test.defineClass("Class" + i, code, 0 ,code.length);
				
			}
		} finally {
			// TODO: handle finally clause
		}
	}
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>(10);
		int j;
		for (int i = 0; i < 200; i++) {
			j = i;
			if (j>10) {
				j=0;
			}
			set.add(String.valueOf(j));
		}
		for (String string : set) {
			System.out.println(string);
		}
	}
}
