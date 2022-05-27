package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.About;
import views.pages.AboutView;
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
 *         Responsibilities of class: It listens to the aboutButton. If the
 *         aboutButton clicked, it creates a new AboutView which is responsible
 *         to show about view pop up.
 * 
 *         Version/date: 1.1 / 05/15/2022
 * 
 * 
 */

// An AboutButtonListener is ActionListener.
public class AboutButtonListener implements ActionListener
{

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the aboutButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Initialize an about.
		About about = new About();

		// create a new AboutView to show a frame with information about the BUYBOOK bookstore.
		new AboutView(about.toString());
	}

}
