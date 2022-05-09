
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.3 / 05/09/2022
 * 
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Book;
import views.pages.PageView;
import views.widgets.Button;

public class BookButtonListener implements ActionListener
{

	// BookButtonListener has-a view.
	private PageView view;

	// BookButtonListener has-a book.
	private Book book;

	/**
	 * `BookButtonListener Constructor - It listen to book's name button and change
	 * the view.
	 * 
	 * @param view       - a PageView
	 * @param bookButton - Indicate which button clicked.
	 * @param book       - it's a book object.
	 */
	public BookButtonListener(PageView view, Button bookButton, Book book)
	{
		// Assign the view value.
		this.view = view;

		// Assign the book value.
		this.book = book;

		// Listen to bookButton.
		bookButton.addActionListener(this);

	}

	/**
	 * It overrides actionPerformed method of ActionListener.
	 * Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Update the view.
		update();
	}

	/**
	 * Update the view.
	 */
	public void update()
	{
		// Remove the booksPanel.
		this.view.removeBooksPanel();

		// Remove the categoryPanel.
		this.view.removeCategoryPanel();

		// Remove the sortPanel.
		this.view.removeSortPanel();

		// Add the categoryPanel.
		this.view.addCategoryPanel(false);

		// Add the fullBookPanel.
		this.view.addFullBookPanel(book);

	}

}
