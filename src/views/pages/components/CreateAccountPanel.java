package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controllers.CreateAccountButtonListener;
import controllers.FormListener;
import views.pages.PageView;
import views.widgets.FormPassword;
import views.widgets.FormText;
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
 *         Responsibilities of class: It creates the accountPanel. It contains a
 *         form for creating a new account.
 * 
 *         Version/date: 1.3 / 05/15/2022
 * 
 * 
 */

// A CreateAccountPanel is-a JPanel.
public class CreateAccountPanel extends JPanel
{
	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JPanel
	 * class implements java.io.Serializable interface so the it's subclass
	 * (CreateAccountPanel).
	 */
	// The CreateAccountPanel class has-a serialVersionUID.
	private static final long serialVersionUID = -5636583615110640231L;

	// A CreateAccountPanel has-a name.
	private FormText name;

	// A CreateAccountPanel has-an email.
	private FormText email;

	// A CreateAccountPanel has-a creditCardNumber.
	private FormText creditCardNumber;

	// A CreateAccountPanel has-an expirationDate.
	private FormText expirationDate;

	// A CreateAccountPanel has-a password.
	private FormPassword password;

	// A CreateAccountPanel has-a confirmPassword.
	private FormPassword confirmPassword;

	// A CreateAccountPanel has-a cvv.
	private FormPassword cvv;

	// A CreateAccountPanel has-a createAccountButton.
	private Button createAccountButton;

	public CreateAccountPanel(PageView view)
	{
		// Initialize the grid.
		GridLayout grid = new GridLayout(0, 1, 0, 15);

		// Set the grid layout for the frame.
		setLayout(grid);

		// Make the panel transparent.
		setOpaque(false);

		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		Font font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize the name.
		name = new FormText("First & Last name..", font, 5);

		// listen to the name field to remove their text when the user clicks on it.
		name.addMouseListener(new FormListener(name));

		add(name);

		// Initialize the email.
		email = new FormText("Email...", font, 5);

		// listen to the email field to remove their text when the user clicks on it.
		email.addMouseListener(new FormListener(email));

		add(email);

		// Initialize the password. 
		password = new FormPassword("Password...", font, 5);

		// listen to the password field to remove their text when the user clicks on it.
		password.addMouseListener(new FormListener(password));

		add(password);

		// Initialize the confirmPassword. 
		confirmPassword = new FormPassword("Password!..", font, 5);

		// listen to the confirmPassword field to remove their text when the user clicks on it.
		confirmPassword.addMouseListener(new FormListener(confirmPassword));

		add(confirmPassword);

		// Initialize the creditCardNumber.
		creditCardNumber = new FormText("Credit Card Number..", font, 5);

		// listen to the creditCardNumber field to remove their text when the user clicks on it.
		creditCardNumber.addMouseListener(new FormListener(creditCardNumber));

		add(creditCardNumber);

		// Initialize the expirationDate.
		expirationDate = new FormText("05/23.", font, 5);

		// listen to the expirationDate field to remove their text when the user clicks on it.
		expirationDate.addMouseListener(new FormListener(expirationDate));

		add(expirationDate);

		// Initialize the CVV. 
		cvv = new FormPassword("CVV", font, 5);

		// listen to the cvv field to remove their text when the user clicks on it.
		cvv.addMouseListener(new FormListener(cvv));

		add(cvv);

		font = new Font("Times New Roman", Font.PLAIN, 32);

		// Initialize the createAccountButton. 
		createAccountButton = new Button("Create Account", font, new Color(27, 108, 89), Color.white);

		// Listen to the createAccountButton to evaluate the input and if their valid, creates a new account.
		createAccountButton.addActionListener(new CreateAccountButtonListener(view, this));

		add(createAccountButton);

	}

	/**
	 * Purpose: Create a hashtable for FormText components.
	 * 
	 * @return a hashtable.
	 */
	public Hashtable<String, FormText> getTextComponents()
	{
		// Initialization of a Hashtable.
		Hashtable<String, FormText> textComponents = new Hashtable<String, FormText>();

		// Inserting the Elements. Adding Key and Value pairs to Hashtable.
		textComponents.put("name", name);
		textComponents.put("email", email);
		textComponents.put("creditCardNumber", creditCardNumber);
		textComponents.put("expirationDate", expirationDate);

		// Returning the textComponents.
		return textComponents;
	}

	/**
	 * Purpose: Creates a hashtable for FormPassword components.
	 * 
	 * @return a hashtable.
	 */
	public Hashtable<String, FormPassword> getPasswordComponents()
	{
		Hashtable<String, FormPassword> passwordComponents = new Hashtable<String, FormPassword>();
		passwordComponents.put("password", password);
		passwordComponents.put("confirmPassword", confirmPassword);
		passwordComponents.put("cvv", cvv);
		return passwordComponents;
	}

	/**
	 * Polymorphism (Method overloading)
	 */

	/**
	 * Purpose: To change textComponent's border color to red and add margin.
	 * 
	 * @param textComponent - used to change its border color.
	 */
	public void setBorderRed(FormText textComponent)
	{
		// create the line border color
		Border colorfulBorder = BorderFactory.createLineBorder(Color.RED, 2);

		// create an empty border as a margin
		Border emptyBorder = new EmptyBorder(7, 7, 7, 7);

		// create a compound border
		CompoundBorder border = new CompoundBorder(colorfulBorder, emptyBorder);

		// add border to textComponent
		textComponent.setBorder(border);

	}

	/**
	 * Purpose: To change passwordComponent's border color to red and add margin.
	 * 
	 * @param passwordComponent - used to change its border color.
	 */
	public void setBorderRed(FormPassword passwordComponent)
	{
		// create the line border color
		Border colorfulBorder = BorderFactory.createLineBorder(Color.RED, 2);

		// create an empty border as a margin
		Border emptyBorder = new EmptyBorder(7, 7, 7, 7);

		// create a compound border
		CompoundBorder border = new CompoundBorder(colorfulBorder, emptyBorder);

		// add border to passwordComponent
		passwordComponent.setBorder(border);
	}

	/**
	 * Purpose: To change textComponent's border color to green.
	 * 
	 * @param textComponent - used to change its border color.
	 */
	public void setBorderGreen(FormText textComponent)
	{
		// create the line border color
		Border colorfulBorder = BorderFactory.createLineBorder(Color.GREEN, 2);

		// create an empty border as a margin
		Border emptyBorder = new EmptyBorder(7, 7, 7, 7);

		// create a compound border
		CompoundBorder border = new CompoundBorder(colorfulBorder, emptyBorder);

		textComponent.setBorder(border);

	}

	/**
	 * Purpose: To change passwordComponent's border color to green.
	 * 
	 * @param passwordComponent - used to change its border color.
	 */
	public void setBorderGreen(FormPassword passwordComponent)
	{
		// create the line border color
		Border colorfulBorder = BorderFactory.createLineBorder(Color.GREEN, 2);

		// create an empty border as a margin
		Border emptyBorder = new EmptyBorder(7, 7, 7, 7);

		// create a compound border
		CompoundBorder border = new CompoundBorder(colorfulBorder, emptyBorder);
		
		passwordComponent.setBorder(border);
	}

}
