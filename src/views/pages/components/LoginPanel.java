package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controllers.FormListener;
import controllers.LoginButtonListener;
import views.pages.PageView;
import views.widgets.FormPassword;
import views.widgets.FormText;
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

// A LoginPanel is-a JPanel.
public class LoginPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (LoginPanel).
	 */
	private static final long serialVersionUID = 8710933131209149707L;

	// A LoginPanel has-a loginButton.
	private Button loginButton;

	// A LoginPanel has-an email.
	private FormText email;

	// A LoginPanel has-a password.
	private FormPassword password;

	public LoginPanel(PageView view)
	{
		GridLayout grid = new GridLayout(3, 1, 0, 10);

		// Set layout to grid.
		setLayout(grid);

		// Make the panel transparent.
		setOpaque(false);

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize the font for text.
		Font font = new Font("Times New Roman", Font.PLAIN, 24);

		// Initialize the email.
		email = new FormText("john@gmail.com", font, 10);

		// Initialize the password. 
		password = new FormPassword("123456791", font, 10);

		// Initialize the font for button.
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
		new FormListener(email);

		new FormListener(password);

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
	public Button getLoginButton()
	{
		return loginButton;
	}

}
