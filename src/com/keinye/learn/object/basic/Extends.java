package com.keinye.learn.object.basic;

/**
 * 继承
 * 
 * @author keinYe
 *
 */
public class Extends {
	public static void main(String[] args) {
		Student s1 = new Student("Jack", 13, 94);
		s1.print();

		System.out.println(s1.getName());
		System.out.println(s1 instanceof Object);
		System.out.println(s1 instanceof Person3);
		System.out.println(s1 instanceof Student);

		Person3 p1 = s1;

		System.out.print(p1.getName());

	}
}

class Person3 {
	protected String name;
	private int age;

	public Person3() {
		// TODO 自动生成的构造函数存根
	}

	public Person3(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Student extends Person3 {
	private int score;

	public Student() {
		// TODO 自动生成的构造函数存根
	}

	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void print() {
		// 可以直接访问 name 字段，但是不能直接访问 age 字段。
		System.out.println(name + " " + getAge() + " " + score);
	}
}

/**
 * Java 通过 extends 关键字来实现继承 一个类从另一个类继承时，将获得该类的所有功能。 Java
 * 只允许一个类继承自一个类，即一个类只能有一个父类。子类无法访问父类中的 private 字段和方法。 protected
 * 关键字将字段和方法的访问权限控制在继承树内部。 super 表示父类或超类，在子类中可以通过 super 直接调用父类的字段和方法。 使用 final
 * 修饰符的类将不允许被继承。可以把一个子类类型安全地变为父类类型的赋值，称为向上转型。 instanceof 判断一个变量所指向的实例是否是指定类型
 *
 */