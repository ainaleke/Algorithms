

public class HeapSort {
	
	private  int compCount=0;
	public static void main(String[] args) {
		long start, stop;
		long elapsedTime;
		double milliseconds;
		
		/********************Initialize all the arrays to be tested with******************************************/
		int[] reverseSortedArray32={32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] sortedArray32={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		
		HeapSort sortedArrayObject=new HeapSort();
		
		/*************************Sort Array of sorted Integers**************************************************/
		System.out.println("Sorted Array of 32 integers");
		for(int i=0;i<sortedArray32.length;i++)
		{
			System.out.print(sortedArray32[i]+" ");
		}
		//store the system start times
		start=System.nanoTime();
		//sort array using Merge Sort
		sortedArrayObject.buildHeap(sortedArray32,sortedArray32.length-1);
		//calculate elapsed time
		stop=System.nanoTime();
		elapsedTime=stop-start;
		milliseconds=(double)elapsedTime/1000000;
		System.out.println();
		System.out.println("Number of Key Comparisons for Sorted Array of Size 32 : " + sortedArrayObject.getCompCount());
		System.out.print("Time Elapsed is: " +milliseconds + "milliseconds\n\n");

	public void buildHeap(int[] arr, int N)
	{
		//if(N==0)
			//return;
		//start from the lowest subtree which is found on the N/2 node
		for(int i=N/2;i>=0;i--)
		{
			pushDown(arr,i,N);
		}		
		//once down with building the heap and pushing down, then, swap the Last component with the first component, 
		//and decrement the length we will traverse in the array, leaving the largest value which was swapped at the end of the array
		//once swapped, make a recursive call to continue with decremented array;	
		for (int i = N; i >= 0; i--)
        {
            swap(arr,0, i);//swap the first and the last node-starting from N-the last node
            N = N-1;
            pushDown(arr, 0,N);
            //buildHeap(arr,N);
        }
        
	}
	public  void pushDown(int arr[],int root, int N){
		int s=root;//index root of the heap being represented in the array
		
		int left=2*root; //index left child
		
		int right=(2*root)+1; //index right child
		
		if(left>N)//if node is a leaf i.e has no child
			return;
		
		if(left==N||arr[left]>arr[right]){//if only left child exists or the Left child is greater than the right child
			s=left;
				compCount++;

		}
		
		else{ //if Left and right child are equal or the right child is greater than the left child. 
			s=right;
			compCount++;
		}
		
		if(arr[s]>arr[root])//if the larger of both children 
		{
			compCount++;
			swap(arr,s,root);
			pushDown(arr,s,N);
		}	
	}
	public  void swap(int[] arraySwap,int i, int j)
	{
		int temp=arraySwap[i];
		arraySwap[i]=arraySwap[j];
		arraySwap[j]=temp;
	}
	private int getCompCount()
	{
		return compCount;
	}
}
