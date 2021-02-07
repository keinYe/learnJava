package com.keinye.learn.io;

import java.io.File;
import java.io.IOException;

/**
 * File 对象
 * @author keinYe
 *
 */
public class FileClass {
	/**
	 * File(java.io.File)对象用来操作文件或目录
	 * 创建 File 本身不涉及 IO 操作，
	 * 可以获取路径／绝对路径／规范路径：getPath()/getAbsolutePath()/getCanonicalPath()；
	 * 可以获取目录的文件和子目录：list()/listFiles()；
	 * 可以创建或删除文件和目录。
	 * 可以判断文件类型 canRead()/canWrite()/canExecute()/exists()/length()
	 */
	
	public static void main(String[] args) {
		getFile();
		getDir();
		createFile();
	}
	
	public static void getFile() {
		File file = new File("test.txt");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(file.canExecute());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.length());
		System.out.println(file.exists());
		
	}
	
	public static void getDir() {
		File f1 = new File("test.txt");
		File f2 = new File("..");
		
		System.out.println(f1.isFile());
		System.out.println(f1.isDirectory());
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
	}
	
	public static void createFile() {
		File f1 = new File("tmp.txt");
		
		try {
			if (f1.createNewFile()) {
				System.out.println("Create tmp.txt sucess!");
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		if (f1.exists()) {
			System.out.println("File is exists");
			f1.delete();
		}
		
		System.out.println(f1.exists() ? "delete fail!" : "delete sucess!");
	}
}
