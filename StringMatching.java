import java.util.HashMap;

public class StringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isSubstring("d","dvd"));
		//System.out.println(longestSubstring("dvdf"));
		System.out.println(lengthOfLongestSubstring("pwwke"));
		boolean[] seats = new boolean[10];
		//System.out.println(seats[5]);
		System.out.println(Math.abs(-123));
		System.out.println(Math.pow(10,10));
	}

	public static boolean isSubstring(String shrt, String lng ){
		
		
		for(int i=0;i<lng.length();i++){
			int j=0;
			while(lng.charAt(i+j)==shrt.charAt(j)){
				j++;
				if(j==shrt.length()){
					return true;
				}
				if((i+j)>=lng.length()){
					break;
				}
				
			}
		}
		return false;
	}
	
	public static String longestSubstring(String str){
		String result="";
		if(str.length()==1){
			return str;
		}
		if(str.length()==0){
			return "0";
		}
		String temp=Character.toString(str.charAt(0));
		for(int i=1; i<str.length();i++){
			String letter=Character.toString(str.charAt(i));
			if(!isSubstring(letter,temp)){
				temp=temp+letter;
				if(result.length()<temp.length()){
					result=temp;
				}
			}
			else{
				temp=letter;
//				if(result.length()==0){
//					result=temp;
//				}
			}
		}
		return result;
	}
		
	public static int longestCommonSubstring(String str){
		int result=0;
		int[] letters=new int[256];
		int currentLength=0;
		if(str.length()==0){
			return 0;
		}
		if(str.length()==1){
			return 1;
		}
		for(int i=0;i<str.length();i++){
			for(int j=i;j<str.length();j++){
				int ascirep=0;
				ascirep=(int)str.charAt(j);
				//if an occurrence has occurred
				++letters[ascirep];
				if(letters[ascirep]==1){
					currentLength+=1;
				}
				//we have found a duplicate
				else if(letters[ascirep]>1){
					if(currentLength>result){
						result=currentLength;
				}
				letters=new int[256];
				currentLength=0;
				break;
			}
		  }
		}
		return result;
	}
	public static int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        char[] arr = s.toCharArray();
        int pre = 0;
 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
        for (int i = 0; i < arr.length; i++) {
        	if (!map.containsKey(arr[i])) {
        		map.put(arr[i], i);
        	} else {
        		pre = Math.max(pre, map.size());
        		i = map.get(arr[i]);
        		map.clear();
        	}
        }
 
	  return Math.max(pre, map.size());
	}

}

