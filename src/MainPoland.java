import java.util.Scanner;

public class MainPoland extends Main {

	public static void main(String[] args) {
		String str;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Fraction result;

		// TODO make this menu similar as in Main.java
		for (;;) // implement checking of string?
		{
			System.out.print(">");
			str = in.nextLine(); // for all line (with spaces)

			if (str.equals("exit"))
				break;
			else {
				System.out.print("=");
				try {
					result = Poland.Calculate(str);
					result.print();
				} catch (Exception e) {
					System.out.println("Error");
				}
			}
		}
	}

}
