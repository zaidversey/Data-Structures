import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int task ;
		boolean taskComplete = false;

		//LList list = new LList();

		while(!taskComplete){
			LList list = new LList(); // inside while loop to refresh loop
			try{
				System.out.println("Enter: \n 1 to add an item or \n 0 to quit");

				task = input.nextInt();

				if(task == 1){
					String name;
					input.nextLine(); // clear scanner
					System.out.println("Enter name to add to list: ");
					name = input.nextLine();
					for(int i = 0; i<name.length(); i++){
						list.addAtHead(name.charAt(i));
					}
					
					String listName = list.getListName();
					
					if(name.equals(listName)){
						System.out.println("Is palindrome");
					}else {
						System.out.println("is not palindrome");
					}
					
					System.out.println("the name in the list becomes: " + listName);
					
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
