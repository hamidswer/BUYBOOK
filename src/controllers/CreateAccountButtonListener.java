
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/09/2022
 * 
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.CreateAccount;
import views.pages.PageView;
import views.pages.components.CreateAccountPanel;
import views.widgets.FormPassword;
import views.widgets.FormText;
import views.widgets.Button;

public class CreateAccountButtonListener implements ActionListener
{

	// CreateAccountButtonListener has-a view.
	private PageView view;

	// CreateAccountButtonListener has-a model.
	private CreateAccount model;

	// CreateAccountButtonListener has-a panel.
	private CreateAccountPanel panel;

	// CreateAccountButtonListener has-a createAccountButton.
	private Button createAccountButton;

	// CreateAccountButtonListener has-an nameComponent.
	private FormText nameComponent;

	// CreateAccountButtonListener has-an emailComponent.
	private FormText emailComponent;

	// CreateAccountButtonListener has-a passwordComponent.
	private FormPassword passwordComponent;

	// CreateAccountButtonListener has-a confirmPasswordComponent.
	private FormPassword confirmPasswordComponent;

	// CreateAccountButtonListener has-a creditCardNumberComponent.
	private FormText creditCardNumberComponent;

	// CreateAccountButtonListener has-a expirationDateComponent.
	private FormText expirationDateComponent;

	// CreateAccountButtonListener has-a cvvComponent.
	private FormPassword cvvComponent;

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

		// Initialize the model.
		this.model = new CreateAccount();

		// Initialize the CreateAccountButton.
		createAccountButton = panel.getCreateAccountComponent();

		// Listen to CreateAccountButton.
		createAccountButton.addActionListener(this);
	}

	/**
	 * It overrides actionPerformed method of ActionListener. Polymorphism
	 * (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{

		// Initialize the nameComponent.
		nameComponent = panel.getNameComponent();

		// Initialize the emailComponent.
		emailComponent = panel.getEmailComponent();

		// Initialize the passwordComponent.
		passwordComponent = panel.getPasswordComponent();

		// Initialize the confirmPasswordComponent.
		confirmPasswordComponent = panel.getConfirmPasswordComponent();

		// Initialize the creditCardNumberComponent.
		creditCardNumberComponent = panel.getCreditCardNumberComponent();

		// Initialize the expirationDateComponent.
		expirationDateComponent = panel.getExpirationDateComponent();

		// Initialize the cvvComponent.
		cvvComponent = panel.getCvvComponent();

		// Initialize the name and assign the text value of component to it.
		String name = nameComponent.getText();

		// Initialize the email and assign the text value of component to it.
		String email = emailComponent.getText();

		// Initialize the password and assign the text value of component to it.
		String password = new String(passwordComponent.getPassword());

		// Initialize the confirmPassword and assign the text value of component to it.
		String confirmPassword = new String(confirmPasswordComponent.getPassword());

		// Initialize the creditCardNumber and assign the text value of component to it.
		String creditCardNumber = creditCardNumberComponent.getText();

		// Initialize the expirationDate and assign the text value of component to it.
		String expirationDate = expirationDateComponent.getText();

		// Initialize the cvv and assign the text value of component to it.
		String cvv = new String(cvvComponent.getPassword());

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
			panel.updateUI(nameComponent);

		if (!model.isEmailValid())
			panel.updateUI(emailComponent);

		if (!model.isPasswordValid())
		{
			panel.updateUI(passwordComponent);
			panel.updateUI(confirmPasswordComponent);
		}

		if (!model.isCreditCardNumberValid())
			panel.updateUI(creditCardNumberComponent);

		if (!model.isexpirationDateValid())
			panel.updateUI(expirationDateComponent);

		if (!model.isCvvValid())
			panel.updateUI(cvvComponent);

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
