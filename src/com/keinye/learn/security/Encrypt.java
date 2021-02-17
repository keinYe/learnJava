package com.keinye.learn.security;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encrypt and Decrypt
 * @author keinYe
 *
 */
public class Encrypt {
	/**
	 * 对称加密算法：用一个秘密进行加密和解密。
	 * 常用的对称加密算法由：DES(56/64)、AES(128/192/256)、IDEA(128)。
	 * 使用对称加密算法需要制定加密算法、工作模式和填充模式。
	 * 
	 * 口令加密算法，通常对用户输入的口令经过 PBE 算法，采用随机数杂凑计算出真正的密钥，再进行加密。
	 * @throws NoSuchAlgorithmException, GeneralSecurityException 
	 */
	
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		String message = "Hello World!";
		System.out.println("Message: " + message);
		byte[] key = "0123456789abcdef".getBytes("UTF-8");
		byte[] encrypted = encryptAES(key, message.getBytes("UTF-8"));
		System.out.println("AES Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
		
		byte[] decrypted = decryptAES(key, encrypted);
		System.out.println("AES Decrypted: " + new String(decrypted, "UTF-8"));
		
		encrypted = encryptAESCBC(key, message.getBytes("UTF-8"));
		System.out.println("AES(CBC) Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
		decrypted = decryptAESCBC(key, encrypted);
		System.out.println("AES(CBC) Decrypted: " + new String(decrypted, "UTF-8"));
	
		
		byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
		encrypted = encryptPBE("123", salt, message.getBytes("UTF-8"));
		System.out.println("PBE Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
		decrypted = decryptPBE("123", salt, encrypted);
		System.out.println("PBE Decrypted: " + new String(decrypted, "UTF-8"));
	}
	
	public static byte[] encryptAES(byte[] key, byte[] input) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKey keySec = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, keySec);
			return cipher.doFinal(input);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decryptAES(byte[] key, byte[] input) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKey keySec = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.DECRYPT_MODE, keySec);
			return cipher.doFinal(input);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;		
	}
	
	public static byte[] encryptAESCBC(byte[] key, byte[] input) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKey keySec = new SecretKeySpec(key, "AES");
			SecureRandom sr = SecureRandom.getInstanceStrong();
			byte[] iv = sr.generateSeed(16);
			IvParameterSpec ivps = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, keySec, ivps);
			byte[] data = cipher.doFinal(input);
			return join(iv, data);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decryptAESCBC(byte[] key, byte[] input) {
		byte[] iv = new byte[16];
		byte[] data = new byte[input.length - 16];
		System.arraycopy(input, 0, iv, 0, 16);
		System.arraycopy(input, 16, data, 0, data.length);
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKey keySec = new SecretKeySpec(key, "AES");
			IvParameterSpec ivps = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, keySec, ivps);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
    
    public static byte[] encryptPBE(String password, byte[] salt, byte[] input) throws GeneralSecurityException{
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_128");
		SecretKey sKey = sKeyFactory.generateSecret(keySpec);
		PBEParameterSpec spec = new PBEParameterSpec(salt, 1000);
		Cipher cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_128");
		cipher.init(Cipher.ENCRYPT_MODE, sKey, spec);
		return cipher.doFinal(input);
	}
    
    public static byte[] decryptPBE(String password, byte[] salt, byte[] input) throws GeneralSecurityException{
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_128");
		SecretKey sKey = sKeyFactory.generateSecret(keySpec);
		PBEParameterSpec spec = new PBEParameterSpec(salt, 1000);
		Cipher cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_128");
		cipher.init(Cipher.DECRYPT_MODE, sKey, spec);
		return cipher.doFinal(input);		
	}
}
