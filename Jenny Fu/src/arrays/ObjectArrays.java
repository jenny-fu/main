package arrays;

import java.util.Arrays;

public class ObjectArrays {

	public ObjectArrays() {
		Person[] people = new Person[20];
		populate(people);
		//people[0] = new Thing("coffee maker");
		
		for(Person p: people) {
			p.mingle(people);
			p.printFriends();
			System.out.println("");
		}
	}
	
	/**
	 * calls count differences on two Person arrays.
	 * each array must contain the same elements, but randomly ordered.
	 * print the number of differences between the two arrays
	 * do this 100 times, print the average (average is a double).
	 */
	public void testShuffling() {
		int num = 0;
		int sum = 0;
		while(num < 100) {
			
		}
	}
	
	//return the number of differences between the two arrays.
	//A "difference" means they don't have the same element at the same position.
	public double countDifferences(Person[] arr1, Person[] arr2) {
		int diff = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(!(arr1[i] == arr2[i]))
				diff++;
		}
		return diff;
	}
	
	public Person[] selectGroup(Person[] population, int length) {
		Person[] group = new Person[length];
		group[0] = selectAPerson(population);
		for(int i = 1; i < length; i++) {
			Person nextPerson = selectAPerson(population);
			while(personInGroup(group, nextPerson)) {
				nextPerson = selectAPerson(population);
			}
			group[i] = nextPerson;
		}
		return group;
	}

	public boolean personInGroup(Person[] group, Person nextPerson) {
		for(int i = 0; i < group.length; i++) {
			if(group[i] == nextPerson)
				return true;
		}
		return false;
	}
	
	public Person selectAPerson(Person[] population) {
		int num = (int) (Math.random() * population.length);
		return population[num];
	}
	
	public void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			
			/**BIG IDEA !!
			 * In Object[] (but not primitive arrays like int[] or double[])
			 * you can have multiple data types (subclasses of the declared type).
			 */
			
			if(Math.random() < 0.6) {
			//60% of the time
				int grade = (int) (Math.random() * 5) + 9;
				people[i] = new Student(firstName, lastName, b, grade);
			}else
			//other 40%
				people[i] = new Person(firstName, lastName, b); 
		}
	}

	public Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int) (Math.random() * Borough.NY_BOROUGHS.length)];
	}

	public String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}

	public String get(String[] a) {
		return a[(int) (Math.random() * a.length)];
	}

}
