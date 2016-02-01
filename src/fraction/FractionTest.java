package fraction;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void test1() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = Fraction.sum(new Fraction(1,4), new Fraction(1,4));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	public void test2() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = Fraction.dif(new Fraction(3,4), new Fraction(1,4));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	public void test3() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = Fraction.mult(new Fraction(1), new Fraction(1,2));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	public void test4() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = Fraction.div(new Fraction(1,4), new Fraction(1,2));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	public void test5() {
		Fraction f1 = new Fraction(1,0);
		Fraction f2 = Fraction.div(new Fraction(1,4), new Fraction(0));
		assertTrue(f1.equals(f2));
	}
	

}
