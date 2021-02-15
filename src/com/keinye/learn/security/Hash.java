package com.keinye.learn.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;


/**
 * 哈希算法（Hash）
 * @author keinYe
 *
 */
public class Hash {
	/**
	 * 哈希算法又称摘要算法，它的作用：对任意一组数据进行计算，得到固定长度的输出摘要。
	 * 哈希算法的特点：
	 * 1. 相同的输入一定得到相同的输出。
	 * 2. 不同的输入大概率得到不同的输出。
	 * 
	 * 哈希碰撞是指两个不同的输入得到了相同的输出。
	 * 哈希算法需要满足：碰撞概率低，不能猜测输出。
	 * 
	 * 哈希算法可用于验证数据完成性，具有防篡改的功能。
	 * 使用哈希算法来存储口令时，要注意考虑彩虹表攻击，常用的方法是加盐 salt。
	 * 
	 * BouncyCastle是一个开源的第三方算法提供商
	 * BouncyCastle提供了很多Java标准库没有提供的哈希算法和加密算法；
	 * 使用第三方算法前需要通过Security.addProvider()注册。
	 * 
	 * HmacMD5 可以看作是带有一个安全 key 的MD5，使用 HmacMD5 而不是使用 MD5 加 salt，有如下好处：
	 * 1. HmacMD5 的 key 长度是 64 位的，更安全。
	 * 2. Hmac 是标准算法，同样适用于 SHA-1 等其他算法。
	 * 3. Hmac 的输出和原有的哈希算法一致。
	 * 
	 * 为了安全，通常使用Java 标准库的 KeyGenerator 生成一个安全的随机 key，而不是自己制定一个 key。
	 */
	
	public static void main(String[] args) {
		System.out.println(printMessageDigest("Hello World!", "MD5"));
		System.out.println(printMessageDigest("Hello World", "SHA-256"));
		testHmac();
	}
	
	public static String printMessageDigest(String str, String algorithm) {
		String result = "";
		try {
			MessageDigest mDigest = MessageDigest.getInstance(algorithm);
			mDigest.update(str.getBytes(StandardCharsets.UTF_8));
			result = new BigInteger(1, mDigest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	public static void testHmac() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
			SecretKey key = keyGen.generateKey();
			System.out.println(new BigInteger(1, key.getEncoded()).toString(16));
			
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(key);
			mac.update("HelloWorld".getBytes("UTF-8"));
	        byte[] result = mac.doFinal();
	        System.out.println(new BigInteger(1, result).toString(16));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
}
