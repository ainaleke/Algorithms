
public class Select2 {
	private int compCount=0;
	
    public static void main(String[] args) 
    {
        int[] ar={3,1,3,1,5,7,9,8,4,6,5,8,6,8,7,5,9,4,8,7,9,11,10,5,4,3,11,10,11,10};
        int n=ar.length;
        //Algorithm X: number or elements in Array, kth element at n/2, A[k] and value, Number of Key-Comparisons
        /***********************************Arrays for Randomly Generated Integers******************************************************************/
        
        int[] randomArray10000=new int[10000];
        int[] randomArray100000=new int[100000];
        int[] randomArray1Million=new int[1000000];
        /**********************************************************************************************************/
        
        Select2 randomArrayObject10000=new Select2();
        Select2 randomArrayObject100000=new Select2();
        Select2 randomArrayObject1Million=new Select2();
        
        /************************************Initialize integers for randomly generated array 10000**************************************************************/
        for(int i=0;i<randomArray10000.length;i++)
		{
			randomArray10000[i]=(int) (Math.random()*1000);	
		}
        
        randomArrayObject10000.quickSelect2(randomArray10000, randomArray10000.length, randomArray10000.length/2);
        System.out.println("Key Comparisons: "+randomArrayObject10000.getCompCount()+"\n");
      
        /**************************Generate and initialize randomly generated integers of length 100000***********/
        for(int i=0;i<randomArray100000.length;i++)
		{
			randomArray100000[i]=(int) (Math.random()*10000);	
		}
        randomArrayObject100000.quickSelect2(randomArray100000, randomArray100000.length, randomArray100000.length/2);
        System.out.println("Key Comparisons: "+randomArrayObject100000.getCompCount()+"\n");
        
        /************************Generate and initialize randomly generated integers of length 1000000****************/
        for(int i=0;i<randomArray1Million.length;i++)
		{
			randomArray1Million[i]=(int) (Math.random()*10000);	
		}
        randomArrayObject1Million.quickSelect2(randomArray1Million, randomArray1Million.length, randomArray1Million.length/2);
        System.out.println("Key Comparisons: "+randomArrayObject1Million.getCompCount()+"\n");
        
        
    }

	public  void quickSelect2(int[] ar, int n,int k) {//k represents the kth element in the selection 
		if(n<25)
        {
        	insertionSort(ar,k);//as input elements the array and the kth element 
        }
        else
        {
        	int kthElement=select2(ar,0,n-1,k);
        	//System.out.println("Value of kth Element at n/2 is: "+kthElement);
        	System.out.print("SELECT2; Number of Elements in Array = "+ar.length +"\nkth element at n/2: "+((k)) +" A[k]: "+kthElement);
        	System.out.println();
        }
	}
    
    private int randomizedPartition(int[] arr, int left, int right)
	{
		//first of all randomly pick an index.
		if(left>=right){
			return -1;
		}
		
		//randomly generate an index which is within the range of the array
		int k= left + (int)(Math.random()*(right - left));//good pivot
		
		int pivot=arr[k];//select pivot using the kth index
		
		//System.out.println("Pivot is: " +pivot);
		
		swapMe(arr,left,k);//swap the pivot's index with the leftmost index.
		
		int leftScanIndex=left+1;//start from left+1 for left scan
		int rightScanIndex=right;
		
		//while both scan indices haven't intersected
		while(leftScanIndex<=rightScanIndex)
		{
			
			while(leftScanIndex<=rightScanIndex && arr[leftScanIndex]<=arr[left])
			{
				incrementCompCount();
				leftScanIndex++;//keep moving with left Scan
				
			}
			while(leftScanIndex<=rightScanIndex && arr[rightScanIndex]>arr[left])
			{
				incrementCompCount();
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
		pivot=arr[rightScanIndex];
		
		int equalToPivotIndex=rightScanIndex-1;
		int seeker=left;
	
		while(seeker<=equalToPivotIndex)
		{
			if(arr[seeker]==pivot && arr[equalToPivotIndex]==pivot)
			{
				incrementCompCount();
				equalToPivotIndex--;
			}
			else if(arr[seeker]==pivot && arr[equalToPivotIndex]!=pivot)
			{
				incrementCompCount();
				swapMe(arr, seeker, equalToPivotIndex);
				equalToPivotIndex--;
				seeker++;
			}
			else if(arr[seeker]!=pivot && arr[equalToPivotIndex]==pivot)
			{
				incrementCompCount();
				seeker++;
				equalToPivotIndex--;
			}
			else
			{
				incrementCompCount();
				seeker++;
			}
		}
		
		return rightScanIndex;
	}

	public int incrementCompCount() {
		return compCount++;
	}
    
    public  int select2(int[] myArray , int p,int r,int i){//i is the ith position of the array, we know median exists at the N+1/2 position
        if(p==r)
            return myArray[p];
        
        int q=randomizedPartition(myArray,p,r); //get the index of the randomly picked pivot
        
        //Now Array is partitioned into the for:  myArray[p,q-1] and myArray[q+1,r] 
        
        int k=q-p+1;//get the kth position of the pivot i.e myArray[p,q]
        
        if(i==k)
            return myArray[q];//if the ith position equals the kth position of pivot then we have found the ith greatest element
        
        else if(i<k)
            return select2(myArray,p,q-1,i);
            
        else
            return select2(myArray,q+1,r,i-k);
    }
    private  void insertionSort(int[] list,int k)
	{
    	int N=list.length;
		//int length=list.length;
		int j=0;
		for(int i=1;i<N;i++)
		{
			j=i;
			while(j>0 && (list[j] < list[j-1]))
			{
				swapMe(list,j,j-1);
				j--;
			}  
		}
		System.out.println("Algorithm SELECT2; +N= "+list.length +"kth element at n/2: "+(k) +"A[k]: "+list[k]);
		
	}
    private int getCompCount()
	{
    	
		return compCount;
	}
    
    private void swapMe(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
