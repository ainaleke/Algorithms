import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin2> {

		public void push(int value){
			int minVal=0;
			if(value==min()){
				minVal=value;
			}
			else{
				minVal=Math.min(value,min());
			}	
			super.push(new NodeWithMin2(value,minVal));
		}
		
		public int min(){
			if(super.isEmpty()){
				return Integer.MAX_VALUE;
			}
			
			NodeWithMin2 top=super.peek(); //this refers to the Stack
			return top.min;	
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			StackWithMin myStackWithMin=new StackWithMin();
			myStackWithMin.push(5);
			myStackWithMin.push(7);
			myStackWithMin.push(9);
			
			
			System.out.println(myStackWithMin.min());
			myStackWithMin.pop();
			System.out.println(myStackWithMin.min());
			myStackWithMin.push(1);
			System.out.println(myStackWithMin.min());
			
			
			
			
		}

	}
	class NodeWithMin2{
		int value;
		int min;
		
		NodeWithMin2(int v, int minValue){
			this.value=v;
			this.min=minValue;
		}
	}

