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
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 1.2 / 05/12/2022
 * 
 * 
 */

// A FormListener is-a MouseListener.
public class FormListener implements MouseListener
{
	// LoginFormListener has-an emailComponent.
	private FormText formTextComponenet;

	// LoginFormListener has-an passwordComponent.
	private FormPassword formPasswordComponenet;

	/**
	 * Purpose: FormListener constructs a mouse listener for a FormText component.
	 * 
	 * @param formTextComponenet - The component which we want to listen to.
	 */
	public FormListener(FormText formTextComponenet)
	{
		this.formTextComponenet = formTextComponenet;
		formTextComponenet.addMouseListener(this);
	}

	/**
	 * Purpose: FormListener constructs a mouse listener for a FormPassword
	 * component.
	 * 
	 * @param formPasswordComponenet - The component which we want to listen to.
	 */
	public FormListener(FormPassword formPasswordComponenet)
	{
		this.formPasswordComponenet = formPasswordComponenet;
		formPasswordComponenet.addMouseListener(this);
	}

	/**
	 * It overrides mouseClicked method of MouseListener. Polymorphism (dynamically
	 * bind)
	 */
	@Override
	public void mouseClicked(MouseEvent event)
	{
		// It removes the field component's text.
		try
		{
			formTextComponenet.setText("");
		} catch (NullPointerException e)
		{
			formPasswordComponenet.setText("");
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
