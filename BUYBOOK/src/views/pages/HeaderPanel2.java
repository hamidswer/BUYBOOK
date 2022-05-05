
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/03/2022
 * 
 * 
 */
package views.pages;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeaderPanel2 extends JPanel
{
	private BufferedImage logoImg;
	private BufferedImage logout;
	private boolean loggedIn = false;

	public HeaderPanel2(boolean loggedIn)
	{
		this.loggedIn = loggedIn;
		try
		{
			logoImg = ImageIO.read(new File("src/views/components/logo.png"));
		} catch (IOException ex)
		{
			System.out.println("The application can not access the logo file.");
		}
		try
		{
			logout = ImageIO.read(new File("src/views/components/logout.png"));
		} catch (IOException ex)
		{
			System.out.println("The application can not access the logout file.");
		}
		
	}

	@Override
	protected void paintComponent(Graphics graphic)
	{
		super.paintComponent(graphic);
		graphic.drawImage(logoImg, 156, 10, 116, 112, this);
		if (loggedIn)
		{
			graphic.drawImage(logoImg, 156, 10, 116, 112, this);
			graphic.drawImage(logout, 388, 6, 25, 29, this);
		}
	}

}
