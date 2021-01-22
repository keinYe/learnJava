package com.keinye.learn.object.basic;


/**
 * 接口
 * 
 * @author keinYe
 *
 */
public class Interface {
	public static void main(String[] args) {
		Learner l1 = new Learner("Jack", "one");
		
		Student3 s1 = l1;
		Person6 p1 = l1;
		
		s1.run();
		System.out.println(s1.getGrade());
		System.out.println(p1.getName());
	}
}

interface Person6 {
	String getName();
}

interface Student3 extends Person6 {
	String getGrade();
	default void run() {
		System.out.println("Run!");
	};
}

class Learner implements Student3 {
	private String name;
	private String grade;
	
	public Learner(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String getName() {
		// TODO 自动生成的方法存根
		return name;
	}

	@Override
	public String getGrade() {
		// TODO 自动生成的方法存根
		return grade;
	}
	
}



/**
 * 如果有一个抽象类没有字段，所有方法都是抽象方法，就可以将该抽象类改为接口。‘
 * 当一个类需要去实现一个接口时，需要使用 implements 关键字。
 * 在 Java 中一个类只能继承自一个父类，不能继承多个类，但一个类可以实现多个 interface。
 * interface 可以继承自另一个接口，接口之间的继承使用 extends 关键字。
 * 接口可以定义 default 方法，实现类不必复写默认方法。
 * 
 * Java 的 interface 定义了纯抽象规范，一个类可以实现多个接口。
 */