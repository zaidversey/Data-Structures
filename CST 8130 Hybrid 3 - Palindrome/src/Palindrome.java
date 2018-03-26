import java.util.Scanner;

public class Palindrome {

	String backwards = "";

	public void testPalindrome(String forwards, int i) {

		backwards = backwards + forwards.charAt(i);

		if(backwards.length() == forwards.length()){

			if(forwards.equals(backwards)) {
				System.out.println("String is a palindrome! :)");
			}else {
				System.out.println("String is not a palindrome! :(");
			}

		}else {
			i--;
			testPalindrome(forwards, i);
			//System.out.println(backwards);
		}

	}// end of method

	public static void main(String args[]) {
		String input1;
		String test = "";

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a string to see if it's a palindrome");
		input1 = input.nextLine();

		for(int i = 0; i<input1.length(); i++){
			if(Character.isLetter(input1.charAt(i)) || Character.isDigit(input1.charAt(i))){
				test = test + input1.charAt(i);
			}
		}
		Palindrome palindrome = new Palindrome ();
		palindrome.testPalindrome(test, test.length() -1);
	}
}	

