package poland;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class PolandParamTest {
	private String expected;
	private String expression;

	public PolandParamTest(String expectedResult, String expression) {
		this.expected = expectedResult;
		this.expression = expression;
	}

	@Parameters
	public static Collection<String[]> addedNumbers() {
		return Arrays.asList(new String[][] { { "8", "3 + 5" }, { "-1", "1 - 2" },
				{ "25", "10 + 15" }, { "120", "120 +0" }, });
	}
	
	@Test
	public void test() {
		assertEquals(expected, Poland.calculate(expression).getString());
		
	}
}
