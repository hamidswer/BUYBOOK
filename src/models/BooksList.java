package models;

import java.util.Arrays;

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
 *         Version/date: 2.3 / 05/12/2022
 * 
 * 
 */

public class BooksList
{
	// A BooksList has-a database.
	private InventoryDatabase database;

	// The BooksList class has many books. 
	private static Book[] books;

	// The BooksList class has many fictions.
	private static Book[] fictions;

	// The BooksList has many nonFictions.
	private static Book[] nonFictions;

	// BooksList constructor
	public BooksList(boolean login)
	{
		if (login)
		{
			// Initialize database.
			database = new InventoryDatabase();

			// Initialize books.
			books = database.getBooks();

			// Initialize fictions.
			fictions = getFicionsList();

			// Initialize nonfictions.
			nonFictions = getNonFictionsList();
		}
	}

	public BooksList()
	{

	}

	/**
	 * Get the fiction list.
	 * 
	 * @return fictionList
	 */
	public Book[] getFicionsList()
	{
		Book[] fictions = new Book[books.length];
		for (int i = 0; i < books.length - 1; i++)
		{
			// If the book's genre is Fiction.
			if (books[i].getGenre().equals("Fiction"))

				// add book to fictionList Array
				fictions[i] = books[i];
		}

		// Remove null elements and resize array.
		fictions = (Book[]) Arrays.stream(fictions).filter(s -> (s != null)).toArray(Book[]::new);

		return fictions;
	}

	/**
	 * Get the non fiction list.
	 * 
	 * @return nonFictionList
	 */
	public Book[] getNonFictionsList()
	{
		Book[] nonFictions = new Book[books.length];
		for (int i = 0; i < books.length - 1; i++)
		{
			// if the book's genre is Non Fiction
			if (books[i].getGenre().equals("Non Fiction"))

				// add book to nonFictions Array
				nonFictions[i] = books[i];
		}

		// Remove null elements and resize array.
		nonFictions = (Book[]) Arrays.stream(nonFictions).filter(s -> (s != null)).toArray(Book[]::new);

		return nonFictions;
	}

	/**
	 * Get all books.
	 * 
	 * @return books.
	 */
	public Book[] getBooks()
	{
		Book[] allBooks = new Book[books.length];
		for (int i = 0; i < books.length - 1; i++)

			// add book to fictionList Array
			allBooks[i] = books[i];

		// Remove null elements and resize array.
		allBooks = (Book[]) Arrays.stream(allBooks).filter(s -> (s != null)).toArray(Book[]::new);

		return allBooks;
	}

	/**
	 * Get all books.
	 * 
	 * @return books.
	 */
	public Book[] getFictions()
	{
		return fictions;
	}

	/**
	 * Get all books.
	 * 
	 * @return books.
	 */
	public Book[] getNonFictions()
	{

		return nonFictions;
	}

}