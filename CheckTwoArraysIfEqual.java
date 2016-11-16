import java.util.HashSet;
import java.util.Set;

public class CheckTwoArraysIfEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1,3,5,7,9};//3,5,7,9,11
		int[] arr2={3,11,9,7,5};
		System.out.println(checkTwoArrays(arr1,arr2,2));
		String strings="+1(333)-444-5678";
		String[] strArr=strings.split("-");
		for(int i=0;i<strArr.length;i++){
			System.out.println(strArr[i]);
		}
		System.out.println(maskPhoneNumber("+1(333)4446678"));
		//+-*-*-**--***-6678
	}
	 public static String maskPhoneNumber(String phonenum)
	    {       
	            char[] charArray=phonenum.toCharArray();
	            StringBuilder builder=new StringBuilder();
	            for(int k=charArray.length-1;k>=charArray.length-4;k--){
	                builder.append(charArray[k]);
	            }
	                builder.append('-');
	                int count=1;
	            for(int k=charArray.length-6;k>=0;k--){
	                 if(charArray[k]=='+'){
	                     builder.append('+');
	                     continue;
	                 }
	                 else if(charArray[k]==')'){
	                	 builder.append('-');
	                     continue;
	                 }
	                 else if(charArray[k]=='('){
	                	 builder.append('-');
	                 }
	                 else{
	                     builder.append('*');
	                     count++;
	                     if(count>3){
	                         builder.append('-');
	                         count=1;
	                     }
	                 }
	             }
	            return reverseAString(builder.toString());
	    }
		public static String reverseAString(String str)
		{
			String newStr=new String();
			for(int i=str.length()-1;i>=0;i--)
			{
				newStr=newStr+str.charAt(i);
			}
			return newStr;
		}
		
	public static String maskPhoneNumber1(String phonenum)
	{      
	
    String[] strArray=phonenum.split("-");
			
	StringBuilder builder=new StringBuilder();
	for(int i=0;i<strArray.length-1;i++){
		String eachString=strArray[i];
		char[] charArray=eachString.toCharArray();
		for(int k=0;k<charArray.length;k++){
			if(charArray[k]=='+'){
				builder.append('+');
				continue;
			}
			else if(charArray[k]=='(' || charArray[k]==')'){
				if(k==0){
					continue;
				}
				builder.append('-');
			}
			else{
				
				builder.append('*');
			}
		}
	}
    builder.append('-');
	builder.append(strArray[strArray.length-1]);
	return builder.toString();
	}
	public static boolean checkTwoArrays(int[] arr1,int[] arr2,int k){
		if(arr1.length!=arr2.length){
			return false;
		}
		int difference=0;
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<arr1.length;i++){
			set.add(arr1[i]);
		}
		for(int p=0;p<arr2.length;p++){
			if(!set.contains(arr2[p]+k)&& !set.contains(arr2[p]-k)){
				return false;
			}
			else if(set.contains(arr2[p]+k)){
				set.remove(arr2[p]+k);
			}
			else if(set.contains(arr2[p]-k)){
				set.remove(arr2[p]-k);
			}
		}
		return true;
	}

}
