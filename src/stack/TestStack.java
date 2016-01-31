package stack;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestStack {
	private static Stack st1 = new Stack();
	private static Stack st2 = new Stack();

	@Before
	public void setUp() {
		st1.push(1);
		st1.push(2);
		st1.push(3);
		st1.push(-4);
	}

	@Test
	public void test1() {
		setUp();
		st2.push(1);
		st2.push(2);
		st2.push(3);
		st2.push(-4);
		assertTrue(st1.equals(st2));
	}

	@Test
	public void test2() {
		setUp();
		try {
			st2.push(-5);
			st2.pop();
			st2.push(1);
			st2.push(2);
			st2.push(3);
			st2.push(-4);
			assertTrue(st1.equals(st2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test3() {
		try {
			setUp();
			st2.push(1);
			st2.push(2);
			st2.pop();
			st2.push(2);
			st2.push(3);
			st2.push(-4);
			st2.push(-3);
			st2.pop();
			assertTrue(st1.equals(st2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test4() {
		setUp();
		st2.push(1);
		st2.push(2);
		st2.push(2);
		st2.push(3);
		st2.push(-4);
		assertTrue(st1.peek() == st2.peek());
	}

	@Test
	public void test5() {
		assertTrue(st2.isEmpty());
	}

	@Test(expected = Exception.class)
	public void test6() throws Exception {
		st2.pop();
	}

	@After
	public void clearStack() throws Exception {
		while (!st1.isEmpty())
			st1.pop();
		while (!st2.isEmpty())
			st2.pop();
	}
}
