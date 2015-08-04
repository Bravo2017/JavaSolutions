package hashmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestStudentRecordJava {

	public static void main(String[] args) throws IOException {
		StudentRecordII<String, Student> src = new StudentRecordII<String, Student>();
		String[] inputToken = null;

		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));

		File fileName = new File("G:\\coding\\java\\NameUserName.txt");
		BufferedReader in = new BufferedReader(new FileReader(fileName));

		String line = null;
		while ((line = in.readLine()) != null) {
			inputToken = line.split(" ");
			System.out.println("Input - " + inputToken[0] + "\t"
					+ inputToken[1]);

			// create a student object
			Student stuObj = new Student(inputToken[0], inputToken[1]);
			src.put(stuObj.getStudentName(), stuObj);
		}

		System.out.println("\n\n");
		src.displayMap();

		// test if these names are present and return their SSN
		fileName = new File("G:\\coding\\java\\CheckName.txt");
		in = new BufferedReader(new FileReader(fileName));
		while ((line = in.readLine()) != null) {

			Student val = src.get(line);
			if (!(val == null)) {
				System.out.println(val);
			} else {
				System.out.println("Name " + line + " Not Found");
			}
		}
	}
}
