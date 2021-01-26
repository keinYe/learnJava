package com.keinye.learn.exception;


/**
 * 空指针异常
 * @author keinYe
 *
 */
public class NullPoException {
	/**
	 * 如果一个对象为 null，那么调用其字段或方法就会产生 NullPointException。
	 * NullPointException 是一种代码逻辑错误，遇到时必须处理。
	 * 
	 * 在成员变量定义时尽量给其赋值，而不是使用默认的 null，来尽可能的避免产生 NullPointException。
	 * 
	 * 可以启用Java 14的增强异常信息来查看NullPointerException的详细错误信息
	 */
	
	public static void main(String[] args) {
		try {
			Integer integer = null;
			integer.byteValue();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
}
