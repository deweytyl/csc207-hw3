package edu.grinnell.csc207.deweytyl.utils;

import java.util.ArrayList;

public class StringUtils {

	public static String[] splitAt(String str, char ch)
	{
		/**
		 * Start each new substring with an empty string, then append what you
		 * find onto it if it's not the separator. Put the last bit on when you've
		 * gone through the whole thing.
		 * 
		 * Time: ~1h
		 */
		ArrayList<String> splitStrings = new ArrayList<String>();
		String storageString = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch) {
				storageString += str.charAt(i);
			} // if
			else {
				splitStrings.add(storageString);
				storageString = ""; // Reset storageString
			} // else
		} // for

		splitStrings.add(storageString);
		
		String[] splitStringsArray = new String[splitStrings.size()];
		return splitStrings.toArray(splitStringsArray);
	} // splitAt(String, char)
	
	/**
	 * splitCSV
	 */
	
	
	
	/**
	 * deLeet
	 */
	
	
	
	/**
	 * nameGame
	 */
	
	
	
} // StringUtils
