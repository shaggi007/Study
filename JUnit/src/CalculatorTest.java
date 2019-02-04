import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void testAdd() {
	    Calculator calculator = new Calculator();
	    int a = 1234;
	    int b = 5678;
	    int actual = calculator.add(a, b);
	 
	    int expected = 6912;
	 
	    assertEquals(expected, actual);
	}
}