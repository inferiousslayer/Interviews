package com.binaryManipulation;

//Reverse the bits in a binary number.  1011 --> 1101

public class ReverseBits {
	public static void main(String args[]) {
		System.out.println(Integer.toBinaryString(reverseBits(0b0011)));
	}

	//Things to consider: 0b0011 --> 11 instead of 1100 because in our solution we don't account for extra 0's.
	//If we wanted to limit the input to a fixed binary length, we could use a bitmask to zero out extra values.
	//We'd have to keep in mind that all values in Java are signed though.

	static int reverseBits(int num) {

		int i = 0; //Position of right-most bit
		int j = 0;
		int temp = num;

		while (temp > 0) {
			temp = temp >> 1;
			j++;
		}

		j = j - 1; //Position of left-most non-zero bit

		while (i < j) {
			//Basically the same idea as reversing a string.  We'll grab the bits at those two points.
			//We'll compare them, and if they don't match, we'll xor them so they reverse their value.
			int bit1 = num >> j & 1;
			int bit2 = num >> i & 1;

			if (bit1 != bit2) {
				num = num ^ 1 << j;
				num = num ^ 1 << i;
			}
			i++;
			j--;
		}
		return num;

	}

}
