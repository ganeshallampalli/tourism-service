package com.tourism.util;

import java.util.Random;

/**
 * Util to create a custom userID based on the name
 */

public class UserIdUtil {

	public static String createUserId(String name) {
		Random random = new Random();
		String id = String.format("%04d", random.nextInt(10000));
		return name.substring(0, 4).toUpperCase() + id;
	}
}
