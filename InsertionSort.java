package com.algorithms;

public class InsertionSort 
{
	public static void main(String[] args) {
		int[] myList={3,5,2,7,9,8,6,5,0,13,12};		
		int[] ar={1,4,3,5,6,2};
		insertionSort(ar,ar.length);
		
		
		
		//insertIntoSorted(ar);
		/**
		for (int i=0;i<myList.length;i++)
		{
			System.out.println(myList[i]);
		}
		**/
		//System.out.println(myList.length +" Items");
	}
	
	public static void insertionSort(int[] list,int N)
	{
		//int length=list.length;
		int j=0;
		for(int i=1;i<N;i++)
		{
			j=i;
			while(j>0 && (list[j] < list[j-1]))
			{
				swap(list,j,j-1);
				//decrement j
				j--;
			}
			for(int k=0;k<list.length;k++){
	            System.out.print(list[k]+" ");
	        }
	        System.out.println();
			
		}
	}
	 public static void insertIntoSorted(int[] ar) {
	        int s=ar.length;
	        int j=s-1;
	        for(int i=0;i<s;i++){
                System.out.print(ar[i]+" ");
            }
	        System.out.println();
	        while(j>0 && (ar[j] < ar[j-1])){
	            swap(ar,j,j-1);
	            j--;//decrement j
	            for(int i=0;i<s;i++){
	                System.out.print(ar[i]+" ");
	            }
	            System.out.println();
	        }
	    }
	    
	
	public static void swap(int[] arr,int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;	
	}
}
