
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.pages.PageView;
import views.pages.components.HeaderPanel;
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
 *         Responsibilities of class: It listens to the logoutButton, and if the
 *         logoutButton is clicked, it removes all the components in the page
 *         view, then it adds headerPanel and loginPanels to the page view.
 * 
 *         Version/date: 1.3 / 05/15/2022
 * 
 * 
 */
// A LogoutButtonListener is-an ActionListener.
public class LogoutButtonListener implements ActionListener
{

	// A LogoutButtonListener has-a pageView.
	private PageView pageView;

	/**
	 * LogoutButtonListener Constructor - It listen to the logoutButton and change
	 * the view.
	 * 
	 * @param view
	 * @param headerPanel
	 */
	public LogoutButtonListener(PageView pageView, HeaderPanel headerPanel)
	{

		// Assign the pageView value.
		this.pageView = pageView;

		// Initialize the logoutButton.
		Button logoutButton = headerPanel.getLogoutButton();

		// Listen to logoutButton.
		logoutButton.addActionListener(this);
	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the logoutButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Update the page view.
		update();

	}

	/**
	 * Purpose: It removes all components from the page view and add the headerPanel
	 * and LoginPanels to the page view.
	 */
	public void update()
	{

		// Remove all panels.
		this.pageView.getContentPane().removeAll();

		// Add headerPanel. false passed as an argument because the customer logged out.
		this.pageView.addHeaderPanel(false);

		// Add loginPanels.
		this.pageView.addLoginPanels();

	}

}
