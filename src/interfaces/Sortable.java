package interfaces;

import models.Book;

/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 2.3 / 5/8/2022
 * 
 */
public interface Sortable
{
	/**
	 * Sort by book name.
	 * 
	 * @param books.
	 */

	public void sortByName(Book[] books);

	/**
	 * Sort by books price.
	 * 
	 * @param books
	 */
	public void sortByPrice(Book[] books);

	/**
	 * Sort books by rate.
	 * 
	 * @param fictionList - list of the Fiction objects
	 */
	public void sortByRate(Book[] books);
}
