package emulator;

import java.util.EmptyStackException;
import java.util.Stack;

public class Emulator {

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
		Stack<String> tmphistory = history;
		String[] tmp = new String[tmphistory.size()];
		for (int i = 0; i < tmphistory.size(); i++)
			tmp[i] = tmphistory.pop();
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
