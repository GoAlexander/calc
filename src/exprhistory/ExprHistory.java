package exprhistory;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExprHistory {

	static private Stack<String> stackback = new Stack<String>();
	static private Stack<String> stackforward = new Stack<String>();
	static private Stack<String> history = new Stack<String>();

	static public String back() throws EmptyStackException {
		if (!stackback.empty()) {
			stackforward.push(stackback.peek());
		}
		stackback.pop();
		if (!stackback.empty())
			return stackback.peek();
		else
			throw new EmptyStackException();
	}

	static public String forward() throws EmptyStackException {
		if (!stackforward.empty()) {
			stackback.push(stackforward.peek());
		}
		stackforward.pop();
		if (!stackback.empty())
			return stackback.peek();
		else
			throw new EmptyStackException();
	}

	static public void newnumber(String str) {
		stackback.push(str);
		history.push(str);

		
		while (stackforward.empty() != true)
			stackforward.pop();
	}

	static public String[] getHistory() {
		Stack<String> tmphistory = history;
		String[] tmp = new String[tmphistory.size()];
		
		for (int i = 0; !tmphistory.empty(); i++) {
			tmp[i] = tmphistory.pop();
		}
		return tmp;
	}

	public int getSize() {
		return history.size();
	}

	public String toString() {
		String s = new String();
		Stack<String> tmp = stackback;
		while (tmp.empty() != true)
			s = s + tmp.pop() + "\n";
		return s;
	}
}
