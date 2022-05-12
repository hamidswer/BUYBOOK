
package models;

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
 *         Version/date: 1.2 / 05/12/2022
 * 
 * 
 */
public class Category
{
	// The Category class has-a name.
	private static String name = "Books";

	// The Category class has many books.
	private static Book[] books;

	/**
	 * Get books based on their categoryName.
	 * 
	 * @param categoryName
	 * @return
	 */
	public Book[] getBooks(String categoryName)
	{
		// Initialize name.
		name = categoryName;

		// Initialize a bookslist.
		BooksList booksList = new BooksList();

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
}
