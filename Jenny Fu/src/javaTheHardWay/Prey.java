package javaTheHardWay;

public class Prey extends ReproductionAnimal {
	
	public static final String[] PREY = {"bunny"};

	public Prey(Habitat matingArea) {
		super(matingArea);
		setMaxLitterSize(10);
	}

	public Prey(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(matingArea, description, trait1, trait2);
		setMaxLitterSize(10);
	}

	public static void main(String[] args) {
		Wilderness wilderness = new Wilderness("A Wooded Area", 400);
		int numPredators = 100;
		int numPrey = 250;
		for(int i = 0; i < numPredators; i++) {
			Predator predator = new Predator(wilderness, "wolf", new Trait(), new Trait());
			wilderness.addAnimal(predator);
		}
		for(int i = 0; i < numPrey; i++) {
			Prey prey = new Prey(wilderness);
			wilderness.addAnimal(prey);
		}
		wilderness.simulate(10);
	}

	public String getName() {
		return PREY[(int)(Math.random() * PREY.length)];
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		return new Prey(habitat, getDescription(), Trait.getDominantTrait(getTrait1(), mate.getTrait1()), Trait.getDominantTrait(getTrait2(), mate.getTrait2()));
	}
}
