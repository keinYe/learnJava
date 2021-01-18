package com.keinye.learn.quickly.flow;


/**
 * while 循环
 * @author keinYe
 *
 */
public class WhileCycle {
	public static void main(String[] args) {
		int sum = 0;
		int n = 1;
		
		// while (n++ <= 100) 错误的
		while (n <= 100) {
			sum += n;
			n++;
		}
		System.out.println(sum);
		System.out.println(sumMtoN(-10, 100));
	}
	
	public static int sumMtoN(int m, int n) {
		int sum = 0;
		if (m > n) return sum;
		while (m <= n) {
			sum += m++;
		}
		return sum;
	}
	/**
	 * while 循环在每次循环前先判断那条件是否为true。true 则执行循环，false 则退出循环。
	 * while 循环可以一次都不执行直接跳出循环。
	 * 使用 while 循环时需要注意循环条件，避免造成死循环。
	 */
}
