package MyPractice;

import java.util.Scanner;
public class AlphabeticSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numOfWords;
		Scanner scnObj = new Scanner(System.in);
		
		System.out.print("Enter the number of Words: \n");
		//read in the value of the words;
		numOfWords=scnObj.nextInt();
		
		
		System.out.printf("Enter " + numOfWords + " names: ");
		String[] name = new String[3]; //new array of strings
		String[] tname= new String[3];
		String temp = null; //temp value
		
		for (int i=0; i<name.length; i++) //iterate through the number of Words to be typed in
		{
			name[i]=scnObj.next(); //for each word that is typed in, fix it into the array of strings
			tname[i]=name[i]; //as each word is fixed into the first array, fix it into the second array
		}
		for(int i=0; i<numOfWords; i++)
		{
			for(int j=i+1; j<numOfWords; j++)
			{
				if
				(name[i].compareToIgnoreCase(name[j])>0)
				{
					temp=name[i];
					name[i]= name[j];
					name[j]=temp;
				}
			}
		}
		System.out.print("\n---------------------------------------------------------------------\n");
		System.out.print("Input Names\tSorted names\n");
		System.out.print("-------------------------------------------------------------------------\n");
		
		for(int i=0; i<numOfWords; i++)
		{
			System.out.print(tname[i] + "\t \t" + name[i] +"\n");
		}
		System.out.println("-------------------------------------------------------------------------\n");
		
	}//end of main method

}// end of class

