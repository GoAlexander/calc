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
		Fraction f5 = Calc.calculate("3 + 5 + 1 + 1+100+7"); //TODO MISTAKE!
		f4.print();
		System.out.println("//----------------------------------------------------");
		
		
		//Console interface:
		Fraction result;
		
		System.out.println("┬───────────┬");
		System.out.println("│Calculator.│");
		System.out.println("│───────────│\n");

		Scanner in = new Scanner(System.in);
		System.out.println("\nInstructions:");
		System.out.println("Syntax: <5 + 3>, <100 + 10> (with spaces!)");
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
