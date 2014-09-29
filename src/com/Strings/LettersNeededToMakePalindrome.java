package com.strings;

import java.util.HashMap;

/* 
Given a string, what are the minimum number of letters you need to insert to make it a palindrome?

For example: 

abb --> abba  (needs 1)
abc --> abcba (needs 2)
aba --> aba (needs 0, already a palindrome)
mdam --> madam (needs 1)

 */

public class LettersNeededToMakePalindrome {
	public static void main(String args[]) {
		System.out.println(findMinInsertions("tostotor"));
		System.out.println(findMinInsertions("mdam"));
		System.out.println(findMinInsertions("aba"));
		System.out.println(findMinInsertions("abb"));
		System.out.println(findMinInsertions("hello"));
		
		System.out.println("With dynamic programming:");
		
		System.out.println(findMinInsertionsDP("tostotor"));
		System.out.println(findMinInsertionsDP("mdam"));
		System.out.println(findMinInsertions("aba"));
		System.out.println(findMinInsertions("abb"));
		System.out.println(findMinInsertions("hello"));
	}

	/* Explanation of algorithm:
		
		Have a left and right pointer.  If the first and last letters match, chop off the ends and recursively call.
		If there's only two letters left, if they match return 0 and if they don't, return 1.
		
		Else what we'll do is chop off the left letter and recursively call on the remainder and we'll
		chop off the right letter and recursively call on the remainder.  We'll want to return the minimum of those two +1.
		
		Example:
		
		mdam --> da (chop off both ends).  Now that we have 2 left, compare.  They don't match so return 1.  Answer is 1.
		
		Example:
		
		"hello"
		
		Step 1:
		
		the character at l and r don't match, so we return the minimum of left chopped off and right chopped off + 1
		that is:  return the minimum of ("hell" and "ello") + 1
		
		Step 2:
		
		hell --> hel and ell, return minimum of ("hel" and "ell") + 1
		ello --> ell and llo, return minimum of ("ell" and "llo") + 1
		
		Step 3:
		
		hel --> he and el, return minimum of ("he" and "el") + 1
		...
		...
		ell --> el and ll, return minimum of ("el" and "ll") + 1
		
		Step 4:
		
		ll --> they match, so return 0;
		
		The answer will be 3	
		
		

	 */

	static int findMinInsertions(String str) {
		if (str.length() == 1) { //It's a single character.
			return 0;
		}
		if (str.length() == 2) { //Two letters left.  0 needed if they match, 1 if they don't.
			return (str.charAt(0) == str.charAt(1)) ? 0 : 1;
		}

		if (str.charAt(0) == str.charAt(str.length() - 1)) { //If the left and right chars match, chop them off.
			return findMinInsertions(str.substring(1, str.length() - 1));
		} else {
			//Return the minimum of (left letter chopped off vs right letter chopped off) + 1.
			return Math.min(findMinInsertions(str.substring(1, str.length())), findMinInsertions(str.substring(0, str.length() - 1))) + 1;
		}
	}

	//Same problem but with dynamic programming

	static HashMap<String, Integer> cache = new HashMap<String, Integer>();

	static int findMinInsertionsDP(String str) {

		if (str.length() == 1) { //It's a single character.
			return 0;
		}
		if (str.length() == 2) { //Two letters left.  0 needed if they match, 1 if they don't.
			if (str.charAt(0) == str.charAt(1)) {
				cache.put(str, 0);
				return 0;
			} else {
				cache.put(str, 1);
				return 1;
			}
		}

		if (str.charAt(0) == str.charAt(str.length() - 1)) { //If the left and right chars match, chop them off.
			String substring = str.substring(1, str.length() - 1);
			if (!cache.containsKey(substring)) {
				cache.put(substring, findMinInsertions(substring));
			}
			return cache.get(substring);
		} else {
			//Return the minimum of (left letter chopped off vs right letter chopped off) + 1.

			String substringL = str.substring(1, str.length());
			String substringR = str.substring(0, str.length() - 1);

			if (!cache.containsKey(substringL)) {
				cache.put(substringL, findMinInsertions(substringL));
			}
			if (!cache.containsKey(substringR)) {
				cache.put(substringR, findMinInsertions(substringR));
			}

			return Math.min(cache.get(substringL), cache.get(substringR)) + 1;
		}
	}
}
