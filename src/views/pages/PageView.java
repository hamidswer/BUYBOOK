package views.pages;

import javax.swing.JFrame;
import models.Book;
import javax.swing.ImageIcon;
import java.awt.Color;
import views.pages.components.LoginAccountPanel;
import views.pages.components.BookPanel;
import views.pages.components.BooksPanel;
import views.pages.components.BuyPanel;
import views.pages.components.CategoryPanel;
import views.pages.components.CreateAccountPanel;
import views.pages.components.FullBookPanel;
import views.pages.components.HeaderPanel;
import views.pages.components.LoginPanel;
import views.pages.components.SortPanel;
import views.widgets.Scroll;

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
 *         Instance variable In Java: All you need to know.
 *         https://www.edureka.co/blog/instance-variable-in-java
 * 
 *         Serializable Interface in Java.
 *         https://www.geeksforgeeks.org/serializable-interface-in-java
 * 
 *         What does it mean: The serializable class does not declare a static
 *         final serialVersionUID field?
 *         https://stackoverflow.com/questions/2288937/what-does-it-mean-the-serializable-class-does-not-declare-a-static-final-serial
 * 
 * 
 *         Responsibilities of class: It creates the pageView.
 * 
 *         Version/date: 1.9 / 05/26/2022
 * 
 * 
 */

// A PageView is-a JFrame.
public class PageView extends JFrame
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JFrame
	 * class implements java.io.Serializable interface so the it's subclass
	 * (PageView).
	 */
	// The PageView class has-a serialVersionUID.
	private static final long serialVersionUID = 3292032292637496818L;

	// A PageView has-a width.
	private final int width = 428;

	// A PageView has-a height.
	private final int height = 800;

	// A PageView has-a headerPanel.
	private HeaderPanel headerPanel;

	// A PageView has-a loginPanel.
	private LoginPanel loginPanel;

	// A PageView has-a loginAccountPanel.
	private LoginAccountPanel loginAccountPanel;

	// A PageView has-a createAccountPanel.
	private CreateAccountPanel createAccountPanel;

	// A PageView has-a categoryPanel.
	private CategoryPanel categoryPanel;

	// A PageView has-a sortPanel.
	private SortPanel sortPanel;

	// A PageView has-a booksPanel.
	private BooksPanel booksPanel;

	// A PageView has-a scroll.
	private Scroll scroll;

	// A PageView has-a fullBookPanel.
	private FullBookPanel fullBookPanel;

	// A PageView has-a buyPanel.
	private BuyPanel buyPanel;

	public PageView()
	{

		// Initialize the logoImage.
		ImageIcon logoImage = new ImageIcon("src/views/images/logo.png");

		// Set this window's icon.
		setIconImage(logoImage.getImage());

		// Set Login page window's title.
		setTitle("BUYBOOK");

		// Close the application when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The absolute positioning.
		setLayout(null);

		// Add headerPanel without the logout button.
		addHeaderPanel(false);

		// Add the loginPanels.
		addLoginPanels();

		// Set the size of this window.
		setSize(width, height);

		// Move the window to the center position of the screen.
		setLocationRelativeTo(null);

		// Display the window.
		setVisible(true);

		// Set resizeable to false.
		setResizable(false);

		// Set the Inkwell color as the application background color.
		getContentPane().setBackground(new Color(54, 57, 69));

	}

	/**
	 * Purpose: It removes the old header panel and adds the new header panel to the
	 * page view.
	 * 
	 * @param isUserloggedIn - true means the user logged.
	 */
	public void addHeaderPanel(boolean isUserloggedIn)
	{
		if (headerPanel != null)
			// Remove old header panel.
			remove(headerPanel);

		// Create a headerPanel.
		headerPanel = new HeaderPanel(this, isUserloggedIn);

		headerPanel.setBounds(0, 0, width, 130);

		add(headerPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It adds the loginPanel, loginErrorPanel, and loginAccountPanel to
	 * the page view.
	 */
	public void addLoginPanels()
	{
		// Create a loginPanel.
		loginPanel = new LoginPanel(this);

		loginPanel.setBounds(0, 280, width, 240);

		add(loginPanel);

		// create a loginAccountPanel.
		loginAccountPanel = new LoginAccountPanel(this);

		loginAccountPanel.setBounds(0, 550, width, 70);

		add(loginAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It adds the createAccountPanel to the page view.
	 */
	public void addCreateAccountPanel()
	{

		// create a createAccountPanel.
		createAccountPanel = new CreateAccountPanel(this);

		createAccountPanel.setBounds(0, 140, width, 600);

		add(createAccountPanel);
		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the old categoryPanel and adds a new categoryPanel with
	 * the option to make the books button disabled or enabled to the page view.
	 * 
	 * @param booksButtonDisabled the books button would be disabled if it's true,
	 *                            or enabled if its false.
	 */
	public void addCategoryPanel(boolean booksButtonDisabled)
	{
		// Remove the old categoryPanel.
		removeCategoryPanel();

		// create a categoryPanel.
		categoryPanel = new CategoryPanel(this, booksButtonDisabled);

		categoryPanel.setBounds(0, 130, width, 40);

		add(categoryPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * It adds the sortPanel to the page view.
	 */
	public void addSortPanel()
	{
		// create a sortPanel.
		sortPanel = new SortPanel(this);

		sortPanel.setBounds(0, 180, width, 35);

		add(sortPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It receives a list of bookPanel. then create a new booksPanel.then
	 * add the new booksPanel to the scroll panel. finally add the scroll panel to
	 * the page view to show the list of books.
	 * 
	 * @param books - a list of bookPanel to show a brief information of each book
	 *              to the customer.
	 */
	public void addBooksPanel(BookPanel[] books)
	{

		// create a booksPanel.
		booksPanel = new BooksPanel(books);

		// create a scroll.
		scroll = new Scroll(booksPanel);

		scroll.setBounds(0, 214, width - 10, 550);

		add(scroll);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It adds the fullBookPanel to the page view to show more information
	 * about a book to customer.
	 * 
	 * @param book - To give more information about a book to customer.
	 */
	public void addFullBookPanel(Book book)
	{
		// create a fullBookPanel.
		fullBookPanel = new FullBookPanel(this, book);

		fullBookPanel.setBounds(35, 180, 340, 320);

		add(fullBookPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: Add the buyPanel to the page view.
	 * 
	 * @param postPurchaseMessage - for displaying post purchase message.
	 */
	public void addBuyPanel(String postPurchaseMessage)
	{
		// create a buyPanel.
		buyPanel = new BuyPanel(this, postPurchaseMessage);

		buyPanel.setBounds(35, 180, 340, 320);

		add(buyPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes loginPanel, loginErrorPanel, and loginAccountPanel from
	 * the page view if they're existed in the page view.
	 */
	public void removeLoginPanels()
	{
		if (loginPanel != null)
			remove(loginPanel);
		if (loginAccountPanel != null)
			remove(loginAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the createAccountPanel from the page view.
	 */
	public void removeCreateAccountPanel()
	{
		if (createAccountPanel != null)
			remove(createAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the categoryPanel from the page view if it's existed in
	 * the page view.
	 */
	public void removeCategoryPanel()
	{
		if (categoryPanel != null)
			remove(categoryPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the sortPanel from the page view if it's existed in the
	 * page view.
	 */
	public void removeSortPanel()
	{
		if (sortPanel != null)
			remove(sortPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the booksPanel and scroll from the page view if they are
	 * existed in the page view.
	 */
	public void removeBooksPanel()
	{
		if (booksPanel != null)
			remove(booksPanel);
		if (scroll != null)
			remove(scroll);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the fullBookPanel from the page view if it's existed in
	 * the page view.
	 */
	public void removeFullBookPanel()
	{
		if (fullBookPanel != null)
			remove(fullBookPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It removes the buyPanel from the page view if it's existed in the
	 * page view.
	 */
	public void removeBuyPanel()
	{
		if (buyPanel != null)
			remove(buyPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Purpose: It repaints the page view.
	 */
	private void repaintPageView()
	{
		// update the UI.
		revalidate();
		validate();
		repaint();
	}

}
