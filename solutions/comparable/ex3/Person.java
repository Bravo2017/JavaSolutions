package comparable.ex3;

import java.util.Comparator;

/**
 * Instead of writing separate classes for each comparator implementation
 * 
 * 
 * 
 * 
 * */
class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) throws ClassCastException,
			NullPointerException {
		if (o == null)
			throw new NullPointerException("Null Object passed");
		if (!(o instanceof Person))
			throw new ClassCastException("A Person object expected.");
		int anotherPersonAge = o.getAge();
		return this.age - anotherPersonAge;
	}

	@Override
	public String toString() {
		return String.format(lastName + ", " + firstName + ". Age:" + age);
	}

	// Anonymous class
	public static class LastNameComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			String lastName1 = o1.getLastName().toUpperCase();
			String firstName1 = o1.getFirstName().toUpperCase();
			String lastName2 = o2.getLastName().toUpperCase();
			String firstName2 = o2.getFirstName().toUpperCase();

			// if last names are not equal, compare last names
			// if last names are equal, then sort wrt to first names
			if (!(lastName1.equals(lastName2)))
				return lastName1.compareTo(lastName2);
			else
				return firstName1.compareTo(firstName2);
		}
	}

	public static class FirstNameComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			String fname1 = o1.getFirstName().toUpperCase();
			String lname1 = o1.getFirstName().toUpperCase();
			String fname2 = o2.getFirstName().toUpperCase();
			String lname2 = o2.getLastName().toUpperCase();

			if (!(fname1.equals(fname2))) {
				return fname1.compareTo(fname2);
			} else {
				return lname1.compareTo(lname2);
			}
		}
	}

}
