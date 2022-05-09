
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/06/2022
 * 
 * 
 */
package views.pages.components;

import java.awt.Dimension;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BooksPanel extends JPanel
{
	
	// BooksPanel has-a xCoordinate.
	private int xCoordinate; 
	
	// BooksPanel has-a yCoordinate.
	private int yCoordinate;
	
	// BooksPanel has-a width.
	private final int width = 343; 
	
	// BooksPanel has-a height.
	private int height = 100; 

	public BooksPanel(BookPanel[] bookPanels)
	{
		// Set null layout/absolute layout.
		setLayout(null);

		// Make the panel transparent.
		setOpaque(false);

		// Initialize a xCoordinate.
		xCoordinate = 35;

		// Initialize a yCoordinate.
		yCoordinate = 25;

		// Add all bookPanels to booksPanel.
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
