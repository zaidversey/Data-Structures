import java.util.InputMismatchException;
import java.util.Scanner;


public class BracketsBalance {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int task ;
		boolean taskComplete = false;

		while(!taskComplete){
			LList list = new LList(); // inside while loop to refresh loop
			try{
				System.out.println("Enter: \n 1 to add an expression or \n 0 to quit");

				task = input.nextInt();

				if(task == 1){
					String expression; // expression to compare
					int extraBracket = 0; // extra bracket counter
					input.nextLine(); // clear scanner
					
					System.out.println("Enter the expression: ");
					expression = input.nextLine();
					
					/* go through linked list find matching braces and delete;*/
					for(int i = 0; i<expression.length(); i++){
						if(expression.charAt(i) == '{' ){
							list.addAtHead('{');
						} else if(expression.charAt(i) == '}' ){
							
							if(list.isEmpty() == false) {
								list.deleteAtHead();
							} else {
								extraBracket++;
							}
							
						}// end of outer if	
					}// end of for
					
					/* if list is empty and extraBracket is 0 then it is balanced 
					 * if extra bracket then increment 
					 * */
					if(list.isEmpty() == true && extraBracket == 0){
						System.out.println("The expression is balanced");
					}else{
						System.out.println("The expressino is NOT balanced");
					}
					/*
					String expression2 = list.getBrackets();
					String expression3 = "";
					for(int j = expression2.length() - 1; j>=0; j--) {
						expression3 += expression2.charAt(j);
					}
					
					System.out.println("brackets are: " + expression3);
					*/
						
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

	}
	
}
