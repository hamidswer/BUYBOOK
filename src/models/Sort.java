package models;

import java.util.Arrays;
import java.util.Comparator;
import interfaces.Sortable;

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
 *         Version/date: 1.3 / 05/12/2022
 * 
 * 
 */
// A Sort is-a Sortable.
public class Sort implements Sortable
{
	// Sort has-a name.
	private String name;

	// Sort has-a booksByCategory.
	private Book[] booksByCategory;

	public Sort(String name, Book[] booksByCategory)
	{
		this.name = name;
		this.booksByCategory = booksByCategory;
	}

	/**
	 * Get books based on their genre.
	 * 
	 * @return books
	 */
	public Book[] getSorted()
	{

		switch (name)
		{
		case "Name":

			// Initialize books.
			sortByName(booksByCategory);
			break;

		case "Price":

			// Initialize books.
			sortByPrice(booksByCategory);
			break;

		case "Rate":

			// Initialize books.
			sortByRate(booksByCategory);
		}

		return booksByCategory;
	}

	/**
	 * Sort by book name.
	 * 
	 * @param books.
	 */

	public void sortByName(Book[] books)
	{

		Arrays.sort(books, new Comparator<Object>()
		{
			public int compare(Object i1, Object i2)
			{
				return ((Book) i1).getName().compareTo(((Book) i2).getName());
			}
		});
	}

	/**
	 * Sort by books price.
	 * 
	 * @param books
	 */
	public void sortByPrice(Book[] books)
	{
		Arrays.sort(books, new Comparator<Object>()
		{
			public int compare(Object i1, Object i2)
			{
				return ((Book) i1).getPrice() - ((Book) i2).getPrice();
			}
		});
	}

	/**
	 * Sort books by rate.
	 * 
	 * @param fictionList - list of the Fiction objects
	 */
	public void sortByRate(Book[] books)
	{
		Arrays.sort(books, new Comparator<Object>()
		{
			public int compare(Object i1, Object i2)
			{
				return ((Book) i2).getRate() - ((Book) i1).getRate();
			}
		});
	}
}
