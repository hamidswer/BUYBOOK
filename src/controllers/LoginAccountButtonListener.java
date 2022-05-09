
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/05/2022
 * 
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.pages.PageView;
import views.pages.components.LoginAccountPanel;
import views.widgets.Button;

public class LoginAccountButtonListener implements ActionListener
{
	// LoginAccountButtonListener has-a createAccountButton.
	private Button createAccountButton;

	// LoginAccountButtonListener has-a view.
	private PageView view;

	/**
	 * LoginAccountButtonListener Constructor - It listen to the create account button.
	 * @param view the PageView.
	 * @param panel the LoginAccountPanel.
	 */
	public LoginAccountButtonListener(PageView view, LoginAccountPanel panel)
	{
		// Set the view.
		this.view = view;

		// Initialize createAccountButton for creating a new account.
		createAccountButton = panel.getCreateAccountComponent();

		// Listen to the createAccountButton.
		createAccountButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Remove loginPanels.
		this.view.removeLoginPanels();
		
		// Add createAccountPanel.
		this.view.addCreateAccountPanel();

	}
}
