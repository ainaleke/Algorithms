import java.util.ArrayList;
import java.util.HashMap;

public class FindDistinctPairsEqualToADifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 5, 3, 4, 2};
		int[] arr={8, 12, 16, 4, 0, 20};
		System.out.println(getValuesWithADifference(arr,4));

	}
	public static ArrayList<Integer> getValuesWithADifference(int[] arr,int target){
		ArrayList<Integer> arrayList=new ArrayList<>();
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			hm.put(arr[i],i);
		}
		int countpairs=0;
		int difference=0;
		for(int i=0;i<arr.length;i++){
			if(hm.containsKey(arr[i]+target)){
				arrayList.add(arr[i]);
				arrayList.add(arr[i]+target);
				countpairs++;
			}
			else if( hm.containsKey(arr[i]-target)){
				arrayList.add(arr[i]);
				arrayList.add(arr[i]-target);
				countpairs++;
			}
			
		}
		return arrayList;
	}
}
