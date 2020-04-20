package hu.me.krz.haladojava.calculatorweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import calculatorapi.Calculation;
import hu.me.krz.haladojava.calculatorweb.service.CalculationService;

@Controller
public class CalculationController {

	@Autowired
	private CalculationService calculationService;
	
	@GetMapping("/")
	public ModelAndView showCalc() {
		return new ModelAndView("calculator").addObject("calc", new Calculation());
	}
	
	@PostMapping("/")
	public @ResponseBody Double  calcResult(@Valid Calculation calc) {
		return calculationService.calculate(calc);
	}
	
}
