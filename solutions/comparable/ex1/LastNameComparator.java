package comparable.ex1;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		String lastName1 = o1.getLastName().toUpperCase();
		String firstName1 = o1.getFirstName().toUpperCase();
		String lastName2 = o2.getLastName().toUpperCase();
		String firstName2 = o2.getFirstName().toUpperCase();
		
		// if lastnames are not equal, compare last names
		// if last names are equal, then sort wrt to first names
		if (!(lastName1.equals(lastName2)))
			return lastName1.compareTo(lastName2);
		else
			return firstName1.compareTo(firstName2);
	}

}
