package com.arrays;

import java.util.Arrays;

//Find all pairs of numbers in the array that sum to k.
public class FindSumToNum {

	public static void main(String args[]) {
		pairsSumToK(new int[] { -2, -3, 3, 1, 2, -1, 0, 0, 4, 5, 7 }, 5);
		System.out.println("\n");
		threeThatSumToANumber(new int[] { -2, -3, 3, 1, 2, -1, 0, 0, 4, 5, 7 }, 5);
	}

	// It's O(n log n) because we need to sort the array.  If it's already sorted then it's O(n)
	//Have a pointer at the beginning and at the end (i and j).  If the sum is larger than k, decrease j.
	//If the sum is less than k, increase i.  If it matches, increase i and decrease j.
	static void pairsSumToK(int[] numArr, int k) {
		Arrays.sort(numArr);
		int i = 0;
		int j = numArr.length - 1;
		while (i < j) {

			int sum = numArr[i] + numArr[j];

			if (sum == k) {
				System.out.println("{" + numArr[i] + "," + numArr[j] + "}");
				i++;
				j--;
			} else if (sum < k) {
				i++;
			} else if (sum > k) {
				j--;
			}
		}
	}

	//Find 3 numbers that sum to num.
	//Basically this is an extension of the 2 numbers method.  We'll need three variables to keep track of the pointers m,i,j.
	//It's O(n^2)
	/*
	Example:

	This is our array:

	[-2][0][3][5][6][7]
	
	Let's say we want to find all sets of 3 numbers that add up to 5.
	
	Start m's index at 0.  Start i's index at m+1.  Start j's index at the last cell.
	
	m's value is -2.  Our desired sum is 5.  So that means i and j have to sum up to (desiredSum - m) = (5-(-2)) = 7.
	So now it's like the previous method, we will keep increasing i and j until we find numbers that will add up to 7.
	
	Once we finish that, we increase m's index by 1.  i's initial index is always m+1.  j always is at the last cell.
	Then we repeat this again.

	*/
	static void threeThatSumToANumber(int[] numArr, int num) {
		Arrays.sort(numArr);
		int i = 0;
		int j = numArr.length - 1;
		for (int m = 0; m < num; m++) {
			while (i < j) {
				int sum = numArr[i] + numArr[j];

				if (sum == num - numArr[m]) {
					System.out.println("{" + numArr[m] + "," + numArr[i] + "," + numArr[j] + "}");
					i++;
					j--;
				} else if (sum < num - numArr[m]) {
					i++;
				} else if (sum > num - numArr[m]) {
					j--;
				}
			}
		}
	}

}
