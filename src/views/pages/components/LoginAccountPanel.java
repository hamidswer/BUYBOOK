
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

import controllers.LoginAccountButtonListener;
import views.pages.PageView;
import views.widgets.Button;

@SuppressWarnings("serial")
public class LoginAccountPanel extends JPanel
{
	// A LoginAccountPanel has-a createAccountButton.
	private Button createAccountButton;

	public LoginAccountPanel(PageView view)
	{
		// Make the panel transparent.
		setOpaque(false);

		// 1 row and 1 column, Horizontal gap == 0, Vertical gap == 10.
		setLayout(new GridLayout(1, 1, 0, 10));

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize the buttonFont.
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the button for create account. 
		createAccountButton = new Button("Create Account", buttonFont, new Color(27, 108, 89), Color.white);

		// Add the createAccountButton to the createAccountPanel.
		add(createAccountButton);

		// Listen to the createAccountButton.
		new LoginAccountButtonListener(view, this);
	}

	/**
	 * Get the create account button component.
	 * 
	 * @return the create account button component.
	 */
	public Button getCreateAccountComponent()
	{
		return createAccountButton;
	}
}
