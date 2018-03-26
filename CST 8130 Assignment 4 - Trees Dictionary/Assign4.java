/*
 * 	  Purpose: Provides user interaction for the user and the dictionary
 *	  Author: Zaid Versey.
 *	  Date: April 5 2017
 *	  Section: CST 8130

 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Assign4 {
	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		Scanner inFile = null;
		Dictionary dictionary = new Dictionary();

		int menuChoice = 1;


		while (menuChoice !=0 ) {
			// loop to enter valid MenuChoice...
			do {

				System.out.print( "\nEnter: \n1 to to clear dictionary, ");
				System.out.print( "\n2 to add text from keyboard, ");
				System.out.print( "\n3 to add text from file, ");
				System.out.print( "\n4 to search for word count, ");
				System.out.print( "\n5 to display number of nodes,  ");
				System.out.print( "\n6 to quit,\n");

				if (in. hasNextInt())
					menuChoice = in.nextInt();
				else {
					in.next();
					System.out.println("Invalid menu choice....reenter: ");
					menuChoice = -1;
				}
			} while (menuChoice < 0 || menuChoice > 6);


			if (menuChoice == 1) {
				dictionary.resetTree();
				System.out.println("The dictionary has been reset.");

			} else if (menuChoice == 2) {
				dictionary.inputWord(in, 'y');
			} else if (menuChoice == 3) {
				inFile = openFile(in);
				if (inFile != null) {
					while (inFile.hasNext())
						dictionary.inputWord(inFile, 'n');
				}
			} else if (menuChoice == 4) {
				dictionary.countWords(in);
			} else if (menuChoice == 5) {
				System.out.println("There are " + dictionary.numNodes() + " nodes");
			} else if (menuChoice == 6) {
				menuChoice = 0;
				System.out.println("Program has quit!");
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
