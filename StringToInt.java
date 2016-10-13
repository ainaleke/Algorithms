
public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int stringToInt(String str) throws Exception{
		if(str.length()==0){
			throw new Exception("Empty string now allowed");
		}
		else if(str.length()==1){
			return (str.charAt(0)-'0');
		}
		int result=0;
		boolean isNegative=false;
		int N=str.length();
		int end=0;
		
		if(str.charAt(end)=='-'){
			end=1;
			isNegative=true;
		}
		for(int i=str.length()-1;i>=end;i--){
			int number=str.charAt(i)-'0';
			result+=(number * Math.pow(10, i))+result;
			
			
		}
		return 0;
	}

}
