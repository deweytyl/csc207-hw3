package edu.grinnell.csc207.deweytyl.utils;

import java.math.BigInteger;

public class Calculator {

	/**
	 * eval10
	 * 
	 * Preconditions: 
	 * 	Must begin and end with number
	 * 	Numbers must alternate with operations
	 * Postconditions:
	 * 	eval10 executes operations from left to right,
	 * 	ignoring precedence.
	 * 	Returns BigInteger with value of final result.
	 * 
	 * Time: ~1h
	 */

	public static BigInteger eval0(String expression) {
		String[] expressionArray = expression.split(" ");
		BigInteger result = new BigInteger("0");

		result = result.add(new BigInteger(expressionArray[0]));

		for (int i = 1; i < (expressionArray.length - 1); i += 2) {
			
			switch (expressionArray[i].charAt(0)) {
			case '+': result = result.add(new BigInteger(expressionArray[i+1]));
				break;
			case '-': result = result.subtract(new BigInteger(expressionArray[i+1]));
				break;
			case '*': result = result.multiply(new BigInteger(expressionArray[i+1]));
				break;
			case '/': result = result.divide(new BigInteger(expressionArray[i+1]));
				break;
			case '^': result = result.pow(Integer.parseInt(expressionArray[i+1]));
				break;
			default: // All other operations are unsupported
				break;
			} // switch

		} // for

		return result;
	} // eval10 (String)

	// Use String.split ();
}
