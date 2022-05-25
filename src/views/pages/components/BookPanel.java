package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import controllers.BookButtonListener;
import models.Book;
import views.pages.PageView;
import views.widgets.Button;
import views.widgets.TextLabel;

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
 *         Trim a string based on the string length Retrieved from
 *         https://stackoverflow.com/questions/8499698/trim-a-string-based-on-the-string-length
 * 
 *         Serializable Interface in Java.
 *         https://www.geeksforgeeks.org/serializable-interface-in-java
 * 
 *         What does it mean: The serializable class does not declare a static
 *         final serialVersionUID field?
 *         https://stackoverflow.com/questions/2288937/what-does-it-mean-the-serializable-class-does-not-declare-a-static-final-serial
 * 
 *         Responsibilities of class: It is responsible to display the book's
 *         name, rate and price to the customer.
 * 
 *         Version/date: 1.3 / 05/15/2022
 * 
 * 
 */

// A BookPanel is-a JPanel.
public class BookPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (BookPanel).
	 */
	// The BookPanel class has-a serialVersionUID.
	private static final long serialVersionUID = -1463357052369615812L;

	public BookPanel(PageView view, Book book)
	{
		// Initialize the name.
		String name = book.getName();

		// Initialize the price.
		String price = String.valueOf(book.getPrice());

		// Initialize the rate.
		int rate = book.getRate();

		// If the name's length is bigger than 32, It cuts the extra and add ... otherwise assign name value. 
		name = (name.length() > 32) ? name.substring(0, Math.min(name.length(), 32)) + "..." : name;

		// Add $ sing to price.
		price = "$" + price;

		// Create absolute layout.
		setLayout(null);

		setBackground(new Color(27, 108, 89));

		Font font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the nameButton.
		Button nameButton = new Button(name, font, new Color(27, 108, 89), new Color(255, 255, 255));

		nameButton.setBounds(-35, 0, 398, 50);

		// Listen to the nameButton
		nameButton.addActionListener(new BookButtonListener(view, nameButton, book));

		add(nameButton);

		// Initialize the ratePanel.
		RatePanel ratePanel = new RatePanel(rate);

		ratePanel.setBounds(15, 45, 200, 50);

		add(ratePanel);

		// Initialize the priceText.
		TextLabel priceText = new TextLabel(price, font, Color.white);

		priceText.setBounds(300, 45, 50, 50);

		add(priceText);
	}
}
