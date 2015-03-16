package HelloWorldPackage;

public class MergeSort {
	
	public static void mergeSort(int[] list)
	{
		if(list.length > 1)
		{//merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2); //copy elements from the source-list array to the firstHalf Array
			mergeSort(firstHalf);
			
			//initialize the second
			int secondHalfLength = list.length - list.length/2; //length of second array
			int[] secondHalf = new int[secondHalfLength];
			
			//copy elements into the second array
			System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			//merge both arrays
			merge(firstHalf,secondHalf,list);
		}
		
			
	}
	public static void merge(int[] firstHalfArray, int[] secondHalfArray, int[] temp)
	{
		int current1=0;//current index in list1
		int current2=0;//current index in list2
		int current3=0;//current index in temp
		
		while(current1 < firstHalfArray.length && current2 < secondHalfArray.length)
		{
			if(firstHalfArray[current1] < secondHalfArray[current2])
				temp[current3++]=firstHalfArray[current1++];
			else
				temp[current3++]=secondHalfArray[current2++];
		}
		while(current1 < firstHalfArray.length)
			temp[current3++]=firstHalfArray[current1++];
		
		while(current2< secondHalfArray.length)
			temp[current3++]=secondHalfArray[current2++];
	}
	public static void main(String[] args) {
		long start,stop;
		int[] list= {2,3,2,5,6,1,-2,3,14,12,23,1,4,9,7,3,5,8,2,9};
		start=System.nanoTime();
		
		mergeSort(list);
		
		stop=System.nanoTime();
		System.out.println("Sorted List is: ");
		for(int i=0; i<list.length; i++)
		{
			System.out.print(list[i] +", ");
		}
		
		long elapsedTime=stop-start;
		double milliseconds=(double)elapsedTime/1000000;
		System.out.print("Time Elapsed is: " +milliseconds +"\n milliseconds");

	}

}
