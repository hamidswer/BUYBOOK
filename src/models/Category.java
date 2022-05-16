
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
 *         Responsibilities of class: It saves the recently category name picked
 *         by user. It gives the books based on their genre(or category).
 * 
 *         Version/date: 1.4 / 05/15/2022
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
	 * Purpose: Get books based on their categoryName.
	 * 
	 * @param categoryName - It could be Books, Fiction or non fiction.
	 * @return books - generated books based on their category.
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

			// Initialize books by invoking getFictions method from the bookList object.(just fiction books)
			books = booksList.getFictions();
			break;

		case "Nonfiction":

			// Initialize books by invoking getNonFictions method from the bookList object.(just non fiction books)
			books = booksList.getNonFictions();
			break;

		case "Books":

			// Initialize books by invoking getBooks method from the bookList object.(all books)
			books = booksList.getBooks();
			break;
		}

		return books;
	}

	/**
	 * Purpose: Get the books that the user has recently selected by category. (Will
	 * be used in sorting by a Sort object).
	 * 
	 * We have two methods with the same name, the above one is for creating a books
	 * array based on the category. this one used for getting books. polymorphism
	 * (overloading)
	 * 
	 * @return books.
	 */
	public Book[] getBooks()
	{
		return books;
	}

}
