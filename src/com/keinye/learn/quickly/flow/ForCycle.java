package com.keinye.learn.quickly.flow;

/**
 * for 循环
 * @author keinYe
 *
 */
public class ForCycle {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		int[] ns = new int[] {1,3,5,7,9};
		//for each来遍历数组
		for (int n : ns) {
			System.out.println(n);
		}
		
		reverseOrder(ns);
		System.out.println(sum(ns));
		
	}
	
	public static void reverseOrder(int[] ns) {
		for (int i = ns.length - 1; i >= 0; i--) {
			System.out.println(ns[i]);
		}
	}
	
	public static int sum(int[] ns) {
		int sum = 0;
		for (int n : ns) {
			sum += n;
		}
		return sum;
	}
	
	/**
	 * for 使用计数器来实现循环，每次循环前判断计数器是否符合条件，循环执行完成后更新计数器
	 * 不要在循环体内修改计数器，否则会产生不必要的错误。
	 * for each 可以无需使用索引来遍历数组。
	 */
}
