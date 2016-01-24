import java.util.Scanner;

public class MainPoland extends Main {

	public static void main(String[] args) {
		String str;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		// TODO make this menu similar as in Main.java
		while (true) // Бесконечный цикл
		{
			System.out.print(">");
			str = in.nextLine(); // for all line (with spaces)
			Poland.Calculate(str).print();
			// Считываем, и выводим результат
		}
	}

}
