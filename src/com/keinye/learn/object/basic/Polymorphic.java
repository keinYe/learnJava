package com.keinye.learn.object.basic;

/**
 * 多态
 * 
 * @author keinYe
 */
public class Polymorphic {
	public static void main(String[] args) {
		Person4 p1 = new Student1();

		p1.run(); // Student.run
		if (p1 instanceof Student1) {
			((Student1) p1).run("Jack");
		}
		run(new Student1()); // Student.run
		run(new Person4()); // Person.run
	}
	
	public static void run(Person4 p) {		
		p.run();
	}
}

class Person4 {
	public void run() {
		System.out.println("Person.run");
	}
}

class Student1 extends Person4 {
	@Override
	public void run() {
		System.out.println("Student.run");
	}
	
	public void run(String name) {
		super.run();
		System.out.println("Student :" + name);
	}
}

/**
 * 在子类中定义和父类中完全相同的方法，称为覆写 override
 * 如果方法签名如果不同，就是Overload，Overload方法是一个新方法；如果方法签名相同，并且返回值也相同，就是Override。
 * Java的方法调用总是作用于运行期对象的实际类型，这种行为称为多态；
 * 多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。
 * final 修饰的方法可以阻止被覆写，final 修饰的类可以阻止被继承，final 修饰的字段必须在创建对象时初始化，随后不能修改。
 */