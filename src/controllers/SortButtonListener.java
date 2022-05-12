
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Book;
import models.Category;
import models.Sort;
import views.pages.PageView;
import views.pages.components.BookPanel;
import views.pages.components.SortPanel;
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
//A SortButtonListener is-an ActionListener.
public class SortButtonListener implements ActionListener
{

	// A SortButtonListener has-a view.
	private PageView view;

	// A SortButtonListener has-a panel.
	private SortPanel panel;

	// A SortButtonListener has-a buttonClicked.
	private Button sortButton;

	/**
	 * SortButtonListener Constructor - It listen to the sort buttons and change the
	 * view.
	 * 
	 * @param view  - the PageView.
	 * @param panel
	 */
	public SortButtonListener(PageView view, SortPanel panel, Button sortButton)
	{

		this.view = view;

		this.panel = panel;

		// the button user clicked on it. e.g. Sort by name, price or rate.
		this.sortButton = sortButton;

		this.sortButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize buttonName.
		String buttonName = sortButton.getText();

		// Update the button style based on buttonName.
		updateButtonsStyle(buttonName);
	}

	/**
	 * Update the button style..
	 * 
	 * @param buttonName
	 */
	public void updateButtonsStyle(String buttonName)
	{
		// Initialize nameButton.
		Button nameButton = panel.getNameButton();

		// Initialize priceButton.
		Button priceButton = panel.getPriceButton();

		// Initialize rateButton.
		Button rateButton = panel.getRateButton();

		// Initialize the buttons.
		Button[] buttons = new Button[]
		{ nameButton, priceButton, rateButton };

		for (int i = 0; i < buttons.length; i++)
		{
			// If the customer clicked on the button element in buttons array.
			if (buttons[i].getText().equals(buttonName))
			{
				// Disable button.
				buttons[i].setEnabled(false);
			} else
			{

				// Enable button.
				buttons[i].setEnabled(true);
			}
		}

		// Add the booksPanel.
		addBookPanel(buttonName);
	}

	/**
	 * Add the booksPanel.
	 */
	public void addBookPanel(String name)
	{
		// Remove the books panel.
		this.view.removeBooksPanel();

		// Initialize the categoryName.
		Book[] booksByCategory = new Category().getBooks(name);

		// Initialize a sortButton.
		Sort sort = new Sort(name, booksByCategory);

		// Initialize books.
		Book[] books = sort.getSorted();

		// Declare a booksPanel.
		BookPanel[] booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.view, books[i]);

		// Add the booksPanel to the view.
		this.view.addBooksPanel(booksPanel);
	}
}
