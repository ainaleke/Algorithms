import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Character> map=new HashMap<Character, Character>();
		map.put('a','p');
		map.put('f', 'e');
		for(Map.Entry<Character, Character> entry : map.entrySet()){
			System.out.println(entry.getKey() +": "+entry.getValue());
		}
		System.out.println(map.containsKey('a'));
		System.out.println(map.get('f'));
		String mine="";
		mine=mine+'a'+'g';
		System.out.println(mine);
		

	}
	public static boolean isIsomorphic(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		if(s.length()==1 && t.length()==1){
			return true;
		}
		HashMap<Character, Character> map=new HashMap<Character, Character>();
		map.put(s.charAt(0),t.charAt(0));
		for(int i=1;i<s.length();i++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i),t.charAt(i));
			}
			//if it contains the key then 
			else{
				if(t.charAt(i)!=map.get(s.charAt(i))){
					return false;
				}
			}
		}
		return true;
	}

}
