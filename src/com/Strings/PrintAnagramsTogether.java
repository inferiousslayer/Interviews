package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given a List of Strings, print all the Strings so that words that are anagrams of one another are next to each other.
public class PrintAnagramsTogether {

	public static void main(String args[]) {
		pat(Arrays.asList(new String[] { "cat", "dog", "tac", "ogd", "act" }));
	}

	public static void pat(List<String> sList) {
		List<String> list2 = new ArrayList<String>();
		for (String str : sList) {
			list2.add(sortWord(str)); //Add each sorted word into the second list. 
		}

		for (int i = 0; i < list2.size(); i++) { //Append a tag to the String that indicates its index (so it looks like asdf#0)
			list2.set(i, list2.get(i) + "#" + i);
		}

		Collections.sort(list2); //Now sort all the words alphabetically.
		//Because we appended the index to the String, we still know where to grab the original word from in sList

		for (String str : list2) {
			int index = Integer.parseInt(str.split("#")[1]); //Grab the index.
			System.out.println(sList.get(index)); //Print out the original word at that index
		}
	}

	static String sortWord(String str) { //Sorts the letters in the word.  Example: xzbap --> abpxz
		char[] cArray = str.toCharArray();
		Arrays.sort(cArray);
		return new String(cArray);
	}
}
