package javaTheHardWay;

public class Wilderness extends Habitat {
	
	private String description;

	public Wilderness(String description, int livingCapacity) {
		super(livingCapacity);
		this.description = description;
	}
	
	public static void main(String[] args) {
		Wilderness w = new Wilderness("An empty desert", 10);
		w.simulate(3);
	}

	public void simulate(int rounds) {
		for(int i = 0; i < rounds; i++) {
			for(Animal a: getAnimal()) {
				if(a instanceof ReproductionAnimal)
					a.reset();
			}
			int predatorCount = 0;
			int preyCount = 0;
			for(Animal a: getAnimal()) {
				//Note: you must create a Predator and Prey class, but they can be empty.
				if(a instanceof Predator) {
					predatorCount++;
				}else if(a instanceof Prey) {
					preyCount++;
				}
			}
			String s = "\nROUND " + (i+1) + "\nPREDATORS: " + predatorCount + ", PREY: " + preyCount + "\n" + animalReport();
			System.out.println(s);
			for(Animal a: getAnimal()) {
				if(a != null)
					a.act();
			}
			growPlants();
		}
	}
	
	public String toString() {
		return this.description + "\n" + animalReport();
	}

}
