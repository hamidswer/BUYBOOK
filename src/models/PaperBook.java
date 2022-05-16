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
 *         Responsibilities of class: It can decrement the number of a book in the inventory database. 
 * 
 *         Version/date: 2.4 / 05/15/2022
 * 
 * 
 */
// A PaperBook is-a Book.
public class PaperBook extends Book
{
	public PaperBook(Book book)
	{
		// Assign the value to variables when an object creates
		super(book.getId(), book.getName(), book.getAuthor(), book.getRate(), book.getPrice(), book.getYear(),
				book.getLeftInStore(), book.getGenre());
	}

	/**
	 * Purpose: It decrements the number of a book in the inventory database.
	 */
	public void decLeftInStore()
	{
		// Initialize a database from the Inventory database.
		InventoryDatabase database = new InventoryDatabase();

		// Update the inventory database based on a book id.
		database.updateInventory(getId());
	}
}
