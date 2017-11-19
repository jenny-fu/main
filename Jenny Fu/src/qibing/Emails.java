package qibing;

import arrays.Person;

public class Emails {

	public Emails() {
		Person[] people = new Person[1000];
		populate(people);
		for(Person p: people) {
			int num = (int) (Math.random() * 101);
			System.out.println("First: " + p.getFirstName() + "\nLast: " + p.getLastName() + "\nEmail: " + p.getFirstName() + "." + p.getLastName() + num + "@gmail.com\n");
		}
	}
	
	public static void main(String[] args) {
		Emails thing = new Emails();
	}
	
	public void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
				people[i] = new Person(firstName, lastName); 
		}
	}
	
	public String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}


	public String get(String[] a) {
		return a[(int) (Math.random() * a.length)];
	}
}
