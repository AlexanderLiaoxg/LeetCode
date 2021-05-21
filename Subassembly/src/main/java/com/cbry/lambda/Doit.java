package com.cbry.lambda;

import java.util.ArrayList;
import java.util.Collections;

public class Doit {
	public static void main(String[] args) {
		Targets whole = (int a, int b) -> {
			System.out.println("whole param:" + "{" + a + "," + +b + "}");
			return a + b;
		};
		whole.say(1, 2); // 执行实现类方法

		Targets noFlower = (int a, int b) -> a;

		// Doit.traverse();

		Thread thread = new Thread(() -> {
			for (int i = 0; i < 6; i++) {
				System.out.println("good good study , day day up");
			}
		});
		thread.start();

	}

	static void traverse() {
		ArrayList<Integer> list = new ArrayList<>();

		Collections.addAll(list, 1, 2, 3, 4, 5, 6);

		// lambda删除集合元素
		list.removeIf(element -> element == 1);

		// lambda表达式遍历每个对象
		list.forEach(System.out::println); // out：23456

		list.forEach(element -> {
			if (element % 2 == 0) {
				System.out.println(element); // out：246
			}
		});

		/*
		 * list.sort(new Comparator<Item>() {
		 * 
		 * @Override public int compare(Item o1, Item o2) { return o1.getId() -
		 * o2.getId(); } });
		 */

		list.sort((o1, o2) -> o1 - o2); // 假设Item对象有id属性和get方法
	}

}
