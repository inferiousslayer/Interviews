package com.strings;

import java.util.ArrayList;
import java.util.List;

public class StringMath {

	//Given a string with operators + - * / do the math.  Example: "5+5*6" should return 35
	//Support for parentheses not implemented.	
	public static void main(String args[]) {
		System.out.println(doMath("5+5*6/5-5"));
	}

	static double doMath(String input) {

		if (input.contains("+")) {
			String[] operands = input.split("\\+");
			double result = 0;
			for (String operand : operands) {
				result += doMath(operand);
			}
			return result;
		} else if (input.contains("-")) {
			String[] operands = input.split("-");
			double result;
			List<Double> resultList = new ArrayList<Double>();
			for (String operand : operands) {
				resultList.add(doMath(operand));
			}
			result = resultList.get(0);
			for (int i = 1; i < resultList.size(); i++) {
				result -= resultList.get(i);
			}
			return result;
		} else if (input.contains("*")) {
			double result = 1;
			String[] operands = input.split("\\*");
			for (String operand : operands) {
				result *= doMath(operand);
			}
			return result;
		} else if (input.contains("/")) {
			String[] operands = input.split("/");
			double result;
			List<Double> resultList = new ArrayList<Double>();
			for (String operand : operands) {
				resultList.add(doMath(operand));
			}
			result = resultList.get(0);
			for (int i = 1; i < resultList.size(); i++) {
				result /= resultList.get(i);
			}
			return result;
		} else {
			return Double.parseDouble(input);
		}
	}
}
