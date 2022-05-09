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
		// Assign the value to variables when an object creates
		this.id = id;
		this.name = name;
		this.author = author;
		this.rate = rate;
		this.price = price;
		this.year = year;
		this.leftInStore = leftInStore;
		this.genre = genre;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Get the author.
	 * 
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * Get the rate.
	 * 
	 * @return rate
	 */
	public int getRate()
	{
		return rate;
	}

	/**
	 * Get the price.
	 * 
	 * @return price
	 */
	public int getPrice()
	{
		return price;
	}

	/**
	 * Get the genre.
	 * 
	 * @return genre
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 * Get the year.
	 * 
	 * @return year
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * Get left in store.
	 * 
	 * @return leftInStore.
	 */
	public int getLeftInStore()
	{
		return leftInStore;
	}

}
