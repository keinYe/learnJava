package com.keinye.learn.object.javaCore;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


/**
 * javaBean
 * @author keinYe
 *
 */
public class JavaBean {
	/**
	 * JavaBean 是一种符合命名规范的 class，它通过 getter 和 setter 来定义属性。
	 * 使用 Introspector.getBeanInfo() 可以获取属性列表
	 * 
	 * 属性只需要定义 setter 和 getter 不一定需要有对应的字段
	 * 
	 * 只有 setter 的属性成为只写属性，只有 getter 的属性成为只读属性。
	 */
	
	public static void main(String[] args) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
			
			for (PropertyDescriptor info : beanInfo.getPropertyDescriptors()) {
				System.out.println(info.getName());
				System.out.println("  " + info.getReadMethod());
				System.out.println("  " + info.getWriteMethod());
			}
		} catch (IntrospectionException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	class Person {
		private String name;
		private int age;
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
		public boolean isChild() {
			if (age < 6) return true;
			return false;
		}
	}
	
}
