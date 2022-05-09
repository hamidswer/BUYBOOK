
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
import javax.swing.border.Border;

import controllers.CreateAccountButtonListener;
import controllers.CreateAccountFormListener;
import views.pages.PageView;
import views.widgets.FormPassword;
import views.widgets.FormText;
import views.widgets.Button;

@SuppressWarnings("serial")
public class CreateAccountPanel extends JPanel
{
	// A CreateAccountPanel has-a name.
	private FormText name;

	// A CreateAccountPanel has-an email.
	private FormText email;

	// A CreateAccountPanel has-a creditCardNumber.
	private FormText creditCardNumber;

	// A CreateAccountPanel has-an expirationDate.
	private FormText expirationDate;

	// A CreateAccountPanel has-a password.
	private FormPassword password;

	// A CreateAccountPanel has-a confirmPassword.
	private FormPassword confirmPassword;

	// A CreateAccountPanel has-a cvv.
	private FormPassword cvv;

	// A CreateAccountPanel has-a createAccountButton.
	private Button createAccountButton;

	// A CreateAccountPanel has-a font.
	private Font font;

	public CreateAccountPanel(PageView view)
	{
		// unlimited rows and 1 column, Horizontal gap == 0, Vertical gap == 15.
		setLayout(new GridLayout(0, 1, 0, 15));

		// Make the panel transparent.
		setOpaque(false);

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize the textFont.
		font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the name.
		name = new FormText("First & Last name..", font, 5);

		// Initialize the email.
		email = new FormText("Email...", font, 5);

		// Initialize the password. 
		password = new FormPassword("Password...", font, 5);

		// Initialize the confirmPassword. 
		confirmPassword = new FormPassword("Password...", font, 5);

		// Initialize the creditCardNumber.
		creditCardNumber = new FormText("Credit Card Number..", font, 5);

		// Initialize the expirationDate.
		expirationDate = new FormText("05/23", font, 5);

		// Initialize the CVV. 
		cvv = new FormPassword("CVV", font, 5);

		// Initialize the buttonFont.
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 32);

		// Add the name to the createAccountPanel.
		add(name);

		// Add the email to the createAccountPanel.
		add(email);

		// Add the password to the createAccountPanel.
		add(password);

		// Add the confirmPassword to the createAccountPanel.
		add(confirmPassword);

		// Add the creditCardNumber to the createAccountPanel.
		add(creditCardNumber);

		// Add the expirationDate to the createAccountPanel.
		add(expirationDate);

		// Add the cvv to the createAccountPanel.
		add(cvv);

		// Initialize the createAccountButton. 
		createAccountButton = new Button("Create Account", buttonFont, new Color(27, 108, 89), Color.white);

		// Add the createAccountButton to the createAccountPanel.
		add(createAccountButton);

		// Listen to the createAccountForm texts.
		new CreateAccountFormListener(this);

		// Listen to the createAccountButton.
		new CreateAccountButtonListener(view, this);
	}

	/**
	 * Get the name component.
	 * 
	 * @return the name component.
	 */
	public FormText getNameComponent()
	{
		return name;
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
	 * Get the confirmPassword component.
	 * 
	 * @return the confirmPassword component.
	 */
	public FormPassword getConfirmPasswordComponent()
	{
		return confirmPassword;
	}

	/**
	 * Get the creditCardNumber component.
	 * 
	 * @return the creditCardNumber component.
	 */
	public FormText getCreditCardNumberComponent()
	{
		return creditCardNumber;
	}

	/**
	 * Get the expirationDate component.
	 * 
	 * @return the expirationDate component.
	 */
	public FormText getExpirationDateComponent()
	{
		return expirationDate;
	}

	/**
	 * Get the cvv component.
	 * 
	 * @return the cvv component.
	 */
	public FormPassword getCvvComponent()
	{
		return cvv;
	}

	/**
	 * Get the button component.
	 * 
	 * @return the button component.
	 */
	public Button getCreateAccountComponent()
	{
		return createAccountButton;
	}

	/**
	 * Polymorphism (Method overloading)
	 */

	/**
	 * Update the UI.
	 * 
	 * @param text
	 */
	public void updateUI(FormText text)
	{
		// Change the border color to red.
		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		text.setBorder(border);
	}

	public void updateUI(FormPassword text)
	{
		// Change the border color to red.
		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		text.setBorder(border);
	}

}
