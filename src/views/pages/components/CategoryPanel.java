
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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.CategoryButtonListener;
import views.pages.PageView;
import views.widgets.Button;

@SuppressWarnings("serial")
public class CategoryPanel extends JPanel
{

	// A CategoryPanel has-a bookButton.
	private Button bookButton;
	
	// A CategoryPanel has-a fictionButton.
	private Button fictionButton;
	
	// A CategoryPanel has-a nonfictionButton.
	private Button nonfictionButton;

	public CategoryPanel(PageView view, boolean disable)
	{
		// 1 row and 3 columns, Horizontal gap == 10, Vertical gap == 0.
		setLayout(new GridLayout(1, 3, 10, 0));

		// Make the panel transparent.
		setOpaque(false);

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize the buttonFont.
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 18);

		if (disable)
		{
			// Initialize the bookButton.
			bookButton = new Button("Books", buttonFont, new Color(131, 56, 87), Color.white);

			// Disable button.
			bookButton.setEnabled(false);
		} else
		{
			// Initialize the bookButton.
			bookButton = new Button("Books", buttonFont, new Color(27, 108, 89), Color.white);
		}

		// Initialize the fictionButton.
		fictionButton = new Button("Fiction", buttonFont, new Color(27, 108, 89), Color.white);

		// Initialize the nonfictionButton.
		nonfictionButton = new Button("Nonfiction", buttonFont, new Color(27, 108, 89), Color.white);

		// Add the bookButton to the panel.
		add(bookButton);

		// Add the fictionButton to the panel.
		add(fictionButton);

		// Add the nonfictionButton to the panel.
		add(nonfictionButton);

		new CategoryButtonListener(view, this);

	}

	/**
	 * Get the bookButton.
	 * 
	 * @return bookButton.
	 */
	public Button getBookButton()
	{
		return bookButton;
	}

	/**
	 * Get the fictionButton.
	 * 
	 * @return fictionButton.
	 */
	public Button getFictionButton()
	{
		return fictionButton;
	}

	/**
	 * Get the nonfictionButton.
	 * 
	 * @return nonfictionButton.
	 */
	public Button getNonfictionButton()
	{
		return nonfictionButton;
	}
}
