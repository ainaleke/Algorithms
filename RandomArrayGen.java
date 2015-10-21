
public class RandomArrayGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] randomArray32768=new int[32768];
		for(int i=0;i<randomArray32768.length;i++)
		{
			if(i!=randomArray32768.length-1){
			randomArray32768[i]=(int) (Math.random()*100);
			System.out.print(randomArray32768[i]+",");
			}
			else
				System.out.print(randomArray32768[i]);
			
		}
		
	
	}

}
