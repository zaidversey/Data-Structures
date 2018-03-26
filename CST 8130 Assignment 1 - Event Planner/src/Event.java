/**
 * This class models an Event
 * Author: Zaid Versey
 * Data Fields: 
 *                 date: OurDate - holds a reference to OurDate class 
 *                 time: OurTime - holds a reference to OurTime class
 *                 description: String - holds the description of an event
 *                 
 * Methods: 
 * 			default constructor
 * 			inputEvent: boolean - prompts ensure if input is from a keyboard or a file,
 * 								  and assign appropriate values
 * 			getDate(): OurDate -  returns reference to OurDate
 * 			getTime(): OurTime -  returns reference to OurTime
 * 			isEqual(): boolean -  returns whether the object has same date and time 
 * 			toString(): String -  displays values of Event to string
 */

import java.util.Scanner;

public class Event {

	private OurDate date;
	private OurTime time;
	private String description;

	public Event() {
		date = new OurDate();
		time = new OurTime();

	}// end of constructor

	public Event(OurDate date, OurTime time, String description){
		this.date = date;
		this.time = time;
		this.description = description;
	}

	public boolean inputEvent(Scanner input, String prompt) {
		// reading input from a keyboard
		if(prompt.charAt(0) == 'y') {
			date.inputDate(input, prompt); 
			time.inputTime(input, prompt);
			input.nextLine();//throw away the \n not consumed by nextInt() *** http://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
			System.out.print("Enter event description: ");
			description = input.nextLine();

			// reading input from a file
		}else if(prompt.charAt(0) == 'n') {

			date.setMonth(input.nextInt()); // catch mismatch exceptions
			date.setDay(input.nextInt());
			date.setYear(input.nextInt());
			time.setHour(input.nextInt());
			time.setMinute(input.nextInt());
			description = input.next();
		}// end of if
		return true;
	} // end of method

	public OurDate getDate() { return date; }

	public OurTime getTime() { return time; }

	public boolean isEqual(Event event){
		if(date.isEqual(event.getDate()) == true && time.isEqual(event.getTime()) == true) {
			return true;
		} else {
			return false;
		}

	}// end of method

	public boolean isGreater (Event event) {
		if(this.date.isGreater(event.date)){
			return true;
		}else if(this.date.isEqual(event.date) && this.time.isGreater(event.time)){
			return true;
		}else {
			return false;
		}
	}


	public boolean isLessThan (Event event) {
		if(this.date.isLessThan(event.date)){
			return true;
		}else if(this.date.isEqual(event.date) && this.time.isLessThan(event.time)){
			return true;
		}else {
			return false;
		}
	}


	public String toString() {

		return new String (date.toString() + " " + time.toString() + " " + description);

	}// end of method

}// end of class
