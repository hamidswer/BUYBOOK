package interfaces;

import models.Book;

/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab
 * 
 *         Other contributors: Allan Schougaard
 * 
 *         Resources:
 * 
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Version/date: 1.2 / 05/15/2022
 * 
 * 
 */
public interface Sortable
{

	/**
	 * Purpose: It uses the Bubble sort algorithm to sort books by name, rate or price.
	 * 
	 * @param books - to be sorted by bubble sort algorithm.
	 * @return sorted array by the bubble sort algorithm.
	 */
	public Book[] bubbleSort(Book[] books);
	
	/**
	 * Purpose: The inOrder method checks if elements of books are sorted or not.
	 * 
	 * @param books - To check if its elements are in order.
	 * @return true if the books in the array are sorted, false if they're not.
	 */
	public boolean inOrder(Book[] books);
	
	/**
	 * Purpose: Get the sorted books.
	 * 
	 * @return sorted books
	 */
	public Book[] getSortedBooks();
}
