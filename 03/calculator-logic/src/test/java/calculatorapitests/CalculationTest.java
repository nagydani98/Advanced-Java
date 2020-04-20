package calculatorapitests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculatorapi.Calculation;

class CalculationTest {

	@Test
	void testDefaultCosntructor() {
		Calculation calc = new Calculation();
		
		assertNotNull(calc);
	}
}
