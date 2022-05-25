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
 *         Responsibilities of class: It listens to the categoryButton, and if
 *         the categoryButton is clicked, It updates the button's style, then It
 *         removes booksPanel, sortPanel, fullBookPanel, and buyPanel from the
 *         page view. Then it adds sortPanel, and booksPanel based on the chosen
 *         category.
 * 
 *         Version/date: 1.2 / 05/15/2022
 * 
 * 
 */
// A CategoryButtonListener is-an ActionListener.
public class CategoryButtonListener implements ActionListener
{

	// A CategoryButtonListener has-a pageView.
	private PageView pageView;

	// A CategoryButtonListener has-a categoryButton.
	private Button categoryButton;

	// A CategoryButtonListener has-a categoryPanel.
	private CategoryPanel categoryPanel;

	// CategoryButtonListener has many booksPanel.
	private BookPanel[] booksPanel;

	public CategoryButtonListener(PageView pageView, CategoryPanel categoryPanel, Button categoryButton)
	{
		// Assign the pageView value.
		this.pageView = pageView;

		// Assign the categoryPanel value.
		this.categoryPanel = categoryPanel;

		// Assign the categoryButton value.
		this.categoryButton = categoryButton;

	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the categoryButton. It gets the categoryButton text and calls
	 * updateButtonsStyle method. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize the categoryButtonText
		String categoryButtonText = categoryButton.getText();

		// Update the button style based on the categoryButtonText.
		updateButtonsStyle(categoryButtonText);
	}

	/**
	 * Purpose: It updates the category buttons UI style. It changes the color of
	 * the clicked button and disable it at the same time.
	 * 
	 * @param categoryButtonText - the button text value which is clicked.
	 */
	public void updateButtonsStyle(String categoryButtonText)
	{
		// Initialize booksButton.
		Button booksButton = categoryPanel.getBooksButton();

		// Initialize fictionButton.
		Button fictionButton = categoryPanel.getFictionButton();

		// Initialize nonFictionButton.
		Button nonFictionButton = categoryPanel.getNonfictionButton();

		// Initialize the buttons array to compare with buttonName and change the category buttons style.
		Button[] buttons = new Button[]
		{ booksButton, fictionButton, nonFictionButton };

		for (int i = 0; i < buttons.length; i++)
		{
			// If the customer clicked on the same button element in buttons array.
			if (categoryButtonText.equals(buttons[i].getText()))
			{
				// Disable the clicked button.
				buttons[i].setEnabled(false);

				// Set the background color.
				buttons[i].setBackground(new Color(131, 56, 87));
			} else
			{

				// Enable button.
				buttons[i].setEnabled(true);

				// Set background color for enable button.
				buttons[i].setBackground(new Color(27, 108, 89));
			}
		}

		// Update the view.
		update(categoryButtonText);
	}

	/**
	 * Purpose: It removes booksPanel, sortPanel, fullBookPanel, and buyPanel from
	 * the page view. It adds sortPanel and new booksPanel based on buttonName in
	 * the page view.
	 * 
	 * @param categoryButtonText - the button text value which is clicked.
	 */
	public void update(String categoryButtonText)
	{
		// Remove booksPanel.
		this.pageView.removeBooksPanel();

		// Remove sortPanel.
		this.pageView.removeSortPanel();

		// Remove fullBookPanel.
		this.pageView.removeFullBookPanel();

		// Remove buyPanel.
		this.pageView.removeBuyPanel();

		// Add sortPanel.
		this.pageView.addSortPanel();

		// Create the BooksPanel array.
		createBooksPanel(categoryButtonText);

		// Add the booksPanel to the view.
		this.pageView.addBooksPanel(booksPanel);
	}

	/**
	 * Purpose: It Creates the booksPanel for adding to the page view.
	 * 
	 * @param categoryButtonText - the button text value which is clicked.
	 */
	public void createBooksPanel(String categoryButtonText)
	{
		// Initialize a category.
		Category category = new Category();

		// Initialize books based on buttonText. This method gives us books based on the desired category.
		Book[] books = category.getBooks(categoryButtonText);

		// Initialize a booksPanel.
		booksPanel = new BookPanel[books.length - 1];

		// For loop to assign booksPanel elements value.
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.pageView, books[i]);
	}
}
