package com.tourism.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Util to encrypt and decrypt using SHA-512 Hashing algorithm
 */

public class EncryptionUtil {

	/**
	 * This method encrypts the given string.
	 *
	 * @param stringToEncrypt
	 * @return
	 */
	public static String encrpyt(String stringToEncrypt) throws Exception {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			StringBuffer sb = new StringBuffer();
			md.update(stringToEncrypt.getBytes());
			byte[] byteData = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return new String(sb);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Error in encrypting");
		}
	}

}
