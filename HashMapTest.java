import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<String,Integer>();
        

        map.put("A",99);
        map.put("B",66);
        map.put("C",67);
        map.put("D",78);
        map.put("E",101);
        map.put("F",28);

        System.out.println("unsorted map: "+map);
        sortMap(map);
        
        System.out.println('Z'-'A');
	}

	public static void sortMap(HashMap<String, Integer> map) {
		ValueComparator1 bvc =  new ValueComparator1(map);
        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
        sorted_map.putAll(map);

        //System.out.println("results: "+sorted_map);
        for(Map.Entry<String, Integer> maps:sorted_map.entrySet()){
			System.out.println(maps.getKey()+" 's tracks were played "+maps.getValue() +" times");
		}
	}

}
class ValueComparator1 implements Comparator<String> {

    Map<String, Integer> base;
    public ValueComparator1(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}