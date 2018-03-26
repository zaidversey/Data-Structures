/**
 * This class models an Event
 * Author: Zaid Versey
 * Data Fields: 
 *                 
 *                 location: String - holds the location of this type of event
 *                 
 * Methods: 
 * 			default constructor - calls super constructor
 * 			inputEvent: boolean - prompts ensure if input is from a keyboard or a file,
 * 								  and adds to same method in super the location value
 * 			
 * 			toString(): String -  displays values of Event to string
 */

import java.util.Scanner;

public class Meeting extends Event {

	private String location;
	public Meeting() {
		super();
	}// end of constructor


	public boolean inputEvent(Scanner input, String prompt){
		super.inputEvent(input, prompt);
		if (prompt.charAt(0) == 'y'){
			System.out.print("Enter event location: ");
			location = input.nextLine();
		}else if(prompt.charAt(0) == 'n'){
			location = input.next();
		}
		return true;
	}


	public String toString() {
		return super.toString() + " " + location;
	}

}// end of class
