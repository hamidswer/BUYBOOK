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
 *         Responsibilities of class: It listens to the bookNameButton. If the
 *         bookNameButton is clicked, it removes the booksPanel and sortPanel.
 *         then adds fullBookPanel and category panel.
 * 
 * 
 * 
 *         Version/date: 1.5 / 05/15/2022
 * 
 * 
 */

// A BookButtonListener is ActionListener.
public class BookButtonListener implements ActionListener
{

	// A BookButtonListener has-a pageView.
	private PageView pageView;

	// A BookButtonListener has-a book.
	private Book book;

	public BookButtonListener(PageView pageView, Button bookNameButton, Book book)
	{
		// Assign the pageView value.
		this.pageView = pageView;

		// Assign the book value. the view use the book object for giving more information about the book, and providing purchase options.
		this.book = book;
	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the bookNameButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Update the page view.
		update();
	}

	/**
	 * Purpose: It removes booksPanel and sortPanel. It adds a new categoryPanel and
	 * fullBookPanel which gives more information about a book.
	 */
	public void update()
	{
		// Remove the booksPanel.
		this.pageView.removeBooksPanel();

		// Remove the sortPanel.
		this.pageView.removeSortPanel();
		// Remove the old categoryPanel.

		// Add the fullBookPanel.
		this.pageView.addFullBookPanel(book);

		// Add categoryPanel. false means the books button enabled. 
		this.pageView.addCategoryPanel(false);

	}

}
