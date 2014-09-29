package com.math;

public class SquareRoot {
	public static void main(String args[]) {
		System.out.println(squareRoot(5000));
	}

	static double squareRoot(double num) {
		return sqrt(num, 0, num);
	}

	private static double sqrt(double num, double low, double high) {
		double tolerance = 000.1;
		double mid = (low + high) / 2; //Find the midpoint between the low and high
		double guess = Math.pow(mid, 2); //Square it.

		if (Math.abs(guess - num) < tolerance) { //See how much it differs from the number we want to find the sqrt of.
			return mid;
		} else { //If the difference is too much...
			if (guess > num) { //Adjust the value of low/high as necessary
				high = mid;
			} else {
				low = mid;
			}
			return sqrt(num, low, high); //Call recursively with the new low or high
		}

	}
}
