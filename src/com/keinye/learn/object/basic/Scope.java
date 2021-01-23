package com.keinye.learn.object.basic;

/**
 * 作用域
 * @author keinYe
 *
 */
public class Scope {

	/**
	 * public 修饰的类和接口，可以被任何类访问。
	 * public 修饰的字段和方法，在可以访问类的前提下，可以被其他类访问。
	 * 
	 * private 修饰的字段和方法的访问权限被限定在类内部，与方法声明的顺序无法。在嵌套类中可以访问 private 修饰的字段和方法。
	 * 
	 * protected 作用域继承关系，被 protected 修饰的字段和方法，可以被子类以及子类的子类访问。
	 * 
	 * package 包作用域是指一个类允许访问同一个package的没有public、private修饰的class，以及没有public、protected、private修饰的字段和方法
	 * 
	 * 在方法内部定义的变量称为局部变量，局部变量作用域从变量声明处开始到对应的块结束。方法参数也是局部变量。
	 * 
	 * final 与访问权限不冲突：
	 *    修饰 class 时可以阻止被继承。
	 *    修饰 method 时可以阻止被子类覆写。
	 *    修饰 field 和局部变量时可以阻止被重新赋值。
	 *    
	 * 如不确定是否需要声明 public 就不声明，避免过分暴露对外的字段和方法。
	 * 一个 java 文件只能包含一个 public 类，但是可以包含多个非 public 类，如果包含 public 类，则文件名必须与类名相同。
	 * 把方法定义为package权限有助于测试，因为测试类和被测试类只要位于同一个package，测试代码就可以访问被测试类的package权限方法。
	 */
}
