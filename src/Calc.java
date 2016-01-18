
class Calc {

	private static String parse(String s) {
		String str = s.replace(" ", "");
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

	static Fraction calculate(String s) throws Exception {
		String str = parse(s);
		String expression_str_line[] = str.split(" ");
		Fraction[] frac_number = new Fraction[expression_str_line.length]; // make
																			// it
		
		if ((expression_str_line.length == 1))
			throw new Exception();// smaller?
		int j = 0;
		for (int i = 0; i < expression_str_line.length; i++) {
			// also make processing of /
			if (!expression_str_line[i].equals("+") && !expression_str_line[i].equals("-")
					&& !expression_str_line[i].equals("*") && !expression_str_line[i].equals("%")) {
				frac_number[j] = new Fraction(expression_str_line[i]);
				j++;

			}
		}

		Fraction cache = new Fraction(0); // it saves the result of last operation
		int index_of_first_sign = 0;

		// for first 2 elements:
		for (int i = 0; i < expression_str_line.length; i++) {
			if (expression_str_line[i].equals("+")) {
				cache = Fraction.sum(frac_number[0], frac_number[1]);
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
			if (expression_str_line[i].equals("-")) {
				cache = Fraction.dif(cache, frac_number[j]);
				j++;
			}
		}

		return cache;
	}
}
