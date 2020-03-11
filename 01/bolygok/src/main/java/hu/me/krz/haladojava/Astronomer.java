package hu.me.krz.haladojava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Astronomer {
	private final String name;
	private List<Planet> discoveredPlanets;
	public Astronomer(String name) {
		super();
		this.name = name;
		discoveredPlanets = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	
	public List<Planet> getDiscoveredPlanets() {
		return discoveredPlanets;
	}

	public void observeTheSky() {
		for (int i = 0; i < 10; i++) {
			double rad = new Random().nextInt(1000000);
			String name = this.name + (i + 1);
			Point pos = new Point(i * 10, 0, 0);
			
			discoveredPlanets.add(new Planet(pos, rad, name));
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Astronomer other = (Astronomer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
