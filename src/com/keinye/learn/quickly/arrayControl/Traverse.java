package com.keinye.learn.quickly.arrayControl;

import java.util.Arrays;

/**
 * 数组遍历
 * 
 * @author keinYe
 *
 */
public class Traverse {
	public static void main(String[] args) {
		int[] ns = new int[] { 1, 2, 3, 4, 5 };
		forIndex(ns);
		forEach(ns);
		printArray(ns);
		reverseOrder(ns);
	}

	/**
	 * 使用下标打印数组
	 * 
	 * @param ns
	 */
	public static void forIndex(int[] ns) {
		for (int i = 0; i < ns.length; i++) {
			System.out.println(ns[i]);
		}
	}

	/**
	 * 使用 for each 打印数组
	 * 
	 * @param ns
	 */
	public static void forEach(int[] ns) {
		for (int n : ns) {
			System.out.println(n);
		}
	}

	/**
	 * 使用 Arrays 打印数组
	 * 
	 * @param ns
	 */
	public static void printArray(int[] ns) {
		System.out.println(Arrays.toString(ns));
	}

	/**
	 * 倒序打印数组
	 * 
	 * @param ns
	 */
	public static void reverseOrder(int[] ns) {
		for (int i = ns.length - 1; i >= 0; i--) {
			System.out.println(ns[i]);
		}
	}

	/**
	 * 使用 for 循环可以获取数组元素及索引，使用 for each 无法获取索引
	 * 使用 Arrays.toString 将一个数组转换为字符串来显示
	 */
}
