package com.keinye.learn.object.basic;

/**
 * 重载方法
 * 
 * @author keinYe
 *
 *         多个方法它们具有相同的方法名，完成相似的功能，只在参数上存在区别 这类方法我们称为方法重载 重载方法必须具有相同的返回参数
 */
public class Overload {
	public static void main(String[] args) {
		hello();
		hello("Jack");
		hello("Jack", 15);
		hello("Lucy", 20);

		Person2 p1 = new Person2();
		Person2 p2 = new Person2();
		p1.setName("xiao ming");
		p2.setName("xiao", "hong");

		System.out.println(p1.getName());
		System.out.println(p2.getName());
	}

	public static void hello() {
		System.out.println("Hello World!");
	}

	public static void hello(String name) {
		System.out.println("Hello, " + name + "!");
	}

	public static void hello(String name, int age) {
		if (age < 18) {
			System.out.println("Hi, " + name + "!");
		} else {
			System.out.println("Hello, " + name + "!");
		}
	}

}

class Person2 {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(String fist, String last) {
		this.name = fist + " " + last;
	}
}
