package com.rbn.practice;

public class StringHelper {

	public String SwapLast2Char(String str) {
		int length = str.length();
		if(length < 2)
			return str;
		char secondLastChar = str.charAt(length-2);
		char lastChar = str.charAt(length-1);
		String remainingString = str.substring(0, length - 2);
		return remainingString + lastChar + secondLastChar;
	}

}
