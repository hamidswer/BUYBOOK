package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controllers.SortButtonListener;
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
 *         Responsibilities of class: It is responsible for creating a sortPanel
 *         to give the sorting option to the customer.
 * 
 *         Version/date: 1.4 / 05/15/2022
 * 
 */

// A SortPanel is-a JPanel.
public class SortPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (SortPanel).
	 */
	// The SortPanel class has-a serialVersionUID.
	private static final long serialVersionUID = 8486334592672057818L;

	// A SortPanel has-a nameButton. 
	private Button nameButton;

	// A SortPanel has-a priceButton.
	private Button priceButton;

	// A SortPanel has-a rateButton.
	private Button rateButton;

	public SortPanel(PageView view)
	{

		GridLayout grid = new GridLayout(1, 4, 10, 0);

		// Set grid as the layout.
		setLayout(grid);

		// Set background color to white.
		setBackground(Color.white);

		setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		Font font = new Font("Times New Roman", Font.PLAIN, 20);

		// Initialize the sortLabel.
		TextLabel sortLabel = new TextLabel("Sort", font, Color.black);

		add(sortLabel);

		// Initialize the nameButton.
		nameButton = new Button("Name", font, new Color(255, 255, 255), new Color(27, 108, 89));
		
		nameButton.addActionListener(new SortButtonListener(view, this, nameButton));
		// Listen to the nameButton to sort books by name.

		add(nameButton);

		// Initialize the priceButton.
		priceButton = new Button("Price", font, new Color(255, 255, 255), new Color(27, 108, 89));

		// Listen to the priceButton to sort books by price.
		priceButton.addActionListener(new SortButtonListener(view, this, priceButton));
		
		add(priceButton);

		// Initialize the rateButton.
		rateButton = new Button("Rate", font, new Color(255, 255, 255), new Color(27, 108, 89));

		// Listen to the rateButton to sort books by rate.
		rateButton.addActionListener(new SortButtonListener(view, this, rateButton));
		
		add(rateButton);

	}

	/**
	 * Purpose: Get the name button.
	 * 
	 * @return nameButton.
	 */
	public Button getNameButton()
	{
		return nameButton;
	}

	/**
	 * Purpose: Get the price button.
	 * 
	 * @return priceButton.
	 */
	public Button getPriceButton()
	{
		return priceButton;
	}

	/**
	 * Purpose: Get the rate button.
	 * 
	 * @return rateButton.
	 */
	public Button getRateButton()
	{
		return rateButton;
	}
}
