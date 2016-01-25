import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Console interface:
		Fraction result;

		/*
		 * System.out.println("┬───────────┬");
		 * System.out.println("│Calculator.│");
		 * System.out.println("│───────────│");
		 */

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Instructions:");
		System.out.println("Example of usage: <50+( 5 * (( 5-1) + (5+1)) + 1  ) +1/2>");
		System.out.println("Output: 203/2");
		System.out.println("Supported operations: +, -, *, /");
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
				try {
					result = Calc.calculate(str);
					result.print();
				} catch (Exception e) {
					System.out.println("Error");
				}
			}
		}

	}

}
