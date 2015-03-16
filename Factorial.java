package MyPractice;

import java.util.Scanner;

public class Factorial {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    int numberFactorial;
		
		System.out.println("This Program Calculates the Factorial for a Number");
		
		Scanner input= new Scanner(System.in); //Receive input from the Keyboard
		
		System.out.print("Please Enter the Value: ");
		numberFactorial= input.nextInt(); //read the value of the number entered
		//Compute the Factorial using the Factorial Method
		
		computeFactorial(numberFactorial);
		//System.out.println("The computed value for the Factorial is: " + );
	}

	public static void computeFactorial(int number) throws ArithmeticException {
		int result=1;
		
		if (number < 0){
			throw new ArithmeticException();
		}
		else if(number == 0){
			System.out.println("The Value of the Factorial of zero is:" +1);
		}
		else
		{
			for(int i=1; i<=number; i++)
			{
				result= result * i;
			}
			System.out.println(result);
	  }
	}

}
