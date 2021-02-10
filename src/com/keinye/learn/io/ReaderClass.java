package com.keinye.learn.io;

import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


/**
 * Reader 字符流
 * @author keinYe
 *
 */
public class ReaderClass {
	/**
	 * InputStream 和 Reader 都是 Java 提供的输入流接口，不同的是 InputStream 是字节流，而 Reader 是字符流。
	 * Reader 是所有字符输入流的超类。
	 * 
	 * FileReader 默认的编码与系统相关，打开文件是如果编码不一致可能出现错误，因此在创建 Reader 时注意传入文件编码格式。
	 * CharArrayReader 将一个char[] 数组变成一个 Reader，和 ByteArrayInputStream 类似。
	 * StringReader 将一个 String 变成一个 Reader。
	 * Reader是基于InputStream构造的：可以通过InputStreamReader在指定编码的同时将任何InputStream转换为Reader。
	 * 
	 */
	
	public static void main(String[] args) {
		charFileRead();
		charArrayReader();
		stringArrayReader();
		inputStreamReader();
	}
	
	public static void charFileRead() {
		try (Reader reader = new FileReader("test.txt", StandardCharsets.UTF_8)) {
			int n;
			while ((n = reader.read()) != -1) {
				System.out.println((char)n);
			}
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void charArrayReader() {
		try (Reader reader = new CharArrayReader("Hello World!".toCharArray())) {
			int n;
			while ((n = reader.read()) != -1) {
				System.out.println((char)n);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void stringArrayReader() {
		try (Reader reader = new StringReader("Hello")) {
			int n;
			while ((n = reader.read()) != -1) {
				System.out.println((char)n);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void inputStreamReader() {
		try (Reader reader = new InputStreamReader(new FileInputStream("test.txt"), "UTF-8")) {
			int n;
			while ((n = reader.read()) != -1) {
				System.out.println((char)n);
			}			
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
