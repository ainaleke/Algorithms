
public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,1,2};
		System.out.println(removeDuplicates(arr));

	}
	 public static int removeDuplicates(int[] arr) {
	        if(arr.length==1){
	            return 1;
	        }
	        int i=0; int count=0;
	        while(i<arr.length-1 && arr[i]<=arr[i+1]){
	            count++;
	            while(arr[i]==arr[i+1]){
	                int temp=arr[i+1];
	                int j=i+1;
	                while(j<arr.length-1){
	                    arr[j]=arr[j+1];
	                    j++;
	                }
	                arr[arr.length-1]=temp;
	            }
	            i++;
	        }
	        return count;
	    }
}
