package strings;
//Complete Implmentation
public class BasicStringCompression {

	public static void main(String[] args) {
		BasicStringCompression app = new BasicStringCompression();
		String input = "aaaabbbcccaaddeee";
		String compress = app.compressString(input);
		System.out.println(compress);
	}

	// compress string
	public String compressString(String input) {
		int len = input.length();
		int size = compressLength(input); //get length of compressed string
		if (size >= len)
			return input; //no need to compress

		char[] array = new char[size]; //compressed string array
		int index = 0;
		char lastSeen = input.charAt(0);
		int count = 1;
		for (int i = 1; i < len; ++i) {
			if (lastSeen == input.charAt(i)) {
				++count;
			} else {
				index = insertIntoArray(index, array, count, lastSeen);
				lastSeen = input.charAt(i);
				count = 1;
			}
		}
		index = insertIntoArray(index, array, count, lastSeen);
		return new String(array);
	}

	int insertIntoArray(int index, char[] array, int count, char lastSeen) {
		array[index++] = lastSeen;
		//convert the integer into a String - can have more than one char
		String numInStr = String.valueOf(count);
		// pick each char and concatenate into the array
		for (int i = 0; i < numInStr.length(); ++i) {
			array[index++] = numInStr.charAt(i);
		}
		return index;
	}

	/**
	 * find the length of the compressed string mathematically without creating
	 * the String first
	 */
	int compressLength(String str) {
		int size = 0;
		char lastSeen = str.charAt(0);
		int count = 1; // one character seen, start from next char

		for (int i = 1; i < str.length(); ++i) {
			if (lastSeen == str.charAt(i))
				++count; // increment if ith char is same as last seen
			else {
				size += 1; // for the letter
				// convert count to string and get length- for multidigit count
				size += String.valueOf(count).length();// 
				lastSeen = str.charAt(i);// update last seen
				count = 1; // reset count to 1.
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

}
