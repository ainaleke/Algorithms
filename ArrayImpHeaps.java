import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Array implementation of a Max Heap.
public class ArrayImpHeaps {
	int size=0;
	int capacity=10;
	private int[] arr=new int[capacity];
	
	public int getLeftChildIndex(int index){
		return (2 * index +1);
	}
	public int getRightChildIndex(int index){
		return (2*index +2);
	}
	public int getParentIndex(int childIndex){
		return ((childIndex-1)/2);
	}
	public boolean hasLeftChild(int index){
		int leftIndex=getLeftChildIndex(index);
		return leftIndex<size;
	}
	public boolean hasRightChild(int index){
		int rightIndex=getRightChildIndex(index);
		return rightIndex<size;
	}
	public boolean hasParent(int childIndex){
		return getParentIndex(childIndex)>=0;
	}
	public void ensureCapacity(){
		if(size==capacity){
			capacity*=2;
			arr=Arrays.copyOf(arr, capacity);
		}
	}
	
	public void add(int value){
		//first ensure capacity of array
		ensureCapacity();
		arr[size]=value;
		size++;
		heapify();
	}
	
	public void heapify(){
		int index=size-1;
		int parentIndex=getParentIndex(size-1);
		while(hasParent(index) && arr[parentIndex]< arr[index]){
			swap(arr,getParentIndex(index), index);
			index=parentIndex;//getParentIndex(index);
			parentIndex=getParentIndex(index);
		}
	}
	public void printElements(){
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public void swap(int[] arr,int index1, int index2){
		int tempval=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=tempval;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayImpHeaps myHeap=new ArrayImpHeaps();
		myHeap.add(1);
		myHeap.add(4);
		myHeap.add(2);
		myHeap.add(3);
		myHeap.add(9);
		myHeap.add(7);
		myHeap.add(8);
		myHeap.add(10);
		myHeap.add(14);
		myHeap.add(16);
		myHeap.add(5);
		myHeap.add(18);
		myHeap.printElements();
		System.out.println();
		String mine="This is a string that \"will be\" \"highlighted when your regular\" expression matches something";
		Matcher match = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(mine);
		List<String> list=new ArrayList<>();
		while (match.find()){
		    list.add(match.group(1));
		}
		for(int i=0;i<list.size();i++){
			String unfold=null;
			if(list.get(i).charAt(0)=='"'){
				unfold=list.get(i).substring(1, list.get(i).length()-1);
				System.out.println(unfold);
			}
			else{
				System.out.println(list.get(i));
			}
		}
		
		

	}

}
