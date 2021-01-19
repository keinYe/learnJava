package com.keinye.learn.quickly.arrayControl;

import java.util.Arrays;

/**
 * 数组排序
 * 
 * @author keinYe
 *
 */
public class ArraySort {
	public static void main(String[] args) {
		int[] ns = new int[] {2, 10, 8, 9, 3, 15, 7, 5};
		
		for (int i = 0; i < ns.length; i++) {
			for (int j = 0; j < ns.length - i - 1; j++) {
				if (ns[j] > ns[j + 1]) {
					int tmp = ns[j];
					ns[j]= ns[j + 1];
					ns[j + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(ns));
		
		ns = new int[] {2, 10, 8, 9, 3, 15, 7, 5};
		Arrays.sort(ns);
		System.out.println(Arrays.toString(ns));
		
		ns = new int[] {2, 10, 8, 9, 3, 15, 7, 5};
		for (int i = 0; i < ns.length; i++) {
			for (int j = 0; j < ns.length - i - 1; j++) {
				if (ns[j] < ns[j + 1]) {
					int tmp = ns[j];
					ns[j]= ns[j + 1];
					ns[j + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(ns));
	}
	/**
	 * 常用的排序算法有冒泡排序、插入排序和快速排序等；
	 * 冒泡排序使用两层for循环实现排序；
	 * 交换两个变量的值需要借助一个临时变量。
	 * 可以直接使用Java标准库提供的Arrays.sort()进行排序；
	 * 对数组排序会直接修改数组本身。
	 */
}
