
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
 *         Responsibilities of class: It listens to the createAccountButton in
 *         loginAccountPanel. If the createAccountButton is clicked, It removes
 *         the loginPanels and adds the createAccountPanel to the page view.
 * 
 *         Version/date: 1.3 / 05/15/2022
 * 
 * 
 */
// A LoginAccountButtonListener is-an ActionListener.
public class LoginAccountButtonListener implements ActionListener
{
	// A LoginAccountButtonListener has-a pageView.
	private PageView pageView;

	public LoginAccountButtonListener(PageView pageView, LoginAccountPanel loginAccountPanel)
	{
		// Assign the pageView value.
		this.pageView = pageView;

		// Initialize createAccountButton by getting accountButton component from the loginAccountPanel.
		Button createAccountButton = loginAccountPanel.getCreateAccountButton();

		// Listen to the createAccountButton.
		createAccountButton.addActionListener(this);
	}

	/**
	 * Purpose: It removes the loginPanels from the page view and adds the
	 * createAccountPanel to the page view.
	 * 
	 * It Invokes when an action occurs. The action of this method is to click on
	 * the createAccountButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Remove loginPanels.
		this.pageView.removeLoginPanels();

		// Add createAccountPanel.
		this.pageView.addCreateAccountPanel();

	}
}
