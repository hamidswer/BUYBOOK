package models;

import java.util.Arrays;

/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * @Resources: Class FileInputStream, retrieved from
 *             https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html
 *             Class XSSFWorkbook retrieved from
 *             https://poi.apache.org/apidocs/dev/org/apache/poi/xssf/usermodel/XSSFWorkbook.html
 *             Java Iterator retrieved from
 *             https://www.w3schools.com/java/java_iterator.asp
 * 
 * 
 *             Version/date: 2.2 / 4/23/2022
 * 
 * 
 */

public class BooksList
{
	// A BooksList has-a database.
	private InventoryDatabase database;

	// I'M NOT SURE! static used to increase the speed in category and sort.

	// A BooksList has-a books. 
	private static Book[] books;

	// A BooksList has-a fictions.
	private static Book[] fictions;

	// A BooksList has-a nonFictions.
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