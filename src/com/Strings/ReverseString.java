package com.strings;

//Write a method to reverse the characters in a string.
public class ReverseString {
	public static void main(String args[]) {
		System.out.println(reverse("Hello World!"));
	}

	public static String reverse(String str) {
		char[] cArr = str.toCharArray();
		int i = 0;
		int j = cArr.length - 1;
		char temp;

		while (i < j) { //swap
			temp = cArr[j];
			cArr[j] = cArr[i];
			cArr[i] = temp;
			i++;
			j--;
		}
		return new String(cArr);
	}

}
