package com.algorithms;

public class AnagramWords {

	public static void main(String[] args) {
		System.out.println(anagramWords("heap","peahs"));

	}
	
	public static boolean anagramWords(String s, String t)
	{
		if(s.length()!=t.length())
			return false;
		char[] schar=s.toCharArray();
		char[] tchar=t.toCharArray();
		//sort both char arrays and return boolean
		return sort(schar).equals(sort(tchar));         
		
	}
	public static String sort(char[] c)
	{
		java.util.Arrays.sort(c);
		//sort the char array and convert it into a string
		return new String(c);
	}

}
