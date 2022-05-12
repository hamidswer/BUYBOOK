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
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 1.3 / 05/12/2022
 * 
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
	private static final long serialVersionUID = 8486334592672057818L;

	// SortPanel has-a nameButton. 
	private Button nameButton;

	// SortPanel has-a priceButton.
	private Button priceButton;

	// SortPanel has-a rateButton.
	private Button rateButton;

	public SortPanel(PageView view)
	{

		GridLayout grid = new GridLayout(1, 4, 10, 0);

		// Set grid as the layout.
		setLayout(grid);

		// Set background color to white.
		setBackground(Color.white);

		// border => top == 0, left == 50, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		// Initialize the buttonFont.
		Font font = new Font("Times New Roman", Font.PLAIN, 20);

		// Initialize the sortLabel.
		TextLabel sortLabel = new TextLabel("Sort", font, Color.black);

		add(sortLabel);

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

		// Listen to the nameButton.
		new SortButtonListener(view, this, nameButton);

		// Listen to the priceButton.
		new SortButtonListener(view, this, priceButton);

		// Listen to the rateButton.
		new SortButtonListener(view, this, rateButton);

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
