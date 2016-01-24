import static org.junit.Assert.*;

//import org.junit.Ignore;
//import org.junit.Before;
import org.junit.Test;

public class PolandTest {
	
	@Test
	public void test1() {
		Fraction f1 = new Fraction(8);
		try {
			Fraction f2 = Poland.Calculate("3 + 5");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test1_2() {
		Fraction f1 = new Fraction(-1);
		try {
			Fraction f2 = Poland.Calculate("1 - 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test2() {
		Fraction f1 = new Fraction(25);
		try {
			Fraction f2 = Poland.Calculate("10 + 15");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test2_2() {
		Fraction f1 = new Fraction(120);
		try {
			Fraction f2 = Poland.Calculate("120 +0");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test3() {
		Fraction f1 = new Fraction(1111);
		try {
			Fraction f2 = Poland.Calculate("1 + 10 + 100 + 1000");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test3_2() {
		Fraction f1 = new Fraction(9);
		try {
			Fraction f2 = Poland.Calculate("2 + 2 + 5");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test4() {
		Fraction f1 = new Fraction(1111);
		try {
			Fraction f2 = Poland.Calculate("1 + 10 +100+1000");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test4_2() {
		Fraction f1 = new Fraction(109);
		try {
			Fraction f2 = Poland.Calculate("3 + 5 + 0 + 1 + 100");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test5() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.Calculate("1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test6() {
		Fraction f1 = new Fraction(311, 2);
		try {
			Fraction f2 = Poland.Calculate("3 + 50 + 1 + 1 + 100 + 1/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test7() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.Calculate("1/2 + 1/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}		
	}
	

	@Test
	public void test7_2() {
		Fraction f1 = new Fraction(6, 4);
		try {
			Fraction f2 = Poland.Calculate("3/4 + 3/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test7_3() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.Calculate("3/4 + 1/4");
			assertTrue(f1.equals(f2));
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test7_4() {
		Fraction f1 = new Fraction(7, 5);
		try {
			Fraction f2 = Poland.Calculate("5/10 + 7/10 + 2/10");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test7_5() {
		Fraction f1 = new Fraction(6, 5);
		try {
			Fraction f2 = Poland.Calculate("5/10 + 7/10");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test7_6() {
		Fraction f1 = new Fraction(6, 5);
		try {
			Fraction f2 = Poland.Calculate("5/10 + 7/10 + 2/10 - 2/10");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test8() {
		Fraction f1 = new Fraction(5, 4);
		try {
			Fraction f2 = Poland.Calculate("1/2 + 3/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test9() {
		Fraction f1 = new Fraction(0);
		try {
			Fraction f2 = Poland.Calculate("-1 + 1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	//next milestone:
	
	@Test 
	
	public void test10() {
		Fraction f1 = new Fraction(10);
		try {
			Fraction f2 = Poland.Calculate("5* 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test11() {
		Fraction f1 = new Fraction(12);
		try {
			Fraction f2 = Poland.Calculate("2 + 5* 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	public void test12() {
		Fraction f1 = new Fraction(7 / 32);
		Fraction f2;
		try {
			f2 = Poland.Calculate("1/32-2/32+1/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test13() {
		try {
			@SuppressWarnings("unused")
			Fraction f = Poland.Calculate("a+35");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void test14_1() {
		try {
			@SuppressWarnings("unused")
			Fraction f2 = Poland.Calculate("+ - 1");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test14_2() {
		try {
			@SuppressWarnings("unused")
			Fraction f2 = Poland.Calculate("1+ - 1");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void test15() {
		try {
			@SuppressWarnings("unused")
			Fraction f2 = Poland.Calculate("+");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test16() {
		try {
			@SuppressWarnings("unused")
			Fraction f2 = Poland.Calculate("1 + -");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test17() {
		Fraction f1 = new Fraction(4,5);
		try {
			Fraction f2 = Poland.Calculate("2/ (5/2)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test18() {
		Fraction f1 = new Fraction(9,2);
		try {
			Fraction f2 = Poland.Calculate("2/1 + 5/(2/1)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}	
}
