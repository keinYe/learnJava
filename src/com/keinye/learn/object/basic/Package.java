package com.keinye.learn.object.basic;


/**
 * 包
 * @author keinYe
 *
 */
public class Package {

	/**
	 * Java内建的package机制是为了避免class命名冲突；
	 * JDK的核心类使用java.lang包，编译器会自动导入；
	 * JDK的其它常用类定义在java.util.*，java.math.*，java.text.*，……；
	 * 包名推荐使用倒置的域名，例如org.apache。
	 * 
	 * 编译器通过以下方式来查找一个类：
	 * 如果是完整类名，就直接根据完整类名查找这个class；
	 * 如果是简单类名，按下面的顺序依次查找：查找当前package是否存在这个class，查找import的包是否包含这个class，查找java.lang包是否包含这个class。
	 * 
	 * 引入类的三种方式：
	 * 直接写出完整类名，使用 import 导入，使用 import static导入类的静态字段和方法。
	 * 
	 * 位于同一包的类可以相互访问包作用域的字段和方法，不用public、protected、private修饰的字段和方法就是包作用域
	 */
}
