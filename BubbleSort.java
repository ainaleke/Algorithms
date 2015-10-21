package com.algorithms;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray={10,9,8,7,6,5,4,3,2,1};
		//recursiveBubbleSort(myArray,myArray.length);
		sort(myArray,myArray.length);
		//recursiveBubbleSort(myArray,myArray.length);
	
			//System.out.println(Arrays.toString(recursiveBubbleSort(myArray,myArray.length)));
		for(int i=0; i<myArray.length;i++)
		{
			System.out.println(myArray[i]);
		}
		
	}
	
	public  static void sort(int[] list, int N)
	{
		int i,j;
		int k = 0;
		for(i=N-1;i>0;i--)
		{
		
			for(j=0;j<i;j++)
			{
				if(list[j]>list[j+1])
				{
					int temp=list[j];
					list[j]=list[j+1];
					list[j+1]=temp;
					k++;
					
				}
			}
			
		}
		
		System.out.println(k + " times");
		
	}
	public static void recursiveBubbleSort(int[] A,int N)
	{
		int temp;
		if(N==1)
		{
			 return;
		}
		recursiveBubbleSort(A,N-1);
		for(int i=0; i<N-1;i++)
		{
			if(A[i]>A[i+1])
			{
				temp=A[i];
				A[i]=A[i+1];
				A[i+1]=temp;
			}
		}
	   
		
	}
	
	public static void swap(int j,int k)
	{
		int temp=k;
		k=j;
		j=temp;
	}
	

}
