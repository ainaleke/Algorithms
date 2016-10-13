import javax.xml.ws.AsyncHandler;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(stringCompression("aabbcccddeff"));
		System.out.println(stringCompression2("aabbcccddefg"));
	}
	public static String stringCompression(String str){
		if(str.length()<=1){
			return str;
		}
		StringBuilder builder=new StringBuilder();
		int counter=1;
		int i=0;
		char[] charArray=str.toCharArray();
		while(i<charArray.length-1){
			char letter=charArray[i];
			while(i<charArray.length-1 && charArray[i]==charArray[i+1]){
				counter++;
				i++;
			}
			builder.append(letter);
			builder.append(counter);
			counter=1;
			i++;
			//i becomes the last index
			if(i==charArray.length-1 && charArray[i-1]!=charArray[i]){
				builder.append(charArray[i]);
				builder.append(counter);
			}
		}
		return builder.toString();
		
	}
	public static String stringCompression2(String str){
		if(str.length()<=1){
			return str;
		}
		StringBuilder builder=new StringBuilder();
		int counter=1;
		int i=0;
		char[] charArray=str.toCharArray();
		while(i<charArray.length-1){
			char letter=charArray[i];
			if(charArray[i]==charArray[i+1]){
				counter++;
				i++;
			}
			else{
				builder.append(letter);
				builder.append(counter);
				counter=1;
				i++;
			}
			
			//i becomes the last index
			if(i==charArray.length-1){
				 if(charArray[i-1]==charArray[i]){
						builder.append(charArray[i]);
						builder.append(counter);
				 }else{
					 builder.append(charArray[i]);
					 builder.append(counter);
				 }
			}
		}
		String compressedString=builder.toString();
		
		//return (str.length()<compressedString.length())? str:compressedString;
		return compressedString;
		
	}

}
