package com.keinye.learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.swing.plaf.synth.SynthGraphicsUtils;

/**
 * 访问字段
 * @author keinYe
 *
 */
public class FieldInfo {
	/**
	 * Class 通过以下方法来获取字段：
	 * 1. Field getField(name): 通过字段名来获取一个 public 的 field（包括父类的字段）。
	 * 2. Field getDeclaredField(name): 通过字段名来获取一个当前类的 field （不包括父类）。
	 * 3. Field getFields(): 获取所有 public 的 field （包括父类）。
	 * 4. Field getDeclaredFields(): 获取当前类的所有 field（不包括父类）。
	 * 一个 Field 对象包含了该字段的所有信息：
	 * 1. getName(): 返回字段名称。
	 * 2. getType(): 返回字段类型，也是一个 Class 实例。
	 * 3. getModifiers(): 返回字段的修饰符，它是一个 int 类型，不同 bit 代表不同的含义。
	 * 
	 * 修改或读取非 public 字段需要 setAccessible(true)
	 */
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class stuClz = Student.class;
		System.out.println(stuClz.getField("name"));
		System.out.println(stuClz.getFields());
		System.out.println(stuClz.getDeclaredField("grade"));
		
		Field field = stuClz.getField("name");
		System.out.println(field.getName());
		System.out.println(field.getType());
		int m = field.getModifiers();
		System.out.println(Modifier.isFinal(m));
		System.out.println(Modifier.isPublic(m));
		System.out.println(Modifier.isProtected(m));
		System.out.println(Modifier.isPrivate(m));
		System.out.println(Modifier.isStatic(m));
		
		FieldInfo fieldInfo = new FieldInfo();
		Student stu =  fieldInfo.new Student("Xiao Ming");
		Class clz = stu.getClass();
		Field f = clz.getField("name");
		System.out.println(f.get(stu));
		f.set(stu, "Xiao Hong");
		System.out.println(stu.name);
		
	}
	
	class Person {
		public String name;
		
		public Person(String name) {
			this.name = name;
		}
	}
	
	class Student extends Person {
		public Student(String name) {
			super(name);
			// TODO 自动生成的构造函数存根
		}
		public int score;
		private int grade;
	}
	
}
