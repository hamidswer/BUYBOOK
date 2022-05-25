package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controllers.LoginAccountButtonListener;
import views.pages.PageView;
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
 *         Serializable Interface in Java.
 *         https://www.geeksforgeeks.org/serializable-interface-in-java
 * 
 *         What does it mean: The serializable class does not declare a static
 *         final serialVersionUID field?
 *         https://stackoverflow.com/questions/2288937/what-does-it-mean-the-serializable-class-does-not-declare-a-static-final-serial
 * 
 *         Responsibilities of class: It is responsible to build createAccount
 *         button to let user have a chance to create a new account.
 * 
 *         Version/date: 1.4 / 05/15/2022
 * 
 * 
 */
// A LoginAccountPanel is-a JPanel.
public class LoginAccountPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (LoginAccountPanel).
	 */
	// The LoginAccountPanel class has-a serialVersionUID.
	private static final long serialVersionUID = -6784010483425734426L;

	// A LoginAccountPanel has-a createAccountButton.
	private Button createAccountButton;

	public LoginAccountPanel(PageView view)
	{
		// Make the panel transparent.
		setOpaque(false);

		// Initialize the grid.
		GridLayout grid = new GridLayout(1, 1, 0, 10);

		// Set the grid layout.
		setLayout(grid);

		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		Font font = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the createAccountButton. 
		createAccountButton = new Button("Create Account", font, new Color(27, 108, 89), Color.white);

		// Listen to the createAccountButton.
		createAccountButton.addActionListener(new LoginAccountButtonListener(view, this));

		add(createAccountButton);

	}
}
