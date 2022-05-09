
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/07/2022
 * 
 * 
 */
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

public class SortButtonListener implements ActionListener
{

	// SortButtonListener has-a view.
	private PageView view;

	// SortButtonListener has-a nameButton.
	private Button nameButton;

	// SortButtonListener has-a priceButton.
	private Button priceButton;

	// SortButtonListener has-a rateButton.
	private Button rateButton;

	// SortButtonListener has-a books sortButton.
	private Sort sortButton;

	// SortButtonListener has-a booksByCategory.
	private Book[] booksByCategory;

	/**
	 * SortButtonListener Constructor - It listen to the sort buttons and change the
	 * view.
	 * 
	 * @param view  - the PageView.
	 * @param panel
	 */
	public SortButtonListener(PageView view, SortPanel panel)
	{
		// Initialize the view.
		this.view = view;

		// Initialize nameButton.
		nameButton = panel.getNameButton();

		// Initialize priceButton.
		priceButton = panel.getPriceButton();

		// Initialize rateButton.
		rateButton = panel.getRateButton();

		// Listen to nameButton.
		nameButton.addActionListener(this);

		// Listen to priceButton.
		priceButton.addActionListener(this);

		// Listen to rateButton.
		rateButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize buttonName.
		String buttonName = ((Button) event.getSource()).getActionCommand();

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
		// Initialize the buttons.
		Button[] buttons = new Button[]
		{ nameButton, priceButton, rateButton };

		for (int i = 0; i < buttons.length; i++)
		{
			// If the customer clicked on the button element in buttons array.
			if (buttonName.equals(buttons[i].getText()))
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
		booksByCategory = new Category().getBooks(name);

		// Initialize a sortButton.
		sortButton = new Sort(name, booksByCategory);

		// Initialize books.
		Book[] books = sortButton.getSorted();

		// Declare a booksPanel.
		BookPanel[] booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.view, books[i]);

		// Add the booksPanel to the view.
		this.view.addBooksPanel(booksPanel);
	}
}
