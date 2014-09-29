package com.arrays;

import java.util.Arrays;
import java.util.HashSet;

//For a matrix, if a cell contains a 0, zero out its entire row and column.
public class ZeroOutZeroes {

	public static void main(String args[]) {
		int mat[][] = new int[2][3];

		mat[0][0] = 1;
		mat[0][1] = 7;
		mat[0][2] = 6;

		mat[1][0] = 1;
		mat[1][1] = 0;
		mat[1][2] = 4;

		System.out.println(Arrays.deepToString(mat));

		System.out.println(Arrays.deepToString(matrixZeroOut(mat)));
	}

	public static int[][] matrixZeroOut(int mat[][]) {
		HashSet<Integer> rowZeroes = new HashSet<Integer>();
		HashSet<Integer> colZeroes = new HashSet<Integer>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					rowZeroes.add(i);
					colZeroes.add(j);
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (rowZeroes.contains(i) || colZeroes.contains(j)) {
					mat[i][j] = 0;
				}
			}
		}
		return mat;
	}

}
