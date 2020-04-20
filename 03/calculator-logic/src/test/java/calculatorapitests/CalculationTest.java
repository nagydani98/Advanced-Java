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
	
	@Test
	void testGettersSetters() {
		int a = 2;
		int b = 5;
		char c = '+';
		
		Calculation calc = new Calculation();
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		calc.setOperator(c);
		
		assertEquals(calc.getLeftOperand(), a);
		assertEquals(calc.getRightOperand(), b);
		assertEquals(calc.getOperator(), c);
	}
	
	@Test
	void testToString() {
		Calculation calc = new Calculation();
		
		assertNotNull(calc.toString());
	}
	
	@Test
	void testHashCode(){
		Calculation calc = new Calculation();
		
		assertNotNull(calc.hashCode());
	}
	
	@Test
	void testEquals() {
		int a = 2;
		int b = 5;
		char c = '+';
		
		Calculation calc = new Calculation();
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		calc.setOperator(c);
		
		Calculation calc2 = new Calculation();
		calc2.setLeftOperand(a);
		calc2.setRightOperand(b);
		calc2.setOperator(c);
		
		assertTrue(calc.equals(calc2));
	}
}
