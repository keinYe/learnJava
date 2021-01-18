package com.keinye.learn.quickly.flow;

/**
 * break 和 continue
 * @author keinYe
 *
 */
public class BreakAndContinue {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if (i == 3) {
				break;
			}
			System.out.print(i);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			if (i == 3) {
				continue;
			}
			System.out.print(i);
		}
		
	}
	/**
	 * break 语句在 switch 中用于终止当前语句块，在循环中用户结束并跳出循环。
	 * continue 语句跳出当前循环直接执行下一循环。
	 */
}
