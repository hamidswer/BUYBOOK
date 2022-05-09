package models;

/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 2.2 / 5/9/2022
 * 
 * 
 */
// PaperBook is-a Book so inherits all of its public methods and variables of Book.
public class PaperBook extends Book
{
	private InventoryDatabase database = new InventoryDatabase();;

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
		database.updateInventory(getId());
	}
}
