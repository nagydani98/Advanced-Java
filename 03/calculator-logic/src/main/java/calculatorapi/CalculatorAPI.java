package calculatorapi;

public class CalculatorAPI {
	public static double calculateResult(Calculation calculation) {
		switch (calculation.getOperator()) {
		case '+':
			return calculation.getLeftOperand() + calculation.getRightOperand();
		case '-':
			return calculation.getLeftOperand() - calculation.getRightOperand();
		case '*':
			return calculation.getLeftOperand() * calculation.getRightOperand();
		case '/':
			return calculation.getLeftOperand() / calculation.getRightOperand();
		}
		
		return Double.MIN_VALUE;
	}
}
