package exprhistory;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExprHistory {

	private Stack<String> stackback = new Stack<String>();
	private Stack<String> stackforward = new Stack<String>();
	private Stack<String> history = new Stack<String>();

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
		history.push(str);

		while (stackforward.empty() != true)
			stackforward.pop();
	}

	public String[] getHistory() {
		String[] tmp = new String[history.size()];
		for (int i = 0; i < history.size(); i++) {
			tmp[i] = history.elementAt(i);
		}
		
		return tmp;
	}
}
