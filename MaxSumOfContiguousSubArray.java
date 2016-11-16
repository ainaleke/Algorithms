
public class MaxSumOfContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr={1,-3,2,-5,7,6,-1,-4,11,-23};
		int[] arr={1,1,-3,4,5};

		System.out.println(maxSumSubArray2(arr));
	}
	
	public static int maxSumSubArray(int[] arr){
		int max=Integer.MIN_VALUE;
		int currentValue=0;
		for(int i=0;i<arr.length;i++){
			currentValue=0;
			for(int j=i; j<arr.length;j++){
				currentValue+=arr[j];
				if(currentValue>max){
					max=currentValue;
				}
			}
		}
		
		return max;
	}
	
	public static int maxSumSubArray2(int[] arr){
		int newsum=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			newsum=Math.max(newsum+arr[i], arr[i]);
			max=Math.max(max, newsum);
		}
		
		return max;
	}

}
