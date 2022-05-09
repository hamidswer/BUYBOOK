
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/09/2022
 * 
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Book;
import models.BuyBook;
import views.pages.PageView;
import views.widgets.Button;

public class BuyButtonListener implements ActionListener
{

	// BuyButtonListener has-a view.
	private PageView view;

	// BuyButtonListener has-a buyBook.
	private BuyBook buyBook;

	// BuyButtonListener has-a book.
	private Book book;

	/**
	 * `BuyButtonListener Constructor - It listen to book's buy button and change
	 * the view.
	 * 
	 * @param view       - a PageView
	 * @param bookButton - Indicate which button clicked.
	 * @param book       - it's a book object.
	 */
	public BuyButtonListener(PageView view, Button bookButton, Book book)
	{
		// Assign the view value.
		this.view = view;

		// Assign the book value.
		this.book = book;

		// Listen to bookButton.
		bookButton.addActionListener(this);

	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize buttonName and assign the value from a ActionEvent object.
		String buttonName = ((Button) event.getSource()).getActionCommand();

		// Initialize a buyBook model with book and buttonName as arguments.
		buyBook = new BuyBook(book, buttonName);

		// Update the view by getting message from buyBook model.
		update(buyBook.getMessage());

	}

	/**
	 * Update the view.
	 */
	public void update(String text)
	{
		// Remove the fullBookPanel.
		this.view.removeFullBookPanel();

		// Add the buyPanel.
		this.view.addBuyPanel(text);

	}

}
