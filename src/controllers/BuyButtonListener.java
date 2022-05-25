package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Book;
import models.BuyBook;
import views.pages.PageView;
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
 *         Responsibilities of class: It listens to the purchaseOptionButton,
 *         and if the purchaseOptionButton is clicked, It removes the full book
 *         panel and adds the buy panel.
 * 
 *         Version/date: 1.4 / 05/15/2022
 * 
 * 
 */
// A BuyButtonListener is-an ActionListener.
public class BuyButtonListener implements ActionListener
{

	// A BuyButtonListener has-a pageView.
	private PageView pageView;

	// A BuyButtonListener has-a book.
	private Book book;

	// A BuyButtonListener has-a purchaseOptionButton.
	private Button purchaseOptionButton;

	public BuyButtonListener(PageView pageView, Button purchaseOptionButton, Book book)
	{
		// Assign the pageView value.
		this.pageView = pageView;

		// Assign the purchaseOptionButton value.
		this.purchaseOptionButton = purchaseOptionButton;

		// Assign the book value.
		this.book = book;

	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the purchaseOptionButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize buttonText with the purchaseOptionButton text value.
		String buttonText = purchaseOptionButton.getText();

		// Initialize a buyBook model with book and buttonText as arguments. The buyBook use this information for 
		// giving the post purchased message and if the customer asks for a paper book, updating the inventory database.
		BuyBook buyBook = new BuyBook(book, buttonText);

		// Update the view by getting getPostPurchasedMessage from buyBook.
		update(buyBook.getPostPurchasedMessage());

	}

	/**
	 * Purpose: It removes the fullBookPanel and adds buyPanel with
	 * postPurchasedMessage as an argument.
	 * 
	 * @param postPurchasedMessage - the message to show the customer after buying a
	 *                             book.
	 */
	public void update(String postPurchasedMessage)
	{
		// Remove the fullBookPanel.
		this.pageView.removeFullBookPanel();

		// Add the buyPanel.
		this.pageView.addBuyPanel(postPurchasedMessage);

	}

}
