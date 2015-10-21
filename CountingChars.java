package com.algorithms;

public class CountingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countChars("Oluwaleke");
	}
	
	public static void countChars(String str)
	{
		int[] myArray=new int[256];
		
		char[] charArray=str.toCharArray();
		
		
		for(int i=0; i<str.length();i++)
		{
			myArray[str.charAt(i)]++;
		}
		//OR
		
		for(char c: charArray)
		{
			myArray[c]++;
		}
		for(int i=0;i<myArray.length;i++) {
			System.out.println(myArray[i]);
		}
	}

}
