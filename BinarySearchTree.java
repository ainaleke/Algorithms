
public class BinarySearchTree {

}
class Node {
	Node leftNode;
	Node rightNode;
	int data;
	Node parent;
	
	//create a Node using a key node constructor
	public Node (int key){
		this.data=key;
		leftNode=null;
		rightNode=null;
		parent=null;
	}
	public Node(){
		
	}
	public void setLeft(Node leftNode){
		this.leftNode=leftNode;
		leftNode.parent=this;
	}
	public void setRight(Node rightNode){
		this.rightNode=rightNode;
		rightNode.parent=this;
	}
	public Node getLeftNode(){
		return this.leftNode;
	}
	public Node getRightNode(){
		return this.rightNode;
	}
	public void setKey(int key){
		this.data=key;
	}
	public int getKey(){
		return this.data;
	}
}
