package views.pages.components;

import java.awt.Dimension;
import javax.swing.JPanel;

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
 *         Responsibilities of class: It is responsible to create a panel from
 *         bookPanels array elements.
 * 
 *         Version/date: 1.2 / 05/15/2022
 * 
 * 
 */

// A BooksPanel is-a JPanel.
public class BooksPanel extends JPanel
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (BooksPanel).
	 */
	// The BooksPanel class has-a serialVersionUID.
	private static final long serialVersionUID = 7555327188223947100L;

	public BooksPanel(BookPanel[] bookPanels)
	{
		// Set null layout/absolute layout.
		setLayout(null);

		// Make the panel transparent.
		setOpaque(false);

		// Initialize a xCoordinate.
		int xCoordinate = 35;

		// Initialize a yCoordinate.
		int yCoordinate = 25;

		// Initialize the width.
		int width = 343;

		// Initialize the height.
		int height = 100;

		// Add all bookPanels to the booksPanel.
		for (BookPanel bookPanel : bookPanels)
		{
			bookPanel.setBounds(xCoordinate, yCoordinate, width, height);
			add(bookPanel);
			yCoordinate += 125;
		}

		// Set the size of a BooksPanel object.
		setPreferredSize(new Dimension(width, yCoordinate + 25));
	}
}
