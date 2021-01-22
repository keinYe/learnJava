package com.keinye.learn.object.basic;

/**
 * 抽象
 * 
 * @author keinYe
 *
 */
public class Abstract {
	public static void main(String[] args) {
		Person5 p1 = new Worker();
		Person5 p2 = new Teacher();
		
		p1.run();
		p2.run();
		p1.test();
		/**
		 * 使用抽象类类引用具体的子类，无需关心具体的子类型。
		 * 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。
		 */
	}
}

abstract class Person5 {
	public abstract void run();
	public void test() {
		System.out.println("test");
	}
}

class Teacher extends Person5 {
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println("Teacher!");
		
	}
}

class Worker extends Person5 {
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println("Worker!");
	}
}

/**
 * 一个方法如果使用 abstract 修饰，那么该方法为抽象方法不需要编写具体的执行代码。
 * 如果一个类包含抽象方法，那么该类也必须使用 abstract 修饰为抽象类，抽象类不能够被实例化。
 * 面向抽象编程的本质就是：
 * 1、上层代码之定义规范。
 * 2、不需要子类就可以实现业务逻辑。
 * 3、具体的业务逻辑有具体的子类来实现，调用者并不关心。
 * 
 * 通过abstract定义的方法是抽象方法，它只有定义，没有实现。抽象方法定义了子类必须实现的接口规范；
 * 定义了抽象方法的class必须被定义为抽象类，从抽象类继承的子类必须实现抽象方法；
 * 如果不实现抽象方法，则该子类仍是一个抽象类；
 * 面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现。
 */
