import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Tests
		Fraction f1 = new Fraction(8);
		
		System.out.println("Test1:");
		Fraction f2 = A.calculate("3 + 5");
		f2.print();
		
		
		System.out.println("Test2:");
		Fraction f3 = A.calculate("3 + 5 + 1");
		f3.print();
		
		System.out.println("Test3:");
		Fraction f4 = A.calculate("3 + 5 + 1 + 1 + 100");
		f4.print();
		
		System.out.println("Test4:");
		Fraction f5 = A.calculate("3 + 5 + 1 + 1+100+7"); //TODO MISTAKE!
		f4.print();
		
		
		System.out.println("//----------------------------------------------------");
		
		
		//Console interface:
		Fraction result;
		
		System.out.println("┬───────────┬");
		System.out.println("│Calculator.│");
		System.out.println("│───────────│\n");

		Scanner in = new Scanner(System.in);
		System.out.println("\nInstructions:");
		System.out.println("Syntax: 5 + 3 (with spaces!)");
		System.out.println("Supported operations: +");
		System.out.println("Enter <exit> to end program.\n");
		
		//int menu = in.nextInt();

		String str;
		for (;;) // implement checking of string?
		{
			//System.out.print(">");
			//String str = new String((String) in.next());
			//str = in.next();
			System.out.print(">");
			str = in.nextLine();
			
			//str="5 + 3";
			
			if (str.equals("exit"))
					break;
			else {				
				System.out.print("=");
				result = A.calculate(str);
				result.print();
			}
		}

	}

}
