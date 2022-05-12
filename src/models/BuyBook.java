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
 *         Version/date: 1.4 / 05/12/2022
 * 
 * 
 */
public class BuyBook
{
	// A BuyBook has-a book.
	private Book book;

	// A BuyBook has-a isPaper.
	private boolean isPaper;

	public BuyBook(Book book, String buttonName)
	{
		this.book = book;
		isPaper = buttonName.equals("Paper Book");
	}

	/**
	 * Get the shopping message in HTML format.
	 * 
	 * @return message.
	 */
	public String getMessage()
	{
		String message = "Thanks for buying the ";
		message += book.getName() + " ";
		message += "by " + book.getAuthor() + ". ";
		if (isPaper)
		{
			message += "You can receive your book from the cashier with this receipt number." + "<br>";
		} else
		{
			message += "An email with more information about your purchase will send to your email." + "<br>";
		}
		message += "The receipt number: " + getRandomNumber();
		if (isPaper)
		{
			message = "<html><center>" + message + "</center></html>";
			PaperBook paperBook = new PaperBook(book);
			paperBook.decLeftInStore();
		} else
		{
			ElectronicBook electronicBook = new ElectronicBook(book);
			message += "<br>" + electronicBook.getAcceptableUsePolicy();
			message = "<html><center>" + message + "</center></html>";
		}
		return message;
	}

	/**
	 * Get a 10 digits random number.
	 * 
	 * @return
	 */
	public String getRandomNumber()
	{
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return String.valueOf(number);
	}

}
