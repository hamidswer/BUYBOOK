package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Book;
import models.BuyBook;
import views.pages.PageView;
import views.widgets.Button;

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
//A BuyButtonListener is-an ActionListener.
public class BuyButtonListener implements ActionListener
{

	// BuyButtonListener has-a view.
	private PageView view;

	// BuyButtonListener has-a book.
	private Book book;

	// BuyButtonListener has-a button.
	private Button button;

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

		button = bookButton;

	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize buttonText with the button's text value.
		String buttonText = button.getText();

		// BuyButtonListener has-a buyBook.
		// Initialize a buyBook model with book and buttonName as arguments.
		BuyBook buyBook = new BuyBook(book, buttonText);

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
