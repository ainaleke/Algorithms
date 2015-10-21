
public class QuickSort {
	private int compCount=0;
	
	public static void main(String[] args) {
		int left=0;
		long start, stop;
		long elapsedTime;
		double milliseconds;

		/********************Initialize all the arrays to be tested with******************************************/
		int[] reverseSortedArray32={32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] sortedArray32={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		
		
		/*********************************Create Objects for all sorting Scenarios********************************/
		QuickSort sortedArrayObject=new QuickSort();
		QuickSort reverseSortedArrayObject= new QuickSort();
		
		
		
		
		/*************************Sort Array of sorted Integers**************************************************/
		System.out.println("Sorted Array of 32 integers");
		for(int i=0;i<sortedArray32.length;i++)
		{
			System.out.print(sortedArray32[i]+" ");
		}
		//store the system start times
		start=System.nanoTime();
		//sort array using Merge Sort
		sortedArrayObject.qSort(sortedArray32,left,sortedArray32.length-1);
		//calculate elapsed time
		stop=System.nanoTime();
		elapsedTime=stop-start;
		milliseconds=(double)elapsedTime/1000000;
		System.out.println();
		System.out.println("COMPCOUNT : " + sortedArrayObject.getCompCount());
		System.out.print("Time Elapsed is: " +milliseconds + "milliseconds\n\n");

		/***************************Sort Array of Reverse Sorted Objects**********************************/
		System.out.println("Reversely Sorted List of 32 Integers");
		
		for(int i=0;i<reverseSortedArray32.length;i++)
		{
			System.out.print(reverseSortedArray32[i]+" ");
			
		}
		System.out.println("\nSorted Output");
		start=System.nanoTime();
		//sort reversely sorted Array
		reverseSortedArrayObject.qSort(reverseSortedArray32,left,reverseSortedArray32.length-1);
		stop=System.nanoTime();
		elapsedTime=stop-start;
		milliseconds=(double)elapsedTime/1000000;
		
		//Print Sorted Values
		for(int i=0;i<reverseSortedArray32.length;i++)
		{
			System.out.print(reverseSortedArray32[i]+" ");
			
		}
		System.out.println();
		System.out.println("COMPCOUNT : " + reverseSortedArrayObject.getCompCount());
		System.out.print("Time Elapsed is: " +milliseconds + "milliseconds\n\n");
		
		
	}
	private void qSort(int[] arr, int left, int right)
	{
		//first of all randomly pick an index.
		if(left>=right){
			return;
		}
		
		//randomly generate an index which is within the range of the array
		int k= left + (right - left) / 2;//good pivot
		
		int pivot=arr[k];//select pivot using the kth index
		
		swapMe(arr,left,k);//swap the pivot's index with the leftmost index.
		
		int leftScanIndex=left+1;//start from left+1 for left scan
		int rightScanIndex=right;
		
		//while both scan indices haven't intersected
		while(leftScanIndex<=rightScanIndex)
		{
			while(leftScanIndex<=rightScanIndex && arr[leftScanIndex]<=pivot)
			{
				leftScanIndex++;//keep moving with left Scan
				compCount++;
			}
			while(leftScanIndex<=rightScanIndex && arr[rightScanIndex]>=pivot)
			{
				rightScanIndex--;
				compCount++;
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
			qSort(arr,left,rightScanIndex-1);
			qSort(arr,rightScanIndex+1,right);
	}
	public void swapMe(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	private int getCompCount()
	{
		return compCount;
	}
}
