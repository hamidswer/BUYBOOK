
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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import views.widgets.Text;

@SuppressWarnings("serial")
public class LoginErrorPanel extends JPanel
{
	// A LoginErrorPanel has a font.
	private Font font;

	// A LoginErrorPanel has-an errorMessage.
	private Text errorMessage;

	public LoginErrorPanel()
	{
		// Make the panel transparent.
		setOpaque(false);
		// 1 row and 1 column, Horizontal gap == 0, Vertical gap == 10.
		setLayout(new GridLayout(1, 1, 0, 10));

		// border => top == 0, left == 35, bottom == 80, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 80, 50));

		// Add the emailField to the createAccountPanel.
		// Initialize the buttonFont.
		font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the button for login. 
		errorMessage = new Text(" ", font, Color.white);
		add(errorMessage);
	}

	/**
	 * Set the error message.
	 */
	public void setError()
	{
		// Remove the errorMessage.
		this.remove(errorMessage);

		// Initialize the errorMessage label.
		errorMessage = new Text(
				"<html>Something is wrong!<br> If you don't have an account, Please first create one.<br> "
						+ "If you have already an account, Please check your Email or Password.",
				font, Color.white);

		// Add the new error messages.
		add(errorMessage);
	}

}
