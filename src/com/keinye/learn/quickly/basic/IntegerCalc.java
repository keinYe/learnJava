package com.keinye.learn.quickly.basic;

/**
 * 整数运算
 * @author keinYe
 *
 */
public class IntegerCalc {
	public static void main(String[] args) {
		
		System.out.println(numberSum(10));
		
	}
	/**
	 * 计算前 N 个自然数之和
	 * @param num 需要计算的自然数个数
	 * @return 计算结果
	 */
	public static int numberSum(int num) {
		int sum = 0;
		
		sum = (1 + num) * num / 2;
		
		return sum;
	}
	
	public static void calc() {
		int a = (1 + 100) * (99 * 88);
		int b = 7 * (5 + 2 * 3);
		
		System.out.println(a); // 879912
		System.out.println(b); // 77
		
		int c = 1000 / 57;
		int d = 1000 % 57;
		
		System.out.println(c); // 17
		System.out.println(d); // 31
		
		// int f = 100 / 0; // Java 中当除数为 0 时，可以正常编译，但运行时将报错。
		
		int g = 1345687654;
		int h = 1123456789;
		
		System.out.println(g + h); // -1825822853
		// 整数在运算过程中如果超出范围不会报错，但是将得到一个错误的计算结果。
		
		int i = 100;
		int j = 100;
		i++;
		j--;
		
		System.out.println(i); // 101
		System.out.println(j); // 99
		
		int k = 1;
		k <<= 2;
		System.out.println(k); // 4
		k >>= 1;
		System.out.println(k); // 2
		
		/**
		 * Java 中运算符优先级
		 * ()
		 * ! ~ ++ --
		 * * / %
		 * + -
		 * << >> >>>
		 * &
		 * |
		 * += -= *= /=
		 */
		// Java 中参与预算的两个变量的类型不同时，将自动转换为较大的类型。
		// Java 使用 （类型） 的方式进行强制转型
	}
}
