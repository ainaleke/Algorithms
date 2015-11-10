
public class Select1 {
	private int compCount=0;
	
	public static void main(String[] args) {

		/********************Initialize Arrays for randomly generated Integers to be tested with******************************************/
		int[] randomArray10000=new int[10000];
        int[] randomArray1HundThousand=new int[100000];
        int[] randomArray1Million=new int[1000000];
		
		/*********************************Create Objects for all sorting Scenarios********************************/
		Select1 randomArrayObject10000=new Select1();
		Select1 randomArrayObject1HundThousand= new Select1();
		Select1 randomArrayObject1Million= new Select1();
	
        
        /************************************Initialize integers for randomly generated array 10000**************************************************************/
        for(int i=0;i<randomArray10000.length;i++)
		{
			randomArray10000[i]=(int) (Math.random()*1000);	
		}
        
        randomArrayObject10000.qSort(randomArray10000,0, randomArray10000.length-1);
        System.out.print("SELECT1: Number of Elements in Array = "+randomArray10000.length +"\nkth element at n/2: "+((randomArray10000.length/2)) +" A[k]: "+randomArray10000[randomArray10000.length/2]);
        System.out.println();
        System.out.println("Key Comparisons: "+randomArrayObject10000.getCompCount());
      
        /**************************Generate and initialize randomly generated integers of length 100000***********/
        for(int i=0;i<randomArray1HundThousand.length;i++)
		{
			randomArray1HundThousand[i]=(int) (Math.random()*10000);	
		}
        
        randomArrayObject1HundThousand.qSort(randomArray1HundThousand, 0, randomArray1HundThousand.length-1);
        System.out.print("\nSELECT1: Number of Elements in Array = "+randomArray1HundThousand.length +"\nkth element at n/2: "+((randomArray1HundThousand.length/2)) +" A[k]: "+randomArray1HundThousand[randomArray1HundThousand.length/2]);
        System.out.println();
        System.out.println("Key Comparisons: "+randomArrayObject1HundThousand.getCompCount());
        
        /************************Generate and initialize randomly generated integers of length 1000000****************/
        for(int i=0;i<randomArray1Million.length;i++)
		{
			randomArray1Million[i]=(int) (Math.random()*100000);	
		}
        randomArrayObject1Million.qSort(randomArray1Million, 0, randomArray1Million.length-1);
        System.out.print("\nSELECT1: Number of Elements in Array = "+randomArray1Million.length +"\nkth element at n/2: "+((randomArray1Million.length/2)) +" A[k]: "+randomArray1Million[randomArray1Million.length/2]);
        System.out.println();
        System.out.println("Key Comparisons: "+randomArrayObject1Million.getCompCount());
        
		
				
	}
	private void qSort(int[] arr, int left, int right)
	{
		//first of all randomly pick an index.
		if(left>=right){
			return;
		}
		
		//randomly generate an index which is within the range of the array
		int k= left + (int)(Math.random()*(right - left));//good pivot
		
		int pivot=arr[k];//select pivot using the kth index
		
		swapMe(arr,left,k);//swap the pivot's index with the leftmost index.
		
		int leftScanIndex=left+1;//start from left+1 for left scan
		int rightScanIndex=right;
		
		//while both scan indices haven't intersected
		while(leftScanIndex<=rightScanIndex)
		{
			while(leftScanIndex<=rightScanIndex && arr[leftScanIndex]<=arr[left])
			{
				leftScanIndex++;//keep moving with left Scan
				compCount++;
			}
			while(leftScanIndex<=rightScanIndex && arr[rightScanIndex]>=arr[left])
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
	private void swapMe(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	private int getCompCount()
	{
		return compCount;
	}
}
