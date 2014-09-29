package com.arrays;

//Find the largest sum you can get from a contiguous subarray within the input array.
public class MaxSumSubArray {

	public static void main(String args[]) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

		System.out.println(maxSubArraySum(a));

	}

	//We'll keep adding each array element to max_ending_here.  If that causes it to go negative, set max_ending_here to 0.
	//If the value of max_ending_here is greater than max, set max to max_ending_here.  Runtime is O(n)

	static int maxSubArraySum(int a[]) {
		int max = 0, max_ending_here = 0;

		for (int i = 0; i < a.length; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max < max_ending_here) {
				max = max_ending_here;
			}
		}
		return max;
	}

}
