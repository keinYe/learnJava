package com.keinye.learn.exception;

/**
 * 断言
 * @author keinYe
 *
 */
public class AssertClass {
	/**
	 * 断言是一种调试程序的方式，在 Java 中使用 assert 关键字来实现断言。
	 * 断言失败会抛出 AssertionError ，只能在开发和测试阶段启动断言。
	 * 对可恢复的错误不能使用断言，而应该抛出异常；
	 * 断言很少被使用，更好的方法是编写单元测试。
	 * 
	 * 要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言。
	 * 还可以有选择地对特定地类启用断言，命令行参数是：-ea:com.itranswarp.sample.Main，
	 */
	
	public static void main(String[] args) {
		int x = -1;
		assert x > 0;
		System.out.println(x);
	}
}
