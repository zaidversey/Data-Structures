/**
 * This class models an Event
 * Author: Zaid Versey
 * 
 * Methods: 
 * 			main method - calls functions of the Planner and executes them
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign2 {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		Planner eventPlanner = new Planner();
		OurDate date;
		int task;		

		boolean taskComplete = false;
		while(!taskComplete) {
			System.out.println("\nEnter:");
			System.out.println("1 to add an event to planner from keyboard");
			System.out.println("2 to display events for a day");
			System.out.println("3 to display events for a week");
			System.out.println("4 to delete and event");
			System.out.println("5 to add events to planner from a file");
			System.out.println("0 to quit");

			try {
				//input = new Scanner (System.in);
				task = input.nextInt();

				if(task == 1){
					eventPlanner.addEventFromKeyboard();

				} else if(task == 2) {
					date = new OurDate();
					System.out.println("\nEnter a date to display: ");
					date.inputDate(input, "yes");
					eventPlanner.displayEventsForDay(date);

				} else if(task == 3) {
					date = new OurDate();
					System.out.println("\nEnter a date to display: ");
					date.inputDate(input, "yes");
					eventPlanner.displayEventsForWeek(date);

				} else if(task == 4) {
					eventPlanner.deleteEVent();

				} else if(task == 5) {
					eventPlanner.addEventFromFile();

				} else if(task == 0) {
					System.out.println("program has quit!");
					taskComplete = true;

				} else {
					throw new InputMismatchException();
				}// end of if-else

				continue;
			} catch (InputMismatchException e) {
				System.out.println("Error: incorrect input, please try again");
				input.nextLine();
				continue;// taskComplete = false;		
			}// end of try-catch

		}// end of while loop

	}// end of main

}// end of class
