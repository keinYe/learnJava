package com.keinye.learn.object.basic;

import java.util.Arrays;

/**
 * 类方法
 * 
 * @author keinYe
 *
 */
public class Method {
	public static void main(String[] args) {
		Person p1 = new Person();

		int age = 16;
		String[] name = new String[] { "Jack" };
		String country = "China";

		p1.setAge(age);
		p1.setName(name);
		p1.setCountry(country);

		age = 17;
		name[0] = "Lucy";
		country = "USA";

		System.out.println(p1.getAge());
		System.out.println(Arrays.toString(p1.getName()));
		System.out.println(p1.getCountry());

		setCountry("China", "USA", "UK");
	}

	public static void setCountry(String... country) {
		System.out.print(Arrays.toString(country));
	}
}

/**
 * 定义一个类
 * 
 * @author keinYe
 *
 */
class Person {
	/**
	 * field 名字
	 */
	private String[] name;
	/**
	 * field 年龄
	 */
	private int age;

	private String country;

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}

/**
 * private 修饰符限制成员仅能在类内部访问，其它类不能够调用被 private 修饰的内部成员。 如果没有任何修饰符时，默认是 public。 使用
 * private 修饰的内部字段，可以通过 setter 或 getter 来访问该字段。 类方法通过 实例变量.方法名(参数) 的形式来调用。
 * 在方法内部，有一个隐含的 this 变量，它始终指向当前实例。 方法可以有任意个参数，调用方法时必须按照参数的顺序一一传递。 可变参数 类型...
 * 在方法内部相当于一个数组，可以按照数组的方法来使用。 基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
 * 引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方。
 */
