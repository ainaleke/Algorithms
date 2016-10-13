import java.util.HashMap;

public class Trie2 {
	TrieNode root;
	public Trie2(){
		root=new TrieNode();
	}
	
	public void insert(String word){
		HashMap<Character,TrieNode> children=root.children;
		TrieNode newNode=null;
		for(int i=0;i<word.length();i++){
			char letter=word.charAt(i);
			//if we find that letter in the trie then we move the children pointer to that point.
			
			if(children.containsKey(letter)){
				newNode=children.get(letter);
			}else{
				newNode=new TrieNode(letter);//create a new trie Node ready to be inserted into the Trie
				children.put(letter, newNode);//insert it into the TrieNode, it will become a new suffix for our word.
			}
			children=newNode.children;
			
			if(i==word.length()-1){
				newNode.isLeaf=true; //terminate it to show we have reached the end of a word
			}
		}
	}
	public boolean search(String word){
		TrieNode trieNode=searchNode(word);
		return (trieNode!=null && trieNode.isLeaf)?true:false;
	}
	
	
	public TrieNode searchNode(String str){
		TrieNode newTrieNode=null;
		HashMap<Character, TrieNode> children=root.children;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(children.containsKey(c)){
				newTrieNode=children.get(c);
				children=newTrieNode.children;
			}else{
				return null;
			}
		}
		
		return newTrieNode;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie2 myTrie2=new Trie2();
		myTrie2.insert("mangoes");
		myTrie2.insert("apple");
		System.out.println(myTrie2.search("mangoes"));
	}
	

}
class TrieNode{
	
	HashMap<Character,TrieNode> children=new HashMap<Character, TrieNode>();
	char c;
	boolean isLeaf=false;
	
	TrieNode(){}
	
	TrieNode(char c){
		this.c=c;
	}
	
}