package strings;
import java.io.IOException;

/**
 * replaceLetter() used a char[] for all string manipulations, 
 * replaceLetter2() uses string method string.charAt(). 
 * both build a new char array with modified chars
 * Performance
 * for a very long string, replaceLetter() has twice better performce(half time)
 * to do the operation,
 * 
 * Algorithmically, replaceLetter() is 3xO(n)
 * replaceLetter2() is 2xO(n)
 */

public class ReplaceChar {

	public static void main(String[] args) throws IOException {
		String testString = new String("Hello Mr How Do You DO TOO");
		
		/*read from an input file - and test performance*/

//		String path = "E:\\Programming\\java\\passage.txt";
//		File fileName = new File(path); 
//		FileReader fr = new FileReader(fileName);
//		BufferedReader in = new BufferedReader(fr);
//		String testString = in.readLine();
//		System.out.println("Length " + testString.length());
//		long startTime = System.nanoTime();
//		replaceLetters2(testString);
//		long endTime = System.nanoTime();
//		System.out.println("Time = " + (endTime - startTime));
	
		
		System.out.println(replaceLetters(testString));
	}
	
	public static String replaceLetters(String someString){
		int length = someString.length();
		char[] arr = someString.toCharArray(); //for faster performance - O(n)
		
		//scan the string once to find the number of spaces
		int _spaces = 0;
		for(int i = 0 ; i < length ; ++i){  // O(n)
			if(arr[i] == ' ') ++_spaces;
		}
		
		//scanning and replacing - O(n) 
		int newLength = length + 2*_spaces;
		char[] arrNew = new char[newLength];
		
		for(int i = length-1, j = newLength-1 ; ( i >= 0 && j >= 0 ); --i){
			if(arr[i] == ' '){
				arrNew[j--] = '0';
				arrNew[j--] = '2';
				arrNew[j--] = '%';
			}else{
				arrNew[j--] = arr[i];
			}
		}
		return new String(arrNew);
	}
	
	//assuming this to be fast - with 3xO(n)
	/*public static void replaceLetters(String someString){
		int length = someString.length();
		char[] arr = someString.toCharArray(); //for faster performance - O(n)
		
		//scan the string once to find the number of spaces
		int _spaces = 0;
		for(int i = 0 ; i < length ; ++i){  // O(n)
			if(arr[i] == ' ') ++_spaces;
		}
		
		//scanning and replacing - O(n) 
		int newLength = length + 2*_spaces;
		char[] arrNew = new char[newLength];
		
		for(int i = 0, j = 0 ; ( i < length && j < newLength ); ++i){
			if(arr[i] == ' '){
				arrNew[j++] = '%';
				arrNew[j++] = '2';
				arrNew[j++] = '0';
			}else{
				arrNew[j++] = arr[i];
			}
		}
		//return new String(arrNew);
	}*/	
	
	public static String replaceLetters2(String someString){
		int length = someString.length();
		
		//scan the string once to find the number of spaces
		int _spaces = 0;
		for(int i = 0 ; i < length ; ++i){  // O(n)
			if(someString.charAt(i) == ' ') ++_spaces;
		}
		
		//scanning and replacing - O(n) - StringBuilders definitely have 
		//poor performance than char[] , so no need to test
		int newLength = length + 2*_spaces;
		char[] arrNew = new char[newLength];
		
		for(int i = 0, j = 0 ; i < length && j < newLength ; ++i){
			if(someString.charAt(i) == ' '){
				arrNew[j++] = '%';
				arrNew[j++] = '2';
				arrNew[j++] = '0';
			}else{
				arrNew[j++] = someString.charAt(i);
			}
		}
		return new String(arrNew);
	}
}
