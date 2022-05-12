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
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 1.3 / 05/12/2022
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
	private static final long serialVersionUID = -6784010483425734426L;

	// A LoginAccountPanel has-a createAccountButton.
	private Button createAccountButton;

	public LoginAccountPanel(PageView view)
	{
		// Make the panel transparent.
		setOpaque(false);

		// 1 row and 1 column, Horizontal gap == 0, Vertical gap == 10.
		GridLayout grid = new GridLayout(1, 1, 0, 10);

		setLayout(grid);

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize the font for createAccountButton.
		Font font = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the button for create account. 
		createAccountButton = new Button("Create Account", font, new Color(27, 108, 89), Color.white);

		// Add the createAccountButton to the createAccountPanel.
		add(createAccountButton);

		// Listen to the createAccountButton.
		new LoginAccountButtonListener(view, this);
	}

	/**
	 * Get the create account button component.
	 * 
	 * @return the create account button component.
	 */
	public Button getCreateAccountButton()
	{
		return createAccountButton;
	}
}
