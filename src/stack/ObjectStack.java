package stack;

public class ObjectStack {
	private Object[] data;
	private int tail = -1;

	public ObjectStack(int capacity) {
		data = new Object[capacity];
	}

	public ObjectStack() {
		this(1);
	}

	public void push(Object value) {
		try {
			data[tail + 1] = value;
			tail = tail + 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			Object[] stacktemp = new Object[(tail + 1) * 2];
			for (int i = 0; i < tail; i++)
				stacktemp[i] = data[i];
			stacktemp[tail] = value;
			tail = tail + 1;
			data = new Object[tail];
			for (int i = 0; i < tail; i++)
				data[i] = stacktemp[i];
		}
	}

	public boolean pop() {
		if (tail != 0) {
			tail = tail - 1;
			Object[] stacktemp = new Object[tail];
			for (int i = 0; i < tail; i++)
				stacktemp[i] = data[i];
			data = new Object[tail];
			for (int i = 0; i < tail; i++)
				data[i] = stacktemp[i];
			return true;
		} else
			return false; // Stack is empty
	}

	public Object peek() {
		if (tail != 0)
			return data[tail - 1];
		else
			return null;
	}

	public boolean empty() {
		if (tail == 0)
			return true;
		else
			return false;
	}

	public String toString() {
		String s = new String();
		for (int i = 0; i <= tail; i++)
			s = "data[" + i + "]:\n" + data[i].toString() + "\n" + s;
		return s;
	}
}
