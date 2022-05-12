
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Book;
import models.BooksList;
import models.Category;
import models.Login;
import views.pages.PageView;
import views.pages.components.BookPanel;
import views.pages.components.LoginPanel;
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
//A LoginButtonListener is-an ActionListener.
public class LoginButtonListener implements ActionListener
{

	// LoginButtonListener has-a view
	private PageView view;

	// LoginButtonListener has-a model
	private Login model;

	// LoginButtonListener has-a panel
	private LoginPanel panel;

	// LoginButtonListener has-a categoryButton.
	private BookPanel[] booksPanel;

	/**
	 * LoginButtonListener Constructor - It listen to the login button.
	 * 
	 * @param view  the PageView.
	 * @param panel the LoginPanel.
	 */
	public LoginButtonListener(PageView view, LoginPanel panel)
	{
		// Initialize the view.
		this.view = view;

		// Initialize the panel.
		this.panel = panel;

		// Initialize the loginButton.
		Button loginButton = panel.getLoginButton();

		// Listen to the loginButton.
		loginButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Get the updated email.
		String email = panel.getEmailComponent().getText();

		// Get the updated password.
		String password = new String(panel.getPasswordComponent().getPassword());

		// Initialize the model.
		this.model = new Login(email, password);

		// Update the login page view and model.
		update();

	}

	/**
	 * Update the view.
	 */
	public void update()
	{
		// If the customer provides right credentials remove login panel and go to the home page.
		if (model.getIsACustomerExist())
		{
			// Remove the login, error and create account panel.
			this.view.removeLoginPanels();

			// Remove old header panel, and add new header panel, because user logged in.
			this.view.addHeaderPanel(true);

			// Add categoryPanel. true the books button disabled. 
			this.view.addCategoryPanel(true);

			this.view.addSortPanel();

			// Add the booksPanel.
			addBookPanel();

		} else
		{
			// Display the error message.
			this.view.addLoginErrorPanel();
		}
	}

	/**
	 * Add the booksPanel.
	 */
	public void addBookPanel()
	{
		// Initialize a bookslist.
		new BooksList(true);

		// Create the booksPanel array in books category.
		createBooksArray("Books");

		// Add the booksPanel to the view.
		this.view.addBooksPanel(booksPanel);
	}

	/**
	 * Create the booksPanel array.
	 * 
	 * @param category
	 */
	public void createBooksArray(String categoryName)
	{
		// Initialize a category.
		Category category = new Category();

		// Initialize books based on categoryName.
		Book[] books = category.getBooks(categoryName);

		// Initialize a bookslist.
		booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel.
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.view, books[i]);
	}
}
