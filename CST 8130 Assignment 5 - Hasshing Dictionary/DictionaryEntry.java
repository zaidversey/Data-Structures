/**	  Purpose: This class models a dictionary.
 *	  Author: Zaid Versey.
 *	  Date: April 5 2017
 *	  Section: CST 8130
 *    
 *	  Data fields:   word: String - stores the word for the entry
 *					 numWords: int - stores how many times this word occurs in the dictionary
 *    
 *    Methods:  	 default constructor
 *    				 initial constructor - calls inputWord();
 *    				 getWord: String - returns the word
 *    				 getCount: int - returns how many times the word occurs
 *    				 incrCount: void - increments count
 *					 inputWord (Scanner in, char prompt): void - inputs a word form the keyboard or file into the variable word and handles
 *						   										 duplicate words
 *              	 formatString (String word): String - changes the parameter word to lower case and removes all non-word characters 
 *              	 isEqual(DictionaryEntry): boolean - checks whether and object of this class have the same word an another object of this class
 */

import java.util.Scanner;

public class DictionaryEntry {
	private String word;
	private int numWords = 0;

	public DictionaryEntry(){

	}

	public DictionaryEntry(Scanner in, char prompt){ //default constructor
		inputWord(in, prompt);
	}
	
	public String getWord(){
		return word;
	}// end of method
	
	public int getCount(){
		return numWords;
	}// end of method
	
	public void incrCount(){
		numWords++;
	}
	
	public boolean inputWord(Scanner in, char prompt){
		if(prompt == 'y')
			System.out.println("Enter word to add to dictionary");

		word = formatString(in.next());
		if(word.isEmpty())
			return false;	
		
		incrCount();

		return true;
	}//end of method
	
	public String formatString(String word){
		word = word.replaceAll("\\W", "");
		word = word.toLowerCase();
		return word;
	}// end of method

	public boolean isEqual(DictionaryEntry entry){
		if(this.word.equals(entry.getWord()))
			return true;
		else
			return false;
	}// end of method\
	
	public String toString(){
		String s = word + " occurs " + numWords + " time(s).";
		return s;
	}

}// end of class
