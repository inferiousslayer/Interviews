package com.dynProgRecursion;

//Return the nth fibonacci number

public class Fibonacci {

	public static void main(String args[]) {
		System.out.println("Regular");
		for (int i = 0; i < 15; i++) {
			System.out.println(fib(i));
		}

		System.out.println("Dynamic");
		for (int i = 0; i < 15; i++) {
			System.out.println(fibDyn(i));
		}
	}

	static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	//Dynamic programming implementation
	static int fibDyn(int n) {
		return fibRecurse(n, new int[n + 1]);
	}

	static int fibRecurse(int n, int[] cache) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (cache[n] != 0) {
			return cache[n];
		}
		cache[n] = fibRecurse(n - 1, cache) + fibRecurse(n - 2, cache);
		return cache[n];
	}

}
