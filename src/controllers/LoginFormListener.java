
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

import views.pages.components.LoginPanel;
import views.widgets.FormPassword;
import views.widgets.FormText;

public class LoginFormListener implements MouseListener
{
	// LoginFormListener has-an emailComponent.
	private FormText emailComponent;

	// LoginFormListener has-an passwordComponent.
	private FormPassword passwordComponent;

	/**
	 * LoginFormListener Constructor - It listen to the forms fields and change the
	 * view.
	 * 
	 * @param panel - LoginPanel
	 */
	public LoginFormListener(LoginPanel panel)
	{
		// Initialize the emailComponent.
		emailComponent = panel.getEmailComponent();

		// Initialize the passwordComponent.
		passwordComponent = panel.getPasswordComponent();

		// Listen to the emailComponent.
		emailComponent.addMouseListener(this);

		// Listen to the passwordComponent.
		passwordComponent.addMouseListener(this);

	}

	/**
	 * It overrides mouseClicked method of MouseListener. Polymorphism (dynamically
	 * bind)
	 */
	@Override
	public void mouseClicked(MouseEvent event)
	{
		// if the click source event is emailComponent, remove its content.
		if (event.getSource().equals(emailComponent))
			emailComponent.setText("");

		// if the click source event is passwordComponent, remove its content.
		if (event.getSource().equals(passwordComponent))
			passwordComponent.setText("");
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
