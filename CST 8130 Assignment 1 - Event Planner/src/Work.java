/**
 * This class models an Event
 * Author: Zaid Versey
 * Data Fields: 
 *                 
 *                 length:int - holds the work duration of this type of event
 *                 
 * Methods: 
 * 			default constructor
 * 			inputEvent: boolean - prompts ensure if input is from a keyboard or a file,
 * 								  and adds to same method in super the length value
 * 			
 * 			toString(): String -  displays values of Event to string
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Work extends Event{

	private int length;

	public Work() {
		super();
	}// end of constructor

	public boolean inputEvent(Scanner input, String prompt){
		super.inputEvent(input, prompt);
		boolean taskComplete = false;
		while(!taskComplete){

			if(prompt.charAt(0) == 'y') {

				try{
					System.out.print("Enter lenght of shift: ");
					length = input.nextInt();
					taskComplete = true;

				}catch(InputMismatchException e) {
					System.out.println("\nInvalid input, enter shift again\n");
					input.nextLine();
					continue;
				}// end of try catch

			}else if(prompt.charAt(0) == 'n') {
				length = input.nextInt();
				taskComplete = true;
			} 
		}// end of while
		return true;
	}// end of method


	public String toString() {
		return super.toString() + " " + length;
	}

}// end of class
