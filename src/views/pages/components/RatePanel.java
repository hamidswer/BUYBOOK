package views.pages.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import views.widgets.TextLabel;

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
 *         Responsibilities of class: It creates a ratePanel for showing
 *         star-rate component for a book to the user.
 * 
 *         Version/date: 1.5 / 05/26/2022
 * 
 * 
 */

// A RatePanel is-a JPanel.
public class RatePanel extends JPanel {
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (RatePanel).
	 */
	// The RatePanel class has-a serialVersionUID.
	private static final long serialVersionUID = 7677127992298657718L;

	// A RatePanel has-a starLabel.
	private TextLabel starLabel;

	private int bookRate;

	public RatePanel(int bookRate) {
		GridLayout grid = new GridLayout(1, 0, 0, 0);

		setLayout(grid);

		// Make the panel transparent.
		setOpaque(false);

		// Set alignment to the left.
		setAlignmentX(Component.LEFT_ALIGNMENT);

		this.bookRate = bookRate;

		// Update the panel.
		update();

	}

	/**
	 * Purpose: creates star-rate images for the panel based on a book's rate.
	 * 
	 */
	public void update() {
		// Initialize the rate by converting rate to the equivelant 5-star rating.
		int rate = bookRate / 20;

		try {
			// Initialize a threeStarsImage.
			BufferedImage threeStarsImage = ImageIO.read(new File("src/views/images/star3.png"));

			// Initialize a fourStarsImage.
			BufferedImage fourStarsImage = ImageIO.read(new File("src/views/images/star4.png"));

			// Initialize a fiveStarsImage.
			BufferedImage fiveStarsImage = ImageIO.read(new File("src/views/images/star5.png"));
			switch (rate) {
			case 3:
				// Initialize star label.
				starLabel = new TextLabel(new ImageIcon(threeStarsImage));
				break;
			case 4:
				// Initialize star label.
				starLabel = new TextLabel(new ImageIcon(fourStarsImage));
				break;
			default:
				// Initialize star label.
				starLabel = new TextLabel(new ImageIcon(fiveStarsImage));
				break;

			}

			// Set alignment to the left.
			starLabel.setHorizontalAlignment(SwingConstants.LEFT);

			// Add starLabel to the ratePanel.
			add(starLabel);

		} catch (IOException ex) {
			Font font = new Font("Times New Roman", Font.PLAIN, 14);

			TextLabel text = new TextLabel(String.valueOf(bookRate), font, Color.white);

			add(text);
		}
	}
}
