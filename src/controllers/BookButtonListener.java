package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Book;
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

// A BookButtonListener is-an ActionListener.
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
	 * @param view          - a PageView
	 * @param buttonClicked - indicate which button clicked.
	 * @param book          - it's a book object.
	 */
	public BookButtonListener(PageView view, Button buttonClicked, Book book)
	{
		// Assign the view value.
		this.view = view;

		// Assign the book value. the view use the book object for giving more information about the book, and providing purchase options.
		this.book = book;

		buttonClicked.addActionListener(this);

	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Update the UI(the view).
		updateUI();
	}

	/**
	 * Update the view.
	 */
	public void updateUI()
	{
		// Remove the booksPanel.
		this.view.removeBooksPanel();

		// Remove the sortPanel.
		this.view.removeSortPanel();
		// Remove the old categoryPanel.

		// Add the fullBookPanel.
		this.view.addFullBookPanel(book);

		// Add categoryPanel. false the books button enabled. 
		this.view.addCategoryPanel(false);

	}

}
