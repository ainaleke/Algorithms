import java.util.ArrayList;

public class ReverseAnInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('-'-'0');	
	}
	
	
 public int reverse(int x) {
    //flag marks if x is negative
 	boolean flag = false;
 	if (x < 0) {
 		x = 0 - x;
 		flag = true;
 	}
 	int res = 0;
 	int p = x;
 	while (p > 0) {
 		int mod = p % 10;
 		p = p / 10;
 		res = res * 10 + mod;
 	}
 	if (flag) {
 		res = 0 - res;
 	} 
 	return res;
 }
    
 public int reverseIntMethod2(int x){
    boolean isNegative=false;
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    int result=0;
    int index=0;
    if(x<0){
        isNegative=true;
        x=Math.abs(x);
    }
    while(x>0){
       int remainder=x%10;
       result=result*10 + remainder;
       x/=10;
    }
        
    if(isNegative){
        result*=-1;
    }
    return result; 
    }
}
