package com.strings;

public class regexMatch {

	public static void main(String args[]) {
		System.out.println(matches("abcbcd", "a.*c.*d"));
	}

	public static boolean matches(String text, String pattern) {
		System.out.println("Trying to match: " + text + " " + pattern);
		// Base case: If both pattern and text are empty, it's a match.
		if (pattern.length() == 0) {
			return text.length() == 0;
		}

		String nextChar = (pattern.length() > 1) ? String.valueOf(pattern.charAt(1)) : ""; //Grab the second letter of the pattern 
		char t = (text.length() > 0) ? text.charAt(0) : 0; //Grab the first letter of the test string
		char p = pattern.charAt(0); //Grab the first character of the pattern.

		if (!"*".equals(nextChar)) { //If the second character in the pattern is not '*'
			return ((t == p) || (p == '.' && t != 0)) && matches(text.substring(1), pattern.substring(1)); //If they match, chop off the first letters and call the method recursively.
		} else { //If the second character in the pattern is '*'
			while ((t == p) || (p == '.' && t != 0)) { //Check if the first characters of text and pattern match (or '.' character is in the pattern)
				if (matches(text, pattern.substring(2))) //Check to see if there's a match between the text and pattern if you chop off the first two characters of the pattern. (the char plus the star)
					return true;
				text = text.substring(1); //There wasn't a match, so we chop off the first letter from the text.
				t = (text.length() > 0) ? text.charAt(0) : 0; //Grab the first character of the new text string.
			}
			//If the first character of the pattern doesn't match the first character of the text, chop off the first two chars of the pattern and recursively call the method. 
			return matches(text, pattern.substring(2));

		}
	}
}
/*
Summary of how the algorithm works:  

 Look at the pattern and see if the second character is a '*'.  If it is, we need to do something different.
 
 In the case that the second character is NOT a '*', we just compare the first characters of both the text and pattern and make sure they match (or check for a '.' character).
 Then we call the function again on the text and pattern with the first characters of each chopped off (since we just confirmed they match).
 
 In the case that the second character IS a '*', we compare the first characters of the text and pattern and make sure they match (or check for a '.' character).
 Now note that if the second character is a '*', that means we have a letter or dot followed by a '*' like 'a*' or '.*'
 To make sure we're not being too greedy, we'll chop off the first two characters and then try to match it with the text.  If that's successful, we're done, it's a match.
 If it's not, chop off the first letter of the text and re-evaluate the loop condition.
 If the loop evaluation fails, chop off the first two characters of the pattern and try matching again.

 */

/*
Examples:

--------------------

Text: abbc
Pattern: ab*bbc

Second character of pattern is not a star.
Check first character of text and first character of pattern.  They match.
Call the method again with the first character chopped off in both:

Text: bbc
Pattern: b*bbc

Second character of pattern is a star.
while the first characters of the text and pattern match...
remove b* from pattern.  Check if both match:

Text: bbc
Pattern bbc

Yes, so return true.

------------------------

Text: abcbcd
Pattern: a.*c.*d

Second character of pattern is not a star.
Check first character of text and first character of pattern.  They match.
Call the method again with the first character chopped off in both:

Text: bcbcd
Pattern .*c.*d

Second character of pattern is a star.
First character of the pattern is a .
Remove .* from the pattern and check if both match:

Text: bcbcd
Pattern: c.*d

It doesn't.  So continue with the while loop.

Text: cbcd
Pattern: c.*d

It matches, so we return true.

----------------------------


*/

/*

Re-wrote the method for practice.  

	public static boolean matches(String text, String pattern) {

		if (text.length() == 0 && pattern.length() == 0)
			return true;

		char t1;
		char p1;
		char p2;
		t1 = text.length() > 0 ? text.charAt(0) : 0;
		p1 = pattern.charAt(0);
		p2 = pattern.length() > 1 ? pattern.charAt(1) : 0;

		if (p2 == '*') {
			while (t1 == p1 || p1 == '.' && t1 != 0) {
				if (matches(text, pattern.substring(2))) {
					return true;
				}
				text = text.substring(1);
				t1 = text.length() > 0 ? text.charAt(0) : 0;
			}
			return matches(text, pattern.substring(2));

		} else {
			return (t1 == p1 || p1 == '.' && t1 != 0) && matches(text.substring(1), pattern.substring(1));
		}

	}
	
	*/
