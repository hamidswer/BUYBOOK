package models;

// import java.util.Arrays;
// import java.util.Comparator;

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
 *         How to sort an array of objects in Java?
 *         https://stackoverflow.com/questions/18895915/how-to-sort-an-array-of-objects-in-java
 * 
 *         Responsibilities of class: It sorts a Book array by rate, name, and
 *         price of its elements.
 * 
 *         Version/date: 1.4 / 05/15/2022
 * 
 * 
 */
public class Sort
{
	// A Sort has-a name.
	private String name;

	// A Sort has many booksByCategory.
	private Book[] booksByCategory;

	public Sort(String name, Book[] booksByCategory)
	{
		// Assign the name value.
		this.name = name;

		// Assign the booksByCategory value.
		this.booksByCategory = booksByCategory;
	}

	/**
	 * Purpose: Get sorted books based on their name, price or rate.
	 * 
	 * @return sortedBooks
	 */
	public Book[] getSorted()
	{
		// Initialize a sortedBooks array.
		Book[] sortedBooks = new Book[booksByCategory.length];

		// Check the sort's name.
		switch (name)
		{

		// If it is Name
		case "Name":

			// Initialize a sortByName from a SortByName and pass booksByCategory as it's argument. 
			SortByName sortByName = new SortByName(booksByCategory);

			// get sorted books and assign it to the sortedBooks.
			sortedBooks = sortByName.getSortedBooks();

			break;

		case "Price":

			// Initialize a sortByPrice from a SortByPrice and pass booksByCategory as it's argument.
			SortByPrice sortByPrice = new SortByPrice(booksByCategory);

			// get sorted books and assign it to the sortedBooks.
			sortedBooks = sortByPrice.getSortedBooks();
			break;

		case "Rate":
			// Initialize a sortByRate from a SortByRate and pass booksByCategory as it's argument.
			SortByRate sortByRate = new SortByRate(booksByCategory);

			// get sorted books and assign it to the sortedBooks.
			sortedBooks = sortByRate.getSortedBooks();
		}

		return sortedBooks;
	}

	// Another way to achieve the same goal! instead of creating the sortByName, sortByPrice and sortByRate classes, 
	// you can call these methods inside the getSorted method in different cases.
	//	/**
	//	 * Sort by book name.
	//	 * 
	//	 * @param books - list of the books objects
	//	 */
	//
	//	public void sortByName(Book[] books)
	//	{
	//
	//		Arrays.sort(books, new Comparator<Book>()
	//		{
	//			public int compare(Book i1, Book i2)
	//			{
	//				return i1.getName().compareTo(i2.getName());
	//			}
	//		});
	//	}
	//
	//	/**
	//	 * Sort by books price.
	//	 * 
	//	 * @param books - list of the books objects
	//	 */
	//	public void sortByPrice(Book[] books)
	//	{
	//		Arrays.sort(books, new Comparator<Book>()
	//		{
	//			public int compare(Book i1, Book i2)
	//			{
	//				return i1.getPrice() - i2.getPrice();
	//			}
	//		});
	//	}
	//
	//	/**
	//	 * Sort books by rate.
	//	 * 
	//	 * @param books - list of the books objects
	//	 */
	//	public void sortByRate(Book[] books)
	//	{
	//		Arrays.sort(books, new Comparator<Book>()
	//		{
	//			public int compare(Book i1, Book i2)
	//			{
	//				return i2.getRate() - i1.getRate();
	//			}
	//		});
	//	}

}
