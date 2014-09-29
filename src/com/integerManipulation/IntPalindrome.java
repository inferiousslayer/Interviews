package com.integerManipulation;

public class IntPalindrome {
	//Figure out if an integer is a palindrome without using extra data structures.
	public static void main(String args[]) {
		System.out.println(isPalindrome(10011));
	}

	static boolean isPalindrome(int num) {
		int left; //Left most digit.
		int right; //Right most digit.
		int divisor = 1;

		//Find the divisor.
		while (num != 0) {
			while (num / divisor >= 10) {
				divisor *= 10;
			}

			left = num / divisor; //For example for 50011, the divisor would be 10000.  50011/10000 = 5 which is the leftmost digit
			right = num % 10; //modulo 10 will give the rightmost digit.

			if (left != right) {
				return false;
			}

			num = (num % divisor) / 10; //This chops off the leftmost and rightmost digits.

			/*Since we got rid of two digits, we need to divide the divisor by 100.  
			 * We have to do this instead of recalculating the divisor because numbers like 10011 will give wrong answers.
			 * 
			 * Example:
			 * The number is 10011.  The divisor would be 10000.  So left = 1 and right = 1
			 * Now after chopping off the left and right digits, we're left with 0011 aka 11.
			 * If we recalculated the divisor, it would be 10.  left = num/divisor = 11/10 = 1 which is wrong!
			 * Instead, we keep the divisor of 10000 and divide it by 100 (to make up for the missing digits).
			 * The new divisor is 100.  Now If we calculate left, left = num/divisor = 11/100 = 0.
			 */
			divisor /= 100;
		}
		return true;
	}

}
