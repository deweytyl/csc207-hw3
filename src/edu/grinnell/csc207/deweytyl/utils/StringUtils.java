package edu.grinnell.csc207.deweytyl.utils;

import java.util.ArrayList;

public class StringUtils {
	
	public static String[]
	splitAt (String str, char ch)
	throws Exception
	{
		// Start each new substring with an empty string, then append what you find onto it
		// if it's not the separator.
		ArrayList<String> splitStrings = new ArrayList<String>();
		String storageString = "";
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) != ch)
			{
				storageString += str.charAt(i);
			}
			else {
				splitStrings.add(storageString);
				storageString = ""; // Reset storageString
			}
		}
		
		return (String[]) splitStrings.toArray ();
	}
}
