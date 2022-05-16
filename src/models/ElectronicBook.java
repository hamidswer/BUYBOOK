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
 *         Responsibilities of class: It's responsible to create ElectronicBook.
 *         It gets the acceptable use policy.
 * 
 * 
 * 
 *         Version/date: 2.4 / 05/15/2022
 * 
 * 
 */
// An ElectronicBook is-a Book.
public class ElectronicBook extends Book
{

	public ElectronicBook(Book book)
	{

		super(book.getId(), book.getName(), book.getAuthor(), book.getRate(), book.getPrice(), book.getYear(),
				book.getGenre());
	}

	/**
	 * Purpose: Get the acceptable user policy.
	 * 
	 * @return Acceptable user policy.
	 */
	public String getAcceptableUsePolicy()
	{
		return "Please note, you cannot reproduce and distribute copies of the e-book. Thanks again for shopping with us.";
	}
}
