
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

import controllers.LoginFormListener;
import controllers.LoginButtonListener;
import views.pages.PageView;
import views.widgets.FormPassword;
import views.widgets.FormText;
import views.widgets.Button;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel
{
	// A LoginPanel has-a loginButton.
	private Button loginButton;
	
	// A LoginPanel has-an email.
	private FormText email;
	
	// A LoginPanel has-a password.
	private FormPassword password;

	// A LoginPanel has-a font.
	private Font font;

	public LoginPanel(PageView view)
	{
		// 3 rows and 1 column, Horizontal gap == 0, Vertical gap == 10.
		setLayout(new GridLayout(3, 1, 0, 10));

		// Make the panel transparent.
		setOpaque(false);

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize the textFont.
		Font textFont = new Font("Times New Roman", Font.PLAIN, 24);

		// Initialize the email.
		email = new FormText("john@gmail.com", textFont, 10);

		// Initialize the password. 
		password = new FormPassword("123456791", textFont, 10);

		// Initialize the buttonFont.
		font = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the button for login. 
		loginButton = new Button("Login", font, new Color(27, 108, 89), Color.white);

		// Add the email to the loginPanel.
		add(email);

		// Add the password to the loginPanel.
		add(password);

		// Add the loginButton to the loginPanel.
		add(loginButton);

		// Listen to the login form texts.
		new LoginFormListener(this);

		// Listen to the login buttons.
		new LoginButtonListener(view, this);
	}

	/**
	 * Get the email component.
	 * 
	 * @return the email component.
	 */
	public FormText getEmailComponent()
	{
		return email;
	}

	/**
	 * Get the password component.
	 * 
	 * @return the password component.
	 */
	public FormPassword getPasswordComponent()
	{
		return password;
	}

	/**
	 * Get the button component.
	 * 
	 * @return the button component.
	 */
	public Button getLoginComponent()
	{
		return loginButton;
	}

}
