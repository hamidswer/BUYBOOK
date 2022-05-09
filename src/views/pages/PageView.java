
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 * 
 */
package views.pages;

import javax.swing.JFrame;

import models.Book;

import javax.swing.ImageIcon;
import java.awt.Color;

import views.pages.components.LoginAccountPanel;
import views.pages.components.LoginErrorPanel;
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

@SuppressWarnings("serial")
public class PageView extends JFrame
{
	// A PageView has-a headerPanel.
	private HeaderPanel headerPanel;

	// A PageView has-a loginPanel.
	private LoginPanel loginPanel;

	// A PageView has-a loginErrorPanel.
	private LoginErrorPanel loginErrorPanel;

	// A PageView has-a loginAccountPanel.
	private LoginAccountPanel loginAccountPanel;

	// A PageView has-a createAccountPanel.
	private CreateAccountPanel createAccountPanel;

	// A PageView has-a categoryPanel.
	private CategoryPanel categoryPanel;

	// A PageView has-a width.
	private final int width = 428;

	// A PageView has-a height.
	private final int height = 926;

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

		// Initialize the img.
		ImageIcon img = new ImageIcon("src/views/images/logo.png");

		// Set this window's icon.
		setIconImage(img.getImage());

		// Set Login page window's title.
		setTitle("BUYBOOK");

		// Close the application when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The absolute positioning.
		setLayout(null);

		// Add headerPanel to JFrame.
		addHeaderPanel();

		// Add Panels to JFrame.
		addLoginPanels();

		// Set the size of this window, width == 428, height == 926.
		setSize(width, height);

		// Move the window to the center position of the screen.
		setLocationRelativeTo(null);

		// Display the window.
		setVisible(true);

		// Set resizeable to false.
		setResizable(false);

		// Set the Inkwell color as the application background color.
		this.getContentPane().setBackground(new Color(54, 57, 69));

	}

	/**
	 * Repaint the page view.
	 */
	public void repaintPageView()
	{
		// update the UI.
		this.revalidate();
		this.validate();
		this.repaint();
	}

	/**
	 * Add the headerPanel to the pageView.
	 */
	public void addHeaderPanel()
	{
		// Add the header panel to the application.
		// The customer is not logged in to the application.
		headerPanel = new HeaderPanel(this, false);

		// x == 0, y == 0, width == 428, height == 130.
		headerPanel.setBounds(0, 0, width, 130);
		add(headerPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the loginPanels to the pageView.
	 */
	public void addLoginPanels()
	{
		// Add the login form panel to the application.
		loginPanel = new LoginPanel(this);
		// x == 0, y == 280, width == 428, height == 240.
		loginPanel.setBounds(0, 280, width, 240);
		add(loginPanel);

		// Add the error panel to the application.
		loginErrorPanel = new LoginErrorPanel();
		// x == 0, y == 530, width == 428, height == 200.
		loginErrorPanel.setBounds(0, 530, width, 200);
		add(loginErrorPanel);

		// Add create account panel to the application.
		loginAccountPanel = new LoginAccountPanel(this);
		// x == 0, y == 750, width == 428, height == 70.
		loginAccountPanel.setBounds(0, 750, width, 70);
		add(loginAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove loginPanels.
	 */
	public void removeLoginPanels()
	{
		if (loginPanel != null)
			this.remove(loginPanel);
		if (loginErrorPanel != null)
			this.remove(loginErrorPanel);
		if (loginAccountPanel != null)
			this.remove(loginAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * add the loginErrorPanel.
	 * 
	 * @return
	 */
	public void addLoginErrorPanel()
	{
		loginErrorPanel.setError();

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the createAccountPanel.
	 * 
	 * @param view
	 */
	public void addCreateAccountPanel()
	{

		// Add the login form panel to the application.
		createAccountPanel = new CreateAccountPanel(this);
		// x == 0, y == 130, width == 428, height == 600.
		createAccountPanel.setBounds(0, 170, width, 600);
		add(createAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove createAccountPanels.
	 */
	public void removeCreateAccountPanel()
	{
		if (createAccountPanel != null)
			this.remove(createAccountPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the activeHeaderPanel.
	 */
	public void addActiveHeaderPanel()
	{
		if (headerPanel != null)
			// Remove old header panel.
			this.remove(headerPanel);

		// Add the header panel to the application.
		// The customer is logged in to the application.
		headerPanel = new HeaderPanel(this, true);
		// x == 0, y == 0, width == 428, height == 130.
		headerPanel.setBounds(0, 0, width, 130);
		add(headerPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the categoryPanel.
	 */
	public void addCategoryPanel(boolean disable)
	{
		// Initialize the categoryPanel.
		categoryPanel = new CategoryPanel(this, disable);

		// x == 0, y == 130, width == 428, height == 40.
		categoryPanel.setBounds(0, 130, width, 40);

		// Add the categoryPanel.
		add(categoryPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove the categoryPanel.
	 */
	public void removeCategoryPanel()
	{
		if (categoryPanel != null)
			this.remove(categoryPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the sort panel.
	 */
	public void addSortPanel()
	{
		sortPanel = new SortPanel(this);
		// x == 0, y == 180, width == 428, height == 35.
		sortPanel.setBounds(0, 180, width, 35);
		add(sortPanel);
		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove the sortPanel.
	 */
	public void removeSortPanel()
	{
		if (sortPanel != null)
			this.remove(sortPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the booksPanel.
	 */
	public void addBooksPanel(BookPanel[] books)
	{

		// Initialize the booksPanel.
		booksPanel = new BooksPanel(books);

		// Initialize scrollPane
		scroll = new Scroll(booksPanel);

		// x ==0, y == 225, width == 418, height == 700.
		scroll.setBounds(0, 214, width - 10, 676);

		// Add scrollPane to the BooksPanel.
		add(scroll);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove the booksPanel.
	 */
	public void removeBooksPanel()
	{
		if (booksPanel != null)
			this.remove(booksPanel);
		if (scroll != null)
			this.remove(scroll);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the fullBookPanel.
	 */
	public void addFullBookPanel(Book book)
	{
		fullBookPanel = new FullBookPanel(this, book);
		// x == 0, y == 180, width == 428, height == 250.
		fullBookPanel.setBounds(35, 180, 340, 320);
		add(fullBookPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove the fullBookPanel.
	 */
	public void removeFullBookPanel()
	{
		if (fullBookPanel != null)
			this.remove(fullBookPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Add the buyPanel.
	 */
	public void addBuyPanel(String text)
	{
		buyPanel = new BuyPanel(this, text);
		// x == 0, y == 180, width == 428, height == 250.
		buyPanel.setBounds(35, 180, 340, 320);
		add(buyPanel);

		// Repaint the page view.
		repaintPageView();
	}

	/**
	 * Remove the buyPanel.
	 */
	public void removeBuyPanel()
	{
		if (buyPanel != null)
			this.remove(buyPanel);

		// Repaint the page view.
		repaintPageView();
	}

}
