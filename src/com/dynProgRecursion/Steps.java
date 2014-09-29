package com.dynProgRecursion;

import java.util.HashMap;

//Person is running up staircase with n steps.  They can jump either 1, 2, or 3 steps.  How many differen ways are there for them to run up the stairs?
public class Steps {

	public static void main(String args[]) {
		System.out.println(numWays(3));
		System.out.println(numWaysDynamic(3, null));
	}

	public static int numWays(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps == 0) {
			return 1;
		} else {
			return numWays(steps - 1) + numWays(steps - 2) + numWays(steps - 3);
		}

	}

	public static int numWaysDynamic(int steps, HashMap<Integer, Integer> hm) {

		if (hm == null) {
			hm = new HashMap<Integer, Integer>();
		}

		if (steps < 0) {
			return 0;
		} else if (steps == 0) {
			return 1;
		} else if (hm.containsKey(steps)) {
			return hm.get(steps);
		} else {
			hm.put(steps, numWaysDynamic(steps - 1, hm) + numWaysDynamic(steps - 2, hm) + numWaysDynamic(steps - 3, hm));
			return hm.get(steps);
		}

	}

}
