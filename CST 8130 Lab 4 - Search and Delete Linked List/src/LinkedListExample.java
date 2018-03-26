import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int task ;
		boolean taskComplete = false;

		LList list = new LList();

		while(!taskComplete){
			try{
				System.out.println("Enter: \n 1 to add item at head \n 2 to delete item at head \n 3 to display the list \n 4 to delete a particular item in list \n 0 to quit");

				task = input.nextInt();

				if(task == 1){
					String name;
					input.nextLine(); // clear scanner
					System.out.println("Enter name to add to list: ");
					name = input.nextLine();
					list.addAtHead(name);
					System.out.println("Name added to list");

				} else if(task == 2) {
					if(list.getHead() == null){
						System.out.println("List is empty, nothing to delete, try again");
					} else {
						LLNode removedOne = list.deleteAtHead();
						System.out.println("After delete, the list is \n");
						list.display();
						System.out.println("The one deleted is..." + removedOne);
					}

				} else if(task == 3) {
					if(list.getHead() == null){
						System.out.println("List is empty, nothing to display, try again");
					} else {
						System.out.println("The list is ");
						list.display();
					}

				} else if(task == 4) {
					String name;
					input.nextLine();
					if(list.getHead() == null){
						System.out.println("List is empty, nothing to delete, try again");
					}else{
						System.out.println("Enter name to delete from list: ");
						name = input.nextLine();
						list.delete(name);
					}
				}else if (task == 0){
					System.out.println("program has quit");
					taskComplete = true;
				} else {
					throw new InputMismatchException();
				}

			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println("Invalid entry please try again");
			}


			}// end of while

			/*
		list.addAtHead("Linda");
		list.addAtHead("George");
		System.out.println("The list is ");
		list.display();

		LLNode removedOne = list.deleteAtHead();
		System.out.println("After delete, the list is ");
		list.display();
		System.out.println("The one deleted is..." + removedOne);
			 */


		}

	}
