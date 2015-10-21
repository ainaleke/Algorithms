package com.algorithms;

public class MinMax {
	static int min1;
	static int max1;
	static int max=0;
	static int min=0;
	
	public static void main(String[] args) {
		int[] listArray={3,5,7,2,1,9,4,12,15};
		
		minMax(listArray,0,listArray.length,max,min);
		
		System.out.println("Max is "+max);
		System.out.println("Min is " +min);

	}

	public static void minMax(int[] A,int start,int N,int max,int min)
	{
		if(start==N)
		{
			max=min=A[0];
		}
		if(start==N-1)
		{
			if(A[0]>A[1])
			{
				max=A[0];
				min=A[1];
			}
			else
			{
				min=A[0];
				max=A[1];
			}
		}//end second if
		else
		{
			int mid=N/2;
			minMax(A,start,mid,max1,min1); //N/2
			minMax(A,mid+1,N-N/2,max,min);//N/2
			if(max1>max) //1
				max=max1;
			if(min1 < min)
				min=min1;
		}
	}
}
