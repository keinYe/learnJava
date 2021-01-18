package com.keinye.learn.quickly.flow;

import java.util.Scanner;

/**
 * 控制台输入和输出
 * @author keinYe
 *
 */
public class InputOutput {
	public static void main(String[] args) {
		System.out.print("A");
		System.out.print("B");
		System.out.println("C");
		System.out.println("END");
		
		System.out.printf("%d, %x", 10, 20);
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input your name:");
		String name = scanner.nextLine();
		System.out.print("Input your age:");
		int age = scanner.nextInt();
		System.out.printf("Hi %s, you are %d\n", name, age);
		
		System.out.print("Input your before grades:");
		int before = scanner.nextInt();
		System.out.print("Input your after grades:");
		int after = scanner.nextInt();
		
		System.out.println(precent(before, after));
	}
	
	
	public static String precent(int before, int after) {
		int inc = after - before;
		double precent = (float)inc / before;
		
		return String.format("%.2f %%", precent * 100);
	}
	
	/**
	 * 控制输出通常使用 System.out 类，控制台输入通常使用 java.util.Scanner
	 */
}
