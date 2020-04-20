package hu.me.krz.haladojava.calculatorweb.service;

import org.springframework.stereotype.Service;

import calculatorapi.Calculation;
import calculatorapi.CalculatorAPI;

@Service
public class CalculationService implements ICalculationService {

	@Override
	public double calculate(Calculation calculation) {
		return CalculatorAPI.calculateResult(calculation);
	}

}
