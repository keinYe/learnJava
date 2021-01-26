package com.keinye.learn.exception;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 捕获异常
 * @author keinYe
 *
 */
public class GetException {
	/**
	 * 多 catch 语句将子类放在前面，父类放在后面。
	 * JVM 在匹配异常时会从上向下匹配，当匹配到一个异常时，就会停止匹配。
	 * 单个 catch 可以通过 | 来同时匹配多个异常。
	 * 
	 * finally 用来执行那些无论是否发生异常都需要执行的操作，比如资源释放等等。
	 * 
	 */
	
	public void get() {
		File file;
		try {
			file = new File("./GetException");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("Bad encoding");
		} catch (IOException e) {
			System.out.println("IO Error");
		}
	}
	
	public void getFinally() {
		File file;
		try {
			file = new File("a.text");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("Bad encoding");
		} catch (IOException e) {
			System.out.println("IO Error");
		} finally {
			System.out.println("END");
		}
	}
}
