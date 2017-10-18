package arrays;

public class ObjectArrays {

	public ObjectArrays() {
		Person[] people = new Person[20];
		populate(people);
		for(Person p: people) {
			System.out.println(p);
		}
	}

	public void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			/**BIG IDEA !!
			 * In Object[] (but not primitive arrays line int[] or double[])
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
