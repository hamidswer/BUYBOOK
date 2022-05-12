package views.widgets;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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

// A TextLabel is-a JLabel.
public class TextLabel extends JLabel
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The
	 * JLabel class implements java.io.Serializable interface so the it's
	 * subclass (TextLabel).
	 */
	private static final long serialVersionUID = -2068023178626384625L;

	public TextLabel(String text, Font font, Color color)
	{
		// initialize the text.
		super(text);

		// Set the font.
		setFont(font);

		// Set the text color.
		setForeground(color);
	}

	public TextLabel(ImageIcon imageIcon)
	{
		super(imageIcon);
	}
}
