import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {


		public static void main(String[] args) {

			Scanner input = new Scanner (System.in);
			Numbers numbers = new Numbers();
			int size;
			int task;		

			boolean taskComplete = false;
			while(!taskComplete) {
				System.out.println("\nEnter:");
				System.out.println("1 to create an array of new size,");
				System.out.println("2 to generate random numbers into array,");
				System.out.println("3 to count a value");
				System.out.println("4 to display array");
				System.out.println("5 to sort array");
				System.out.println("0 to quit");

				try {
					//input = new Scanner (System.in);
					task = input.nextInt();

					if(task == 1){
						System.out.println("Enter new size");
						size = input.nextInt();
						numbers = new Numbers(size);

					} else if(task == 2) {
						numbers.generateNumbers();
						System.out.println("Numbers have been generated");
					} else if(task == 3) {
						System.out.println("Enter number to search for:");
						int search = input.nextInt();
						System.out.println("The are " + numbers.count(search)+ " of the number " + search);
					} else if(task == 4) {
						System.out.println(numbers.toString());
					} else if(task == 5) {
						numbers.sort();
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
