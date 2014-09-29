package com.arrays;

import java.util.Arrays;

public class RotateMatrix90Degree {
	public static void main(String args[]) {
		int[][] matrix = new int[4][4];
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = count;
				count++;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
		rotateMatrix90(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

	static void rotateMatrix90(int[][] matrix) {

		for (int offset = 0; offset < matrix.length / 2; offset++) { //Rotate the outer layer then work your way inward
			int start = offset;
			int end = matrix.length - 1 - offset;

			for (int i = start; i < end; i++) {

				int temp = matrix[start][i]; // Top to temp
				matrix[start][i] = matrix[end - i][start]; //Left to Top
				matrix[end - i][start] = matrix[end][end - i];//Bottom to Left
				matrix[end][end - i] = matrix[start + i][end];//Right to Bottom
				matrix[start + i][end] = temp; // Top to Right
			}
		}

	}
}
