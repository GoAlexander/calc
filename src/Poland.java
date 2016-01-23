import java.util.Stack;
import java.util.EmptyStackException;

public class Poland {
	// Метод Calculate принимает выражение в виде строки и возвращает результат,
	// в своей работе использует другие методы класса
	static public double Calculate(String input) {
		String output = GetExpression(input); // Преобразовываем выражение в
												// постфиксную запись
		double result = Counting(output); // Решаем полученное выражение
		return result; // Возвращаем результат
	}

	// Метод, преобразующий входную строку с выражением в постфиксную запись
	static private String GetExpression(String input) {
		// String output = String.Empty; //Строка для хранения выражения
		String output = "";
		// Stack<char> operStack = new Stack<char>(); //Стек для хранения
		// операторов
		Stack<Character> operStack = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) // Для каждого символа в
													// входной строке
		{
			// Разделители пропускаем
			if (IsDelimeter(input.charAt(i)))
				continue; // Переходим к следующему символу

			// Если символ - цифра, то считываем все число
			if (Character.isDigit(input.charAt(i))) // Если цифра
			{
				// Читаем до разделителя или оператора, что бы получить число
				while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i))) {
					output += input.charAt(i); // Добавляем каждую цифру числа к
												// нашей строке
					i++; // Переходим к следующему символу

					if (i == input.length())
						break; // Если символ - последний, то выходим из цикла
				}

				output += " "; // Дописываем после числа пробел в строку с
								// выражением
				i--; // Возвращаемся на один символ назад, к символу перед
						// разделителем
			}

			// Если символ - оператор
			if (IsOperator(input.charAt(i))) // Если оператор
			{
				if (input.charAt(i) == '(') // Если символ - открывающая скобка
					operStack.push(input.charAt(i)); // Записываем её в стек
				else if (input.charAt(i) == ')') // Если символ - закрывающая
													// скобка
				{
					// Выписываем все операторы до открывающей скобки в строку
					Character s = operStack.pop();

					while (s != '(') {
						output += s.toString() + ' ';
						s = operStack.pop();
					}
				} else // Если любой другой оператор
				{
					// C# -> Count является количеством элементов, которые
					// фактически содержатся в Stack.
					// if (operStack.Count > 0) //Если в стеке есть элементы
					if (operStack.size() > 0) // Если в стеке есть элементы
						if (GetPriority(input.charAt(i)) <= GetPriority(operStack.peek())) // И
																							// если
																							// приоритет
																							// нашего
																							// оператора
																							// меньше
																							// или
																							// равен
																							// приоритету
																							// оператора
																							// на
																							// вершине
																							// стека
							output += operStack.pop().toString() + " "; // То
																		// добавляем
																		// последний
																		// оператор
																		// из
																		// стека
																		// в
																		// строку
																		// с
																		// выражением

					//operStack.Push(Character.Parse(input.charAt(i).toString())); 
					operStack.push(input.charAt(i));// Если
																					// стек
																					// пуст,
																					// или
																					// же
																					// приоритет
																					// оператора
																					// выше
																					// -
																					// добавляем
																					// операторов
																					// на
																					// вершину
																					// стека

				}
			}
		}

		// Когда прошли по всем символам, выкидываем из стека все оставшиеся там
		// операторы в строку
		while (operStack.size() > 0)
			output += operStack.pop() + " ";

		return output; // Возвращаем выражение в постфиксной записи
	}

	// Метод, вычисляющий значение выражения, уже преобразованного в постфиксную
	// запись
	static private double Counting(String input) {
		double result = 0; // Результат
		Stack<Double> temp = new Stack<Double>(); // Dhtvtyysq стек для решения

		for (int i = 0; i < input.length(); i++) // Для каждого символа в строке
		{
			// Если символ - цифра, то читаем все число и записываем на вершину
			// стека
			if (Character.isDigit(input.charAt(i))) {
				String a = "";

				while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i))) // Пока
																						// не
																						// разделитель
				{
					a += input.charAt(i); // Добавляем
					i++;
					if (i == input.length())
						break;
				}
				temp.push(Double.parseDouble(a)); // Записываем в стек
				i--;
			} else if (IsOperator(input.charAt(i))) // Если символ - оператор
			{
				// Берем два последних значения из стека
				Double a = temp.pop();
				Double b = temp.pop();

				switch (input.charAt(i)) // И производим над ними действие,
											// согласно оператору
				{
				case '+':
					result = b + a;
					break;
				case '-':
					result = b - a;
					break;
				case '*':
					result = b * a;
					break;
				case '/':
					result = b / a;
					break;
				case '^':
					//result = Double.parseDouble(Math.pow(Double.parseDouble(b.toString()), Double.parseDouble(a.toString())).toString());
					result = Math.pow(Double.parseDouble(b.toString()), Double.parseDouble(a.toString()));
					result = Double.parseDouble(Double.toString(result));
					break;
				}
				temp.push(result); // Результат вычисления записываем обратно в
									// стек
			}
		}
		return temp.peek(); // Забираем результат всех вычислений из стека и
							// возвращаем его
	}

	// small functions:
	// Метод возвращает true, если проверяемый символ - разделитель ("пробел"
	// или "равно")
	static private boolean IsDelimeter(char c) {
		if ((" =".indexOf(c) != -1))
			return true;
		return false;
	}

	// Метод возвращает true, если проверяемый символ - оператор
	static private boolean IsOperator(char с) {
		if (("+-/*^()".indexOf(с) != -1))
			return true;
		return false;
	}

	// Метод возвращает приоритет оператора
	static private byte GetPriority(char s) {
		switch (s) {
		case '(':
			return 0;
		case ')':
			return 1;
		case '+':
			return 2;
		case '-':
			return 3;
		case '*':
			return 4;
		case '/':
			return 4;
		case '^':
			return 5;
		default:
			return 6;
		}
	}
}