package com.strings;

import java.util.HashSet;

//Write a method to determine if a string has all unique characters.
public class AllUniqueCharacters {
	public static void main(String args[]) {
		System.out.println(allUnique("asdf"));
		System.out.println(allUnique("asdfa"));
		System.out.println(allUnique2("飯桶"));
		System.out.println(allUnique2("飯桶飯桶"));
	}

	public static boolean allUnique(String str) { //Assume the char set is ASCII.
		if (str.length() > 256) { //It's impossible for a string longer than 256 to have no unique characters.
			return false;
		}
		//There's only 256 possible values so we just make a size 256 array.
		boolean[] charFound = new boolean[256];
		char[] cArr = str.toCharArray();
		for (char c : cArr) {
			if (charFound[c]) { //If the character has already been found, then it's not unique so we return false.
				return false;
			} else {
				charFound[c] = true;
			}
		}
		return true;
	}

	public static boolean allUnique2(String str) { //Generalized so any char set works.
		HashSet<Character> hs = new HashSet<Character>(); //Basically we just use a hashset instead of an array.
		char[] cArr = str.toCharArray();
		for (char c : cArr) {
			if (hs.contains(c)) {
				return false;
			} else {
				hs.add(c);
			}
		}
		return true;
	}

}
