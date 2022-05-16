package views.widgets;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

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
 *         Responsibilities of class: It's responsible to create a formText and
 *         set's its text, font and margin.
 * 
 *         Version/date: 1.3 / 05/16/2022
 * 
 * 
 */

//A FormText is-a JTextField.
public class FormText extends JTextField
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The
	 * JTextField class implements java.io.Serializable interface so the it's
	 * subclass (FormText).
	 */
	// The FormText class has-a serialVersionUID.
	private static final long serialVersionUID = 5779771745533988802L;

	public FormText(String text, Font font, int margin)
	{

		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(new Color(147, 149, 151));

		// Set text value.
		setText(text);

		// Set the cursor color to white.
		setCaretColor(Color.WHITE);

		// Set margin for a text field (The space between text and border).
		setMargin(new Insets(margin, margin, margin, margin));

		// Make a text field transparent.
		setOpaque(false);
	}

}
