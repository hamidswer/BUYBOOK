package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import views.pages.PageView;
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

// A BuyPanel is-a JPanel.
public class BuyPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (BuyPanel).
	 */
	private static final long serialVersionUID = 3275083896254627824L;

	public BuyPanel(PageView view, String postPurchaseMessage)
	{

		// A BuyPanel has-a grid.
		GridLayout grid = new GridLayout(1, 1, 10, 0);

		// Set the grid as the layout.
		setLayout(grid);

		// Set the border to the layout.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// A BuyPanel has-a backgroundColor.
		Color backgroundColor = new Color(131, 56, 87);

		// Set background color to the layout.
		setBackground(backgroundColor);

		// A BuyPanel has-a font.
		Font font = new Font("Times New Roman", Font.PLAIN, 18);

		// A BuyPanel has-a postPurchaseTextLabel.
		// Initialize postPurchaseTextLabel for displaying post purchase message.
		TextLabel postPurchaseTextLabel = new TextLabel(postPurchaseMessage, font, Color.white);

		add(postPurchaseTextLabel);

	}
}
