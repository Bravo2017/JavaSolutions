package comparable.ex1;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Person> {

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
