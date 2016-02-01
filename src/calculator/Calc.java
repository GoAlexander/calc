package calculator;

import fraction.Fraction;

class Calc {

	static boolean debug = true; // for DEBUG

	// Expression calculation
	public static Fraction calculate(String s) {
		if (debug)
			System.out.println("DEBUG: " + s);

		String str = parse(s);

		if (debug)
			System.out.println("DEBUG: " + str);
		
		// Calculate expressions in brackets
		while (str.contains("(")) {
			String tmp = str.substring(str.lastIndexOf("(") + 1, str.indexOf(")", str.lastIndexOf("(") + 1));
			str = str.replace(str.substring(str.lastIndexOf("("), str.indexOf(")", str.lastIndexOf("(") + 1) + 1),
					calc(tmp).toString());
		}

		if (debug)
			System.out.println("DEBUG: " + str);
		
		// Calculate prioritized expressions
		if ((str.contains("*")) || (str.contains("%"))) {
			String tmp;
			int first = 0;
			int last = 0;

			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) == '*') || (str.charAt(i) == '%')) {
					first = i - 2;
					while ((first >= 0) && (Character.isDigit(str.charAt(first)) || (str.charAt(first) == '/'))) {
						first--;
					}
					last = i + 2;
					if (str.charAt(last) == '-')
						last = last + 2;
					while ((last < str.length())
							&& ((str.charAt(last) == '/') || (Character.isDigit(str.charAt(last))))) {
						last++;
					}
					tmp = str.substring(first + 1, last);
					str = str.replace(tmp, calc(tmp).toString());
				}
			}
		}

		if (debug)
			System.out.println("DEBUG: " + str);
		
		// Calculate a final expression
		return calc(str);
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
