import java.util.LinkedList;
public class MoveAverage {
	int size=0;
	LinkedList moveAverageList;
	int counter=0;
	int sum=0;
	public static void main(String[] args) {
		 MoveAverage newMoveAverage=new MoveAverage(3);
		    System.out.println(newMoveAverage.next(1));
		    System.out.println(newMoveAverage.next(3));
		    System.out.println(newMoveAverage.next(10));
		    System.out.println(newMoveAverage.next(10));
		    System.out.println(newMoveAverage.next(10));
	}

	public MoveAverage(int size){
		this.size=size;
		moveAverageList=new LinkedList();
	}
	public double next(int val){
			counter++;
			double average=0.0;
			if(counter<=size){
					moveAverageList.offer(val);
					sum+=val;
					average= sum/counter;
			}
			else if(counter>size){
				int remove=(int) moveAverageList.poll();
				moveAverageList.offer(val);
				sum-=remove;
				sum+=val;
				average= sum/size;
			}
			return average;
		}


}
