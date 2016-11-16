import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UseHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hm=new HashMap();
		
		hm.put("Oluwaleke", 29);
		hm.put("Adekemi",25);
		hm.put("Adetutu", 26);
		Set myHashSet=new HashSet();
		myHashSet.add("Oluwaleke");
		myHashSet.add("Adekemi");
		myHashSet.add(3);
		System.out.println(myHashSet);
		
		
		
		//Iterator iterator=hm.entrySet().iterator();
//		while(iterator.hasNext()){
			for(Map.Entry<String, Integer> entry : hm.entrySet()){
				System.out.println("Key is: "+ entry.getKey() +":: Value: "+entry.getValue() );
				
			
			}
			System.out.println(hm.get("Oluwaleke"));
		
		
		}
	
	

}
