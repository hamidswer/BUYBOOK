
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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import views.pages.LoginPageView;
import views.widgets.FormPasswordField;
import views.widgets.FormTextField;

public class FormFieldListener implements MouseListener
{
	private FormTextField emailField;
	private FormPasswordField passwordField;

	public FormFieldListener(LoginPageView loginPageView)
	{
		emailField = loginPageView.getEmailField();
		passwordField = loginPageView.getPasswordField();

		// Add mouse listener to the emailField.
		emailField.addMouseListener(this);

		// Add mouse listener to the passwordField.
		passwordField.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
		if (event.getSource().equals(emailField))
			emailField.setText("");
		if (event.getSource().equals(passwordField))
			passwordField.setText("");
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
