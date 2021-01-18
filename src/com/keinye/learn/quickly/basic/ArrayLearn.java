package com.keinye.learn.quickly.basic;


/**
 * 数组
 * @author keinYe
 *
 */
public class ArrayLearn {
	public static void main(String[] args) {
		int[] ns = new int[5];
		System.out.println(ns);
		ns = new int[] {1,3, 5, 7, 8};
		System.out.println(ns);
		
		System.out.println(ns[1]);
		System.out.println(ns[5]);
	}
	
	/**
	 * 数组用来存储一组类型相同的数据
	 * 数组一旦创建其大小不可改变，数组中元素创建后既有一个默认值，整型为 0，浮点型为 0.0，布尔型为 false
	 * 可以通过索引来访问数组的元素，但是如果索引越界将报错。
	 * 数组索引值从 0 开始。
	 */

}
