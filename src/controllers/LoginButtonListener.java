
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.InvalidCredentialsException;
import models.Book;
import models.BooksList;
import models.Category;
import models.Login;
import views.pages.ErrorView;
import views.pages.PageView;
import views.pages.components.BookPanel;
import views.pages.components.LoginPanel;

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
 *         Responsibilities of class: It listens to the loginButton in the
 *         loginPanel. If the loginButton is clicked, it uses login to check if
 *         the customer provides the right credentials or not. If the customer
 *         exist in database, it removes loginPanels and adds headerPanels,
 *         categoryPanel, sortedPanel, and booksPanel to the page view. Note:
 *         books in booksPanel would be all the books in the inventory.
 * 
 *         Version/date: 1.4 / 05/26/2022
 * 
 * 
 */
// A LoginButtonListener is-an Exception 
// A LoginButtonListener is ActionListener.
public class LoginButtonListener extends Exception implements ActionListener {

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The
	 * Exception class implements java.io.Serializable interface so the it's
	 * subclass (LoginButtonListener).
	 */
	private static final long serialVersionUID = -2464791958699263060L;

	// A LoginButtonListener has-a pageView.
	private PageView pageView;

	// A LoginButtonListener has-a login.
	private Login login;

	// A LoginButtonListener has-a loginPanel.
	private LoginPanel loginPanel;

	// A LoginButtonListener has many booksPanel.
	private BookPanel[] booksPanel;

	// A LoginButtonListener has-a booksList.
	private BooksList booksList;

	public LoginButtonListener(PageView pageView, LoginPanel loginPanel) {
		// Assign the pageView value.
		this.pageView = pageView;

		// Assign the loginPanel value.
		this.loginPanel = loginPanel;

		// Create a new Bookslist.
		booksList = new BooksList(true);
	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the loginButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// Initialize the email.
		String email = loginPanel.getEmailComponent().getText();

		// Initialize the password.
		String password = new String(loginPanel.getPasswordComponent().getPassword());

		// Initialize the login based on email and password.
		this.login = new Login(email, password);

		// It tries to update page view, and if the customer didn't provide right
		// credentials throw an invalidCredentialsException.
		// then adds loginErrorPanel with customized error message from the
		// invalidCredentialsException error message.
		try {
			update();
		} catch (InvalidCredentialsException error) {
			// create new ErrorView if customer provides wrong credentials with customized
			// message from invalidCredentialsException.
			new ErrorView("Invalid credentials", error.getMessage());
		}

	}

	/**
	 * Purpose: It removes loginPanels, and adds the HeaderPanel, CategoryPanel, and
	 * sortPanel to the page view. It throws invalidCredentialsException if a
	 * customer provides wrong credentials.
	 * 
	 * @throws InvalidCredentialsException used to throw an exception when a
	 *                                     customer provides wrong credentials.
	 */
	public void update() throws InvalidCredentialsException {

		if (!login.getIsACustomerExist()) {
			// If we catch an error by reading the database file
			if (login.isError())
				new ErrorView("IO Error", login.getDatabaseFileErrorMessage());
			else {
				// If the customer provides input wrong credentials throw an
				// invalidCredentialsException.
				throw new InvalidCredentialsException();
			}
		}
		else if (booksList.isError()) {
			new ErrorView("IO Error", booksList.getDatabaseFileErrorMessage());
		}

		else {
			// Remove the login, error and create account panel.
			this.pageView.removeLoginPanels();

			// Remove old header panel, and add new header panel, because user logged in.
			this.pageView.addHeaderPanel(true);

			// Add categoryPanel. true the books button disabled.
			this.pageView.addCategoryPanel(true);

			// Add sortPanel to the page view.
			this.pageView.addSortPanel();

			// Add the booksPanel.
			addBookPanel();
		}
	}

	/**
	 * Purpose: It creates a new BooksList and adds the booksPanel to the page view.
	 */
	public void addBookPanel() {

		// Create the booksPanel array by books category.
		createBooksArray("Books");

		// Add the booksPanel to the page view.
		this.pageView.addBooksPanel(booksPanel);
	}

	/**
	 * Purpose: This method gives us books based on the categoryName.
	 * 
	 * @param categoryName - It could be books, fictions, or non fictions.
	 */
	public void createBooksArray(String categoryName) {
		// Create a category.
		Category category = new Category();

		// Initialize books based on categoryName.
		Book[] books = category.getBooks(categoryName);

		// Initialize a bookslist.
		booksPanel = new BookPanel[books.length - 1];

		// For loop to initialize booksPanel.
		for (int i = 0; i < booksPanel.length; i++)
			booksPanel[i] = new BookPanel(this.pageView, books[i]);
	}
}
