package com.keinye.learn.quickly.basic;

public class Variable {
	public static void main(String[] args) {
		//变量先定义后使用
		int x = 100;
		System.out.println(x);
		
		int n = x;
		System.out.println(n);
		
		x += 100;
		System.out.println("x = " + x);
		System.out.println("n = " + n);
	}
	
	/**
	 * Java 中基本数据类型分为以下几种：
	 * 整数类型：byte short int long
	 * 浮点数类型：float double
	 * 字符类型：char
	 * 布尔类型：boolean
	 */
	
	/**
	 * 整数类型中占用的内存空间：
	 * byte - 1 字节
	 * short - 2 字节
	 * int - 4 字节
	 * long - 8 字节
	 */
	
	/**
	 * 浮点数类型中 float 的定义要在数值后面加上一个 f，例如 float pi = 3.14f。
	 */
	
	/**
	 * 布尔类型boolean 只有 false 和 true 两个值。
	 */
	
	/**
	 * 字符类型占有 2 个字节，标识 ASCII 字符或 Unicode 字符。
	 */

	/**
	 * 在 Java 中除了整数类型、浮点数类型、字符类型、布尔类型以外，其他的均为引用类型
	 */
	
	/**
	 * 在 Java 中使用 final 修饰符修饰的变量即为常量。
	 */
	
	/**
	 * 使用 var 关键字可以在定义变量时省略变量类型，由编译器自动推断出变量的类型。
	 */
	
	/**
	 * Java 中变量的作用域通常是从变量定义处到作用域结尾
	 * Java 中的作用域指两个花括号之间的内容
	 */
}
