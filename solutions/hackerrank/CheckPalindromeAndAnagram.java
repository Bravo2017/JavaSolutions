package hackerrank;

import java.util.*;

public class CheckPalindromeAndAnagram {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String line = in.nextLine();
		in.close();

		if (checkForPalindrome(line)) {
			System.out.println("YES");
		} else
			System.out.println("NO");

	}

	public static boolean checkForPalindrome(String str) {
		// a string can be a palindrome if it has same characters from the
		// start and end. Thus, there must be even count and one odd count
		// only(odd len)

		// only english letters
		int[] count = new int[26];
		int index = 0;
		for (int i = 0; i < str.length(); ++i) {
			index = str.charAt(i) - 'a';
			count[index]++;
		}
		// test for palindrome
		// if the str.length() is even, count[i] must be even,
		// if the str.length() is odd, only one can be odd, rest is even

		int length = str.length();
		boolean isOdd = !(length % 2 == 0);
		if (isOdd) {
			boolean oneOdd = false;
			for (int i = 0; i < count.length; ++i) {
				if (count[i] % 2 != 0 && oneOdd)
					return false;
				else if (count[i] % 2 != 0 && !oneOdd)
					oneOdd = true;
			}

		} else {
			for (int i = 0; i < count.length; ++i) {
				if (count[i] % 2 != 0)
					return false;
			}
		}
		return true;
	}
}
