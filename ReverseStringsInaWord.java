
public class ReverseStringsInaWord {

	//Reversing   the   words   in   a   string 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Oluwaleke aina is a boy"));

	}
	public static String reverseWords(String str){
		char[] charArray=str.toCharArray();
		//now we look for spaces in this String
		int i=0;
		int start=0;
		int end=0;
		while(i<charArray.length){
			while(charArray[i]==' ' && i<charArray.length){
				i++;
			}
			start=i;
			while(charArray[i]!=' '){
				i++;
				if(i==charArray.length){
					break;
				}
			}
			end=i-1;
			reverseString(charArray,start, end);
			//i++;
		}
		return new String(charArray);
	}

	private static void reverseString(char[] arr,int start, int end){
		int N=start+end;
		for(int i=start;i<=N/2;i++){
			char temp=arr[i];
			arr[i]=arr[N-i];
			arr[N-i]=temp;
		}
	}
}
