
public class JavaPassByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c=4;
		int d=9;
		c=c+d;
		d=c-d;//13-9=4
		c=c-d;//13-4=9
		System.out.println("C: "+c);
		System.out.println("D: "+d);

		Integer a=5;
		Integer b=6;
		swap(a,b);
		
		int x=50;
		x=change(x);
		System.out.println("X is:"+x);
		
		
		System.out.println("a: "+a);
		System.out.println("b: "+b);
	}
	public static void swap(Integer a, Integer b){
		Integer temp=a;
		a=b;
		b=temp;
		
	}
	static int change(int val){
		val=val * 2;
		return val;
	}

}
