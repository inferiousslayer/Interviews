package com.arrays;

public class BinarySearch {
	public static void main(String args[]) {
		int[] sortedArray = { 3, 10, 15, 60, 320, 1000, 1337, 8080, 10000 };

		System.out.println(bSearch(sortedArray, 10));
		System.out.println(bSearch(sortedArray, 1337));
		System.out.println(bSearch(sortedArray, 10000));
		System.out.println(bSearch(sortedArray, 7));
	}

	public static Integer bSearch(int[] sortedArray, int value) {
		int low = 0;
		int high = sortedArray.length - 1;
		int mid;

		while (low <= high) {
			mid = (high + low) / 2;

			if (sortedArray[mid] == value) {
				return mid;
			}
			if (sortedArray[mid] > value) {
				high = mid - 1;
			}
			if (sortedArray[mid] < value) {
				low = mid + 1;
			}
		}
		return null; //Return null if we couldn't find it;
	}
}
