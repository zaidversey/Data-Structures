import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReaderv2 {

	public static void main(String[] args) {

		String fields [] = {"type: ", "month: ", "day: ", "year: ", "hour: ", "minute: ", "description: ", "extra: " };
		String fileName = "/Users/zaidversey/Desktop/Lab 1/Events.txt";
		File file = new File (fileName);
		Scanner inFile; 

		try {

			if (file.exists()) {
				inFile = new Scanner(file);	// scanner connected to read input from file			

				while (inFile.hasNextLine()){ // while scanner has a next line

					Scanner inFile2 = new Scanner(inFile.nextLine()); //scanner connected to each line in the file. each line is the input for the scanner.

					for (int i = 0; i < fields.length; i++){
						
						System.out.print(fields[i]);
						
						if (inFile2.hasNext()){
							System.out.print(inFile2.next() + " ");
						}else{
							System.out.print("");
						} // end of if
					}// end of for loop
					System.out.println("");
				}// end of while loop
				inFile.close();
			}// end of if statement
		} catch (IOException e) {
			System.out.println("Could not open file...." + fileName + "exiting"); 
		}// end of try catchs
	}// end of main
}// end of class

