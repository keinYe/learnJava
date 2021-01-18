package com.keinye.learn.quickly.flow;

/**
 * do while 循环
 * @author keinYe
 *
 */
public class DoWhileCycle {
	public static void main(String[] args) {
		int sum = 0;
		int n = 1;
		
		do {
			sum += n;
			n++;
		} while (n <= 100);
		System.out.println(sum);
		
		sum = 0;
		n = 1;
		do {
			sum += n++;
		} while (n <= 100);
		System.out.println(sum);
	}

	/**
	 * do while 循环，限制性循环体在判断循环条件，true 则继续执行，false 则退出。
	 * do while 循环的循环体至少会被执行一次。
	 */
}
