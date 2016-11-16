
public class ElementAppearOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,3,3,3,4,4,5,5,5,6,6};
		System.out.println(numberWhichAppearsOnce(arr));
		System.out.println('A'-'A');
	}
	
	public static int numberWhichAppearsOnce(int[] arr){
		int i=0;
		int counter=1;
		int result = 0;
		while(i<arr.length-1){
			if(arr[i]==arr[i+1]){
				counter++;
				i++;
			}
			else{
				//if the number which appears once is the last value then break out of loop and return that value
				if(i+1==arr.length-1){
					result= arr[i+1];
					break;
				}
				//if the number which appears once is the first value then return that first value and break out of the loop
				if(counter==1){
					result=arr[i];
					break;
				}
				else if(counter>1){
					counter=1;
					i++;
				}
				
			}
		}
		return result;
	}

}
