package com.dynProgRecursion;

//Given a number, return the number of ways you can make change.

public class WaysToMakeChange {

	public static void main(String args[]) {
		System.out.println(waysC(100, 25));
	}

	static int waysC(int amt, int denom) {

		int next = 0;
		switch (denom) {
			case 25:
				next = 10;
				break;

			case 10:
				next = 5;
				break;

			case 5:
				next = 1;
				break;

			case 1:
				return 1;

		}
		int i = 0;
		int ways = 0;
		while (amt - i * denom >= 0) {
			ways += waysC(amt - i * denom, next);
			i++;
		}
		return ways;
	}
}
