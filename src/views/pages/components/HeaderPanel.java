package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.AboutButtonListener;
import controllers.LogoutButtonListener;
import views.pages.PageView;
import views.widgets.Button;
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
 *         Responsibilities of class: It creates the headerPanel which includes
 *         logo image, about and logout button.
 * 
 *         Version/date: 1.6 / 05/26/2022
 * 
 * 
 */

// A HeaderPanel is-a JPanel.
public class HeaderPanel extends JPanel {
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (HeaderPanel).
	 */
	// The HeaderPanel class has-a serialVersionUID.
	private static final long serialVersionUID = -2651358270064871405L;

	// A HeaderPanel has-a logoImage.
	private BufferedImage logoImage;

	// A HeaderPanel has-a logoutImage.
	private BufferedImage logoutImage;

	// A HeaderPanel has-a logoutButton.
	private Button logoutButton;

	// A HeaderPanel has-a logoutButton.
	private String logoErrorMessage;

	private String logoutErrorMessage;

	public HeaderPanel(PageView pageView, boolean isUserloggedIn) {
		// Make the panel transparent.
		setOpaque(false);

		// Set null layout/absolute layout.
		setLayout(null);

		try {
			logoImage = ImageIO.read(new File("src/views/images/logo.png"));
		} catch (IOException ex) {
			logoErrorMessage = "Logo is not available.";
		}
		try {
			logoutImage = ImageIO.read(new File("src/views/images/logout.png"));
		} catch (IOException ex) {
			logoutErrorMessage = "logout";
		}
		if (isUserloggedIn) {
			if (logoutErrorMessage == null) {
				// Initialize the logoutButton.
				logoutButton = new Button(new ImageIcon(logoutImage));

				// Set an empty border.
				logoutButton.setBorder(BorderFactory.createEmptyBorder());

				// Disable area fill by default style.
				logoutButton.setContentAreaFilled(false);

				// Set the location of logoutButton.
				logoutButton.setBounds(388, 6, 22, 25);

				// Add logoutButton to the headerPanel.
				add(logoutButton);

				// Listen to the logoutButton.
				logoutButton.addActionListener(new LogoutButtonListener(pageView));

			} else {
				Font font = new Font("Times New Roman", Font.PLAIN, 14);

				// Initialize the button for logout.
				Button logoutButton = new Button(logoutErrorMessage, font, new Color(27, 108, 89), Color.white);

				logoutButton.setBounds(340, 6, 60, 30);

				// Add logoutButton to the headerPanel.
				add(logoutButton);

				// Listen to the logoutButton.
				logoutButton.addActionListener(new LogoutButtonListener(pageView));
			}
		}

		Font font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initializing an aboutButton.
		Button aboutButton = new Button("About", font, new Color(54, 57, 69), new Color(255, 255, 255));

		aboutButton.setBounds(0, 0, 50, 40);

		add(aboutButton);

		// Listen to the aboutButton
		aboutButton.addActionListener(new AboutButtonListener());

	}

	/**
	 * It overrides paintComponent method. Polymorphism (dynamically bind).
	 */
	@Override
	protected void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		if (logoErrorMessage == null) {
			graphic.drawImage(logoImage, 150, 10, 116, 112, this);
		} else {
			Font font = new Font("Times New Roman", Font.PLAIN, 14);

			TextLabel text = new TextLabel(logoErrorMessage, font, Color.white);

			text.setBounds(150, 6, 200, 50);

			add(text);

		}
	}

}
