
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Resources: Trim a string based on the string length Retrieved from
 *         https://stackoverflow.com/questions/8499698/trim-a-string-based-on-the-string-length
 * 
 *         Version/date: 1.1 / 05/08/2022
 * 
 */
package views.pages.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import controllers.BookButtonListener;
import models.Book;
import views.pages.PageView;
import views.widgets.Button;
import views.widgets.Text;

@SuppressWarnings("serial")
public class BookPanel extends JPanel
{
	// BookPanel has-a price.
	private String price; 
	
	// BookPanel has-a priceText.
	private Text priceText; 
	
	// BookPanel has-a nameButton.
	private Button nameButton;
	
	// BookPanel has-a name.
	private String name; 
	
	// BookPanel has-a ratePanel.
	private RatePanel ratePanel;
	
	// BookPanel has-a rate.
	private int rate;

	public BookPanel(PageView view, Book book)
	{
		// Initialize the name.
		name = book.getName();

		// Initialize the price.
		price = String.valueOf(book.getPrice());
		
		// Initialize the rate.
		rate = book.getRate();

		// If the name's length is bigger than 32, It cuts the extra and add ... otherwise assign name value. 
		this.name = (name.length() > 32) ? name.substring(0, Math.min(name.length(), 32)) + "..." : name;

		// Add $ sing to price.
		this.price = "$" + price;

		// Create absolute layout.
		setLayout(null);

		// Set background color to white.
		setBackground(new Color(27, 108, 89));

		// Initialize the buttonFont.
		Font font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the nameButton.
		nameButton = new Button(this.name, font, new Color(27, 108, 89), new Color(255, 255, 255));

		// x == -35, y == 0, width == 398, height == 50.
		nameButton.setBounds(-35, 0, 398, 50);

		// Listen to the nameButton
		new BookButtonListener(view, nameButton, book);
		
		// Add the nameButton to the BookPanel;
		add(nameButton);

		// Initialize the ratePanel.
		ratePanel = new RatePanel(rate);

		// x == -30, y == 45, width == 200, height == 50.
		ratePanel.setBounds(15, 45, 200, 50);

		// Add the ratePanel to the BookPanel;
		add(ratePanel);

		// Initialize the priceText.
		priceText = new Text(this.price, font, Color.white);

		// x == 300, y == 45, width == 50, height == 50.
		priceText.setBounds(300, 45, 50, 50);

		// Add the priceText to the BookPanel;
		add(priceText);
	}
}
