import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Console interface:
		Fraction result;

		System.out.println("┬───────────┬");
		System.out.println("│Calculator.│");
		System.out.println("│───────────│");

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Instructions:");
		System.out.println("Syntax: <5 + 3>, <100 + 10>, <1/2 + 1/2>, <1 + 1/2> (with spaces!)");
		System.out.println("Supported operations: +");
		System.out.println("Enter <exit> to end program.\n");

		String str;
		for (;;) // implement checking of string?
		{
			System.out.print(">");
			str = in.nextLine(); // for all line (with spaces)

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
