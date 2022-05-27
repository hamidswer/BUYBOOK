package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.widgets.FormPassword;
import views.widgets.FormText;

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
 *         Responsibilities of class: It listens to the text and password
 *         components. If the customer clicks on them, it removes that
 *         components text value.
 * 
 *         Version/date: 1.3 / 05/15/2022
 * 
 * 
 */

// A FormListener is MouseListener.
public class FormListener implements MouseListener
{
	// A FormListener has-a textComponenet.
	private FormText textComponenet;

	// A FormListener has-a passwordComponenet.
	private FormPassword passwordComponenet;

	/**
	 * Purpose: FormListener constructs a mouse listener for a FormText component.
	 * 
	 * @param textComponenet - The component which we want to listen to.
	 */
	public FormListener(FormText textComponenet)
	{
		// Assign the textComponenet value.
		this.textComponenet = textComponenet;
	}

	/**
	 * Purpose: FormListener constructs a mouse listener for a FormPassword
	 * component.
	 * 
	 * @param passwordComponenet - The component which we want to listen to.
	 */
	public FormListener(FormPassword passwordComponenet)
	{
		// Assign the passwordComponenet value.
		this.passwordComponenet = passwordComponenet;
	}

	/**
	 * Purpose: It Invokes when a mouse click event happened. The event of this
	 * method is to click on the textComponenet or passwordComponenet. It overrides
	 * mouseClicked method of MouseListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void mouseClicked(MouseEvent event)
	{

		// It tries to removes the textComponenet text value, but if the textComponenet was null, it means the customer didn't click on the textComponenet
		// and we didn't assign any value to the textComponenet on the constructor, so it throws a NullPointerException. 
		// It means the mouse click event happened but It wasn't on the textComponenet
		// so it was on the passwordComponenet. so It removes the passwordComponenet text value.
		try
		{
			textComponenet.setText("");
		} catch (NullPointerException e)
		{
			passwordComponenet.setText("");
		}
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
