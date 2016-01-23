import java.util.Scanner;

public class MainPoland extends Main {

	public static void main(String[] args) {
		String str;
		Scanner in = new Scanner(System.in);
		
		// TODO make this menu similar as in Main.java
		while (true) //Бесконечный цикл
        {
			System.out.print(">");
			str = in.nextLine(); // for all line (with spaces)
            System.out.println(Poland.Calculate(str)); //Считываем, и выводим результат
        }
	}

}
