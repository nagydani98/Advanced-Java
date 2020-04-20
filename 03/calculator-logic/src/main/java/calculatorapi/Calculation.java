package calculatorapi;

import lombok.Data;

@Data
public class Calculation {
	private int leftOperand;
	private int rightOperand;
	private char operator;
}
