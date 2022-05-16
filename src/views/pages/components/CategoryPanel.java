package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controllers.CategoryButtonListener;
import views.pages.PageView;
import views.widgets.Button;

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
// A CategoryPanel is-a JPanel.
public class CategoryPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (CategoryPanel).
	 */
	// The CategoryPanel class has-a serialVersionUID.
	private static final long serialVersionUID = 2882009846855201959L;

	// A CategoryPanel has-a booksButton.
	private Button booksButton;

	// A CategoryPanel has-a fictionButton.
	private Button fictionButton;

	// A CategoryPanel has-a nonfictionButton.
	private Button nonfictionButton;

	public CategoryPanel(PageView view, boolean booksButtonDisabled)
	{
		// A CategoryPanel has-a grid.
		GridLayout grid = new GridLayout(1, 3, 10, 0);

		// Set the grid layout.
		setLayout(grid);

		// Make the panel transparent.
		setOpaque(false);

		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		Font font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the bookButton.
		booksButton = new Button("Books", font, new Color(27, 108, 89), Color.white);

		// Initialize the fictionButton.
		fictionButton = new Button("Fiction", font, new Color(27, 108, 89), Color.white);

		// Initialize the nonfictionButton.
		nonfictionButton = new Button("Nonfiction", font, new Color(27, 108, 89), Color.white);

		// if the constructor indicates that books button must be disabled
		if (booksButtonDisabled)
		{
			// Change the background of booksButton.
			booksButton.setBackground(new Color(131, 56, 87));

			// Disable booksButton.
			booksButton.setEnabled(false);
		}

		// Add the bookButton to the panel.
		add(booksButton);

		// Add the fictionButton to the panel.
		add(fictionButton);

		// Add the nonfictionButton to the panel.
		add(nonfictionButton);

		// Listen to the booksButton. 
		new CategoryButtonListener(view, this, booksButton);

		// Listen to the fictionButton.
		new CategoryButtonListener(view, this, fictionButton);

		// Listen to the nonfictionButton.
		new CategoryButtonListener(view, this, nonfictionButton);

	}

	/**
	 * Purpose: Get the booksButton.
	 * 
	 * @return booksButton.
	 */
	public Button getBooksButton()
	{
		return booksButton;
	}

	/**
	 * Purpose: Get the fictionButton.
	 * 
	 * @return fictionButton.
	 */
	public Button getFictionButton()
	{
		return fictionButton;
	}

	/**
	 * Purpose: Get the nonfictionButton.
	 * 
	 * @return nonfictionButton.
	 */
	public Button getNonfictionButton()
	{
		return nonfictionButton;
	}
}
