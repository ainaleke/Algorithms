import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RandomSelect {

    public static void main(String[] args) {
        
        int[] ar={1,3,7,4,6,5,8,5,9};
        int n=ar.length-1;
        int pivotIndex=ar[0]+(int)(Math.random()*(ar[n]-ar[0]));
        int mid=(ar.length+1)/2;
        System.out.println(randomizedSelect(ar,0,n,3));
        //System.out.println(pivotIndex);
       randomizedPartition(ar,0,n);
       for(int i=0;i<ar.length;i++)
       {
    	   System.out.print(ar[i]+" ");
       }
    }
    private static int randomizedPartition(int[] arr, int left, int right)
	{
		//first of all randomly pick an index.
		if(left>=right){
			return -1;
		}
		
		//randomly generate an index which is within the range of the array
		int k= left + (int)(Math.random()*(right - left));//good pivot
		
		//int pivot=arr[k];//select pivot using the kth index
		
		swapMe(arr,left,k);//swap the pivot's index with the leftmost index.
		
		int leftScanIndex=left+1;//start from left+1 for left scan
		int rightScanIndex=right;
		
		//while both scan indices haven't intersected
		while(leftScanIndex<=rightScanIndex)
		{
			while(leftScanIndex<=rightScanIndex && arr[leftScanIndex]<=arr[left])
			{
				leftScanIndex++;//keep moving with left Scan
				
			}
			while(leftScanIndex<=rightScanIndex && arr[rightScanIndex]>=arr[left])
			{
				rightScanIndex--;
				
			}
			//once both scans have found values to be swapped. check if the left scan index is lesser than the rightscan index 
			if(leftScanIndex<rightScanIndex)
			{
				swapMe(arr, leftScanIndex, rightScanIndex);
				leftScanIndex++;//increment leftScanIndex 
				rightScanIndex--;//decrement rightScanIndex
			}
		}
		swapMe(arr, left, rightScanIndex);
		return rightScanIndex;
		
	}
    public static int randomizedSelect(int[] myArray , int p,int r,int i){//i is the ith position of the array, we know median exists at the N+1/2 position
        if(p==r)
            return myArray[p];
        
        int q=randomizedPartition(myArray,p,r); //get the index of the randomly picked pivot
        
        //Now Array is partitioned into the for:  myArray[p,q-1] and myArray[q+1,r] 
        
        int k=q-p+1;//get the kth position of the pivot i.e myArray[p,q]
        
        if(i==k)
            return myArray[q];//if the ith position equals the kth position of pivot then we have found the ith greatest element
        
        else if(i<k)
            return randomizedSelect(myArray,p,q-1,i);
            
        else
            return randomizedSelect(myArray,q+1,r,i-k);
    }
    
    private static void swapMe(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
