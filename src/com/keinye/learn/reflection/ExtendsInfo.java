package com.keinye.learn.reflection;

/**
 * 通过反射获取继承信息
 * @author keinYe
 *
 */
public class ExtendsInfo {
	/**
	 * 通过 getSuperClass() 来获取父类的 Class 实例。
	 * 通过 getInterfaces() 来获取实现的 interface 的 Class 实例。
	 * 两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom()：
	 */
	
	public static void main(String[] args) {
		Class clz = String.class;
		System.out.println(clz.getSuperclass());
		System.out.println(clz.getInterfaces());
		System.out.println(Number.class.isAssignableFrom(Integer.class));
		System.out.println(Integer.class.isAssignableFrom(Number.class));
	}
}
