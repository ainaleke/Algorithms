
public class MaxSumOfNonContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray={-7,-3,-2,11,-3,0,1};
		System.out.println(maxSumSubArray(myArray));
		//System.out.println(5* ('5'-'0'));

	}
	
	public static int maxSumSubArray(int[] arr){
		int minValue=Integer.MIN_VALUE;
		int sum=0;
		boolean allNegative=true;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<0 && allNegative==true){
				if(arr[i]>minValue){
					minValue=arr[i];
				}
			}
			else if(arr[i]>0){
				allNegative=false;
				sum+=arr[i];
			}
		}//end for loop
		return (allNegative)? minValue:sum;
	}

}
