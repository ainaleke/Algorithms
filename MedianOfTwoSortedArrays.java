
public class MedianOfTwoSortedArrays {

	/**
	There are two sorted arrays nums1 and nums2 of size m and n respectively.
	Example 1:
    nums1 = [1, 3]
	nums2 = [2]

    The median is 2.0
    Example 2:
    nums1 = [1, 2]
	nums2 = [3, 4]

    The median is (2 + 3)/2 = 2.5
	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	**/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,2,3,6,9};//1,2,3,6,9
		int arrSize=arr.length;
		//int median=(N+1)/2;
		System.out.println("Median is: " +getMedian(arr,0,arrSize));
		int[] arr1={1,4,6};
		int[] arr2={2,3,5,7};
		int[] newArray=new int[arr1.length+arr2.length];
		merge(arr1,arr2,newArray);
		for(int i=0;i<newArray.length;i++){
			System.out.print(newArray[i]+" ");
		}
		System.out.println("Median is: " +getMedian(newArray,0,arrSize));
		
	}
	
	
	public static double getMedian(int[] arr,int start, int arraySize){
		int N=arraySize-1;
		if(arraySize==0){
			return -1;
		}
		else if(arraySize%2==0){
			int mid1=randomizedSelect(arr,start,N,arraySize/2);
			int mid2=randomizedSelect(arr,start,N,(arraySize/2)+1);
			return (double)(mid1+mid2)/2;
		}
		else{
			return randomizedSelect(arr,start,N,arraySize/2);
		}
		
	}
	public static int randomizedPartition(int[] arr,int left, int right){
		if(left>right){
			return -1;
		}
		int pivotIndex=left +(int) (Math.random()*(right-left));
		int pivot=arr[pivotIndex];
		//swap the leftmost value in the array with the value at the pivotIndex
		swap(arr,left,pivotIndex);
		int leftScanIndex=left+1;
		int rightScanIndex=right;
		
		while(leftScanIndex<=rightScanIndex){
			while(leftScanIndex<=rightScanIndex && arr[leftScanIndex]<=arr[left]){
				leftScanIndex++;
			}
			
			while(leftScanIndex<=rightScanIndex && arr[rightScanIndex]>=arr[left]){
				rightScanIndex--;
			}
			
			if(leftScanIndex<rightScanIndex){
				swap(arr,leftScanIndex,rightScanIndex);
				leftScanIndex++;
				rightScanIndex--;
			}
		}
		//now we swap the pivot value which is at the leftmost position with rightScanIndex;
		swap(arr,left,rightScanIndex);
		//now we return the current position of the pivot which is at the rightScanIndex position
		return rightScanIndex;
	}
	
	public static int randomizedSelect(int[] myArr, int p, int r, int i){
		//base case: if we have just one value in the array, then return just that value
		if(p==r){
			return myArr[p];
		}
		int pivotIndex=randomizedPartition(myArr,p,r);
		int positionOfPivotIntermsOfSize=pivotIndex-p+1;
		if(positionOfPivotIntermsOfSize==i){
			//if this is the value we are looking for then we return it
			return myArr[pivotIndex];
		}
		else if(i<positionOfPivotIntermsOfSize){
			return randomizedSelect(myArr,p,pivotIndex-1,i);
			
		}
		else//now i is greater than positionOfPivotIntermsOfSize
			return randomizedSelect(myArr,pivotIndex+1,r,i-positionOfPivotIntermsOfSize);
		
	} 
	
	 public static void merge(int[] lefthalflist,int[] righthalflist,int[] mainlist)
	    {       
	            int i=0;
	            int j=0;
	            int k=0;
	            //if the righthalf completes its iteration
	            while(i<lefthalflist.length)
	            {
	                mainlist[k]=lefthalflist[i];
	                i=i+1;
	                k=k+1;
	            }
	            while(j<righthalflist.length)
	            {
	                mainlist[k]=righthalflist[j];
	                j=j+1;
	                k=k+1;
	            }
	       }
	
	private static void swap(int[] array, int left, int right){
		int temp=array[left];
		array[left]=array[right];
		array[right]=temp;
	}
}
