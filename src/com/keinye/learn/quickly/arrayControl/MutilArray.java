package com.keinye.learn.quickly.arrayControl;

import java.util.Arrays;

/**
 * 多维数组
 * 
 * @author keinYe
 *
 */
public class MutilArray {
	public static void main(String[] args) {
		int[][] ns = { { 1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10 }, };
		System.out.println(Arrays.deepToString(ns));

		int[][] scores = { { 82, 90, 91 }, { 68, 72, 64 }, { 95, 91, 89 }, { 67, 52, 60 }, { 79, 81, 85 }, };
		double average = 0;
		int num = 0;
		System.out.println(average);

		for (int[] arr : scores) {
			for (int n : arr) {
				average += n;
				num++;
			}
		}
		average = average / num;
		System.out.println(average);
	}
	
	/**
	 * 二维数组就是数组的数组，三维数组就是二维数组的数组；
	 * 多维数组的每个数组元素长度都不要求相同；
	 * 打印多维数组可以使用Arrays.deepToString()；
	 * 最常见的多维数组是二维数组，访问二维数组的一个元素使用array[row][col]。
	 */
}
