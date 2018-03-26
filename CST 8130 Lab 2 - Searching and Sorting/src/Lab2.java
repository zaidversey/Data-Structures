import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {


		public static void main(String[] args) {

			Scanner input = new Scanner (System.in);
			Generic <Float>numbers = new Generic<Float>();
			int size;
			int task;		

			boolean taskComplete = false;
			while(!taskComplete) {
				System.out.println("\nEnter:");
				System.out.println("1 to create an array of new size,");
				System.out.println("2 to enter data into array,");
				System.out.println("3 to sort array");
				System.out.println("4 to display array");
				System.out.println("0 to quit");

				try {
					//input = new Scanner (System.in);
					task = input.nextInt();

					if(task == 1){
						System.out.println("Enter new size");
						size = input.nextInt();
						numbers = new Generic<Float>(size);

					} else if(task == 2) {
						
						numbers.inputData();
					} else if(task == 3) {
						numbers.sort();
					} else if(task == 4) {
						System.out.println(numbers.toString());
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
				} catch (NullPointerException e){// end of try-catch
					System.out.println("Something went wrong, please try again");
					continue;
				}
			}// end of while loop

		}// end of main
}// end of class
