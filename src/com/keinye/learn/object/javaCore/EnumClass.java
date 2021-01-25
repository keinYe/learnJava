package com.keinye.learn.object.javaCore;

import java.awt.print.Printable;

import javax.management.RuntimeErrorException;
import javax.xml.crypto.Data;

/**
 * 枚举类
 * @author keinYe
 *
 */
public class EnumClass {
	/**
	 * 使用 enum 关键字来定义一个枚举类,它被编译器编译为final class Xxx extends Enum { … }。
	 * enum 常量自带有类型信息，编译器会自动检查出类型错误。
	 * 枚举类型不能引用到非枚举的值。
	 * 不同类型的枚举不能互相比较或者赋值，因为类型不同。
	 * 
	 * 通过name() 获取常量定义是的字符串，而不是使用 toString。
	 * 通过 ordinal() 放回定义常量的顺序。
	 * 可以为 enum 定义构造方法、字段和方法。
	 * enum的构造方法要声明为private，字段强烈建议声明为final；
	 * enum适合用在switch语句中。
	 */
	
	public static void main(String[] args) {
		WeekDay day = WeekDay.SUN;
		
		System.out.println(day.name()); // SUN
		System.out.println(day.ordinal()); // 0
		System.out.println(day.toString()); // 星期日
		
		switch (day) {
		case MON:
		case TUE:
		case WED:
		case THU:
		case FRI:
			System.out.println("Today is " + day + ". Work at office!");
			break;
		case SAT:
		case SUN:
			System.out.println("Today is " + day + ". Work at home!");
			break;
		default:
			throw new RuntimeException("cannot process " + day);
		}
	}
	
	enum WeekDay {
		SUN(0, "星期日"),
		MON(1, "星期一"),
		TUE(2, "星期二"),
		WED(3, "星期三"),
		THU(4, "星期四"),
		FRI(5, "星期五"),
		SAT(6, "星期六");
		
		public final int dayValue;
		private final String chinese;
		
		private WeekDay(int dayValue, String chinese) {
			this.dayValue = dayValue;
			this.chinese = chinese;
		}
		
		@Override
		public String toString() {
			// TODO 自动生成的方法存根
			return this.chinese;
		}
		
	}
}
