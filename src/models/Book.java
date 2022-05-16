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
 *         Responsibilities of class: It creates book objects.. 
 * 
 *         Version/date: 1.5 / 05/12/2022
 * 
 */
public class Book
{
	// A book has-an id.
	private int id;

	// A book has-a name.
	private String name;

	// A book has-an author.
	private String author;

	// A book has-a rate.
	private int rate;

	// A book has-a price.
	private int price;

	// A book has-a year.
	private int year;

	// A book has a genre.
	private String genre;

	// A book has a leftInStore.
	private int leftInStore;

	public Book(int id, String name, String author, int rate, int price, int year, int leftInStore, String genre)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.rate = rate;
		this.price = price;
		this.year = year;
		this.leftInStore = leftInStore;
		this.genre = genre;
	}

	public Book(int id, String name, String author, int rate, int price, int year, String genre)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.rate = rate;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * Purpose: Get the id.
	 * 
	 * @return id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Purpose: Get the name.
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Purpose: Get the author.
	 * 
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * Purpose: Get the rate.
	 * 
	 * @return rate
	 */
	public int getRate()
	{
		return rate;
	}

	/**
	 * Purpose: Get the price.
	 * 
	 * @return price
	 */
	public int getPrice()
	{
		return price;
	}

	/**
	 * Purpose: Get the genre.
	 * 
	 * @return genre
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 * Purpose: Get the year.
	 * 
	 * @return year
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * Purpose: Get left in store (How many of this book exists in the store).
	 * 
	 * @return leftInStore.
	 */
	public int getLeftInStore()
	{
		return leftInStore;
	}

}
