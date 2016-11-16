import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] list = new int[][] {{},{1, 2}, {3}, {}, {4,5,6}, {},{},{7,8,9}};
	  ArrayIterator iterator=new ArrayIterator(list);
	  iterator.remove();
	  while(iterator.hasNext()){
		  System.out.println(iterator.next());
	  }
	}
}
class ArrayIterator {
	
	private int[][] list;
	private int counter=0;
	int pos=-1;
	List<Integer> queue=new ArrayList<>();
	
	public ArrayIterator(int[][] list) {
		this.list=list;
		fillList(this.list);
	}
	
	public  boolean hasNext() 
	{   int currPos=pos;
		return ++currPos<queue.size();
	}

	public void fillList(int[][] list2) {
		while(counter<list.length){
			if(list[counter].length==0){
				counter++;
				continue;
			}
			for(int i=0;i<list[counter].length;i++){
				queue.add(list[counter][i]);
			}
			counter++;
		}
	}
	
	public int next(){
		if(hasNext()){
			pos++;
			return queue.get(pos);
		}
		return (Integer) null;
	}
	public void remove(){
		if(queue.size()>0){
			queue.remove(0);
		}
	}
}
