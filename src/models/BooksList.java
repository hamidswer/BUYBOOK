package models;

import java.util.ArrayList;

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
 *         ArrayList toArray method class cast exception [duplicate]
 *         https://stackoverflow.com/questions/21322478/arraylist-toarray-method-class-cast-exception
 * 
 *         Responsibilities of class:It is responsible for initializing an
 *         inventory database and creating and getting all books, fiction and
 *         non-fiction books.
 * 
 * 
 *         Version/date: 2.4 / 05/12/2022
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

	public BooksList(boolean loggedIn)
	{
		// If customer logged in.
		if (loggedIn)
		{
			// Initialize database.
			database = new InventoryDatabase();

			// Initialize books.
			books = database.getBooks();

			// Set a book list for all books.
			setBooks();

			// Set a book list with fiction genre.
			setFicions();

			// Set a book list with non fiction genre.
			setNonFictions();

		}
	}

	public BooksList()
	{

	}

	/**
	 * Purpose: Set the books with fiction genre.
	 * 
	 * @return fictionList
	 */
	public void setFicions()
	{
		ArrayList<Book> fictionsArrayList = new ArrayList<Book>();
		for (int i = 0; i < books.length - 1; i++)

			// If the genre is Fiction.
			if (books[i].getGenre().equals("Fiction"))

				// Add books elements to fictionsArrayList.
				fictionsArrayList.add(books[i]);

		// Create a regular array from fictionsArrayList.
		fictions = fictionsArrayList.toArray(new Book[fictionsArrayList.size()]);

	}

	/**
	 * Purpose: Set the books with non fiction genre.
	 * 
	 * @return nonFictionList
	 */
	public void setNonFictions()
	{
		// Initialize a nonFictionsArrayList.
		ArrayList<Book> nonFictionsArrayList = new ArrayList<Book>();

		for (int i = 0; i < books.length - 1; i++)

			// If the genre is Non Fiction.
			if (books[i].getGenre().equals("Non Fiction"))

				// Add books elements to nonFictionsArrayList.
				nonFictionsArrayList.add(books[i]);

		// Converting the nonFictionsArrayList to a regular array.
		nonFictions = nonFictionsArrayList.toArray(new Book[nonFictionsArrayList.size()]);

	}

	/**
	 * Purpose: Set the books with non fiction genre.
	 * 
	 * @return nonFictionList
	 */
	public void setBooks()
	{
		// Initialize a nonFictionsArrayList.
		ArrayList<Book> booksArrayList = new ArrayList<Book>();

		for (int i = 0; i < books.length - 1; i++)

			// Add books elements to nonFictionsArrayList.
			booksArrayList.add(books[i]);

		// Converting the nonFictionsArrayList to a regular array.
		books = booksArrayList.toArray(new Book[booksArrayList.size()]);

	}

	/**
	 * Purpose: Get all books.
	 * 
	 * @return books.
	 */
	public Book[] getBooks()
	{
		return books;
	}

	/**
	 * Purpose: Get all books in fictions category.
	 * 
	 * @return fictions.
	 */
	public Book[] getFictions()
	{
		return fictions;
	}

	/**
	 * Purpose: Get all books in non fictions category.
	 * 
	 * @return nonFictions.
	 */
	public Book[] getNonFictions()
	{

		return nonFictions;
	}

}