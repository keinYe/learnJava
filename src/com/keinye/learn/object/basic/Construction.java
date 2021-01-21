package com.keinye.learn.object.basic;

/**
 * 构造函数
 * 
 * @author keinYe
 *
 */
public class Construction {

	public static void main(String[] args) {
		Person1 p1 = new Person1("Jack", 22, "USA");

		System.out.println(p1.getName());
		System.out.println(p1.getAge());
	}
}

class Person1 {
	private String name;
	private int age;
	private String country;

	public Person1() {
		/**
		 * 如果没有其他构造函数时，此函数为默认构造函数，可以不写。编译器会自动创建。 当定义了其他构造函数时，编译器将不再自动创建该构造函数。
		 */
	}

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person1(String name, int age, String country) {
		this(name, age);
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

/**
 * 没有在构造方法中初始化字段时，引用类型的字段默认是 null，数值类型的字段用默认值，int 类型默认值是0，布尔类型默认值是 false
 * 在Java中，创建对象实例的时候，按照如下顺序进行初始化： 1. 先初始化字段. 2. 执行构造方法的代码进行初始化。
 * 可以同时定义多个构造函数，编译器会根据参数的类型和顺序，自动进行判断。 可以在一个构造函数中调用其他的构造函数，便于代码的复用。
 */