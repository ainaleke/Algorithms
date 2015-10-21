package com.algorithms;

public class MergeSort {

	private int compCount=0;
	
	public MergeSort(){}
	
	public int getCompCount()
	{
		return compCount;
	}
	
	public static void main(String[] args) 
	{
		long start, stop;
		long elapsedTime;
		double milliseconds;
		
		/********************Initialize all the arrays to be tested with*********************************/
		int[] reverselySortedArray32={32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] sortedArray32={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		int[] randomArray32=new int[32];
		int[] randomArray1024=new int[1024];
		int[] randomArray32768=new int[32768];
		
		/*********Randomly Generate values for all the Random Arrays*******************************************/
		for(int i=0;i<randomArray32.length;i++)
		{
			randomArray32[i]=(int) (Math.random()*100);
		}
		
		for(int i=0;i<randomArray1024.length;i++)
		{
			randomArray1024[i]=(int)(Math.random()*10);
		}
		
		for(int i=0;i<randomArray32768.length;i++)
		{
			randomArray32768[i]=(int) (Math.random()*100);
		}
		
		/******************Create the Objects for each Array Size Data Test**********************************/
		MergeSort sortedArrayObject=new MergeSort();
		MergeSort reverseSortedArrayObject= new MergeSort();
		MergeSort randomArrayObject32= new MergeSort();
		MergeSort randomArrayObject1024= new MergeSort();
		MergeSort randomArrayObject32768= new MergeSort();
		
		
		
		
		/*************************Sort Array of sorted Integers**************************************/
		
		System.out.println("Sorted Array of 32 integers");
		for(int i=0;i<sortedArray32.length;i++)
		{
			System.out.print(sortedArray32[i]+" ");
		}
		
		//store the system start times
		start=System.nanoTime();
		//sort array using Merge Sort
		sortedArrayObject.mergesort(sortedArray32);
		//calculate elapsed time
		stop=System.nanoTime();
		elapsedTime=stop-start;
		milliseconds=(double)elapsedTime/1000000;
		System.out.println();
		System.out.println("Number of Key Comparisons for Sorted Array of Size 32 : " + sortedArrayObject.getCompCount());
		System.out.print("Time Elapsed is: " +milliseconds + "milliseconds");

		/***************************Sort Array of Reverse Sorted Objects**********************************/
		
		
		start=System.nanoTime();
		reverseSortedArrayObject.mergesort(sortedArray32);
		stop=System.nanoTime();
		System.out.println("Reversely Sorted List");
		
		
		start=System.nanoTime();
		sortedArrayObject.mergesort(sortedArray32);
		stop=System.nanoTime();
		elapsedTime=stop-start;
		milliseconds=(double)elapsedTime/1000000;
		
		System.out.println("\n Number of Key Comparisons for Sorted Array of Size 32 : " + sortedArrayObject.getCompCount());
		System.out.print("Time Elapsed is: " +milliseconds + "milliseconds");
		/****************************************************************/
		
		/**
		int[] randomArray=new int[32];
		for(int i=0;i<randomArray.length;i++)
		{
			randomArray[i]=(int) (Math.random()*1000);
		}
		**/
		
		
		
		/**
		
		System.out.println("For a Random Generated array of Size 2^10=1024");
		int[] mylist=new int[1024];
		for(int i=0;i<mylist.length;i++)
		{
			mylist[i]=(int) (Math.random()*1000);
		}
		
		**/
		
		System.out.println();
		/**
		for(int i=0;i<mylist.length;i++)
		{
			if(i!=mylist.length-1)
			{
				System.out.print(mylist[i]+", ");
			}
			else
				System.out.print(mylist[i]);
		}
		System.out.println("\n Number of Key Comparisons : " +compCountSorted32);
		System.out.print("Time Elapsed is: " +milliseconds + "milliseconds");
		**/
	}
	
	public void mergesort(int[] list)
	{
		int length=list.length;
		int lefthalfNumber=length/2;
		//int righthalfNumber=(length-(lefthalfNumber/2));
		int [] lefthalf = new int[lefthalfNumber];
		int[] righthalf=new int[length-lefthalfNumber];
		int leftcount=0; 
		int rightcount=0;
		if(length>1)
		{
			
			for(int i=0;i<lefthalfNumber;i++)
			{
				
				lefthalf[leftcount]=list[i];
				leftcount++;
				//System.out.println(lefthalf[i]);
			}
			
			for(int i=lefthalfNumber;i<length;i++)
			{
				righthalf[rightcount]=list[i];
				//System.out.println(righthalf[count]);
				rightcount++;
			}
			
			mergesort(lefthalf);//keep splitting the array elements while the number of elements in the array is greater than one
			mergesort(righthalf);//keep splitting the array elements while the number of element in the array is greater than one
			
			
			//now merge them together by comparing and contrasting and placing them into the final list
			merge(lefthalf,righthalf,list);
		}
	 }//end mergesort method
	public  void merge(int[] lefthalflist,int[] righthalflist,int[] mainlist)
	{		
			int i=0;
			int j=0;
			int k=0;
			
			while(i<lefthalflist.length && j<righthalflist.length)
			{
			
				if(lefthalflist[i]<righthalflist[j])
				{
					mainlist[k]=lefthalflist[i];
					//increment both i and k
					i=i+1;//advance index in lefthalf
					k=k+1;//advance index in main array
					compCount++;
					
				}
				else
				{
					mainlist[k]=righthalflist[j];
					j=j+1; //advance index in righthalf
					k=k+1; //advance index in main array
					compCount++;
					
				}
				
			}//end while
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
	
	}

