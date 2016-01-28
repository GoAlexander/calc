import java.util.Stack;

public class Poland {
	// Method Calculate takes expression as string and return result
	// This method calls another methods of current class
	static public Fraction calculate(String input) {
		if (input.startsWith("-"))
			input = "0" + input;
		if (input.contains("(-"))
			input = input.replace("(-", "(0-");
		String output = getExpression(input); // Transformation of expression to
												// postfix form
		Fraction result = counting(output); // returned expression solving
		return result; // return result
	}

	// This method transforms string to postfix form
	static private String getExpression(String input) {
		String output = ""; // String for expression
		Stack<Character> operStack = new Stack<Character>(); // Stack for
																// operators

		for (int i = 0; i < input.length(); i++) { // for each symbol in imputed
													// string
			// Avoid separators!
			if (isDelimeter(input.charAt(i)))
				continue; // Go to the next symbol

			// If symbol is digit -> read all number
			if (Character.isDigit(input.charAt(i))) // If symbol is digit
			{
				// Read until separator or operator (to get a number)
				while (!isDelimeter(input.charAt(i)) && !isOperator(input.charAt(i))) {
					output += input.charAt(i); // Add each digit to output
												// string
					i++; // Go to the next symbol
					if (i == input.length())
						break; // If symbol is the last -> break
				}

				output += " "; // Finish our string-expression with space
				i--; // Make one step back (symbol before separator)
			}

			// If symbol is operator
			if (isOperator(input.charAt(i))) // If operator
			{
				if (input.charAt(i) == '(') // If symbol is "("
					operStack.push(input.charAt(i)); // Write to the stack
				else if (input.charAt(i) == ')') // If symbol is ")"
				{
					// Write all operators until "(" to the string
					Character s = operStack.pop();

					while (s != '(') {
						output += s.toString() + ' ';
						s = operStack.pop();
					}
				}

				else if (operStack.size() > 0) // If another operator
				{
					// if priority of operator is greater -> then add operator
					// to the peek of stack
					if (getPriority(input.charAt(i)) > getPriority(operStack.peek()))
						operStack.push(input.charAt(i));
					else {
						// if priority of our operator is less or equal priority
						// of operator in the peek of stack
						while (operStack.size() > 0 && getPriority(input.charAt(i)) <= getPriority(operStack.peek()))
							output += operStack.pop().toString() + " "; // Then
																		// add
																		// last
																		// operator
																		// from
																		// stack
																		// to
																		// the
																		// string-expression
						operStack.push(input.charAt(i));
					}
				} else
					// if stack is empty add operator to the peek of stack
					operStack.push(input.charAt(i));
			}
		}

		// When we processed all symbols -> purge all residual operators to the
		// string
		while (operStack.size() > 0)
			output += operStack.pop() + " ";

		return output; // Return expression in postfix form!!!
	}

	// This method calculates value of expression (expression is already in
	// postfix form)
	static private Fraction counting(String input) {
		Fraction result = new Fraction(0);
		Stack<Fraction> temp = new Stack<Fraction>(); // Stack for answers
		for (int i = 0; i < input.length(); i++) { // For each symbol in the
													// string
			// If the symbol is digit -> read the number and write to the peek
			// of stack
			if (Character.isDigit(input.charAt(i))) {
				String a = "";

				while (!isDelimeter(input.charAt(i)) && !isOperator(input.charAt(i))) // Until
																						// it
																						// is
																						// not
																						// separator
				{
					a += input.charAt(i); // add
					i++;
					if (i == input.length())
						break;
				}
				temp.push(new Fraction(a)); // Write to the stack
				i--;
			} else if (isOperator(input.charAt(i))) // If symbol if operator
			{
				// Take two last values from stack
				Fraction a = temp.pop();
				Fraction b = temp.pop();
				switch (input.charAt(i)) // And calculate them according to the
											// current operator
				{
				case '+':
					result = Fraction.sum(b, a);
					break;
				case '-':
					result = Fraction.dif(b, a);
					break;
				case '*':
					result = Fraction.mult(b, a);
					break;
				case '/':
					result = Fraction.div(b, a);
					break;
				/*
				 * case '^': //result =
				 * Double.parseDouble(Math.pow(Double.parseDouble(b.toString()),
				 * Double.parseDouble(a.toString())).toString()); result =
				 * Math.pow(Double.parseDouble(b.toString()),
				 * Double.parseDouble(a.toString())); result =
				 * Double.parseDouble(Double.toString(result)); break;
				 */
				}
				temp.push(result); // New result is written to the stack

			}
		}
		return temp.peek(); // We take result of all calculations from stack and
							// return them
	}

	// small functions:
	// Method returns true if verifiable symbol is separator (space or =)
	static private boolean isDelimeter(char c) {
		if ((" =".indexOf(c) != -1))
			return true;
		return false;
	}

	// Method returns true if verifiable symbol is separator
	static private boolean isOperator(char c) {
		if (("+-/*()".indexOf(c) != -1))
			return true;
		return false;
	}

	// Method returns priority of operator
	static private byte getPriority(char s) {
		switch (s) {
		case '(':
			return 0;
		case ')':
			return 1;
		case '+':
			return 2;
		case '-':
			return 2;
		case '*':
			return 4;
		case '/':
			return 4;
		/*
		 * case '^': return 5;
		 */
		default:
			return 6;
		}
	}
}