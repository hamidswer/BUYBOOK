
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
 *         Responsibilities of class: It listens to the sortButton, and if the
 *         sortButton is clicked, it updates the sort buttons style and then
 *         remove booksPanel from the page view, and adds a new booksPanel based
 *         on category and sorted option provided by the customer. Version/date:
 *         1.5 / 05/15/2022
 * 
 * 
 */
// A SortButtonListener is ActionListener.
public class SortButtonListener implements ActionListener
{

	// A SortButtonListener has-a pageView.
	private PageView pageView;

	// A SortButtonListener has-a sortPanel.
	private SortPanel sortPanel;

	// A SortButtonListener has-a sortButton.
	private Button sortButton;

	public SortButtonListener(PageView pageView, SortPanel sortPanel, Button sortButton)
	{
		// Assign the pageView value.
		this.pageView = pageView;

		// Assign the sortPanel value.
		this.sortPanel = sortPanel;

		// Assign the sortButton value. sortButton is the button user clicked on it. e.g. name, price or rate.
		this.sortButton = sortButton;
	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the sortButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize sortButtonText.
		String sortButtonText = sortButton.getText();

		// Update the button style based on sortButtonText.
		updateButtonsStyle(sortButtonText);
	}

	/**
	 * Purpose: It updates the sort buttons UI style. It disables the clicked
	 * button.
	 * 
	 * @param sortButtonText - the button text value which is clicked.
	 */
	public void updateButtonsStyle(String sortButtonText)
	{
		// Initialize nameButton.
		Button nameButton = sortPanel.getNameButton();

		// Initialize priceButton.
		Button priceButton = sortPanel.getPriceButton();

		// Initialize rateButton.
		Button rateButton = sortPanel.getRateButton();

		// Initialize the buttons.
		Button[] buttons = new Button[]
		{ nameButton, priceButton, rateButton };

		for (int i = 0; i < buttons.length; i++)
		{
			// If the customer clicked on the button element in buttons array.
			if (buttons[i].getText().equals(sortButtonText))
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
		addBookPanel(sortButtonText);
	}

	/**
	 * Purpose: It removes booksPanel. then gets the book array on recent category.
	 * and then create a sort method and sort the books array. then creates a
	 * booksPanel and finally add booksPanel to the page view.
	 */
	public void addBookPanel(String name)
	{
		// Remove the books panel.
		this.pageView.removeBooksPanel();

		// A SortButtonListener uses many booksByCategory.
		// Initialize the categoryName.
		Book[] booksByCategory = new Category().getBooks(name);

		// A SortButtonListener uses-a sort.
		// Initialize a sortButton.
		Sort sort = new Sort(name, booksByCategory);

		// A SortButtonListener uses-a books.
		// Initialize books.
		Book[] books = sort.getSorted();

		// A SortButtonListener uses many booksPanel.
		// Declare a booksPanel.
		BookPanel[] booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.pageView, books[i]);

		// Add the booksPanel to the view.
		this.pageView.addBooksPanel(booksPanel);
	}
}
