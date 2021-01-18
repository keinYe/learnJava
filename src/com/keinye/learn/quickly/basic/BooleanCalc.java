package com.keinye.learn.quickly.basic;

public class BooleanCalc {
	public static void main(String[] args) {
		boolean b = 5 < 3;
		int c = 2;
		System.out.println(b && (c++ > 1)); 
		System.out.println(c); // 2 在上一句中由于 b 为 false，因此 c++ > 1 是没有运行的，这是布尔运算中的短路运算
		
		int n = -100;
		System.out.println(n > 0 ? n : -n);
		
		System.out.println(isPrimaryStudent(7));
		System.out.println(isPrimaryStudent(5));
	}
	
	
	public static boolean isPrimaryStudent(int age) {
		return age >= 6 && age <= 12 ? true : false;
	}

	/**
	 * 布尔运算是一种关系运算，主要包括以下几种：
	 * > >= < <= == !=
	 * &&
	 * ||
	 * !
	 * 优先级顺序
	 * !
	 * >= <= < > 
	 * == !=
	 * &&
	 * ||
	 */
}
