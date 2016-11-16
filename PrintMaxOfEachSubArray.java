import java.util.ArrayList;

public class PrintMaxOfEachSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//9,6,11,8,10,5,14,13,93,14
		int arr[]={9,6,11,8,10,5,14,13,93,14};
		int[] arr2={4,2,12,34,23,35,44,55};
		System.out.println(printMaxElementFromEachSubArray(arr,4));
		System.out.println(printMaxElementFromEachSubArray(arr2,3));
	}
	
	public static int getMaxOfSubArray(int[] arr,int start,int end){
		int max=0;
		for(int i=start;i<=end;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
	public static ArrayList<Integer> printMaxElementFromEachSubArray(int[] arr, int k){
		ArrayList<Integer> subArrayMax=new ArrayList<Integer>();
		int j=0;int N=arr.length;
		//we expect to start from 0 and end at N-k for example if we have 8 elements(i.e. index 0-7) and k=4
		//this means the first sub array will be 0-4 and the last sub array will be from 4-7(which are the last 4 elements gotten by 8-4=4 to arr.length as the last index
		//so here i is the start index in every sub array
		for(int i=0; i<=N-k;i++){
			j=i+k-1; //its not just i+k because, we are looking at indices in the array, the last element in final sub array of 8 elements should be arr.length -1 which is 7
			subArrayMax.add(getMaxOfSubArray(arr,i,j));
		}
		return subArrayMax;
	}
	
	
	
	//If you are given an integer array and an integer 'k' as input, 
	//write a program to print elements with maximum values from each possible sub-array (of given input array) 
	//of size 'k'. If the given input array is {9,6,11,8,10,5,14,13,93,14} and for k = 4, 
	//output should be 11,11,11,14,14,93,93. Please observe that 11 is the largest element 
	//in the first, second and third sub-arrays - {9,6,11,8}, {6,11,8,10} and {11,8,10,5}; 
	//14 is the largest element for fourth and fifth sub-array and 
	//93 is the largest element for remaining sub-arrays.

}
