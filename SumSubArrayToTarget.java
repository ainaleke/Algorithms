
public class SumSubArrayToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,3,5,7,9};
		System.out.println(sumSubArrayToTarget(arr, 27));
		
	}
	
	public static boolean sumSubArrayToTarget1(int[] arr, int target){
		if(arr.length<1){
			return false;
		}
		
		for(int i=0;i<arr.length;i++){
			int sum=0; int k=i;
			innerloop:
			while(k<arr.length){
				sum+=arr[k];
				if(sum==target){
					return true;
				}
				else if(sum>target){
					break innerloop;
				}
				k++;
			}
		}
		return false;
	}
	public static boolean sumSubArrayToTarget(int[] arr, int target){
		if(arr.length<1){
			if(target!=0){
				return false;
			}
			return true;
		}
		int sum=0;
		int indexCount=0;
		int i=0;
		while(i<arr.length){			
			sum+=arr[i];
			while(sum>target){
				 sum-=arr[indexCount];
				 indexCount++;
			}
			if(sum==target){
				return true;
			}
			i++;
		}
		return false;
	}
//	public static boolean sumSubArrayToTarget(int[] arr, int target){
//		if(arr.length<1){
//			if(target!=0){
//				return false;
//			}
//			return true;
//		}
//		int sum=arr[0];
//		int indexCount=0;
//		int i=1;
//		while(i<arr.length && indexCount<arr.length){			
//			if(sum>target){
//				 
//				 sum-=arr[indexCount];
//				 indexCount++;
//				 
//			}
//			if(sum==target){
//				return true;
//			}
//			if(i==arr.length-1){
//				 break;
//			}
//			if(sum<target){
//				i++;
//				sum+=arr[i];
//			}
//			
//		}
//		return false;
//	}

}
