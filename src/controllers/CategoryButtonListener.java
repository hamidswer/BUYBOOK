
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Resources:
 * 
 *         Get button name from ActionListener? Retrieved from:
 *         https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
 * 
 *         Version/date: 1.1 / 05/07/2022
 * 
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Book;
import models.Category;
import views.pages.PageView;
import views.pages.components.BookPanel;
import views.pages.components.CategoryPanel;
import views.widgets.Button;

public class CategoryButtonListener implements ActionListener
{

	// CategoryButtonListener has-a view.
	private PageView view;

	// CategoryButtonListener has-a booksButton.
	private Button booksButton;

	// CategoryButtonListener has-a fictionButton.
	private Button fictionButton;

	// CategoryButtonListener has-a nonFictionButton.
	private Button nonFictionButton;

	// CategoryButtonListener has-a categoryButton.
	private Category categoryButton;

	// CategoryButtonListener has-a booksPanel.
	private BookPanel[] booksPanel;

	/**
	 * `CategoryButtonListener Constructor - It listen to categories buttons and
	 * change the view based on that.
	 * 
	 * @param view  - a PageView.
	 * @param panel - it's a CategoryPanel.
	 */
	public CategoryButtonListener(PageView view, CategoryPanel panel)
	{
		// Initialize the view.
		this.view = view;

		// Initialize booksButton.
		booksButton = panel.getBookButton();

		// Initialize booksButton.
		fictionButton = panel.getFictionButton();

		// Initialize booksButton.
		nonFictionButton = panel.getNonfictionButton();

		// Listen to booksButton.
		booksButton.addActionListener(this);

		// Listen to fictionButton.
		fictionButton.addActionListener(this);

		// Listen to nonFictionButton.
		nonFictionButton.addActionListener(this);
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

		// Update the button style.
		updateButtonsStyle(buttonName);
	}

	/**
	 * Update the button style.
	 * 
	 * @param buttonName - the button name
	 */
	public void updateButtonsStyle(String buttonName)
	{
		// Initialize buttons to compare with buttonName and change its elements style.
		Button[] buttons = new Button[]
		{ booksButton, fictionButton, nonFictionButton };

		for (int i = 0; i < buttons.length; i++)
		{
			// If the customer clicked on the same button element in buttons array.
			if (buttonName.equals(buttons[i].getText()))
			{
				// Disable button.
				buttons[i].setEnabled(false);

				// Set Raspberry Sorbet Shade background color.
				buttons[i].setBackground(new Color(131, 56, 87));
			} else
			{

				// Enable button.
				buttons[i].setEnabled(true);

				// Set Mint shade background color.
				buttons[i].setBackground(new Color(27, 108, 89));
			}
		}

		// Update the view.
		update(buttonName);
	}

	/**
	 * Update the view.
	 */
	public void update(String buttonName)
	{
		// Remove booksPanel.
		this.view.removeBooksPanel();

		// Remove sortPanel.
		this.view.removeSortPanel();

		// Remove fullBookPanel.
		this.view.removeFullBookPanel();

		// Remove buyPanel.
		this.view.removeBuyPanel();

		// Add sortPanel.
		this.view.addSortPanel();
		
		// Create the booksPanel array.
		createBooksArray(buttonName);

		// Add the booksPanel to the view.
		this.view.addBooksPanel(booksPanel);
	}

	/**
	 * Create the booksPanel array. 
	 * @param buttonName - the name of button which is clicked.
	 */
	public void createBooksArray(String buttonName)
	{
		// Initialize a categoryButton.
		categoryButton = new Category();

		// Initialize books based on buttonName.
		Book[] books = categoryButton.getBooks(buttonName);

		// Initialize a bookslist.
		booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel.
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.view, books[i]);
	}
}
