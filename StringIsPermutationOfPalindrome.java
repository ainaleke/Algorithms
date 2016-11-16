
public class StringIsPermutationOfPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myString="tact toe";
		System.out.println(stringIsPermutationOfPalindrome("tact coapapa"));	
	}

	public static String removeSpacesFromString(String str) {
		//initialize variable to count the number of spaces in the string
		int spaceCount=0;
		for(int q=0;q<str.length();q++){
			if(str.charAt(q)== ' '){
				spaceCount++;
			}
		}
		char[] str_array=new char[str.length()- spaceCount];
		int p=0;int charArrayIndex=0;
		while(p<str.length()){
			//if we don't encounter a space 
			if(str.charAt(p)!=' '){
			  str_array[charArrayIndex]=str.charAt(p);
			  charArrayIndex++;
			}	
			p++;
		}
		return new String(str_array);
	}

	public static boolean stringIsPermutationOfPalindrome(String initStr){
		String str=removeSpacesFromString(initStr).toLowerCase();
		//remove spaces from the string and convert into a char array
		char[] str_array=str.toCharArray();
		int p=0;
		while(p<str.length()){
			if(str.charAt(p)==' '){
				p++;
			}
			else{
				str_array[p]=str.charAt(p);
				p++;
			}
		}
		
		int[] letters=new int[256];
		int ascirep=0;
		int N=str.length();
		for(int i=0; i<str.length();i++){
			ascirep=(int)str_array[i];
			++letters[ascirep];
		}
		//if the length of the string is even
		if(N%2==0){
			//loop through the Ascii Rep Array Letters
			for(int k=0;k<letters.length;k++){
				//if we find any of the letters not occurring an even number of times then its not a permutation of a palindrome
				if(letters[k]%2!=0){
					return false;
				}
			}
		}//end if
		else{
			int counter=0;
			for(int k=0;k<letters.length;k++){
				
				//lets get the letters which occur just once, we musn't have more than one letter having this characteristic 
				if(letters[k]==1){
					counter+=1;
				}
				//if we find more than one letter occuring once or if the number of occurrences is >1 and is odd
				else if(counter>1 || (letters[k]>1 && letters[k]%2!=0)){
					return false;
				}
			}
		}
		return true;
	}
}
