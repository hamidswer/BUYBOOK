
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import views.widgets.FormPasswordField;
import views.widgets.FormTextField;
import views.widgets.SignButton;

@SuppressWarnings("serial")
public class LoginPageView extends JFrame
{
	private JPanel loginFormPanel;
	private FormTextField emailField;
	private FormPasswordField passwordField;
	private SignButton loginButton;
	private JPanel errorPanel;
	private JPanel createAccountPanel;
	private SignButton createAccountButton;
	private JLabel errorMessage;

	public LoginPageView()
	{
		ImageIcon img = new ImageIcon("src/views/components/logo.png");

		// Set this window's icon.
		setIconImage(img.getImage());

		// Set Login page window's title.
		setTitle("BUYBOOK");

		// Close the application when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add a GridLayout manager to the content pane with three row and one column.
		setLayout(new GridLayout(4, 1));

		// Add the header panel to the application.
		JPanel headerPanel = new HeaderPanel(false); // The customer is not logged in to the application.
		headerPanel.setOpaque(false); // Make the panel transparent.
		add(headerPanel);

		// Add the login form panel to the application.
		loginFormPanelBuilder();
		loginFormPanel.setOpaque(false); // Make the panel transparent.
		add(loginFormPanel);

		// Add the error panel to the application.
		errorPanelBuilder();
		errorPanel.setOpaque(false); // Make the panel transparent.
		add(errorPanel);

		// Add create account panel to the application.
		accountPanelBuilder();
		createAccountPanel.setOpaque(false); // Make the panel transparent.
		add(createAccountPanel);
		pack();

		// Set the size of this window, width == 428, height == 926.
		setSize(428, 926);

		// Move the window to the center position of the screen.
		setLocationRelativeTo(null);

		// Display the window.
		setVisible(true);

		// Set the Inkwell color as the application background color.
		this.getContentPane().setBackground(new Color(54, 57, 69));

	}

	public void loginFormPanelBuilder()
	{
		loginFormPanel = new JPanel();

		// 3 rows and 1 column, Horizontal gap == 0, Vertical gap == 10.
		loginFormPanel.setLayout(new GridLayout(3, 1, 0, 10));

		// border => top == 0, left == 50, bottom == 0, right == 50.
		loginFormPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		// Initialize the textFont.
		Font textFont = new Font("Times New Roman", Font.PLAIN, 24);

		// Initialize the emailField.
		emailField = new FormTextField("Email...", textFont, 10);

		// Initialize the passwordField. 
		passwordField = new FormPasswordField("Password...", textFont, 10);

		// Initialize the buttonFont.
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the button for login. 
		loginButton = new SignButton("Login", buttonFont, new Color(27, 108, 89), 10);

		// Add the emailField to the loginFormPanel.
		loginFormPanel.add(emailField);

		// Add the passwordField to the loginFormPanel.
		loginFormPanel.add(passwordField);

		// Add the loginButton to the loginFormPanel.
		loginFormPanel.add(loginButton);
	}

	public void errorPanelBuilder()
	{
		errorPanel = new JPanel();

		// 1 row and 1 column, Horizontal gap == 0, Vertical gap == 10.
		errorPanel.setLayout(new GridLayout(1, 1, 0, 10));

		// border => top == 0, left == 50, bottom == 80, right == 50.
		errorPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 80, 50));

		// Initialize the buttonFont.
		Font errorFont = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the button for login. 
		errorMessage = new JLabel("Error!");
		errorMessage.setFont(errorFont);
		errorMessage.setForeground(Color.white);

		// Add the emailField to the createAccountPanel.
		errorPanel.add(errorMessage);
	}

	public void accountPanelBuilder()
	{
		createAccountPanel = new JPanel();

		// 1 row and 1 column, Horizontal gap == 0, Vertical gap == 10.
		createAccountPanel.setLayout(new GridLayout(1, 1, 0, 10));

		// border => top == 80, left == 50, bottom == 80, right == 50.
		createAccountPanel.setBorder(BorderFactory.createEmptyBorder(80, 50, 80, 50));

		// Initialize the buttonFont.
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the button for login. 
		createAccountButton = new SignButton("Create Account", buttonFont, new Color(27, 108, 89), 10);

		// Add the emailField to the createAccountPanel.
		createAccountPanel.add(createAccountButton);
	}

	public FormTextField getEmailField()
	{
		return emailField;
	}

	public FormPasswordField getPasswordField()
	{
		return passwordField;
	}

	public SignButton getLoginButton()
	{
		return loginButton;
	}

	public SignButton getCreateAccountButton()
	{
		return createAccountButton;
	}
}
