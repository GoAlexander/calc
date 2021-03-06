package poland;

import fraction.Fraction;
import static org.junit.Assert.*;

import org.junit.Ignore;
//import org.junit.Before;
//import org.junit.After;
import org.junit.Test;


public class PolandTest {

	/*
	 * @Before public void setUp() { System.out.println("@Before setUp"); }
	 * 
	 * @After public void tearDown() { System.out.println("@After tearDown"); }
	 */

	@Test
	public void test1() {
		Fraction f1 = new Fraction(8);
		try {
			Fraction f2 = Poland.calculate("3 + 5");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test1_2() {
		Fraction f1 = new Fraction(-1);
		try {
			Fraction f2 = Poland.calculate("1 - 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test2() {
		Fraction f1 = new Fraction(25);
		try {
			Fraction f2 = Poland.calculate("10 + 15");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test2_2() {
		Fraction f1 = new Fraction(120);
		try {
			Fraction f2 = Poland.calculate("120 +0");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test3() {
		Fraction f1 = new Fraction(1111);
		try {
			Fraction f2 = Poland.calculate("1 + 10 + 100 + 1000");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test3_2() {
		Fraction f1 = new Fraction(9);
		try {
			Fraction f2 = Poland.calculate("2 + 2 + 5");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test4() {
		Fraction f1 = new Fraction(1111);
		try {
			Fraction f2 = Poland.calculate("1 + 10 +100+1000");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test4_2() {
		Fraction f1 = new Fraction(109);
		try {
			Fraction f2 = Poland.calculate("3 + 5 + 0 + 1 + 100");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test5() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.calculate("1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test6() {
		Fraction f1 = new Fraction(311, 2);
		try {
			Fraction f2 = Poland.calculate("3 + 50 + 1 + 1 + 100 + 1/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test7() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.calculate("1/2 + 1/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test7_2() {
		Fraction f1 = new Fraction(6, 4);
		try {
			Fraction f2 = Poland.calculate("3/4 + 3/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test7_3() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.calculate("3/4 + 1/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test7_4() {
		Fraction f1 = new Fraction(7, 5);
		try {
			Fraction f2 = Poland.calculate("5/10 + 7/10 + 2/10");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test7_5() {
		Fraction f1 = new Fraction(6, 5);
		try {
			Fraction f2 = Poland.calculate("5/10 + 7/10");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test7_6() {
		Fraction f1 = new Fraction(6, 5);
		try {
			Fraction f2 = Poland.calculate("5/10 + 7/10 + 2/10 - 2/10");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test8() {
		Fraction f1 = new Fraction(5, 4);
		try {
			Fraction f2 = Poland.calculate("1/2 + 3/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test9() {
		Fraction f1 = new Fraction(0);
		try {
			Fraction f2 = Poland.calculate("-1 + 1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	// next milestone:

	@Test

	public void test10() {
		Fraction f1 = new Fraction(10);
		try {
			Fraction f2 = Poland.calculate("5* 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test11() {
		Fraction f1 = new Fraction(12);
		try {
			Fraction f2 = Poland.calculate("2 + 5* 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	public void test12() {
		Fraction f1 = new Fraction(7 / 32);
		Fraction f2;
		try {
			f2 = Poland.calculate("1/32-2/32+1/4");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}


	@Test(expected = Exception.class)
	public void test13() throws Exception {
		@SuppressWarnings("unused")
		Fraction f2 = Poland.calculate("a+35");
	}

	@Test(expected = Exception.class)
	public void test14_1() throws Exception {
		@SuppressWarnings("unused")
		Fraction f2 = Poland.calculate("+ - 1");
	}

	@Test(expected = Exception.class)
	public void test14_2() throws Exception {
		@SuppressWarnings("unused")
		Fraction f2 = Poland.calculate("1+ - 1");
	}
	
	@Test(expected = Exception.class)
	public void test15() throws Exception {
		@SuppressWarnings("unused")
		Fraction f2 = Poland.calculate("+");
	}

	@Test(expected = Exception.class)
	public void test16_1() throws Exception {
		@SuppressWarnings("unused")
		Fraction f2 = Poland.calculate("1 + -");
	}
	
	@Test(expected = Exception.class)
	public void test16_2() throws Exception {
		@SuppressWarnings("unused")
		Fraction f2 = Poland.calculate("1 + (2-3");
	}

	@Test
	public void test17_1() {
		Fraction f1 = new Fraction("0");
		try {
			Fraction f2 = Poland.calculate("(-1) + 1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test17() {
		Fraction f1 = new Fraction(4, 5);
		try {
			Fraction f2 = Poland.calculate("2/ (5/2)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test18() {
		Fraction f1 = new Fraction(9, 2);
		try {
			Fraction f2 = Poland.calculate("2/1 + 5/(2/1)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test19_1() {
		Fraction f1 = new Fraction(203, 2);
		try {
			Fraction f2 = Poland.calculate("50+( 5 * (( 5-1) + (5+1)) + 1  ) +1/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test19_2() {
		Fraction f1 = new Fraction(75);
		try {
			Fraction f2 = Poland.calculate("((1-1)+50/2)+( 5 * (( 5-1) + (5+1)) + 1  ) +(1/2-3/2)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test20() {
		Fraction f1 = new Fraction(1, 2);
		try {
			Fraction f2 = Poland.calculate("  1/2  ");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test21() {
		Fraction f1 = new Fraction(-1800);
		try {
			Fraction f2 = Poland.calculate("-1000*2 + ((50+150))");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test22() {
		Fraction f1 = new Fraction(2600, 3);
		try {
			Fraction f2 = Poland.calculate("1000*2/3 + ((50+150))");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test23() {
		Fraction f1 = new Fraction(25, 2);
		try {
			Fraction f2 = Poland.calculate("5*2 + 5/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test24() {
		Fraction f1 = new Fraction(35, 2);
		try {
			Fraction f2 = Poland.calculate("5* (2 + 5) /2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test25() {
		Fraction f1 = new Fraction("0");
		try {
			Fraction f2 = Poland.calculate("(-1) + 1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Ignore
	@Test
	public void test26() {
		Fraction f1 = new Fraction("222222222222");
		try {
			Fraction f2 = Poland.calculate("111111111111 * 2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Ignore
	@Test
	public void test27() {
		Fraction f1 = new Fraction("111111111112");
		try {
			Fraction f2 = Poland.calculate("111111111111 + 1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test28() {
		Fraction f1 = new Fraction("10000");
		try {
			Fraction f2 = Poland.calculate("9999 + 1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Ignore
	@Test(timeout = 2) // number in milliseconds
	// TODO BUG to long
	public void test29() {
		Fraction f1 = new Fraction("1111111111");
		try {
			Fraction f2 = Poland.calculate("1111111111");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Ignore

	@Test(timeout = 10) // TODO too long + BUG
	public void test30_1() {
		Fraction f1 = new Fraction(1192801855, 13332);
		try {
			Fraction f2 = Poland.calculate("12345/22222222 + 1431295/125385");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test30() {
		Fraction f1 = new Fraction("55555");
		try {
			Fraction f2 = Poland.calculate("50000 + 5555");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Ignore
	@Test(timeout = 10000)
	public void test31() {
		Fraction f1 = new Fraction(308160493, 469350862);
		try {
			Fraction f2 = Poland.calculate("12345/22222 + 2134/21121");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		} // TODO too long + BUG
	}

	@Test
	public void test32() {
		Fraction f1 = new Fraction("5");
		try {
			Fraction f2 = Poland.calculate("5 - 1/2*1/3  + 1/6");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test35() {
		Fraction f1 = new Fraction(-3, 2);
		try {
			Fraction f2 = Poland.calculate("1+(2/4-3)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test36() {
		Fraction f1 = new Fraction(-3, 2);
		try {
			Fraction f2 = Poland.calculate("1+(2/4-3)+(-4+5)-1");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test37() {
		Fraction f1 = new Fraction("0");
		try {
			Fraction f2 = Poland.calculate("-1+(-2+3)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test49() {
		Fraction f1 = new Fraction(-5,3);
		try {
			Fraction f2 = Poland.calculate("-1+(-2/3)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test50() {
		Fraction f1 = new Fraction(-23,4);
		try {
			Fraction f2 = Poland.calculate("(-1)/(-4)+(-2)*3");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test51() {
		Fraction f1 = new Fraction(-10);
		try {
			Fraction f2 = Poland.calculate("5*(1-3)");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test52() {
		Fraction f1 = new Fraction(1);
		try {
			Fraction f2 = Poland.calculate("4/2/2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void test53() {
		Fraction f1 = new Fraction(3);
		try {
			Fraction f2 = Poland.calculate("4/2/2+2");
			assertTrue(f1.equals(f2));
		} catch (Exception e) {
			fail();
		}
	}
}
