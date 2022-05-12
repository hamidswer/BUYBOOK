
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import views.pages.PageView;
import views.pages.components.HeaderPanel;

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
//A LogoutButtonListener is-an ActionListener.
public class LogoutButtonListener implements ActionListener
{

	// LogoutButtonListener has-a view.
	private PageView view;

	/**
	 * LogoutButtonListener Constructor - It listen to the logoutButton and change
	 * the view.
	 * 
	 * @param view
	 * @param panel
	 */
	public LogoutButtonListener(PageView view, HeaderPanel panel)
	{

		// Initialize the view.
		this.view = view;

		// Initialize the logoutButton.
		JButton logoutButton = panel.getLogoutButton();

		// Listen to login button.
		logoutButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Update the view.
		update();

	}

	/**
	 * Update the view and transfer to the login page.
	 */
	public void update()
	{

		// Remove all panels.
		this.view.getContentPane().removeAll();

		// Add headerPanel. false passed as an argument because the customer logged out.
		this.view.addHeaderPanel(false);

		// Add loginPanels.
		this.view.addLoginPanels();

	}

}
