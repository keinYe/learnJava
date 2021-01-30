package com.keinye.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 * @author keinYe
 *
 */
public class MethodInfo {
	/**
	 * Class 提供一下方法来通过反射获取类的方法:
	 * 1. Method getMethod(name, Class...): 获取名称为 name 的 public 的方法（包括父类）
	 * 2. Method getDeclareMethod(name, Class...): 获取当前类的名称为 name 的方法（不包括父类）。
	 * 3. Method[] getMethods(): 获取当前类的public方法（包括父类）。
	 * 4. Method[] getDeclareMethod(): 获取当前类的所有方法（不包括父类）。
	 * Method 对象包含获取到方法的所有信息：
	 * 1. getName(): 返回方法名称。
	 * 2. getReturnType(): 返回方法的返回值类型，也是一个 Class 实例。
	 * 3. getParameterTypes(): 返回方法的参数类型，是一个 Class 数组。
	 * 4. getModifiers(): 返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
	 * 
	 * 在 Method 实例上调用 invoke 就相当于调用方法，invoke 的第一个参数是对象实例，即在那个实例上调用该方法，后面的可变参数要与方法保持一致否则将报错。
	 * 如果是静态方法，那么 invoke 的第一个参数将设置为 null。
	 * 
	 * 使用反射时仍然遵守多态原则，即总是调用实际类型的覆写方法。
	 * 
	 * 通过设置setAccessible(true)来访问非public方法；
	 * 通过Method实例可以调用某个对象的方法：Object invoke(Object instance, Object... parameters)；
	 * 
	 * 通过 Class 获取 Constructor 的方法如下:
	 * 1. getConstructor(Class...): 获取某个 public 的 constructor。
	 * 2. getDeclaredConstructor(Class...)：获取某个Constructor；
	 * 3. getConstructors()：获取所有public的Constructor；
	 * 4. getDeclaredConstructors()：获取所有Constructor。
	 * Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题
	 * 通过Constructor实例可以创建一个实例对象：newInstance(Object... parameters)； 通过设置setAccessible(true)来访问非public构造方法。
	 */
	
	public static void main(String[] args) {
		getMethod();
		callMethod();
		getContructor();
	}
	
	public static void getMethod() {
		Class clz = Student.class;
		try {
			System.out.println(clz.getMethod("getName"));
			System.out.println(clz.getMethod("getScore", int.class));
			System.out.println(clz.getDeclaredMethod("getGrade"));
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void callMethod() {
        String s = "Hello world";
        Method m;
		try {
			m = String.class.getMethod("substring", int.class);
	        String r = (String) m.invoke(s, 6);
	        System.out.println(r);	
	        
	        m = Integer.class.getMethod("parseInt", String.class);
	        Integer n = (Integer) m.invoke(null, "12345");
	        System.out.println(n);
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	
	public static void getContructor() {
		try {
	        Constructor cons1 = Integer.class.getConstructor(int.class);
	        Integer n1 = (Integer) cons1.newInstance(123);
	        System.out.println(n1);
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	class Person {
		public String name;
		
		public Person(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	class Student extends Person {
		public int score;
		public int grade;
		
		public Student(String name, int score, int grade) {
			super(name);
			this.score = score;
			this.grade = grade;
		}
		
		public int getScore(int score) {
			return this.score;
		}
		
		private int getGrade() {
			return this.grade;
		}
		
	}
}
