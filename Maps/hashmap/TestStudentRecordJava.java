package hashmap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestStudentRecordJava {
	
	public static void main(String[] args) throws IOException {
		StudentRecord src = new StudentRecord();
		String[] inputToken = null;
		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		File fileName = new File("G:\\coding\\java\\NameUserName.txt"); 
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		
		String line = null;
		System.out.println();

		while ( (line = in.readLine()) != null) {
			inputToken = line.split(" ");
			System.out.println("Input - " + inputToken[0] + " " + inputToken[1]);
		
			//create a student object
			Student stuObj = new Student(inputToken[0], inputToken[1]); 

			src.put(stuObj.getStudentName(), stuObj);
		}
		src.displayMap();
	}
}
