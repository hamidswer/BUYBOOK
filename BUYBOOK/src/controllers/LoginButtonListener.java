
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/03/2022
 * 
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.pages.LoginPageView;
import views.widgets.FormPasswordField;
import views.widgets.FormTextField;
import views.widgets.SignButton;

public class LoginButtonListener implements ActionListener
{

	private SignButton loginButton; // LoginButtonListener has-a loginButton
	private FormTextField emailField;
	private FormPasswordField passwordField;

	public LoginButtonListener(LoginPageView loginPageView)
	{
		emailField = loginPageView.getEmailField();
		passwordField = loginPageView.getPasswordField();
		loginButton = loginPageView.getLoginButton();
		loginButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		String email = emailField.getText();
		String password = new String(passwordField.getPassword());
		System.out.println(email + "\n" + password);

	}
}
