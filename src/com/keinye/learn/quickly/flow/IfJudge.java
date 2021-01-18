package com.keinye.learn.quickly.flow;

import java.util.Scanner;

/**
 * if 判断
 * @author keinYe
 *
 */
public class IfJudge {
	public static void main(String[] args) {
		int n = 100;
		
		if (n < 100)
			System.out.println(100);
		else {
			System.out.println(n);
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input your weight:");
		float weight = scanner.nextFloat();
		System.out.print("Input your height:");
		float height = scanner.nextFloat();
		calcBMI(weight, height);
	}
	
	public static void calcBMI(float weight, float height) {
		float bmi = weight / (height * height);
		
		if (bmi < 18.5) System.out.println("过轻");
		else if (bmi >= 18.5 && bmi <= 25) System.out.println("正常");
		else if (bmi > 25 && bmi < 28) System.out.println("过重");
		else if (bmi >= 28 && bmi < 32) System.out.println("肥胖");
		else if (bmi >= 23) System.out.println("非常肥胖");
	}
	
	/**
	 * JVM 根据 if 语句的结果来判断是否执行 if语句块的内容。
	 * if ... else 用来作为条件判断，else 是可选的。语句块有{}包括，当只有一条语句时可以省略花括号。
	 * 使用 if ... else 判断时需要注意判断的顺序以及边界。
	 * 判断浮点数时不能直接使用 == ，应判断其偏差是否小于某个值。
	 * 判断引用类型是应使用 equals 而不是使用==。
	 */
}
