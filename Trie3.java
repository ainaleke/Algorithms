import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Trie3 {
	char c;
	Trie3[] children;//=new Trie[26];;
	boolean isLeaf;
	
	public Trie3(char c){
		this.c=c;
		this.children=new Trie3[26];
		this.isLeaf=false;
	}
	public Trie3(){
		//this.c;
		this.children=new Trie3[26];
		this.isLeaf=false;
	}

	public void add2(String word) {
		if(word.isEmpty()){
			this.isLeaf=true;
			return;
		}

		char letter=word.charAt(0);
		int index=letter - 'a';

		if(this.children[index]==null){
			this.children[index]=new Trie3(letter);
			//this.children[index].c=letter;
		}
		this.children[index].add(word.substring(1));
	}
	public void add(String word) {
		Trie3 node=this;
		for(int i=0;i<word.length();i++)
		{
			char letter=word.charAt(i);
			int index=letter - 'a';
			if(node.children[index]==null){
				node.children[index]=new Trie3(letter);
				//this.children[index].c=letter;
			}
			node=node.children[index];
			if(i==word.length()-1){
				node.isLeaf=true;
			}
		}
	}

	public boolean isWords(String s) {
		if(s.isEmpty()) {
			return this.isLeaf;
		}
		int index = s.charAt(0) - 'a';
		if(this.children[index] == null) {
			return false;
		}
		return this.children[index].isWords(s.substring(1));
	}
	public boolean hasWord(String s) {
		if(s.isEmpty()) {
			return true;
		}
		int index = s.charAt(0) - 'a';
		if(this.children[index] == null) {
			return false;
		}
		return this.children[index].hasWord(s.substring(1));
	}

	public void words(List<String> w, Stack<Character> st) {
		if(c != 0)
			st.push(c);
		if(isLeaf) {
			StringBuilder s = new StringBuilder();
			for(char character : st) {
				s.append(character);
			}
			w.add(s.toString());
		}
		for(int i = 0; i < 26; i++) {
			if(children[i] != null) {
				children[i].words(w, st);
			}
		}
		if(!st.isEmpty())
			st.pop();
	}

	public List<String> words() {
		List<String> w = new LinkedList<>();
		Stack<Character> st = new Stack<>();
		words(w, st);
		return w;
	}
	
	public boolean hasPrefix(String prefix){
		Trie3 node=this;
		for(int i=0; i<prefix.length();i++){
			int index = prefix.charAt(i)-'a';
			Trie3 child=node.children[index];
			if(child==null){
				return false;
			}
			node=child;
		}
		return true;
	}
	
	public void printPrefixes(String prefix){
		Trie3 node=this;
		for(int i=0; i<prefix.length();i++){
			int index = prefix.charAt(i)-'a';
			Trie3 child=node.children[index];
			if(child==null){
				return ;
			}
			node=child;
		}
		for(int i=0;i<node.children.length;i++){
			if(node.children[i]!=null){
				System.out.println(node.children[i].c);
			}
		}
		//return node.children;
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie3 ob = new Trie3();
		ob.add("trie");
		ob.add("try");
		ob.add("apples");
		ob.add("mangoes");
		ob.add("tango");
		ob.add("train");
		//System.out.println((char)(1+97));
		System.out.println(ob.words());
		System.out.println(ob.isWords("trie"));
		System.out.println(ob.hasPrefix("tri"));
		//System.out.println(ob.hasWord("tangl"));
		ob.printPrefixes("tr");
	}

}
