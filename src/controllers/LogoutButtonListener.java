
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/08/2022
 * 
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import views.pages.PageView;
import views.pages.components.HeaderPanel;

public class LogoutButtonListener implements ActionListener
{

	// LogoutButtonListener has-a view.
	private PageView view;

	// LogoutButtonListener has-a logoutButton.
	private JButton logoutButton;

	/**
	 * LogoutButtonListener Constructor - It listen to the logoutButton and change the
	 * view.
	 * 
	 * @param view
	 * @param panel
	 */
	public LogoutButtonListener(PageView view, HeaderPanel panel)
	{

		// Initialize the view.
		this.view = view;

		// Initialize the logoutButton.
		logoutButton = panel.getLogoutComponent();

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

		// Add headerPanel.
		this.view.addHeaderPanel();

		// Add loginPanels.
		this.view.addLoginPanels();

	}

}
