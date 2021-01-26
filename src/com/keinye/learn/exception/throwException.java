package com.keinye.learn.exception;

import java.io.File;
import java.io.IOException;

/**
 * 抛出异常
 * @author keinYe
 *
 */
public class throwException {

	/**
	 * 某个方法抛出异常时，如果异常没有被捕获会一直向上传递，指导异常被 try...catch 捕获。
	 * 
	 * printStackTrace 对于调试非常有用，它可以打印出异常的调用路径，便于解析出现异常的原因。
	 * 
	 * 程序的编写过程中可以通过 throw 语句来抛出异常。
	 * 
	 * 捕获到异常并再次抛出时，一定要留住原始异常，否则很难定位第一案发现场！
	 * 
	 * 一个函数同时有多个异常抛出时，只能抛出一个异常，没有被抛出的异常成为“被屏蔽”的异常。
	 * 
	 * 通常不要在finally中抛出异常。如果在finally中抛出异常，应该原始异常加入到原有异常中。调用方可通过Throwable.getSuppressed()获取所有添加的Suppressed Exception。
	 */
	
	public void throwOne() {
		throw new NullPointerException();
	}
	
	public void throwTwo() {
		File file = new File("a.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
	}
}
