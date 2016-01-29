
class Calc {

	private static String parse(String s) {
		String str = s.replace(" ", "");
		if (str.startsWith("-"))
			str = "0" + str;
		if (str.contains("(-"))
			str = str.replace("(-", "(0-");

		String tmp;

		/*
		 * if (str.contains("(")) { str = str.replace("(", " ( "); } if
		 * (str.contains(")")) { str = str.replace(")", " ) "); }
		 */
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
		
		System.out.println(str);
		tmp = str.substring(str.lastIndexOf("(")+1, str.indexOf(")"));
		System.out.println(tmp);
		if (str.contains("(")) {
			tmp = str.substring(str.lastIndexOf("(") + 1, str.indexOf(")"));
			System.out.println(tmp);
			if (tmp.contains("+")) {
				String arr[] = tmp.split(" \\+ ");
				tmp = Fraction.sum(new Fraction(arr[0]), new Fraction(arr[1])).toString();
			}
			str=str.replace(str.substring(str.lastIndexOf("("), str.indexOf(")")+1),tmp);
		}

		return str;
	}

	public static Fraction calculate(String s) throws Exception {
		String str = parse(s);
		/*
		 * if (str.startsWith(" +") || str.startsWith(" -") || str.startsWith(
		 * " *") || str.startsWith(" %")) throw new Exception();
		 */
		String expression_str_line[] = str.split(" ");
		Fraction[] frac_number = new Fraction[expression_str_line.length]; // make
																			// it

		int j = 0;
		for (int i = 0; i < expression_str_line.length; i++) {
			// also make processing of

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
