package comparable.ex1;

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
	public int compareTo(Person o) throws ClassCastException, NullPointerException {
		if(o == null)	throw new NullPointerException("Null Object passed");
		if (!(o instanceof Person))
			throw new ClassCastException("A Person object expected.");
		int anotherPersonAge = ((Person) o).getAge();
		return this.age - anotherPersonAge;
	}
	@Override
	public String toString(){
		return String.format(lastName + ", " + firstName + ". Age:" + age);
	}
	
}
