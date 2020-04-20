package dataTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.NeptunGenerator;

class NeptunGeneratorTest {

	@Test
	void testCounter() {
		NeptunGenerator nGenerator = new NeptunGenerator();
		assertEquals(0, nGenerator.getNextCounter());
		assertEquals(1, nGenerator.getNextCounter());
		
		nGenerator.getNextCounter();
		nGenerator.getNextCounter();
		
		assertEquals(4, nGenerator.getNextCounter());
	}

}
