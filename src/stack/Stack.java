package stack;

public class Stack {

	int[] data;

	Stack(int capacity) {
		data = new int[capacity];
	}

	Stack() {
		this(1);
	}

	int tail = 0;

	void push(int value) {
		if (data.length <= tail + 1) {
			int[] stacktemp = new int[(tail + 1) * 2];
			for (int i = 0; i < tail; i++)
				stacktemp[i] = data[i];
			stacktemp[tail] = value;
			tail = tail + 1;
			data = new int[tail];
			for (int i = 0; i < tail; i++)
				data[i] = stacktemp[i];
		} else if (data.length > tail + 1) {
			data[tail + 1] = value;
			tail = tail + 1;
		}
	}


	void pop() throws Exception {
		if (tail != 0) {
			tail = tail - 1;
			int[] stacktemp = new int[tail];
			for (int i = 0; i < tail; i++)
				stacktemp[i] = data[i];
			data = new int[tail];
			for (int i = 0; i < tail; i++)
				data[i] = stacktemp[i];
		} else
			throw new Exception(); // Stack is empty
	}

	int peek() throws Exception {
		if (tail != 0)
			return data[tail - 1];
		else
			throw new Exception();
	}

	boolean isEmpty() {
		if (tail == 0)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		String s = new String();
		for (int i = 0; i < data.length; i++)
			s = "data[" + i + "]:\n" + Integer.toString(data[i]) + "\n" + s;
		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Stack))
			return false;
		Stack f = (Stack) o;
		for (int i = 0; i < f.data.length; i++) {
			if (f.data[i] != data[i])
				return false;
		}
		return true;
	}
}
