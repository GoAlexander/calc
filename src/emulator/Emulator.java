package emulator;

import java.util.EmptyStackException;
import java.util.Stack;

public class Emulator {

	private Stack<String> stackback = new Stack<String>();
	private Stack<String> stackforward = new Stack<String>();

	public String back() throws EmptyStackException {
		if (!stackback.empty()) {
			stackforward.push(stackback.peek());
		}
		stackback.pop();
		if (!stackback.empty())
			return stackback.peek();
		else
			throw new EmptyStackException();
	}

	public String forward() throws EmptyStackException {
		if (!stackforward.empty()) {
			stackback.push(stackforward.peek());
		}
		stackforward.pop();
		if (!stackback.empty())
			return stackback.peek();
		else
			throw new EmptyStackException();
	}

	public void newnumber(String str) {
		stackback.push(str);

		while (stackforward.empty() != true)
			stackforward.pop();

	}
}
