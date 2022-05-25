
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import exceptions.InvalidCreditCardNumberException;
import exceptions.InvalidCvvException;
import exceptions.InvalidEmailException;
import exceptions.InvalidExpirationDateException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import models.CreateAccount;
import views.pages.ErrorView;
import views.pages.PageView;
import views.pages.components.CreateAccountPanel;
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
 *         Responsibilities of class: It listens to the createAccountButton, and
 *         if the categoryButton clicked, It gets the value of the form
 *         components. Then It sets those values to the createAccount. Then it
 *         uses the createAccount to evaluate if the information provided by the
 *         customer is valid or not. If it's valid, It uses a createAccount to
 *         adds a new customer to the database and removes the
 *         createAccountPanel and adds the loginPanels to the page view. If it's
 *         invalid, it creates a new ErrorView and adds red border to the
 *         invalid components.
 * 
 * 
 * 
 *         Version/date: 1.5 / 05/15/2022
 * 
 * 
 */
// A CreateAccountButtonListener is-an ActionListener.
public class CreateAccountButtonListener implements ActionListener
{

	// A CreateAccountButtonListener has-a pageView.
	private PageView pageView;

	// A CreateAccountButtonListener has-a createAccount.
	private CreateAccount createAccount;

	// A CreateAccountButtonListener has-a createAccountPanel.
	private CreateAccountPanel createAccountPanel;

	// A CreateAccountButtonListener has-a textComponents.
	private Hashtable<String, FormText> textComponents;

	// A CreateAccountButtonListener has-a passwordComponents.
	private Hashtable<String, FormPassword> passwordComponents;

	public CreateAccountButtonListener(PageView pageView, CreateAccountPanel createAccountPanel)
	{
		// Initialize the createAccount. It works as the model. 
		this.createAccount = new CreateAccount();

		// Assign the pageView value.
		this.pageView = pageView;

		// Assign the createAccountPanel value.
		this.createAccountPanel = createAccountPanel;

	}

	/**
	 * Purpose: It Invokes when an action occurs. The action of this method is to
	 * click on the createAccountButton. It overrides actionPerformed method of
	 * ActionListener. Polymorphism (dynamically bind)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Assign the textComponents value.
		textComponents = createAccountPanel.getTextComponents();

		// Assign the passwordComponents value.
		passwordComponents = createAccountPanel.getPasswordComponents();

		// First get the name component from the hashtable and then get it's text value.
		String name = textComponents.get("name").getText();

		// First get the email component from the hashtable and then get it's text value.
		String email = textComponents.get("email").getText();

		// First get the password component from the hashtable and then get it's password value and then convert it to the String.
		String password = String.valueOf(passwordComponents.get("password").getPassword());

		// First get the confirmPassword component from the hashtable and then get it's text value and then convert it to the String.
		String confirmPassword = String.valueOf(passwordComponents.get("confirmPassword").getPassword());

		// First get the creditCardNumber component from the hashtable and then get it's text value.
		String creditCardNumber = textComponents.get("creditCardNumber").getText();

		// First get the expirationDate component from the hashtable and then get it's text value.
		String expirationDate = textComponents.get("expirationDate").getText();

		// First get the cvv component from the hashtable and then get it's text value and then convert it to the String.
		String cvv = String.valueOf(passwordComponents.get("cvv").getPassword());

		// Set the updated name in createAccount.
		this.createAccount.setName(name);

		// Set the updated email in createAccount.
		this.createAccount.setEmail(email);

		// Set the updated password in createAccount.
		this.createAccount.setPassword(password);

		// Set the updated confirmPassword in createAccount.
		this.createAccount.setConfirmPassword(confirmPassword);

		// Set the updated creditCardNumber in createAccount.
		this.createAccount.setCreditCardNumber(creditCardNumber);

		// Set the updated expirationDate in createAccount.
		this.createAccount.setExpirationDate(expirationDate);

		// Set the updated cvv in createAccount.
		this.createAccount.setCvv(cvv);

		// Create an error message.
		// Initialize errorMessage.
		String errorMessage = "";

		// It tries to update name, but if the name is invalid, it throws a customized invalidNameException,
		// and adds the invalidNameException error message to the errorMessage.
		try
		{
			updateName();
		} catch (InvalidNameException error)
		{
			errorMessage += error.getMessage();
		}

		// It tries to update email, but if the email is invalid, it throws a customized invalidEmailException,
		// and adds the invalidEmailException error message to the errorMessage.
		try
		{
			updateEmail();
		} catch (InvalidEmailException error)
		{
			errorMessage += " " + error.getMessage();
		}

		// It tries to update password, but if the password or confirmedPassword are invalid, it throws a customized invalidPasswordException,
		// and adds the invalidPasswordException error message to the errorMessage.
		try
		{
			updatePassword();
		} catch (InvalidPasswordException error)
		{
			errorMessage += " " + error.getMessage();
		}

		// It tries to update creditCardNumber, but if the creditCardNumber is invalid, it throws a customized invalidCreditCardNumberException,
		// and adds the invalidCreditCardNumberException error message to the errorMessage.
		try
		{
			updateCreditCardNumber();
		} catch (InvalidCreditCardNumberException error)
		{
			errorMessage += " " + error.getMessage();
		}

		// It tries to update expirationDate, but if the expirationDate is invalid, it throws a customized invalidExpirationDateException,
		// and adds the invalidExpirationDateException error message to the errorMessage.
		try
		{
			updateExpirationDate();
		} catch (InvalidExpirationDateException error)
		{
			errorMessage += " " + error.getMessage();
		}

		// It tries to update cvv, but if the cvv is invalid, it throws a customized invalidCvvException,
		// and adds the invalidCvvException error message to the errorMessage.
		try
		{
			updateCvv();
		} catch (InvalidCvvException error)
		{
			errorMessage += " " + error.getMessage();
		}

		// If there is an error happened.
		if (errorMessage.length() > 0)
		{

			// creates an ErrorView.
			new ErrorView("Can't create a BUYBOOK account!", errorMessage);
		} else
		{
			// update the UI and model.
			updateUIAndModel();
		}

	}

	/**
	 * Purpose: It updates the name component if the customer didn't provide a valid
	 * name and throws a invalidNameException.
	 * 
	 * @throws InvalidNameException - it's an exception with customized error
	 *                              message for an invalid name.
	 */
	public void updateName() throws InvalidNameException
	{
		if (createAccount.isNameValid())
		{
			createAccountPanel.setBorderGreen(textComponents.get("name"));
		} else
		{
			createAccountPanel.setBorderRed(textComponents.get("name"));
			throw new InvalidNameException();
		}
	}

	/**
	 * Purpose: It updates the email component if the customer didn't provide a
	 * valid email and throws a invalidEmailException.
	 * 
	 * @throws InvalidEmailException - it's an exception with customized error
	 *                               message for an invalid email.
	 */
	public void updateEmail() throws InvalidEmailException
	{
		if (createAccount.isEmailValid())
		{
			createAccountPanel.setBorderGreen(textComponents.get("email"));
		} else
		{
			createAccountPanel.setBorderRed(textComponents.get("email"));
			throw new InvalidEmailException();
		}
	}

	/**
	 * Purpose: It updates the password and confirmPassword components if the
	 * customer didn't provide a valid password or confirmPassword and throws a
	 * invalidPasswordException.
	 * 
	 * @throws InvalidPasswordException - it's an exception with customized error
	 *                                  message for invalid password or
	 *                                  confirmPassword.
	 */
	public void updatePassword() throws InvalidPasswordException
	{
		if (createAccount.isPasswordValid())
		{
			createAccountPanel.setBorderGreen(passwordComponents.get("password"));
			createAccountPanel.setBorderGreen(passwordComponents.get("confirmPassword"));
		} else
		{
			createAccountPanel.setBorderRed(passwordComponents.get("password"));
			createAccountPanel.setBorderRed(passwordComponents.get("confirmPassword"));
			throw new InvalidPasswordException();
		}
	}

	/**
	 * Purpose: It updates the creditCardNumber component if the customer didn't
	 * provide a valid creditCardNumber and throws a
	 * invalidCreditCardNumberException.
	 * 
	 * @throws InvalidCreditCardNumberException - it's an exception with customized
	 *                                          error message for an invalid
	 *                                          creditCardNumber.
	 */
	public void updateCreditCardNumber() throws InvalidCreditCardNumberException
	{
		if (createAccount.isCreditCardNumberValid())
		{
			createAccountPanel.setBorderGreen(textComponents.get("creditCardNumber"));
		} else
		{
			createAccountPanel.setBorderRed(textComponents.get("creditCardNumber"));
			throw new InvalidCreditCardNumberException();
		}
	}

	/**
	 * Purpose: It updates the expirationDate component if the customer didn't
	 * provide a valid expirationDate and throws a invalidExpirationDateException.
	 * 
	 * @throws InvalidExpirationDateException - it's an exception with customized
	 *                                        error message for an invalid
	 *                                        expirationDate.
	 */
	public void updateExpirationDate() throws InvalidExpirationDateException
	{
		if (createAccount.isexpirationDateValid())
		{
			createAccountPanel.setBorderGreen(textComponents.get("expirationDate"));
		} else
		{
			createAccountPanel.setBorderRed(textComponents.get("expirationDate"));
			throw new InvalidExpirationDateException();
		}
	}

	/**
	 * Purpose: It updates the cvv component if the customer didn't provide a valid
	 * cvv and throws a invalidCvvException.
	 * 
	 * @throws InvalidCvvException - it's an exception with customized error message
	 *                             for an invalid cvv.
	 */
	public void updateCvv() throws InvalidCvvException
	{
		if (createAccount.isCvvValid())
		{
			createAccountPanel.setBorderGreen(passwordComponents.get("cvv"));
		} else
		{
			createAccountPanel.setBorderRed(passwordComponents.get("cvv"));
			throw new InvalidCvvException();
		}
	}

	/**
	 * Purpose: It adds a new customer to the database. It removes
	 * createAccountPanel from the page view and adds loginPanels to the page view.
	 */
	public void updateUIAndModel()
	{
		// It adds a new customer to the database.
		createAccount.addNewCustomer();

		// Remove createAccountPanel.
		pageView.removeCreateAccountPanel();

		// Add loginPanels.
		pageView.addLoginPanels();
	}
}
