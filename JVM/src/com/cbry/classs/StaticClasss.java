package com.cbry.classs;

/**
 * @apiNote 
 * 对于静态代码块的编码查验：cinit指令
 **/
public class StaticClasss {
	static int i = 0;
	static{
		i = 1;
	}

	static{
		i = 2;	
	}

}
