package calculator;


import fraction.Fraction;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ATest {

	@Test
	public void simpleAdd1() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 + 1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAdd2() {
		Fraction expected = new Fraction("13/12");
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 + 1/3 + 1/4");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAdd3() {
		Fraction expected = new Fraction(2);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 + 1/2 + 1/2 + 1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAdd4() {
		Fraction expected = new Fraction(1, 2);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 + 0");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAdd5() {
		Fraction expected = new Fraction(1, 2);
		Fraction result = new Fraction();
		result = Calc.calculate("-1/2 + 1");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAdd6() {
		Fraction expected = new Fraction(-1);
		Fraction result = new Fraction();
		result = Calc.calculate("-2 + 1");
		assertEquals(expected.toString(), result.toString());
	}

	@Ignore
	
	@Test
	public void simpleAdd7() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate("2 + - 1");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleDeduct1() {
		Fraction expected = new Fraction("-1/2");
		Fraction result = new Fraction();
		result = Calc.calculate("0 - 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleDeduct2() {
		Fraction expected = new Fraction(1, 2);
		Fraction result = new Fraction();
		result = Calc.calculate("3/2 - 1/2 - 1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleDeduct3() {
		Fraction expected = new Fraction(1, 2);
		Fraction result = new Fraction();
		result = Calc.calculate("4/2 - 1/2 - 1/2 - 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleDeduct4() {
		Fraction expected = new Fraction(0);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 - 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleDeduct5() {
		Fraction expected = new Fraction(-1);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 - 1/2-1");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAddDeduct1() {
		Fraction expected = new Fraction(2);
		Fraction result = new Fraction();
		result = Calc.calculate("4/2 - 1/2 + 1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAddDeduct2() {
		Fraction expected = new Fraction("5/2");
		Fraction result = new Fraction();
		result = Calc.calculate("4/2 + 2/2 - 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAddDeduct3() {
		Fraction expected = new Fraction("1/2");
		Fraction result = new Fraction();
		result = Calc.calculate("4/2 - 1/2 + 1/2 - 3/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAddDeduct4() {
		Fraction expected = new Fraction("3/2");
		Fraction result = new Fraction();
		result = Calc.calculate("4/2 + 1/2 + 1/2 - 3/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAddDeduct5() {
		Fraction expected = new Fraction("5/2");
		Fraction result = new Fraction();
		result = Calc.calculate("4/2 - 1/2 - 1/2 + 3/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleMultiply1() {
		Fraction expected = new Fraction(3, 4);
		Fraction result = new Fraction();
		result = Calc.calculate("3/2 * 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleMultiply2() {
		Fraction expected = new Fraction("1/24");
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 * 1/3 * 1/4");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleMultiply3() {
		Fraction expected = new Fraction(1, 16);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 * 1/2 * 1/2 * 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Ignore
	
	@Test
	public void simpleMultiply4() {
		Fraction expected = new Fraction(2);
		Fraction result = new Fraction();
		result = Calc.calculate("5+(6% -2)");
		// System.out.println(result);
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleMultiply5() {
		Fraction expected = new Fraction(0);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 * 0");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAddMultiply1() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate("3/4 + 1/2 * 1/2");
		assertTrue(expected.toString().equals(result.toString()));
	}

	@Test
	public void simpleAddMultiply2() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate("2/4 + 1/2 * 1/2 +1/2*1/2");
		assertEquals(expected.toString(), result.toString());
	}
	
	@Ignore
	
	@Test
	public void simpleAddMultiply3() {
		Fraction expected = new Fraction(1, 2);
		Fraction result = new Fraction();
		result = Calc.calculate("1+1*-1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAddMultiply4() {
		Fraction expected = new Fraction(2);
		Fraction result = new Fraction();
		result = Calc.calculate("1+(1-1 +1*1/2*2)");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleAddMultiplyDivide1() {
		Fraction expected = new Fraction(2);
		Fraction result = new Fraction();
		result = Calc.calculate("3/4 + 1/2 * 1/2 +1/2%1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleDivide1() {
		Fraction expected = new Fraction(3);
		Fraction result = new Fraction();
		result = Calc.calculate("3/2 % 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleDivide2() {
		Fraction expected = new Fraction(4);
		Fraction result = new Fraction();
		result = Calc.calculate("4%2%1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleDivide3() {
		Fraction expected = new Fraction(12);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 % 1/3 % 1/4 % 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleDivide4() {
		Fraction expected = new Fraction(0);
		Fraction result = new Fraction();
		result = Calc.calculate("0 % 1/3");
		assertTrue(expected.equals(result));
	}
/*
	@Test
	public void simpleParse1() {
		String expected = " - 1 - 2";
		String result = Calc.parse("-1-2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse2() {
		String expected = "1 + 2";
		String result = Calc.parse("1+2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse3() {
		String expected = "1 * 2";
		String result = Calc.parse("1*2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse4() {
		String expected = "1 % 2";
		String result = Calc.parse("1%2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse5() {
		String expected = "( 1 % 2 )";
		String result = Calc.parse("(1%2)");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse6() {
		String expected = "( ( 1 % 2 ) )";
		String result = Calc.parse("((1%2))");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse7() {
		String expected = "1 - 2 + 3";
		String result = Calc.parse("1-2+3");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse8() {
		String expected = "( 1 * 2 ) + 5 - 3 % 2";
		String result = Calc.parse("(1*2)+5-3%2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse9() {
		String expected = "1 * ( 2 + 3 )";
		String result = Calc.parse("1*(2+3)");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse10() {
		String expected = "( 1 % 2 ) * ( 2 + 3 ) * ( 1 - 2 )";
		String result = Calc.parse("(1%2)*(2+3)*(1-2)");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse11() {
		String expected = "1 * ( 2 + 3 ) * ( 1 - 2 ) * 2";
		String result = Calc.parse("1*(2+3)*(1-2)*2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse12() {
		String expected = "2 * ( 5 * ( 2 + 3 ) ) + 3";
		String result = Calc.parse("2*(5*(2+3))+3");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse13() {
		String expected = "3 + 2 * ( 5 * ( 2 + 3 ) )";
		String result = Calc.parse("3+2*(5*(2+3))");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse14() {
		String expected = "( 1 + 3 ) + ( 2 + 3 )";
		String result = Calc.parse("(1+3)+(2+3)");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleParse15() {
		String expected = "1/2 + ( 1 + ( 1/2 + 1/2 ) * ( - 1/2 ) )";
		String result = Calc.parse("1/2+(1 +(1/2+1/2)*(-1/2))");
		assertTrue(expected.equals(result));
	}*/

	@Test
	public void simpleAddParse1() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2 +1/2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleAddParse2() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate(" 1/2+1/2 ");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleSc1() {
		Fraction expected = new Fraction("3/2");
		Fraction result = new Fraction();
		result = Calc.calculate("( 1/2 + 1/2 ) + 1/2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleSc2() {
		Fraction expected = new Fraction("1/2");
		Fraction result = new Fraction();
		result = Calc.calculate("1/4 + ( 1/2 * 1/2 )");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleSc3() {
		Fraction expected = new Fraction("5/4");
		Fraction result = new Fraction();
		result = Calc.calculate("( 1/2 * 1/2 ) + ( 1/2 + 1/2 )");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleSc4() {
		Fraction expected = new Fraction(8);
		Fraction result = new Fraction();
		result = Calc.calculate("( 3 + 1 ) + ( 2 + 2 )");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleSc5() {
		Fraction expected = new Fraction(7);
		Fraction result = new Fraction();
		result = Calc.calculate("2+(5*(1/2+1/2))");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleSc6() {
		Fraction expected = new Fraction(25);
		Fraction result = new Fraction();
		result = Calc.calculate("2+(5*(1+3))+3");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleSc7() {
		Fraction expected = new Fraction(29);
		Fraction result = new Fraction();
		result = Calc.calculate("2+(5*(1+3))+(3+2)+2");
		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void simpleSc8() {
		Fraction expected = new Fraction(29);
		Fraction result = new Fraction();
		result = Calc.calculate("2+5*(1+3)+(3+2)+2");
		assertTrue(expected.equals(result));
	}

	@Test
	public void simpleSc9() {
		Fraction expected = new Fraction(1);
		Fraction result = new Fraction();
		result = Calc.calculate("1/2+(1 +(1/2+1/2)*(-1/2))");
		assertEquals(expected.toString(), result.toString());
	}

	@Ignore
	public void simpleSc10() {
		Fraction expected = new Fraction("-1/2");
		Fraction result = new Fraction();
		result = Calc.calculate("(-1/2)");
		assertTrue(expected.equals(result));
	}

	@Test(timeout = 100)
	public void simpleCalculation1() {
		Fraction expected = new Fraction(14);
		Fraction result = new Fraction();
		result = Calc.calculate("-(-(2)*(3+4)%1)");
		assertEquals(expected.toString(), result.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void calcError1() {
		Calc.calculate("((1+2)))");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calcError2() {
		Calc.calculate("()");
	}


	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Ignore
	
	@Test
	public void shouldTestExceptionMessage() throws IllegalArgumentException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid input! Error in brackets!");
		Calc.calculate("((1+2)))"); // execution will never get past this line
	}

}

