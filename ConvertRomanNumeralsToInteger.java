import java.util.HashMap;

public class ConvertRomanNumeralsToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertRomanNumeralsToInteger("CMLXXVIII"));//CLXXVIII MCCMXIV
		try {
			for(int i=0;i<10;i++){
				Thread.sleep(500);
				System.out.println(i);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int convertRomanNumeralsToInteger(String str){
		char[] charArray=str.toCharArray();
		HashMap<Character, Integer> map=new HashMap<Character,Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int total=0; int numOfReps=1;
		int before=0;
		int after=0;
		for(int i=0;i<charArray.length-1;i++){
			before=map.get(charArray[i]);
			after=map.get(charArray[i+1]);
			//MCCM
			if(before!=after){
				if(before<after){
					total-=before*numOfReps;
					numOfReps=1;
				}
				else if(before>after){
					total+=before*numOfReps;
					numOfReps=1;
				}
			}
			//if they are both equal
			else{
				numOfReps++;
				continue;
			}
			
		}
		//if at the end of the loop, we looped through the else clause 
		//if(numOfReps>1){
			total+=numOfReps*after;//*map.get(charArray[str.length()-1]);
		//}
		//else{
			//total+=after;//map.get(charArray[str.length()-1]);;
		//}
		return total;
	}
}
