import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

public class CalcTest {
	//private Fraction f1;

	/*@Before
	public void setUp() {
		Fraction f1 = new Fraction(0);
	}*/

	@Test
	public void test() {
		Fraction f1 = new Fraction(8);
		Fraction f2 = Calc.calculate("3 + 5");
		assertTrue(f1.equals(f2));
	}

}
