
class Calc {

	static boolean debug = true; // for DEBUG

	// Expression calculation
	public static Fraction calculate(String s) throws Exception {
		if (debug)
			System.out.println("DEBUG: " + s);

		String str = parse(s);
		// Substitute expression in brackets with result
		String tmp;
		while (str.contains("(")) {
			tmp = str.substring(str.lastIndexOf("(") + 1, str.indexOf(")", str.lastIndexOf("(") + 1));
			tmp = calc(tmp).toString();
			str = str.replace(str.substring(str.lastIndexOf("("), str.indexOf(")", str.lastIndexOf("(") + 1) + 1), tmp);
		}

		return calc(str);
	}

	static private boolean isOperator(char c) {
		if (("+-%)".indexOf(c) != -1))
			return true;
		return false;
	}

	// Parsing
	private static String parse(String s) {
		String str = s.replace(" ", "");
		if (str.startsWith("-"))
			str = "0" + str;
		if (str.contains("(-"))
			str = str.replace("(-", "(0-");

		if (str.contains("+")) {
			str = str.replace("+", " + ");
		}
		if (str.contains("-")) {
			str = str.replace("-", " - ");
		}
		if (str.contains("*")) {
			str = str.replace("*", " * ");

		}
		if (str.contains("%")) {
			str = str.replace("%", " % ");
		}

		int first = -2, last = -2;
		char arr[] = str.toCharArray();
		int index = 0;
		String tmp[] = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
	
			if (arr[i] == '*' || arr[i] == '%') {
				// Find first
				for (int j = i - 1; j != 0; j--) {
					if (arr[j] == ')') {
						for (int k = 0; k != arr.length; k++) {
							if (arr[k] == '(') {
								first = k;
								break;
							}
						}
						break;
					}
					if (arr[j] == '(') {
						first = j;
						break;
					}
					if (isOperator(arr[j])) {
						first = j + 2;
						break;
					}
					first = j - 1;
				}
				
				//Find last
				for (int j = i + 1; j != arr.length; j++) {
					if (arr[j] == '(') {
						for (int k = arr.length-1; k != 0; k--) {
							if (arr[k] == ')') {
								last = k;
								break;
							}
						}
						break;
					}
					if (arr[j] == ')') {
						last = j;
						break;
					}
					if (isOperator(arr[j])) {
						last = j - 1;
						break;
					}
					last = j + 1;
				}
				
				// Save this expression
				if (first != -2 && last != -2) {
					tmp[index] = str.substring(first, last);
					index++;
				}
				
			}
		}
		// Add brackets
		for (int j = 0; j < index; j++)
			str = str.replace(tmp[j], "(" + tmp[j] + ")");

		if (debug)
			System.out.println("DEBUG: " + str);

		return str;
	}

	// Calculate simple expression
	private static Fraction calc(String str) {
		String expression_str_line[] = str.split(" ");
		Fraction[] frac_number = new Fraction[expression_str_line.length];
		int j = 0;
		for (int i = 0; i < expression_str_line.length; i++) {
			if (!expression_str_line[i].equals("+") && !expression_str_line[i].equals("-")
					&& !expression_str_line[i].equals("*") && !expression_str_line[i].equals("%")) {
				frac_number[j] = new Fraction(expression_str_line[i]);
				j++;

			}
		}

		if ((expression_str_line.length == 1) && (frac_number[0] != null))
			return frac_number[0];

		Fraction cache = new Fraction(0); // it saves the result of last
											// operation
		int index_of_first_sign = 0;

		// for first 2 elements:
		for (int i = 0; i < expression_str_line.length; i++) {
			if (expression_str_line[i].equals("+")) {
				cache = Fraction.sum(frac_number[0], frac_number[1]);
				index_of_first_sign = i;
				break;
			}
			if (expression_str_line[i].equals("*")) {
				cache = Fraction.mult(frac_number[0], frac_number[1]);
				index_of_first_sign = i;
				break;
			}
			if (expression_str_line[i].equals("%")) {
				cache = Fraction.div(frac_number[0], frac_number[1]);
				index_of_first_sign = i;
				break;
			}
			if (expression_str_line[i].equals("-")) {
				cache = Fraction.dif(frac_number[0], frac_number[1]);
				index_of_first_sign = i;
				break;
			}

		}

		// TODO here make checking if string is long
		// for next elements:
		j = 2;
		for (int i = index_of_first_sign + 1; i < expression_str_line.length; i++) {
			if (expression_str_line[i].equals("+")) {
				cache = Fraction.sum(cache, frac_number[j]);
				j++;
			}
			if (expression_str_line[i].equals("*")) {
				cache = Fraction.mult(cache, frac_number[j]);
				j++;
			}
			if (expression_str_line[i].equals("%")) {
				cache = Fraction.div(cache, frac_number[j]);
				j++;
			}
			if (expression_str_line[i].equals("-")) {
				cache = Fraction.dif(cache, frac_number[j]);
				j++;
			}
		}

		return cache;
	}
}
