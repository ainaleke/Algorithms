
public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "find you will pain only go you recordings security the into if";
		String[] wordArray=message.split("\\s");
		System.out.println(reverseWords(message));
	}
	
	public static String reverseWords(String sentence){
		if(sentence.length()==0){
			return null;
		}
		String[] wordArray=sentence.split("\\s");
		int i=0;
		int j=wordArray.length-1;
		while(i<j){
			String temp=wordArray[i];
			wordArray[i]=wordArray[j];
			wordArray[j]=temp;
			i++;
			j--;
		}
		String result="";
		for(int k=0;k<wordArray.length;k++){
			result+=wordArray[k]+" ";
		}
		
		return result;
	}

}
