
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 * 
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import views.pages.components.CreateAccountPanel;
import views.widgets.FormPassword;
import views.widgets.FormText;

public class CreateAccountFormListener implements MouseListener
{

	// CreateAccountFormListener has-a name.
	private FormText name;

	// CreateAccountFormListener has-an email.
	private FormText email;

	// CreateAccountFormListener has-a password.
	private FormPassword password;

	// CreateAccountFormListener has-a confirmPassword.
	private FormPassword confirmPassword;

	// CreateAccountFormListener has-a creditCardNumber.
	private FormText creditCardNumber;

	// CreateAccountFormListener has-a expirationDate.
	private FormText expirationDate;

	// CreateAccountFormListener has-a cvv.
	private FormPassword cvv;

	public CreateAccountFormListener(CreateAccountPanel panel)
	{
		// Set the name.
		name = panel.getNameComponent();

		// Set the email.
		email = panel.getEmailComponent();

		// Set the password.
		password = panel.getPasswordComponent();

		// Set the confirmPassword.
		confirmPassword = panel.getConfirmPasswordComponent();

		// Set the creditCardNumber.
		creditCardNumber = panel.getCreditCardNumberComponent();

		// Set the expirationDate.
		expirationDate = panel.getExpirationDateComponent();

		// Set the cvv.
		cvv = panel.getCvvComponent();

		// Listen to the name.
		name.addMouseListener(this);

		// Listen to the email.
		email.addMouseListener(this);

		// Listen to the password.
		password.addMouseListener(this);

		// Listen to the confirmPassword.
		confirmPassword.addMouseListener(this);

		// Listen to the creditCardNumber.
		creditCardNumber.addMouseListener(this);

		// Listen to the expirationDate.
		expirationDate.addMouseListener(this);

		// Listen to the cvv.
		cvv.addMouseListener(this);

	}

	/**
	 * It overrides mouseClicked method of MouseListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void mouseClicked(MouseEvent event)
	{
		// if the click source event is name, remove its content.
		if (event.getSource().equals(name))
			name.setText("");

		// if the click source event is email, remove its content.
		if (event.getSource().equals(email))
			email.setText("");

		// if the click source event is password, remove its content.
		if (event.getSource().equals(password))
			password.setText("");

		// if the click source event is confirmPassword, remove its content.
		if (event.getSource().equals(confirmPassword))
			confirmPassword.setText("");

		// if the click source event is creditCardNumber, remove its content.
		if (event.getSource().equals(creditCardNumber))
			creditCardNumber.setText("");

		// if the click source event is expirationDate, remove its content.
		if (event.getSource().equals(expirationDate))
			expirationDate.setText("");

		// if the click source event is cvv, remove its content.
		if (event.getSource().equals(cvv))
			cvv.setText("");

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}
}
