package hu.me.krz.haladojava;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.IsEqual;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.jupiter.api.Test;

class AstronomerTest {
	
	@Test
    public void testAstronomerName() {
		
		String name = "test";
		Astronomer astronomer = new Astronomer(name);
		
		//assertTrue(astronomer.getName().equals(name));
		
		assertThat(astronomer.getName(), is(equalTo(name)));
	}
	
	@Test
	public void testGetDiscoveredPlanets() {
		String name = "test";
		Astronomer astronomer = new Astronomer(name);
		assertTrue(astronomer.getDiscoveredPlanets().isEmpty());
		astronomer.observeTheSky();
		assertEquals(astronomer.getDiscoveredPlanets().size(), 10);
	}

}
