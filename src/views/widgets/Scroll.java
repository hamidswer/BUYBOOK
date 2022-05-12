package views.widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

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
 *         Class BasicScrollBarUI Retrieved from
 *         https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/plaf/basic/BasicScrollBarUI.html
 * 
 *         How to hide the arrow buttons in a JScrollBar Retrieved from
 *         https://stackoverflow.com/questions/7633354/how-to-hide-the-arrow-buttons-in-a-jscrollbar
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

// A Scroll is-a JScrollPane.
public class Scroll extends JScrollPane
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The
	 * JScrollPane class implements java.io.Serializable interface so the it's
	 * subclass (Scroll).
	 */
	private static final long serialVersionUID = -4346093878409316920L;

	public Scroll(Component view)
	{
		super(view);

		// Make the panel transparent.
		setOpaque(false);

		// Make the viewport transparent.
		getViewport().setOpaque(false);

		// Set Inkwell color as scroll bar's background color.
		getVerticalScrollBar().setBackground(new Color(54, 57, 69));

		// Set the scroll speed.
		getVerticalScrollBar().setUnitIncrement(16);

		// Set custom scroll bar design
		getVerticalScrollBar().setUI(new BasicScrollBarUI()
		{
			// override configureScrollBarColors method of BasicScrollBarUI class.
			@Override
			protected void configureScrollBarColors()
			{
				// Set the thumb color.
				this.thumbColor = new Color(210, 56, 108);

				// Set the scroll bar width.
				this.scrollBarWidth = 20;
			}

			// override createDecreaseButton method of BasicScrollBarUI class.
			@Override
			protected Button createDecreaseButton(int orientation)
			{
				return createZeroButton();
			}

			// override createIncreaseButton method of BasicScrollBarUI class.
			@Override
			protected Button createIncreaseButton(int orientation)
			{
				return createZeroButton();
			}

		});

	}

	/**
	 * Remove the button.
	 * 
	 * @return button with size zero.
	 */
	private Button createZeroButton()
	{
		// Initialize an empty button.
		Button button = new Button();

		// Set preferrred size of button to zero.
		button.setPreferredSize(new Dimension(0, 0));

		// Set minimum size of button to zero.
		button.setMinimumSize(new Dimension(0, 0));

		// Set maximum size of button to zero.
		button.setMaximumSize(new Dimension(0, 0));

		return button;
	}
}
