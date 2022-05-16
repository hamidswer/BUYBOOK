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
 *         Generating 10 digits unique random number in java.
 *         https://stackoverflow.com/questions/5328822/generating-10-digits-unique-random-number-in-java
 * 
 *         Responsibilities of class: It gets the post purchased message.
 * 
 *         Version/date: 1.5 / 05/15/2022
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
		// Assign the value of book.
		this.book = book;

		// It would be true if the customer picked to buy paper book version.
		isPaper = buttonName.equals("Paper Book");
	}

	/**
	 * Purpose: Get the post purchased message in HTML format.
	 * 
	 * @return message.
	 */
	public String getPostPurchasedMessage()
	{
		// Create a postPurchasedMessage.
		String postPurchasedMessage = "Thanks for buying the ";

		// Adds the book's name to the postPurchasedMessage.
		postPurchasedMessage += book.getName() + " ";

		// Adds the book's author to the postPurchasedMessage.
		postPurchasedMessage += "by " + book.getAuthor() + ". ";

		// If the customer picked to buy a paper book
		if (isPaper)
		{
			postPurchasedMessage += "You can receive your book from the cashier with this receipt number." + "<br>";
		} else
		{
			postPurchasedMessage += "An email with more information about your purchase will send to your email."
					+ "<br>";
		}

		// Adds a random 10 digits number as a receipt to the postPurchasedMessage.
		postPurchasedMessage += "The receipt number: " + getRandomNumber();

		// If the customer picked to buy a paper book
		if (isPaper)
		{

			postPurchasedMessage = "<html><center>" + postPurchasedMessage + "</center></html>";

			// Create a paperBook.
			PaperBook paperBook = new PaperBook(book);

			// decrement the number of books in inventory database.
			paperBook.decLeftInStore();

		} else
		{
			// Create an electronicBook.
			ElectronicBook electronicBook = new ElectronicBook(book);

			// Add acceptableUsePolicy to the postPurchasedMessage.
			postPurchasedMessage += "<br>" + electronicBook.getAcceptableUsePolicy();

			postPurchasedMessage = "<html><center>" + postPurchasedMessage + "</center></html>";
		}
		return postPurchasedMessage;
	}

	/**
	 * Purpose: Get a 10 digits random number.
	 * 
	 * @return a 10 digits random number.
	 */
	public String getRandomNumber()
	{
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return String.valueOf(number);
	}

}
