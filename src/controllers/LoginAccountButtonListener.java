
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.pages.PageView;
import views.pages.components.LoginAccountPanel;
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
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 1.2 / 05/12/2022
 * 
 * 
 */
//A LoginAccountButtonListener is-an ActionListener.
public class LoginAccountButtonListener implements ActionListener
{
	// LoginAccountButtonListener has-a view.
	private PageView view;

	/**
	 * LoginAccountButtonListener Constructor - It listen to the create account
	 * button.
	 * 
	 * @param view  the PageView.
	 * @param panel the LoginAccountPanel.
	 */
	public LoginAccountButtonListener(PageView view, LoginAccountPanel panel)
	{
		// Set the view.
		this.view = view;

		// Initialize createAccountButton for creating a new account.
		Button createAccountButton = panel.getCreateAccountButton();

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
