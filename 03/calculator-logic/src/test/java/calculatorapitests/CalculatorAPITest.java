package calculatorapitests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculatorapi.Calculation;
import calculatorapi.CalculatorAPI;

class CalculatorAPITest {

	@Test
	void testNullCalculation() {
		Calculation calc = new Calculation();
		
		assertEquals(Double.MIN_VALUE, (CalculatorAPI.calculateResult(calc)));
	}
	
	@Test
	void testCalculationWithNotNullOperatorButNullOperands() {
		Calculation calc = new Calculation();
		calc.setOperator('+');
		
		assertNotNull((CalculatorAPI.calculateResult(calc)));
	}
	
	@Test
	void testCalculationWithNotNullLeftOperand() {
		Calculation calc = new Calculation();
		int a = 5;
		
		calc.setOperator('+');
		calc.setLeftOperand(a);
		
		assertEquals(a, (CalculatorAPI.calculateResult(calc)));
		
	}
	
	@Test
	void testCalculationWithNotNullRightOperand() {
		Calculation calc = new Calculation();
		int a = 5;
		
		calc.setOperator('+');
		calc.setRightOperand(a);
		
		assertEquals(a, (CalculatorAPI.calculateResult(calc)));
		
	}

	@Test
	void testAddition() {
		Calculation calc = new Calculation();
		int a = 5;
		int b = 4;
		char c = '+';
		calc.setOperator(c);
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		
		int expected = a + b;
		
		assertEquals(expected, (CalculatorAPI.calculateResult(calc)));
	}
	
	@Test
	void testSubtraction() {
		Calculation calc = new Calculation();
		int a = 5;
		int b = 4;
		char c = '-';
		calc.setOperator(c);
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		
		int expected = a - b;
		
		assertEquals(expected, (CalculatorAPI.calculateResult(calc)));
	}
	
	@Test
	void testMultiplication() {
		Calculation calc = new Calculation();
		int a = 5;
		int b = 4;
		char c = '*';
		calc.setOperator(c);
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		
		int expected = a * b;
		
		assertEquals(expected, (CalculatorAPI.calculateResult(calc)));
	}
	
	@Test
	void testDivision() {
		Calculation calc = new Calculation();
		int a = 5;
		int b = 4;
		char c = '/';
		calc.setOperator(c);
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		
		int expected = a / b;
		
		assertEquals(expected, (CalculatorAPI.calculateResult(calc)));
	}
	
	
	@Test
	void testDefaultConstructor() {
		//this is only for that sweet sweet 100% coverage
		
		CalculatorAPI api = new CalculatorAPI();
		
		assertNotNull(api);
	}
	
	@Test
	void testNullDivision(){
		Calculation calc = new Calculation();
		int a = 5;
		int b = 0;
		char c = '/';
		calc.setOperator(c);
		calc.setLeftOperand(a);
		calc.setRightOperand(b);
		
		assertThrows(ArithmeticException.class, () -> CalculatorAPI.calculateResult(calc));
	}
}
