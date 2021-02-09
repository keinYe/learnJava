package com.keinye.learn.io;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Filter 模式
 * @author keinYe
 *
 */
public class FilterMode {
	/**
	 * Filter 模式又称为 Decorator，是指在通过给基础组件增加各种附加功能的方式。
	 * 
	 * Filter 模式既不更改基础组件也不从基础组件继承，只是在内部持有基础组件，对外提供的接口与基础组件相同。
	 * 
	 * Java 标准库通过 Filter 模式为 InputStream 和 OutputStream 增加功能。
	 * 可以把一个 InputStream 和任意个 FilterInputStream 组合，同样也可以将 OutputStream 和任意个 FilterOutputStream 组合。
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		byte[] data = "hello, world!".getBytes("UTF-8");
		
		try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))){
			int n;
			while ((n = input.read()) != -1) {
				System.out.println((char)n);
			}
			System.out.println("Total read " + input.getBytesRead() + " Bytes");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

class CountInputStream extends FilterInputStream {
	private int count = 0;
	
	public CountInputStream(InputStream in) {
		super(in);
	}
	
	public int getBytesRead() {
		return count;
	}
	
	@Override
	public int read() throws IOException {
		int n = super.read();
		if (n != -1) {
			this.count++;
		}
		return n;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int n = super.read(b, off, len);
		if (n != -1) {
			this.count += n;
		}
		return n;
	}
}
