package calculator;

import fraction.Fraction;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Console interface:
		Fraction result;

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Instructions:");
		System.out.println("Example of usage: <100/2+( 5 * (( 5-1) + (5+1)) + 1  ) +1%2>");
		System.out.println("Output: 203/2");
		System.out.println("Supported operations: +, -, *, %");
		System.out.println("Enter <exit> to end program.\n");

		String str;
		for (;;) // implement checking of string?
		{
			System.out.print(">");
			str = in.nextLine(); // for all line (with spaces)

			if (str.equals("exit"))
				break;
			else {
				try {
					result = Calc.calculate(str);
					System.out.print("=");
					result.print();
				} catch (Exception e) {
					System.out.println("Error");
				}
			}
		}

	}

}
