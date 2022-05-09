
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/08/2022
 * 
 * 
 */
package views.pages.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.LogoutButtonListener;
import views.pages.PageView;

@SuppressWarnings("serial")
public class HeaderPanel extends JPanel
{
	// HeaderPanel has-a logoImg.
	private BufferedImage logoImg;

	// HeaderPanel has-a logout.
	private BufferedImage logout;

	// HeaderPanel has-a logoutButton.
	private JButton logoutButton;

	public HeaderPanel(PageView view, boolean loggedIn)
	{
		// Make the panel transparent.
		setOpaque(false);
		setLayout(null);

		try
		{
			logoImg = ImageIO.read(new File("src/views/images/logo.png"));
		} catch (IOException ex)
		{
			System.out.println("The application can not access the logo file.");
		}
		try
		{
			logout = ImageIO.read(new File("src/views/images/logout.png"));
		} catch (IOException ex)
		{
			System.out.println("The application can not access the logout file.");
		}
		if (loggedIn)
		{
			// Initialize the logoutButton.
			logoutButton = new JButton(new ImageIcon(logout));

			// Set an empty border.
			logoutButton.setBorder(BorderFactory.createEmptyBorder());

			// Disable area fill by default style.
			logoutButton.setContentAreaFilled(false);

			// Set the location of logoutButton.
			logoutButton.setBounds(388, 6, 22, 25);

			// Add logoutButton to the headerPanel.
			add(logoutButton);

			// Listen to the logoutButton.
			new LogoutButtonListener(view, this);
		}

	}

	/**
	 * It overrides paintComponent method. Polymorphism (dynamically bind)
	 */
	@Override
	protected void paintComponent(Graphics graphic)
	{
		super.paintComponent(graphic);
		graphic.drawImage(logoImg, 150, 10, 116, 112, this);
	}

	public JButton getLogoutComponent()
	{
		return logoutButton;
	}

}
