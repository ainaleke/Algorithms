
public class MoveZeroes {

	public static void main(String[] args) {
		int[] myarray1={0,2,0,3,0};
		int[] myarray={0, 0, 0, 3, 6, 9, 7, 0, 8, 5, 0, 11, 12,0, 13,20,5,0,1};
		moveZeroes(myarray);
		for(int i=0;i<myarray.length;i++)
		{
			System.out.print(myarray[i]+" ");
		}
		
		

	}
	
	   public static void moveZeroes(int[] nums) 
	   {
	        int j=0;
	        for(int i=0;i<nums.length;i++)
	        {
	        	if(nums[i]==0)
	        	{
	        		j=i+1;
	        		//check for a non zero value
	        		while(j<nums.length)
	        		{
	        			if(nums[j]==0)
	        			{
	        				j++;
	        			}
	        			else
	        			{
	        				swap(nums, i, j);
	        				break;
	        			}
	        		}   
	        	}
	        }
	    }
	   
	    private static void swap(int[] arr, int i, int j)
	    {
	        int temp;
	        temp=arr[i];
	        arr[i]=arr[j];
	        arr[j]=temp;
	    }

}
