import java.util.LinkedList;

public class Poland {
	static boolean isDelim(char c) {
		return c == ' ';
	}

	static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
	}

	static int priority(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '%':
			return 2;
		default:
			return -1;
		}
	}

	static void processOperator(LinkedList<Fraction> st, char op) {
		Fraction r = st.removeLast();
		Fraction l = st.removeLast();
		switch (op) {
		case '+':
			st.add(Fraction.sum(l, r));
			break;
		case '-':
			st.add(Fraction.dif(l, r));
			break;
		case '*':
			st.add(Fraction.mult(l, r));
			break;
		case '%':
			st.add(Fraction.div(l, r));
			break;
		}
	}

	public static Fraction eval(String s) {
		LinkedList<Fraction> st = new LinkedList<Fraction>();
		LinkedList<Character> op = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isDelim(c))
				continue;
			if (c == '(')
				op.add('(');
			else if (c == ')') {
				while (op.getLast() != '(')
					processOperator(st, op.removeLast());
				op.removeLast();
			} else if (isOperator(c)) {
				while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
					processOperator(st, op.removeLast());
				op.add(c);
			} else {
				/*
				 * while (i < s.length()) { try { Fraction temp = new
				 * Fraction(s.charAt(i)); operand += s.charAt(i++); } catch
				 * (NumberFormatException e) { continue; } } --i; st.add(new
				 * Fraction(operand));
				 */

				String operand = "";
				while (i < s.length() && Character.isDigit(s.charAt(i)))
				{
					operand += s.charAt(i++);
				}
				--i;
				st.add(new Fraction(operand));
			}
		}
		while (!op.isEmpty())
			processOperator(st, op.removeLast());
		return st.get(0);
	}

	public static void main(String[] args) throws Exception {
		String exp = "7+(5*2*8)";
		eval(exp).print();
	}
}