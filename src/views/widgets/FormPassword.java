package views.widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPasswordField;

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
 *         Version/date: 1.1 / 05/12/2022
 * 
 * 
 */

// A FormPassword is-a JPasswordField.
public class FormPassword extends JPasswordField
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The
	 * JPasswordField class implements java.io.Serializable interface so the it's
	 * subclass (FormPassword).
	 */
	private static final long serialVersionUID = 8215160929807479423L;

	public FormPassword(String text, Font font, int margin)
	{
		super(text);
		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(new Color(147, 149, 151));

		// Set the cursor color to white.
		setCaretColor(Color.WHITE);

		// Set margin for a password field (The space between text and border).
		setMargin(new Insets(margin, margin, margin, margin));

		// Make a password field transparent.
		setOpaque(false);
	}
}
