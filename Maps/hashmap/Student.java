package hashmap;

public class Student {
	private final String studentName;
	private final String SSN;
	
	//constructor
	public Student(String name, String SSN){
		this.studentName = name;
		this.SSN = SSN;
	}

	//getters
	public String getStudentName() {
		return studentName;
	}

	@Override
	public String toString(){
		return String.format("Name = " + studentName + "\nSSN =" + SSN + "\n");
	}
}
