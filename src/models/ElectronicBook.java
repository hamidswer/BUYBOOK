package models;

/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 2.2 / 4/23/2022
 * 
 * 
 */
// ElectronicBook is-a Book so inherits all of its public methods and variables of Book.
public class ElectronicBook extends Book
{
	private final static int left = 0;
	// ElectronicBook constructor 
	public ElectronicBook(Book book)
	{
		
		super(book.getId(), book.getName(), book.getAuthor(), book.getRate(), book.getPrice(), book.getYear(), left,
				book.getGenre());
	}

	/**
	 * Provides accept user policy to customer
	 * 
	 * @return Accept user policy
	 */
	public String getAcceptableUsePolicy()
	{
		return "Please note, you cannot reproduce and distribute copies of the e-book. Thanks again for shopping with us.";
	}
}
