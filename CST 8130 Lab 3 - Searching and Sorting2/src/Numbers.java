import java.util.Random;
import java.util.Scanner;

public class Numbers {

	private Integer [] numbers;
	private int size;
	Scanner input = new Scanner(System.in);

	//default constructor
	public Numbers(){

	} // end of constructor


	public Numbers(int size){
		this.size = size;
		numbers = new Integer[size];
	} // end if con

	public void generateNumbers(){
		Random rand = new Random ();
		//int randomNumber = rand.nextInt(100)
		for(int i = 0; i<numbers.length; i++){
			numbers[i] = rand.nextInt(101);
		}// end of for

	}// end of method

	public int count(int search){
		int count=0;

		for(int i=0; i<numbers.length; i++){
			if(search == numbers[i]){
				count++;
			}
		}// end of for

		return count;
	}//end of method

	public String toString(){
		String str = "";

		for(int i=0; i<numbers.length; i++){
			str +=  numbers[i] + " ";
		}

		return str;


	}//end of method

	public void sort(){
		quickSort(0,numbers.length-1);
	}

	public void quickSort(int start, int end){
		if (start>=end){
			return;
		}

		int pivot = start;
		int left = start + 1;
		int right = end;		

		while(left<right){
			//partition
			while((numbers[left]<numbers[pivot]) && (left<right)){
				left ++;
			}//end
			while((numbers[right]>numbers[pivot]) && (left<right)){
				right --;
			}//end

			//swap
			int temp = numbers [left];
			numbers[left] = numbers[right];
			numbers[right] = temp;

			if (left < right) {
				left++;
				right--;
			}
		}// end of while

		if (numbers[left] > numbers[pivot]){ // move pivot and call recursively
			int temp = numbers[pivot];
			numbers[pivot] = numbers[left-1];
			numbers[left-1] = temp;
			quickSort (start, left-2); // sorts left side
			quickSort (left, end); // sorts right side
		} else {
			int temp = numbers[pivot];
			numbers[pivot] = numbers[left];
			numbers[left] = temp;
			quickSort (start, left-1); // sorts left side, 
			quickSort (left+1, end); // sorts right side;
		}

	}// end of method


}// end of class
