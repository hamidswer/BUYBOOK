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
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 2.4 / 05/12/2022
 * 
 * 
 */
public interface Sortable
{
	/**
	 * Sort by books' name.
	 * 
	 * @param books.
	 */

	public void sortByName(Book[] books);

	/**
	 * Sort by books' price.
	 * 
	 * @param books
	 */
	public void sortByPrice(Book[] books);

	/**
	 * Sort by books' rate.
	 * 
	 * @param fictionList - list of the Fiction objects
	 */
	public void sortByRate(Book[] books);
}
