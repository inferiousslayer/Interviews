package com.strings;

//Find the longest palindrome that is a substring of the given string
public class LongestPalindromeSubstring {

	public static void main(String args[]) {
		System.out.println(findLongestPalindrome("ZZZZZZZZZZZZabbaZZZ"));

	}

	static String findLongestPalindrome(String str) {
		String maxFound = "";
		String substr;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				substr = str.substring(i, j);
				if (isPalindrome(substr)) {
					if (substr.length() > maxFound.length()) {
						maxFound = substr;
					}
				}
			}
		}
		return maxFound;
	}

	public static boolean isPalindrome(String str) {
		char[] cArray = str.toCharArray();
		int i = 0;
		int j = cArray.length - 1;

		while (i < j) {
			if (cArray[i] != cArray[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
