package app;

import calculatorapi.Calculation;
import calculatorapi.CalculatorAPI;

public class App {

	private static Calculation calc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (String string : args) {
			System.out.println(string);
		}
		
		calc = new Calculation();
		calc.setOperator(parseOperator(args[0]));
		
		calc.setLeftOperand(parseOperand(args[1]));
		
		calc.setRightOperand(parseOperand(args[2]));
		
		double result = CalculatorAPI.calculateResult(calc);
		
		System.out.println("Result is: " + result);
		
	}

	private static int parseOperand(String input) {
		int value = Integer.MIN_VALUE;
		try {
			value = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return value;
	}

	private static char parseOperator(String input) {
		for (char c : input.toCharArray()) {
			switch (c) {
			case '+':
				return c;
			case '-':
				return c;
			case '*':
				return c;
			case '/':
				return c;
			default:
				return '*';
			}
		}
		
		return 'e';
	}
	
}
