package com.keinye.learn.security;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;


/**
 * URLEncode 和 Base64
 * @author keinYe
 *
 */
public class Encode {
	/**
	 * URL 编码对字符进行编码，表示成 %XX 的形式，而 Base64 编码是对二进制进行编码，表示成文本格式。
	 * 
	 * URL 编码通过 URLEncoder 和 URLDecoder 完成编码和解码。编码后的文本仅包含A~Z，a~z，0~9，-，_，.，*和%。
	 * Base64 可以将任意长度的二进制数据变成纯文本。且只包含A~Z、a~z、0~9、+、/、=这些字符。
	 * 它的原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串。 
	 * 
	 * URL 编码和 Base64 都只是编码算法而不是加密算法。Base64编码的目的是把任意二进制数据编码为文本，但编码后数据量会增加1/3
	 */
	
	public static void main(String[] args) {
		testURL();
		testBase64();
	}
	
	public static void testURL() {
		String encoded = URLEncoder.encode("中国", StandardCharsets.UTF_8);
		System.out.println(encoded); //%E4%B8%AD%E5%9B%BD
		
		String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
		System.out.println(decoded); //中国		
	}
	
	public static void testBase64() {
		byte[] intput = new byte[] {(byte)0xE4, (byte)0xB8,(byte)0xAD};
		String encoded = Base64.getEncoder().encodeToString(intput);
		System.out.println(encoded); //5Lit
		
		byte[] decoded = Base64.getDecoder().decode(encoded);
		System.out.println(Arrays.toString(decoded));//[-28, -72, -83]
	}
}
