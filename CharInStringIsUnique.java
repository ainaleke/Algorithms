
public class CharInStringIsUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUnique("oluwake"));
	}

	public static boolean isUnique(String str){
		char[] charArray=str.toCharArray();
		int[] letters=new int[256];
		for(int i=0;i<charArray.length;i++){
			int ascirep=0;
			ascirep=(int)charArray[i];//111
			++letters[ascirep];
			if(letters[ascirep]>1){
				return false;
			}
			
		}
		return true;
	}
}
