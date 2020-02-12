package hu.me.krz.haladojava;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Astronomer dude = new Astronomer("Joe");
        dude.observeTheSky();
        
        for (Planet planet : dude.getDiscoveredPlanets()) {
			System.out.println(planet.getName() + planet.getPosition() + planet.getRadius());
		}
    }
}
