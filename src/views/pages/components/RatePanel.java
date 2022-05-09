
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 * 
 */
package views.pages.components;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RatePanel extends JPanel
{
	// A RatePanel has-a rateToFive.
	private int rateToFive;
	
	// A RatePanel has-a starLabel.
	private JLabel starLabel;

	public RatePanel(int rate)
	{
		// 1 row and unlimited columns, Horizontal gap == 0, Vertical gap == 0.
		setLayout(new GridLayout(1, 0, 0, 0));

		// Make the panel transparent.
		setOpaque(false);

		// Set alignment to the left.
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// Initialize the rateToFive.
		rateToFive = rate / 20;
		
		// Update the panel.
		update(rateToFive);

	}

	/**
	 * Update the panel based on rate.
	 * @param rateToFive
	 */
	public void update(int rateToFive)
	{
		try
		{
			BufferedImage star3 = ImageIO.read(new File("src/views/images/star3.png"));
			BufferedImage star4 = ImageIO.read(new File("src/views/images/star4.png"));
			BufferedImage star5 = ImageIO.read(new File("src/views/images/star5.png"));
			switch (rateToFive)
			{
			case 4:
				// Initialize star label.
				starLabel = new JLabel(new ImageIcon(star4));
				break;
			case 5:
				// Initialize star label.
				starLabel = new JLabel(new ImageIcon(star5));
				break;
			default:
				// Initialize star label.
				starLabel = new JLabel(new ImageIcon(star3));
				break;

			}

			// Set alignment to the left.
			starLabel.setHorizontalAlignment(SwingConstants.LEFT);

			// Add starLabel to the ratePanel.
			add(starLabel);

		} catch (IOException ex)
		{
			System.out.println("The application can not access the star file.");
		}
	}
}
