
package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controllers.BuyButtonListener;
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
 *         Serializable Interface in Java.
 *         https://www.geeksforgeeks.org/serializable-interface-in-java
 * 
 *         What does it mean: The serializable class does not declare a static
 *         final serialVersionUID field?
 *         https://stackoverflow.com/questions/2288937/what-does-it-mean-the-serializable-class-does-not-declare-a-static-final-serial
 * 
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 1.2 / 05/12/2022
 * 
 * 
 */

// A FullBookPanel is-a JPanel.
public class FullBookPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (FullBookPanel).
	 */
	private static final long serialVersionUID = 8221159403787184417L;

	public FullBookPanel(PageView view, Book book)
	{
		// Initialize the name.
		String name = book.getName();

		// Initialize the author.
		String author = "Author: " + book.getAuthor();

		// Initialize the year.
		String year = "Published in: " + String.valueOf(book.getYear());

		// Initialize the rate.
		int rate = book.getRate();

		// Initialize the price.
		String price = "$" + String.valueOf(book.getPrice());

		int leftInStore = book.getLeftInStore();

		// Initialize bgColor with Raspberry Sorbet Shade color.
		Color backgroundColor = new Color(131, 56, 87);

		// Set background color.
		setBackground(backgroundColor);

		// Intialize grid as GridBagLayout.
		GridBagLayout grid = new GridBagLayout();

		// Set the grid as the layout.
		setLayout(grid);

		// Initialize constraints.
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.VERTICAL;

		// Initialize the font for nameLabel.
		Font font = new Font("Times New Roman", Font.PLAIN, 20);

		// Turn name in Html format.
		name = "<html><center>" + printName(name, 0) + "</center></html>";

		// Initialize nameLabel.
		TextLabel nameLabel = new TextLabel(name, font, Color.white);

		// Set grid settings for nameText.
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 12;
		constraints.gridheight = 4;

		add(nameLabel, constraints);

		// Initialize the font for descriptionLabel.
		font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the descriptionText.
		String description = "<html>" + author + "<br>" + year + "</htl>";

		// Initialize descriptionLabel.
		TextLabel descriptionLabel = new TextLabel(description, font, Color.white);

		// Set constraints settings for descriptionText.
		constraints.gridy = 5;
		constraints.gridheight = 4;

		// align to the left.
		constraints.anchor = GridBagConstraints.WEST;

		// Add insets to the descriptionText for margin.
		constraints.insets = new Insets(0, 20, 0, 20);

		add(descriptionLabel, constraints);

		// Initialize bgColor with Mint color.
		backgroundColor = new Color(0, 161, 112);

		// Initialize the electronicButton.
		Button electronicButton = new Button("Electronic Book", font, backgroundColor, new Color(255, 255, 255));

		// Set empty border for electronicButton.
		electronicButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

		// Listen to the electronicButton
		new BuyButtonListener(view, electronicButton, book);

		// Set constraints settings for electronicButton.
		constraints.gridy = 10;
		constraints.gridheight = 1;
		constraints.gridwidth = 6;

		// Add insets to the electronicButton for margin.
		constraints.insets = new Insets(0, 20, 0, 0);

		// Add the electronicButton to the fullBookPanel;
		add(electronicButton, constraints);

		if (leftInStore > 0)
		{
			// Initialize the paperButton.
			Button paperButton = new Button("Paper Book", font, backgroundColor, new Color(255, 255, 255));

			// Set empty border for paperButton.
			paperButton.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));

			// Listen to the paperButton
			new BuyButtonListener(view, paperButton, book);

			// align to the right.
			constraints.anchor = GridBagConstraints.EAST;

			// Add insets to the paperButton for margin.
			constraints.insets = new Insets(0, 0, 0, 20);

			// Add the paperButton to the fullBookPanel;
			add(paperButton, constraints);
		}

		// Initialize the ratePanel.
		RatePanel ratePanel = new RatePanel(rate);

		// Set constraints settings for ratePanel.
		constraints.gridy = 15;
		constraints.gridheight = 2;

		// align to the left.
		constraints.anchor = GridBagConstraints.WEST;

		// Add insets to the ratePanel for margin.
		constraints.insets = new Insets(0, 20, 0, 0);

		add(ratePanel, constraints);

		// Initialize the font for priceLabel.
		font = new Font("Times New Roman", Font.PLAIN, 16);

		// Initialize the priceLabel.
		TextLabel priceLabel = new TextLabel(price, font, Color.white);

		// align to the right.
		constraints.anchor = GridBagConstraints.EAST;

		// Add insets to the priceText for margin.
		constraints.insets = new Insets(0, 0, 0, 30);

		// Add the priceText to the fullBookPanel;
		add(priceLabel, constraints);
	}

	/**
	 * Recursive method to turn name in Html format.
	 * 
	 * @param name  book's name
	 * @param start it's the start point
	 * @return name in html format
	 */
	public String printName(String name, int start)
	{
		int end = name.length();
		if (end < 30)
		{
			return name + "";
		}
		return name.substring(start, 30) + "<br>" + printName(name.substring(start + 30, end), start);

	}
}
