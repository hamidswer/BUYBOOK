
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 * 
 */
package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.SortButtonListener;
import views.pages.PageView;
import views.widgets.Button;
import views.widgets.Text;

@SuppressWarnings("serial")
public class SortPanel extends JPanel
{

	// SortPanel has-a text.
	private Text text; 
	
	// SortPanel has-a nameButton. 
	private Button nameButton; 
	
	// SortPanel has-a priceButton.
	private Button priceButton; 
	
	// SortPanel has-a rateButton.
	private Button rateButton;

	// SortPanel has-a font.
	private Font font; 

	public SortPanel(PageView view)
	{
		// 1 row and 4 columns, Horizontal gap == 10, Vertical gap == 0.
		setLayout(new GridLayout(1, 4, 10, 0));

		// Set background color to white.
		setBackground(Color.white);

		// border => top == 0, left == 50, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		// Initialize the buttonFont.
		font = new Font("Times New Roman", Font.PLAIN, 20);

		// Initialize the text.
		text = new Text("Sort", font, Color.black);

		// Add the text to the panel.
		add(text);

		// Initialize the nameButton.
		nameButton = new Button("Name", font, new Color(255, 255, 255), new Color(27, 108, 89));

		// Initialize the priceButton.
		priceButton = new Button("Price", font, new Color(255, 255, 255), new Color(27, 108, 89));

		// Initialize the rateButton.
		rateButton = new Button("Rate", font, new Color(255, 255, 255), new Color(27, 108, 89));

		// Add the nameButton to the panel.
		add(nameButton);

		// Add the priceButton to the panel.
		add(priceButton);

		// Add the rateButton to the panel.
		add(rateButton);
		
		// Listen to the buttons.
		new SortButtonListener(view, this);

	}

	/**
	 * Get the name button.
	 * 
	 * @return nameButton.
	 */
	public Button getNameButton()
	{
		return nameButton;
	}

	/**
	 * Get the price button.
	 * 
	 * @return priceButton.
	 */
	public Button getPriceButton()
	{
		return priceButton;
	}

	/**
	 * Get the rate button.
	 * 
	 * @return rateButton.
	 */
	public Button getRateButton()
	{
		return rateButton;
	}
}
