package com.keinye.learn.quickly.basic;

/**
 * 浮点数运算
 * @author keinYe
 *
 */
public class floatCalc {
	public static void main(String[] args) {
		calc();
		equationCalc(1.0, 3.0, -4.0);
	}
	
	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void equationCalc(double a, double b, double c) {
		double x = Math.sqrt(b * b - 4 * a * c);
		double r1 = (-b + x) / (2 * a);
		double r2 = (b - x) / (2 * a);
		
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
	}
	
	public static void calc() {
		double x = 1.0 / 10;
		double y = 1.0 - 9.0 / 10;
		
		System.out.println(x); // 0.1
		System.out.println(y); // 0.09999999999999998
		System.out.println(x == y); // false
		
		System.out.println(0.0 / 0.0); // NaN
		System.out.println(1.0 / 0); // Infinity
		System.out.println(-1.0 / 0); // -Infinity
	}
	
	/**
	 * 浮点数运算与整数运算相比，除了不能进行移位和按位运算以外，其他运算方法相同。
	 * 浮点数在内存中常常无法精确表示，因此浮点数运算会产生误差。
	 * 判断浮点数是否相等，通常判断其差的绝对值是否在误差范围内，而不是直接判断两个浮点数相等。
	 * 浮点数溢出不会报错，但是会返回 NaN，Infinity， -Infinity
	 * 浮点数强制转换为整形时，其小数部分将会被丢弃，如果需要进行四舍五入，在进行转型前先将浮点数+0.5。
	 * 整形与浮点型进行计算时，整形将被转换为浮点型。
	 * 浮点型转换为整型是，若超出范围将一直返回整型最大值。
	 */
}
