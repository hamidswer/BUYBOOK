
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
import views.widgets.SignButton;

public class CreateAccountButtonListener implements ActionListener
{
	private LoginPageView loginPageView;
	private SignButton createAccountButton; // CreateAccountButtonListener has-a createAccountButton

	public CreateAccountButtonListener(LoginPageView loginPageView)
	{
		this.loginPageView = loginPageView;

		createAccountButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}
}
