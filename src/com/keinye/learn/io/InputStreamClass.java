package com.keinye.learn.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 输入流 InputStream
 * @author keinYe
 *
 */
public class InputStreamClass {
	/**
	 * InputSteam 是 Java 标准库提供的最基础的输入流，它是一个抽象类，也是所有输入流的超类。
	 * 使用 InputStream 时可以使用 try(resource) 语句，编译器会自动对资源进行关闭。
	 * InputStream 支持一次性读取多个字节数据，同时支持从指定位置读取指定长度的数据。
	 * read 方法是阻塞的，当调用到 read 方法后，必须等到 read 方法返回才能执行后面的代码。
	 * 
	 * FileInputStream 支持从文件中获取输入流。
	 * ByteArrayInputStream 支持从内存中创建的数组获取输入流。
	 * 
	 */
	
	public static void main(String[] args) {
		fileRead();
	}
	
	public static void fileRead() {
		try (InputStream input = new FileInputStream("test.txt")) {
			System.out.println(readString(input));
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		try (InputStream input = new FileInputStream("test.txt")) {
			byte[] buffer = new byte[100];
			int n;
			while ((n = input.read(buffer)) != -1) {
				System.out.println("read " + n + " bytes");
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static String readString(InputStream input) throws IOException {
		StringBuilder str = new StringBuilder();
		int n;
		while ((n = input.read()) != -1) {
			str.append((char)n);
		}
		return str.toString();
	}
	
}
