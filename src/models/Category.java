
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/08/2022
 * 
 * 
 */
package models;

public class Category
{
	// Category has-a name.
	private static String name = "Books";
	
	// Category has-a books.
	private static Book[] books;
	
	// Category has-a books.
	private BooksList booksList;
	
	/**
	 * Get books based on their genre.
	 * 
	 * @return books
	 */
	public Book[] getBooks(String categoryName)
	{

		// Initialize name.
		name = categoryName;
		
		// Initialize a bookslist.
		booksList = new BooksList();

		switch (name)
		{
		case "Fiction":

			// Initialize books.
			books = booksList.getFictions();
			break;

		case "Nonfiction":

			// Initialize books.
			books = booksList.getNonFictions();
			break;

		case "Books":

			// Initialize books.
			books = booksList.getBooks();
			break;
		}

		return books;
	}

	/**
	 * Get the category name.
	 * 
	 * @return name.
	 */
	public String getCategoryName()
	{
		return name;
	}
	
	public Book[] getBooks()
	{
		return books;
	}
	
	public void setBooks(Book[] booksList)
	{
		books = booksList;
	}
}
