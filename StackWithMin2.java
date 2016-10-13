import java.util.Stack;

public class StackWithMin2 {
	
	Stack<NodeWithMin> stackMin=null;
	public StackWithMin2(){
		stackMin=new Stack<NodeWithMin>();
	}
	public void push(int value){
		int minVal=0;
		if(value==min()){
			minVal=value;
		}
		else{
			minVal=Math.min(value,min());
		}	
		stackMin.push(new NodeWithMin(value,minVal));
	}
	public NodeWithMin pop(){
		return stackMin.pop();
	}
	
	public int min(){
		if(stackMin.isEmpty()){
			return Integer.MAX_VALUE;
		}
		
		NodeWithMin top=stackMin.peek();
		return top.min;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin2 myStackWithMin=new StackWithMin2();
		myStackWithMin.push(3);
		myStackWithMin.push(7);
		myStackWithMin.push(9);
		
		
		System.out.println(myStackWithMin.min());
		myStackWithMin.pop();
		System.out.println(myStackWithMin.min());
		myStackWithMin.push(1);
		System.out.println(myStackWithMin.min());
		
		
		
		
	}

}
class NodeWithMin{
	int value;
	int min;
	
	NodeWithMin(int v, int minValue){
		this.value=v;
		this.min=minValue;
	}
}