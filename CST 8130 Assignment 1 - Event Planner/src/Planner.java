/**
 * This class models an event planner, where events an array of type Events is manipulated
 * Author: Zaid Versey
 * Data Fields: 
 *                 events[]: int - array to hold events
 *                 numEvents: int - counter of total number of events
 *                 input: Scanner - 
 *                 task: int - holds user selection for menu 2
 * Methods: 
 * 			   default constructor
 *             addEventFromKeyboard(): - create event from keyboard then add to array
 *             displayOneDay(OurDate) - display events on a particular date
 *             displaySevenDays(OurDate) - display events for a particular week starting on some date
 *             deleteEvent(): - delete an event from array
 *             addeventFromFile(): - add events from file to array
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Planner {

	private ArrayList <Event> events;
	private Scanner input;
	private int numEvents;

	public Planner() {
		input = new Scanner(System.in);
		events = new ArrayList <Event> (1000);
		numEvents = 0;
	} // end of constructor

	public void addEventFromKeyboard() {

		//boolean eventFound = false;
		boolean taskComplete = false;
		Event temp;
		while(!taskComplete) { // while (true)
			System.out.println("Enter the event type to add:");
			System.out.println("1 for a meeting event");
			System.out.println("2 for a school event");
			System.out.println("3 for a work event");
			System.out.println("4 for a social event");

			try{
				//input = new Scanner (System.in); // reset scanner every time to release bad tokens left in the scanner / alternatively input.nextline()
				int task;
				task = input.nextInt();

				if(task == 1) {
					temp = new Meeting();
					//temp.inputEvent(input, "yes"); 
				}else if(task == 2) {
					temp = new School();
				}else if(task == 3) {
					temp = new Work();
				}else if(task == 4) {
					temp = new Social();
				} else {
					throw new InputMismatchException();
				}

				//add data to the object
				temp.inputEvent(input, "yes");

				//compare and insert
				// binary search: is event already exists, else: add the event
				if(binarySearch(temp) != -1){
					System.out.println("You already have an activity for that date and time...event not added");
					break;
				}else {
					events.add(numEvents, temp);
					System.out.println("\nEvent is added to array");
					insertionSort();
					numEvents++;
					taskComplete = true;	
				}

			}catch(InputMismatchException e){
				System.out.println("Error: invalid input, please try again\n");
				input.nextLine(); // clear scanner of bad tokens
				continue;
			}// end of try/catch
			break;
		}// end of while


	} // end of method

	public void displayEventsForDay(OurDate date) {
		boolean dateFound = false;
		System.out.println("\nyour activites for " + date + " are:" );
		for(int i = 0; i<numEvents; i++){
			if(date.isEqual(events.get(i).getDate()) == true) {
				//if(date.isEqual(events[i].getDate()) == true){
				System.out.println(events.get(i));
				dateFound = true;
			}
		}// end of for

		if(dateFound == false){
			System.out.println("No events on this date");
		} // end of if

	} // end of method'

	public void displayEventsForWeek(OurDate date) {

		System.out.println("\nYour events for the week starting on " + date + " are: ");
		int firstIndex = 0;
		int lastIndex = 0;
		OurDate firstDate = new OurDate(date);
		OurDate endDate = new OurDate(date);

		// get End date
		for(int i = 1; i<7; i++){
			endDate.addOne();
		}

		// get first index
		for(int i = 0 ; i<numEvents; i++){
			//if(firstDate.isEqual(events.get(i).getDate()) == true) {
			if(events.get(i).getDate().isEqual(firstDate)){
				firstIndex = i;
				break;
			}else if (events.get(i).getDate().isGreater(firstDate)){
				firstIndex = i ;
				break;
			}else {
				continue;
			}

		}// end of for

		// get last index
		for(int j = 0 ; j<numEvents; j++){
			if(events.get(j).getDate().isEqual(endDate)){
				lastIndex = j;
				break;

				//}else if(endDate.isGreater(events.get(j).getDate())){
			}else if(events.get(j).getDate().isGreater(endDate)){
				lastIndex = j - 1; // index just before the greater event
				break;

			}else{
				continue;
			}
		}

		// print events in week from first index to last index
		for(int i = firstIndex; i<= lastIndex; i++){
			System.out.println("\nyour activites for " + events.get(i).getDate() + " are:" + "\n" + events.get(i) );

		}

	} // end of method

	public void deleteEVent() {

		if (numEvents == 0){
			System.out.println("there is nothing to delete, array is empty ");
		}else{

			OurDate date = new OurDate();
			OurTime time = new OurTime();

			//while(!eventFound){
			System.out.println("Enter date and time of event to delete: ");
			date.inputDate(input, "yes");
			time.inputTime(input, "yes");

			Event temp = new Event(date, time, "");

			int indexToRemove = binarySearch(temp);

			if(indexToRemove != -1){
				events.remove(indexToRemove);
				numEvents -- ;
				System.out.println("Event Deleted!");
			}else {
				System.out.println("There were no Events to Delete");
			}

		}// end of if

	} // end of method

	public void addEventFromFile() {

		String fileName = null;// = input.nextLine();
		File file;// = new File (fileName);
		//Scanner inFile; 

		//boolean eventFound = false;
		Event temp;
		try {
			System.out.println("Enter name of file to process: ");
			fileName = input.nextLine();
			file = new File (fileName);

			if (file.exists()) {
				Scanner inFile = new Scanner(file);	// scanner connected to read input from file			

				while (inFile.hasNext()){ // while scanner has a next line from the file

					int type = inFile.nextInt();
					// meeting
					if(type == 1){
						temp = new Meeting();
					}else if(type == 2) {
						temp = new School();
					}else if(type == 3) {
						temp = new Work();
					}else if(type == 4) {
						temp = new Social();
					}else {
						inFile.close();
						throw new InputMismatchException();
					}// end of if/else

					temp.inputEvent(inFile, "no");

					//compare and insert
					// binary search: is event already exists, else: add the event

					if (binarySearch(temp) != -1){
						System.out.println("You already have an activity for that date and time...Event not added\n");

					}else {
						events.add(numEvents, temp);
						insertionSort();
						numEvents++;
					}

				}// end of while loop

			}else {
				System.out.println("could not open file.... " + fileName );
			}// end of outer if-else
			//inFile.close();
		}catch(InputMismatchException e) {
			System.out.println("Corrupt file, some events may not have been added");
			//inFile.nextLine(); // clears scanner of bad tokens
		} catch(IOException e) {
			System.out.println("Error: try again"); 
		}// end of try catch

	} // end of method

	public int binarySearch(Event target){
		int start= 0;
		int end= numEvents-1; // size() returns # of elements in the arraylist

		while(start <= end){

			// mid point of array
			int mid = (start+end)/2;
			//if(target.isEqual(events.get(mid))) {
			if(events.get(mid).isEqual(target)){
				return mid;
				//return true;
				//} else if(target.isLessThan(events.get(mid))) {
			}else if(events.get(mid).isLessThan(target)){
				start = mid +1;
			} else {
				end = mid -1;
			}
		}// end of while

		// if event does not exist
		return -1;
		//return false;

	}// end of method

	public void insertionSort(){
		//for(int i = 1; i<numEvents; i++){

			Event value = events.get(numEvents);
			int emptySpot = events.size()-1;
			while(emptySpot>0 && events.get(emptySpot-1).isGreater(value)){
				//while(emptySpot>0 && value.isGreater(events.get(emptySpot - 1))){
				events.set(emptySpot, events.get(emptySpot-1));
				emptySpot --;
			}// end of while

			//swap
			events.set(emptySpot, value);
		//}// end of for loop	

	}// end of method

}// end of class