import java.util.ArrayList;
import java.util.Arrays;

public class PermutateCoinsToGivenAmt {

    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int sum = 0;
        for (int x: partial){ 
        	sum += x;
        }
        if (sum == target){
             System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
             return;
        }
        if (sum > target){
             return;
        }
        for(int i=0;i<numbers.size();i++) {
              ArrayList<Integer> remaining = new ArrayList<Integer>();
              int num = numbers.get(i);
              for (int j=i+1; j<numbers.size();j++) {
            	  remaining.add(numbers.get(j));
              }
              ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
              partial_rec.add(num);
              sum_up_recursive(remaining,target,partial_rec);
        }
     }
    
     static void sum_up(ArrayList<Integer> numbers, int target) {
         sum_up_recursive(numbers,target,new ArrayList<Integer>());
     }
     
     public static void main(String args[]) {
         Integer[] numbers = {3,9,8,4,5,7,10,3,1};
         int target = 16;
         sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
         
         
         System.out.println("\n\n");
//         ArrayList<Integer> partial = new ArrayList<Integer>();
//         
//         partial.add(1);
//         partial.add(2);
//         partial.add(3);
//         ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
//         System.out.println(partial_rec);
         //String libe=1;
         
     }

}
