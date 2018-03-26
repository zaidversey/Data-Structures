/**   Purpose: This class models a dictionary.
 *	  Author: Zaid Versey.
 *	  Date: April 5 2017
 *	  Section: CST 8130
 *    
 *	  Data fields:   dictionary: TreeMap<String, Integer> - Holds the words entered by the keyboard or file, 
 *															and how many times each word occurs
 *    Methods:  default constructor
 *              resetTree : void - clears the dictionary (tree) of all nodes
 *				inputWord (Scanner in, char prompt): void - inputs a word form the keyboard or file into the dictionary
 *              formatString (String word): String - changes the parameter word to lower case and removes all non-word characters
 *              countWords (Scanner in): void - searches the dictionary for the word and return how many times it occurs
 *              numNodes() : int : returns the number of nodes in the dictionary tree
 */

import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
	private TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();

	public Dictionary() {};

	public void resetTree(){
		dictionary.clear();
	}// end of method


	public void inputWord(Scanner in, char prompt) {
		String key; // word is the key
		int value; // how many times the word occurs
		if(prompt == 'y')
			System.out.println("Enter word to add to dictionary");

		key = formatString(in.next());
		if(key.isEmpty())
			return;

		if(dictionary.containsKey(key)){
			value = dictionary.get(key);
			value ++;
			dictionary.replace(key, value);
			return;
		}

		dictionary.put(key, 1);

	}// end of method

	public String formatString(String word){
		word = word.replaceAll("\\W", "");
		word = word.toLowerCase();
		return word;
	}// end of method


	public void countWords(Scanner in){
		if(dictionary.isEmpty()){
			System.out.println("The dictionary is empty");
			return;
		}
		String key;
		int numWords = 0;

		System.out.println("Enter word to search for: ");
		key = formatString(in.next());

		if(dictionary.containsKey(key))
			numWords = dictionary.get(key);

		System.out.println(key + " occurs " + numWords + " time(s).");

	}// end of method

	public int numNodes(){
		return dictionary.size();
	}// end of method

}// end of class
