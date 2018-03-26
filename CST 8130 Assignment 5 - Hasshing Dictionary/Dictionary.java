/**   Purpose: This class models a dictionary.
 *	  Author: Zaid Versey.
 *	  Date: April 5 2017
 *	  Section: CST 8130
 *    
 *	  Data fields:   dictionary: ArrayList<DicitionaryEntry> hashTable - Holds the words entered by the keyboard or file, 
 *															and how many times each word occurs
 *    Methods:  default constructor - initializes the array to null values
 *    updated:  resethashTable : void - clears the dictionary (hash table) of all entries
 *              hash(String word): void - reads in a string and uses a hash algorithm to return an a value that can be used as 
 *              						  an index for the hashTable(arrayList)
 *              setSize(Scanner in): void: set the size of a new ArrayList and initializes the ArrayList
 *	  updated:	inputWord(Scanner in, char prompt): boolean - inputs a dictionaryEntry and handles collisions
 *	  updated:	countWords (Scanner in): void - searches the dictionary(hashTable) for the word and return how many times it occurs
 *				numEntries(): int - returns the number of entries in the dictionary (hashTable)           
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	private ArrayList<DictionaryEntry> hashTable; 
	private int size = 15000;
	private int numEntries = 0;

	public Dictionary() {
		hashTable = new ArrayList<DictionaryEntry> (size);
		resetHashTable();
	}// end of constructor

	public void resetHashTable(){
		hashTable.clear();
		for(int i = 0; i < size; i++){
			hashTable.add(i, null);
		}
		numEntries = 0;
	}// end of method
	
	public void setSize(Scanner in){
		do{
			System.out.println("Please enter the size of the Data Structure:");
			if(in.hasNextInt()){
				size = in.nextInt();
			}else{
				in.next();
				System.out.println("incorrect input, try again");
				size = -1;
			}
		}while(size < 0);
		hashTable = new ArrayList<DictionaryEntry> (size);
		resetHashTable();
	}

	public int hash(String word){
		int total = 0;
		for(int i = 0; i < word.length(); i++){
			total += (int)word.charAt(i); // type case to int - casts char to an int
		}

		return total%size;
	}// end of method

	/* if index = null, add word at index, else handle
	 * if word at index == word: increment word count
	 * if word at index != word, and does not exist somewhere else: collision - find next empty spot to store word - index++
	 * if word at index != word, but word exists somewhere else: find word and increment word count
	 * if index >= SIZE: output message
	 */
	public boolean inputWord(Scanner in, char prompt) {
		int index; // where the word will go in the hashTable

		DictionaryEntry entry = new DictionaryEntry();
		if(!entry.inputWord(in, prompt))
			return true; // if it returns false, don't add entry to hashTable but keep executing

		index = hash(entry.getWord());

		while(index < size && (hashTable.get(index) != null) ){

			if(hashTable.get(index).isEqual(entry)){
				hashTable.get(index).incrCount();
				return true;
			}// end of if
			index++;
		}

		if(index >= size){
			System.out.println("word cannot be entered");
			return false;
		}

		hashTable.set(index, entry);
		numEntries++;

		return true;

	}// end of method

	public void countWords(Scanner in){
		if(numEntries == 0){
			System.out.println("The dictionary is empty");
			return;
		}

		String word;
		int index;

		System.out.println("Enter word to search for: ");

		DictionaryEntry entry = new DictionaryEntry (in, 'n');
		word = entry.getWord();

		if(word.isEmpty()){
			System.out.println("This type of word cannot be found, as it would never be in the dictionary");
			return;
		}
		
		index = hash(word);

		while(hashTable.get(index) != null){
			if(hashTable.get(index).isEqual(entry)){
				System.out.println(hashTable.get(index).toString());
				return;
			}// end of if
			index++;
		}

		System.out.println("Word does not occur in the data structure");

	}// end of method

	public int numEntries(){
		return numEntries;
	}// end of method

}// end of class
