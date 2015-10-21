package com.algorithms;

public class CheckPalindrome {

	public static void main(String[] args) throws Exception {
		System.out.println(isPalindrome("race car"));
		System.out.println(isPalindrome("a"));

	}
	
	public static boolean isPalindrome(String str) throws Exception
	{
		if(str==null)
			 throw new Exception("String Entered is Null");
		
		if(str.length()==1)
			return false; //a single length string cannot be a palindrome
		
		int i=0; //starting index to begin palindrome check
		int j=str.length()-1;
		
		while(i<j)
		{
			
			while(str.charAt(i)==' ')
			{
				i++; //if you find white spaces advance to the next letter towards the right 
			}
			while(str.charAt(j)==' ')
			{
				j--; //if you find white spaces advance to the next letter towards the left
			}
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
			//advance both indices to check for other corresponding values.
			i++;
			j--;
		}	
		return true;
	}//end method

	
}
