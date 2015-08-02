package comparable.ex2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Testing {
	public static void main(String[] args) {
		Person[] persons = new Person[4];

		persons[0] = new Person();
		persons[0].setFirstName("Elvis");
		persons[0].setLastName("Goodyear");
		persons[0].setAge(56);

		persons[1] = new Person();
		persons[1].setFirstName("Stanley");
		persons[1].setLastName("Clark");
		persons[1].setAge(8);

		persons[2] = new Person();
		persons[2].setFirstName("Jane");
		persons[2].setLastName("Graff");
		persons[2].setAge(16);

		persons[3] = new Person();
		persons[3].setFirstName("Nancy");
		persons[3].setLastName("Goodyear");
		persons[3].setAge(69);

		System.out.println("Print in Insertion Order");
		for (int i = 0; i < 4; i++) {
			Person person = persons[i];
			String lastName = person.getLastName();
			String firstName = person.getFirstName();
			int age = person.getAge();
			System.out.println(lastName + ", " + firstName + ". Age:" + age);
		}

		/* Example of using the Comparable interface in sorted data structure */
		Set<Person> personSet = new TreeSet<Person>();
		for (Person p : persons) {
			personSet.add(p);
		}

		// print treeSet using Iterator objects
		System.out.println();
		System.out.println("Print data in Tree");
		Iterator<Person> it = personSet.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person);

		}

		System.out.println("\nUSING ANONYMOUS CLASSES");
		
		Arrays.sort(persons, Person.LastNameComparator);
		System.out.println();
		System.out.println("Sorted by last name");

		for (int i = 0; i < 4; i++) {
			Person person = persons[i];
			String lastName = person.getLastName();
			String firstName = person.getFirstName();
			int age = person.getAge();
			System.out.println(lastName + ", " + firstName + ". Age:" + age);
		}

		Arrays.sort(persons, Person.FirstNameComparator);
		System.out.println();
		System.out.println("Sorted by first name");

		for (int i = 0; i < 4; i++) {
			Person person = persons[i];
			System.out.println(person);
		}
		
		

		System.out.println();
		Arrays.sort(persons); // uses the Comparable interface and overridden
								// compareTo()
		System.out.println("Sorted by age");

		for (Person person : persons) {
			System.out.println(person);
		}
	}
}