package com.tourism.util;

public interface CustomExecption {

	public class PasswordException extends Exception {

		private static final long serialVersionUID = 1L;

		public PasswordException(String message) {
			super(message);
		}

	}
}
