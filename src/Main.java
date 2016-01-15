import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Tests TODO delete
		Fraction f1 = new Fraction(8);
		
		System.out.println("Test1:");
		Fraction f2 = Calc.calculate("3 + 5");
		f2.print();
		
		
		System.out.println("Test2:");
		Fraction f3 = Calc.calculate("3 + 5 + 1");
		f3.print();
		
		System.out.println("Test3:");
		Fraction f4 = Calc.calculate("3 + 5 + 1 + 1 + 100");
		f4.print();
		
		System.out.println("Test4:");
		Fraction f5 = Calc.calculate("3 + 5 + 1 + 1+100+7"); //TODO MISTAKE! Fix it!
		f4.print();
		
		System.out.println("Test5:");
		Fraction f6 = Calc.calculate("3 + 50 + 1 + 1 + 100 + 1/2");
		f6.print(); //output: 311/2 //TODO rewrite class Fraction (badly output). Fix it!
		
		System.out.println("Test6:");
		Fraction f7 = Calc.calculate("1/2 + 1/2");
		f7.print(); //TODO Error! In class Calc because see next strings (commented). Fix it!
		/*
		//checking
		Fraction f8 = new Fraction(1,2);
		Fraction f9 = new Fraction(1,2);
		f8.addition(f9);
		f8.print();
		*/
		
		System.out.println("//----------------------------------------------------");
		
		
		//Console interface:
		Fraction result;
		
		System.out.println("┬───────────┬");
		System.out.println("│Calculator.│");
		System.out.println("│───────────│\n");

		Scanner in = new Scanner(System.in);
		System.out.println("\nInstructions:");
		System.out.println("Syntax: <5 + 3>, <100 + 10>, <1/2 + 1/2>, <1 + 1/2> (with spaces!)");
		System.out.println("Supported operations: +");
		System.out.println("Enter <exit> to end program.\n");
		
		String str;
		for (;;) // implement checking of string?
		{
			System.out.print(">");
			str = in.nextLine(); //for all line (with spaces)
						
			if (str.equals("exit"))
					break;
			else {				
				System.out.print("=");
				result = Calc.calculate(str);
				result.print();
			}
		}

	}

}
