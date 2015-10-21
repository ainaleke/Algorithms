package com.algorithms;

public class RecursiveMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] newArray={3,4,2,1,3,10,12,15};
		
		System.out.println(max(newArray,newArray.length));
	}
	
	public static int max(int[] list, int N)
	{
		N=list.length;
		int temp;
		
		if (N==1)
		{
			return list[0];
		}
		
		else
		{
			temp=max(list,N-1);
			if(temp >= list[N-1])
			{
				return temp;
			}
			else 
				return list[N-1]; 
		}
	}

}
