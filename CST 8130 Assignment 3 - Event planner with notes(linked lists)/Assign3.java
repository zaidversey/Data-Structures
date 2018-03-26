/*
 * Author: Linda Crane revised by Zaid Versey
 * Purpose: Provides user interaction for the user and planner
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Assign3 {
	public static void main(String[] args) {


		Scanner in = new Scanner (System.in);
		Scanner inFile = null;
		Planner planner = new Planner();
		OurDate displayDate = new OurDate();

		int menuChoice = 1;


		while (menuChoice !=0 ) {
			// loop to enter valid MenuChoice...
			do {

				System.out.print( "\nEnter: \n1 to add an event to planner from keyboard;  ");
				System.out.print( "\n2 to display events for a day;  ");
				System.out.print( "\n3 to display events for a week;  ");
				System.out.print( "\n4 to delete an event; ");
				System.out.print( "\n5 to add events to planner from a file;  ");
				System.out.print( "\n6 to add a note to an event;  ");
				System.out.print( "\n7 to delete a note from an event;  ");
				System.out.print( "\n0 to quit: ");

				if (in. hasNextInt())
					menuChoice = in.nextInt();
				else {
					in.next();
					System.out.println("Invalid menu choice....reenter: ");
					menuChoice = -1;
				}
			} while (menuChoice < 0 || menuChoice > 7);


			if (menuChoice == 1) {
				planner.inputEvent(in, "yes");
				System.out.println (planner);
			} else if (menuChoice == 2) {
				System.out.println ("Enter a date to display: ");
				if (displayDate.inputDate(in, "yes")) 
					planner.displayOneDay(displayDate);
			} else if (menuChoice == 3) {
				System.out.println ("Enter a date to display: ");
				if (displayDate.inputDate(in, "yes"))
					planner.displaySevenDays(displayDate);
			} else if (menuChoice == 4) {
				planner.deleteEvent(in, "yes");
			} else if (menuChoice == 5) {
				inFile = openFile(in);
				if (inFile != null) {
					while (inFile.hasNext())
						planner.inputEvent(inFile, "no");
					System.out.println (planner);
				}
			} else if (menuChoice == 6) {
				//in.nextLine();
				planner.addNotes(in);
			} else if (menuChoice == 7) {
				//in.nextLine();
				planner.deleteNote(in);
			}

		}


	}

	//********************openFile*********************************
	public static Scanner openFile(Scanner in) {
		String fileName = new String();
		Scanner inFile = null;

		System.out.print("\n\nEnter name of file to process: ");
		fileName = in.next();

		File file = new File(fileName);
		try {
			if (file.exists()) {
				inFile = new Scanner(file);
			}
			else System.out.println ("File does not exist.....");
			return inFile;
		} catch (IOException e) {
			System.out.println("Could not open file...." + fileName + "exiting");
			return null;
		}
	}// end openFile method

}
