/**   This class models an event.
 *	  Author: Linda Crane revised by Zaid Versey.
 *    Assignment 3 update - :added LinkedList <String>
 *    						:added inputNotes method, deleteNotes method, and displayNotes method
 *    						:changed inputEvent method
 *    
 *	  Data fields:   date:  OurDate - the day/month/year of the event
 *                   time: Time - the hour/minute that event starts at
 *					 description: String - a description of event
 *					 notes: LinkedList <String> - adds notes to the event
 *				
 *    Methods:  default constructor
 *				initial constructors
 *              getDate: OurDate - returns date of event
 *				getTime: Time - returns time of event
 *			
 *              toString: String - displays event to a String
 *              inputEvent (Scanner, String): boolean - prompts (if String parameter starts with 'y') input 
 *                                             			from Scanner parameter  for all data fields
 *                                             
 *                                            			calls inputNotes method for note input
 *              inputNotes(Scanner in, String prompt): boolean - :prompts (is string parameter starts with 'y') input
 *              										 		  from Scanner parameter for all data fields
 *              										
 *              												 :takes note information from the user/file and adds the note(s) to the Linked List
 *              deleteNotes(Scanner in): void - displays the notes currently in the linked list with index, ask the user which index to delete
 *              								(Scanner parameter), and deletes it from the linked list
 *              displayNotes(): int - displays the current notes in the linked list           
 *              isEqual (Event): boolean - compares date and time in two objects and returns true/false if they are equal 
 *           ** isGreater (Event): boolean - compares date and time in two objects and returns true if object in class (this)
 *                                           is greater than parameter object; else returns false                               
 */
import java.util.*;
public class Event {
	private OurDate date = new OurDate();
	private OurTime time = new OurTime();
	private String description = new String();
	private LinkedList <String> notes = new LinkedList<String>();

	public Event() {
	}
	public Event (OurDate date, OurTime time, String description){
		this.date = new OurDate(date);
		this.time = new OurTime (time);
		this.description = new String (description);
	}
	public Event (int day, int month, int year, int hour, int minute, String description){
		this.date = new OurDate (day, month, year);
		this.time = new OurTime (hour, minute);
		this.description = new String (description);
	}

	// get methods
	public OurDate getDate() { return date;}
	public OurTime getTime() { return time; }



	// accessor methods and mutators
	public String toString() {

		String notesToString = new String("");

		for(int i = 0; i < notes.size(); i++){
			notesToString += notes.get(i); 
			if(i != notes.size()-1){
				notesToString += ", ";
			}
		}

		return new String("     " + date + " " + time + " " + description + "\n \t[" + notesToString + "]");
	}

	//***********************EVENTS************************
	public boolean inputEvent(Scanner in, String prompt) {

		if (!date.inputDate(in, prompt)) {
			return false;
		}
		if (!time.inputTime(in,prompt)) {
			return false;
		}


		if (prompt.charAt(0) == 'y')
			System.out.print ("Enter event description: ");
		this.description = in.next();
		if((inputNotes(in,prompt) == false)){
			return false;
		}
		return true;
	}
	//***********************END EVENTS********************


	//************************NOTES*************************
	public boolean inputNotes(Scanner in, String prompt){
		int times = -1;
		String note = "";
		boolean correctIn = false;

		while(!correctIn) {
			if(prompt.charAt(0)=='y')
				System.out.println("How many notes would you like to add?: ");

			if(in.hasNextInt()){
				times = in.nextInt();
				if(times < 0){
					return false;
				}

				for(int i = 0; i < times; i++) {
					if(prompt.charAt(0)=='y')
						System.out.println("Enter note:");

					note = in.next();
					notes.add(note);
				}
				System.out.println ("Note(s) added");
				correctIn = true; // break while loop

			} else {

				if(prompt.charAt(0) == 'y') { // if input is from the keyboard, keep asking user to enter again until valid input
					System.out.println("Invalid input, please try again");
					in.next();
				}else { // if the input is from a file, than just return false and go to next line - this event will not be added tothe arraylist
					System.out.println("Invalid note input, event not added");
					in.nextLine();
					return false;
				}// end of inner if/else in outer else

			}// end of outer if

		}// end of while loop

		return true;

	}//end of method


	public void deleteNotes(Scanner in){
		int indexToDelete = -1;
		int maxIndex;
		boolean correctIndex = false;

		// if linked list is empty
		if(notes.isEmpty()){
			System.out.println("There are no notes associated with this event, cannot delete");
			return;
		}

		//display current notes with index, and retrieve max index 
		maxIndex = displayNotes();

		//ask user which index to delete, and delete note at that index
		while(!correctIndex){
			System.out.println("Enter which note to delete");

			// if the input is a valid character, i.e an int
			if(in.hasNextInt()){
				indexToDelete = in.nextInt();

				in.nextLine();

				// if index to delete is inside the range of the linked list index (0 - maxIndex), than remove the note at that index
				if (indexToDelete <= maxIndex && indexToDelete > -1){ 
					notes.remove(indexToDelete);
					System.out.println("Note deleted");
					correctIndex = true;// breaks out of while loop
				} else {
					System.out.println("Invalid input, please try again");
				} // end of inner if

			}else {
				System.out.println("Invalid input, please try again");
				in.next();
			}// end of outer if

		}// end of while

	}// end of method 

	public int displayNotes(){
		int i;
		System.out.println("Current notes for this event are:");

		for(i = 0; i < notes.size(); i++){
			System.out.println( i + ": " + notes.get(i));
		}

		return i - 1;

	}
	//************END OF NOTES******************

	public boolean isEqual (Event rhs) {
		return (this.date.isEqual(rhs.date) && this.time.isEqual(rhs.time));
	}

	public boolean isGreater (Event rhs) {
		if (this.date.isGreater (rhs.date))
			return true;
		else if (this.date.isEqual(rhs.date) && this.time.isGreater (rhs.time))
			return true;
		return false;

	}



}
