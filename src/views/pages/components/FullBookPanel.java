
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 * 
 *         Version/date: 1.1 / 05/08/2022
 * 
 */
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
import views.widgets.Text;

@SuppressWarnings("serial")
public class FullBookPanel extends JPanel
{
	// FullBookPanel has-a price.
	private String price;

	// FullBookPanel has-a priceText.
	private Text priceText;

	// FullBookPanel has-a nameText.
	private Text nameText;

	// FullBookPanel has-a name.
	private String name;

	// FullBookPanel has-a author.
	private String author;

	// FullBookPanel has-a year.
	private String year;

	// FullBookPanel has-a ratePanel.
	private RatePanel ratePanel;

	// FullBookPanel has-a rate.
	private int rate;

	// FullBookPanel has-a bgColor.
	private Color bgColor;

	// FullBookPanel has-a font.
	private Font font;

	// FullBookPanel has-a descriptionLabel.
	private Text descriptionLabel;

	// FullBookPanel has-a constraints.
	private GridBagConstraints constraints;

	// FullBookPanel has-a electronicButton.
	private Button electronicButton;

	// FullBookPanel has-a paperButton.
	private Button paperButton;

	// FullBookPanel has-a leftInStore.
	private int leftInStore;

	public FullBookPanel(PageView view, Book book)
	{
		// Initialize the name.
		name = book.getName();

		// Initialize the author.
		author = "Author: " + book.getAuthor();

		// Initialize the year.
		year = "Published in: " + String.valueOf(book.getYear());

		// Initialize the rate.
		rate = book.getRate();

		// Initialize the price.
		price = "$" + String.valueOf(book.getPrice());

		leftInStore = book.getLeftInStore();

		// Initialize bgColor with Raspberry Sorbet Shade color.
		bgColor = new Color(131, 56, 87);

		// Set background color.
		setBackground(bgColor);

		// Set GridBagLayout.
		setLayout(new GridBagLayout());

		// Initialize constraints.
		constraints = new GridBagConstraints();
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.VERTICAL;

		// Initialize the font for nameButton.
		font = new Font("Times New Roman", Font.PLAIN, 20);

		// Turn name in Html format.
		name = "<html><center>" + printName(name, 0) + "</center></html>";

		// Initialize nameText.
		nameText = new Text(name, font, Color.white);

		// Set grid settings for nameText.
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 12;
		constraints.gridheight = 4;

		// Add the nameText to the fullBookPanel;
		add(nameText, constraints);

		// Initialize the font for description.
		font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the descriptionText.
		String descriptionText = "<html>" + author + "<br>" + year + "</htl>";

		// Initialize descriptionLabel.
		descriptionLabel = new Text(descriptionText, font, Color.white);

		// Set constraints settings for descriptionLabel.
		constraints.gridy = 5;
		constraints.gridheight = 4;

		// align to the left.
		constraints.anchor = GridBagConstraints.WEST;

		// Add insets to the descriptionLabel for margin.
		constraints.insets = new Insets(0, 20, 0, 20);

		// Add the descriptionLabel to the fullBookPanel;
		add(descriptionLabel, constraints);

		// Initialize bgColor with Mint color.
		bgColor = new Color(0, 161, 112);

		// Initialize the electronicButton.
		electronicButton = new Button("Electronic Book", font, bgColor, new Color(255, 255, 255));

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
			paperButton = new Button("Paper Book", font, bgColor, new Color(255, 255, 255));

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
		ratePanel = new RatePanel(rate);

		// Set constraints settings for ratePanel.
		constraints.gridy = 15;
		constraints.gridheight = 2;

		// align to the left.
		constraints.anchor = GridBagConstraints.WEST;

		// Add insets to the ratePanel for margin.
		constraints.insets = new Insets(0, 20, 0, 0);

		// Add ratePanel to the fullBookPanel.
		add(ratePanel, constraints);

		// Initialize the font for priceText.
		font = new Font("Times New Roman", Font.PLAIN, 16);

		// Initialize the priceText.
		priceText = new Text(this.price, font, Color.white);

		// align to the right.
		constraints.anchor = GridBagConstraints.EAST;

		// Add insets to the priceText for margin.
		constraints.insets = new Insets(0, 0, 0, 30);

		// Add the priceText to the fullBookPanel;
		add(priceText, constraints);
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
