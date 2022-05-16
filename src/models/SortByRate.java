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
 *         Responsibilities of class: It sorts a Book array by rating of its
 *         elements with the bubble sort algorithm.
 * 
 *         Version/date: 1.1 / 05/15/2022
 * 
 * 
 */
import interfaces.Sortable;

// A SortByRate is Sortable.
public class SortByRate implements Sortable
{

	// A SortByRate has many sortedBooksByRate;
	private Book[] sortedBooksByRate;

	public SortByRate(Book[] books)
	{
		// Assign the sortedBooksByRate by invoking the bubbleSort method and books as its argument.
		sortedBooksByRate = bubbleSort(books);
	}

	/**
	 * Purpose: Bubble sort algorithm sorts by books rate.
	 * 
	 * @param books - to sort by bubble sort algorithm.
	 * @return sorted array by bubble sort.
	 */
	public Book[] bubbleSort(Book[] books)
	{
		// Declaring swap variable because we need to swap two elements values in the
		// books.
		Book swap;

		// while books is not ordered do bubbleUp.

		while (!inOrder(books))
		{
			for (int i = 0; i < books.length - 1; i++)
			{

				// Check if an element's value in the books with index i is smaller than the
				// next element in the books.
				if (books[i].getRate() < books[i + 1].getRate())
				{
					// swapping two elements values.
					swap = books[i];
					books[i] = books[i + 1];
					books[i + 1] = swap;
				}
			}
		}
		// return fully sorted books by bubble sort algorithm.
		return books;
	}

	/**
	 * Purpose: The inOrder method checks if elements of books are sorted in order
	 * by rate.
	 * 
	 * @param books - To check if its elements are in order by rate.
	 * @return true if the books array is sorted by rate, false if it's not.
	 */
	public boolean inOrder(Book[] books)
	{
		for (int i = 0; i < books.length - 1; i++)
		{
			// Check if an element's value in books with index i is smaller than an
			// next element in the books.
			if (books[i].getRate() < books[i + 1].getRate())
				// return false to indicate the books is not ordered.
				return false;
		}
		// return true to indicate the books is ordered.
		return true;
	}

	/**
	 * Purpose: Get the sorted books by rate.
	 * 
	 * @return books
	 */
	public Book[] getSortedBooks()
	{
		return sortedBooksByRate;
	}
}
