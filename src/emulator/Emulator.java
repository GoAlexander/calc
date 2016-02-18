package emulator;

import java.util.EmptyStackException;
import java.util.Stack;

public class Emulator {

	Stack<String> stackback = new Stack<String>();
	Stack<String> stackforward = new Stack<String>();

	void back() throws EmptyStackException {
		if (!stackback.empty()) {
			stackforward.push(stackback.peek());
		}
		stackback.pop();
	}

	void forward() throws EmptyStackException {
		if (!stackforward.empty()) {
			stackback.push(stackforward.peek());
		}
		stackforward.pop();
	}

	void newnumber(String str) {
		stackback.push(str);
		while (stackforward.empty() != true)
			stackforward.pop();

	}
}
