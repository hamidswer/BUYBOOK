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
 *         Version/date: 1.2 / 05/12/2022
 * 
 * 
 */
//A CategoryButtonListener is-an ActionListener.
public class CategoryButtonListener implements ActionListener
{

	// CategoryButtonListener has-a view.
	private PageView view;

	// CategoryButtonListener has-a categoryButton.
	private Button categoryButton;

	// CategoryButtonListener has-a panel.
	private CategoryPanel categoryPanel;

	// CategoryButtonListener has-a booksPanel.
	private BookPanel[] booksPanel;

	/**
	 * `CategoryButtonListener Constructor - It listen to categories buttons and
	 * change the view based on that.
	 * 
	 * @param view  - a PageView.
	 * @param panel - it's a CategoryPanel.
	 */
	public CategoryButtonListener(PageView view, CategoryPanel categoryPanel, Button categoryButton)
	{
		// Initialize the view.
		this.view = view;

		// Initialize the categoryPanel.
		this.categoryPanel = categoryPanel;

		// Initialize the categoryButton.
		this.categoryButton = categoryButton;

		// Listen to categoryButton.
		this.categoryButton.addActionListener(this);

	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		String buttonName = categoryButton.getText();

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
		// CategoryButtonListener has-a booksButton.
		// Initialize booksButton.
		Button booksButton = categoryPanel.getBooksButton();

		// CategoryButtonListener has-a fictionButton.
		// Initialize booksButton.
		Button fictionButton = categoryPanel.getFictionButton();

		// CategoryButtonListener has-a nonFictionButton.
		// Initialize booksButton.
		Button nonFictionButton = categoryPanel.getNonfictionButton();

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
	 * 
	 * @param buttonName - the name of button which is clicked.
	 */
	public void createBooksArray(String buttonName)
	{
		// Initialize a category.
		Category category = new Category();

		// Initialize books based on buttonName.
		Book[] books = category.getBooks(buttonName);

		// Initialize a bookslist.
		booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel.
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.view, books[i]);
	}
}
