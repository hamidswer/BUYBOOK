
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import models.CreateAccount;
import views.pages.PageView;
import views.pages.components.CreateAccountPanel;
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
 *         Responsibilities of class:
 * 
 *         
 * 
 *         Version/date: 1.4 / 05/12/2022
 * 
 * 
 */
//A CreateAccountButtonListener is-an ActionListener.
public class CreateAccountButtonListener implements ActionListener
{

	// CreateAccountButtonListener has-a view.
	private PageView view;

	// CreateAccountButtonListener has-a model.
	private CreateAccount model;

	// CreateAccountButtonListener has-a panel.
	private CreateAccountPanel panel;

	// CreateAccountButtonListener has-a textComponents.
	private Hashtable<String, FormText> textComponents;

	// CreateAccountButtonListener has-a passwordComponents.
	private Hashtable<String, FormPassword> passwordComponents;

	/**
	 * `CreateAccountButtonListener Constructor - It listen to the create account
	 * text fields components and change the view based on that.
	 * 
	 * @param view  - a PageView.
	 * @param panel - it's a CreateAccountPanel.
	 */
	public CreateAccountButtonListener(PageView view, CreateAccountPanel panel)
	{
		// Create a new account model.
		this.model = new CreateAccount();

		// Initialize the view.
		this.view = view;

		// Initialize the panel.
		this.panel = panel;

		textComponents = panel.getTextComponents();

		passwordComponents = panel.getPasswordComponents();

		// Initialize the model.
		this.model = new CreateAccount();

		// CreateAccountButtonListener has-a createAccountButton.
		// Initialize the CreateAccountButton.
		Button createAccountButton = panel.getCreateAccountButton();

		// Listen to CreateAccountButton.
		createAccountButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event)
	{

		// First get the name component from the hashmap and then get it's text value.
		String name = textComponents.get("name").getText();

		// First get the name component from the hashmap and then get it's text value.
		String email = textComponents.get("email").getText();

		// First get the name component from the hashmap and then get it's text value.
		String password = passwordComponents.get("password").getText();

		// First get the name component from the hashmap and then get it's text value.
		String confirmPassword = passwordComponents.get("confirmPassword").getText();

		// First get the name component from the hashmap and then get it's text value.
		String creditCardNumber = textComponents.get("creditCardNumber").getText();

		// First get the name component from the hashmap and then get it's text value.
		String expirationDate = textComponents.get("expirationDate").getText();

		// First get the name component from the hashmap and then get it's text value.
		String cvv = passwordComponents.get("cvv").getText();

		// Set the updated name to model.
		this.model.setName(name);

		// Set the updated email to model.
		this.model.setEmail(email);

		// Set the updated password to the model.
		this.model.setPassword(password);

		// Set the updated confirmPassword to the model.
		this.model.setConfirmPassword(confirmPassword);

		// Set the updated creditCardNumber to the model.
		this.model.setCreditCardNumber(creditCardNumber);

		// Set the updated expirationDate to the model.
		this.model.setExpirationDate(expirationDate);

		// Set the updated cvv to the model.
		this.model.setCvv(cvv);

		// Update the view, and model.
		update();

	}

	/**
	 * Update the view, and model.
	 */
	public void update()
	{
		if (!model.isNameValid())
			panel.updateUI(textComponents.get("name"));

		if (!model.isEmailValid())
			panel.updateUI(textComponents.get("email"));

		if (!model.isPasswordValid())
		{
			panel.updateUI(passwordComponents.get("password"));
			panel.updateUI(passwordComponents.get("confirmPassword"));
		}

		if (!model.isCreditCardNumberValid())
			panel.updateUI(textComponents.get("creditCardNumber"));

		if (!model.isexpirationDateValid())
			panel.updateUI(textComponents.get("expirationDate"));

		if (!model.isCvvValid())
			panel.updateUI(passwordComponents.get("cvv"));

		if (model.isValid())
		{
			// Create a new account.
			model.createAccount();

			// Remove createAccountPanel.
			view.removeCreateAccountPanel();

			// Add loginPanels.
			view.addLoginPanels();
		}
	}
}
