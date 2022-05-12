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
 *         Version/date: 2.3 / 05/12/2022
 * 
 * 
 */
// A PaperBook is-a Book.
public class PaperBook extends Book
{
	// PaperBook constructor 
	public PaperBook(Book book)
	{
		// Assign the value to variables when an object creates
		super(book.getId(), book.getName(), book.getAuthor(), book.getRate(), book.getPrice(), book.getYear(),
				book.getLeftInStore(), book.getGenre());
	}

	/**
	 * Decrement the number of same books in database.
	 */
	public void decLeftInStore()
	{
		InventoryDatabase database = new InventoryDatabase();
		database.updateInventory(getId());
	}
}
