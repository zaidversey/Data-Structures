import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;

public class Generic <T> implements Comparable <T> {
	
	private T [] objects;
	private int size;
	private int count;
	Scanner input = new Scanner(System.in);
	
	//default constructor
	public Generic(){
		
	} // end of constructor
	
	
	public Generic(int size){
		this.size = size;
		objects = (T[]) new Object [size];
	} // end if con
	
	public void inputData(){
		System.out.println("Enter the data you want to enter into the array");
		T data = (T)input.next();
		objects [count] = data;
		count++;
	}// end of method
	
	public void sort(){
		insertionSort();
	}

	public void insertionSort(){
		//for(int i = 1; i<numEvents; i++){

			T value = objects[count -1];
			int emptySpot = count -1;
			while(emptySpot>0 && isGreater( objects[emptySpot-1],value) == true){
				//while(emptySpot>0 && value.isGreater(events.get(emptySpot - 1))){
				objects[emptySpot] = objects[emptySpot-1];
				emptySpot --;
			}// end of while

			//swap
			objects [emptySpot] =  value;
		//}// end of for loop	

	}// end of method
	
	public boolean isGreater(T lhs, T rhs){
		
		if(lhs.compareTo(rhs)>0)
			return false;
		else
		return true;
	}
	/*
	public int count(T search){
		int count=0;
		
		for(int i=0; i<objects.length; i++){
			if(search == objects[i]){
				count++;
			}
		}// end of for
		
		return count;
	}//end of method
	*/
	
	public String toString(){
		String str = "";
		
		for(int i=0; i<objects.length; i++){
			str +=  objects[i] + " ";
		}
		
		return str;
		
		
	}//end of method


	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}// end of class
