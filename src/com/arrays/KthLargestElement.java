package com.arrays;

//Given an unsorted array, return the kth largest element.  Sorting is not allowed (plus our solution should be faster than n log n)

public class KthLargestElement {

	public static void main(String args[]) {
		int[] arr = { 5, 4, 99, 3, 7, 10, 75 };
		System.out.println(kthLargest(arr, 2));
	}

	static int kthLargest(int[] arr, int k) {
		//Create a temp array of size k.
		int temp[] = new int[k];
		for (int num : arr) {
			for (int x = 0; x < temp.length; x++) {
				if (num > temp[x]) {
					int tmp = temp[x];
					temp[x] = num;
					num = tmp;
				}
			}
		}
		return temp[k - 1];
	}

}
