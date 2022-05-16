package views.widgets;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
 *         Responsibilities of class: It's responsible to create a button and
 *         sets it's background, and foreground color, it's text value and it's
 *         font.
 *         
 *         Version/date: 1.4 / 05/15/2022
 * 
 * 
 */

// A Button is-a JButton.
public class Button extends JButton
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JButton
	 * class implements java.io.Serializable interface so the it's subclass
	 * (Button).
	 */
	// The Button class has-a serialVersionUID.
	private static final long serialVersionUID = -4059844035938244665L;

	// overrides the constructor without any parameter in JButton Superclass (Polymorphism).
	public Button()
	{
	}

	public Button(String text, Font font, Color backgroundColor, Color foregroundColor)
	{
		// calling JButton(Superclass) and set the text of Button.
		super(text);

		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(foregroundColor);

		// Set background color.
		setBackground(backgroundColor);

		// Remove border around a button.
		setBorder(BorderFactory.createEmptyBorder());

		// Remove border around a button's text after mouse clicking.
		setFocusable(false);
	}

	// overrides the constructor with ImageIcon parameter in JButton Superclass (Polymorphism).
	public Button(ImageIcon imageIcon)
	{
		super(imageIcon);
	}

}
