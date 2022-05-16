package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
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

// A LoginErrorPanel is-a JPanel.
public class LoginErrorPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (LoginErrorPanel).
	 */
	// The LoginErrorPanel class has-a serialVersionUID.
	private static final long serialVersionUID = -7885383771258589142L;

	// A LoginErrorPanel has a font.
	private Font font;

	// A LoginErrorPanel has-an errorLabel.
	private TextLabel errorLabel;
	
	public LoginErrorPanel(String errorMessage)
	{
		// Make the panel transparent.
		setOpaque(false);

		GridLayout grid = new GridLayout(1, 1, 0, 10);

		// Set grid layout.
		setLayout(grid);

		setBorder(BorderFactory.createEmptyBorder(0, 35, 80, 50));

		// Add the emailField to the createAccountPanel.
		// Initialize the buttonFont.
		font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the errorLabel. 
		errorLabel = new TextLabel(errorMessage, font, Color.white);
		add(errorLabel);
	}

}
