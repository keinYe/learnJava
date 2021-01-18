package com.keinye.learn.quickly.flow;

/**
 * Switch 多重选择
 * @author keinYe
 *
 */
public class SwitchSelect {
	public static void main(String[] args) {
		String fruit = "Mango";
		
		switch (fruit) {
		case "Apple" -> System.out.println("Select Apple");
		case "Pear" -> System.out.println("Select Pear");
		case "Mango" -> {
			System.out.println("Select Mango");
			System.out.println("Good Noice");
		}
		default -> System.out.println("No fruit selected");
		}
		
		int result = switch (fruit) {
		case "Apple" -> 1;
		case "Pear", "Mango" -> {
			System.out.println(fruit);
			yield 3;
		}
		default -> 2;
		};
		System.out.println(result);
	}

	/**
	 * Switch 是一种条件判断，依据判断语句的结果，选择相应的执行分支
	 * 
	 * case 用来定义一个分支的条件，直到遇到 break 语句为止，case 具有穿透功能（当前 case 没有 break 语句时，会一直执行直到遇到 break 语句。
	 * 
	 * 当每个 case 语句后都根由 break 语句时，case 语句的顺序不会影响执行结果。
	 * 
	 * 从 Java12 后新增 switch 语句。-> 如果要执行多条语句使用花括号，无需 break 语句，没有穿透功能。可以通过 yield 返回值
	 */
}
