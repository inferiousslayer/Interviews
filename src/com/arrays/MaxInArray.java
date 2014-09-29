package com.arrays;

public class MaxInArray {
	//The easiest solution would be just to sort the array and grab the last element.  That would be O(n log n).  We can do it in O(n) time however if we traverse through the array.

	public static void main(String args[]) {
		int[] arr = { 5, 65, 3, 2, 8, 9, 1, 18, 0, 4 };
		max(arr);
		max2(arr);

	}

	static void max(int[] arr) { //Prints the maximum integer in the array.
		if (arr.length < 1) {
			System.out.println("Invalid array!");
			return;
		}

		int max = 0;

		for (int num : arr) {
			if (num > max) {
				max = num;
			}
		}
		System.out.println(max);
	}

	static void max2(int[] arr) { //Prints the two largest integers in the array
		if (arr.length < 2) {
			System.out.println("Invalid array!");
		}

		int max = 0; //Largest number
		int max2 = 0; //2nd largest number

		for (int num : arr) {
			if (num > max) {
				max2 = max;
				max = num;
			} else if (num > max2) {
				max2 = num;
			}
		}
		System.out.println("Largest: " + max + ".  2nd largest: " + max2);
	}
}
