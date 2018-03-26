import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {

		String fileName = "/Users/zaidversey/Desktop/Lab 1/Events.txt";
		File file = new File (fileName);
		Scanner inFile; 

		try {

			if (file.exists()) {
				inFile = new Scanner(file);	// scanner connected to read input from file			

				while (inFile.hasNextLine()){ // while scanner has a next line

					Scanner inFile2 = new Scanner(inFile.nextLine()); // insures it doesn't get an element form the next line. goes line by line. scanner gets input from each line of the file
					if (inFile2.hasNextInt()){
					System.out.print("type: ");
					System.out.print(inFile2.nextInt());
					} else {
						throw new Exception ();// next element in line
					}
					System.out.print(" month: ");
					System.out.print(inFile2.nextInt());
					System.out.print(" day: ");
					System.out.print(inFile2.nextInt());
					System.out.print(" year: ");
					System.out.print(inFile2.nextInt());
					System.out.print(" hour: ");
					System.out.print(inFile2.nextInt());
					System.out.print(" minute: ");
					System.out.print(inFile2.nextInt());
					System.out.print(" description: ");
					System.out.print(inFile2.next());
					System.out.print(" extra: ");
					if (inFile2.hasNext()){
						System.out.println(inFile2.next());
					} else {
						System.out.println("");
					}// end of if
				}// end of while loop
				inFile.close();
			}// end of if statement
		} catch (IOException e) {
			System.out.println("Could not open file...." + fileName + "exiting"); 
		} catch (Exception e){
			System.out.println("error");
		}
	}// end of main
}// end of class
