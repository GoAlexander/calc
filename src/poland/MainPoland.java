package poland;

import fraction.Fraction;
import java.util.Scanner;

class MainPoland {

	public static void main(String[] args) {
		String str;
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

		for (;;) // implement checking of string?
		{
			System.out.print(">");
			str = in.nextLine(); // for all line (with spaces)

			if (str.equals("exit"))
				break;
			else {
				try {
					result = Poland.calculate(str);
					System.out.print("=");
					result.print();
				} catch (Exception e) {
					System.out.println("Error");
				}
			}
		}
	}

}
