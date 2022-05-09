
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Resource: Regex Retrieved from https://regexr.com/
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 * 
 */
package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccount
{
	// CreateAccountModel has-an name.
	private String name;

	// CreateAccountModel has-an email.
	private String email;

	// CreateAccountModel has-a password.
	private String password;

	// CreateAccountModel has-a confirmPassword.
	private String confirmPassword;

	// CreateAccountModel has-a creditCardNumber.
	private String creditCardNumber;

	// CreateAccountModel has-a expirationDate.
	private String expirationDate;

	// CreateAccountModel has-a cvv.
	private String cvv;

	// CreateAccountModel has-a customer.
	private Customer customer;

	// CreateAccountModel has-a customerDatabase.
	private CustomerDatabase customerDatabase;

	public CreateAccount()
	{

	}

	/**
	 * Set the name.
	 * 
	 * @return the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set the name.
	 * 
	 * @return the name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Set the email.
	 * 
	 * @return the email.
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Set the password.
	 * 
	 * @return the password.
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Set the confirmPassword.
	 * 
	 * @return the confirmPassword.
	 */
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Set the creditCardNumber.
	 * 
	 * @return the creditCardNumber.
	 */
	public void setCreditCardNumber(String creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * Set the expirationDate.
	 * 
	 * @return the expirationDate.
	 */
	public void setExpirationDate(String expirationDate)
	{
		this.expirationDate = expirationDate;
	}

	/**
	 * Set the cvv.
	 * 
	 * @return the cvv.
	 */
	public void setCvv(String cvv)
	{
		this.cvv = cvv;
	}

	/**
	 * Test if the name is valid.
	 * 
	 * @return true is the name is valid, false if the name is not valid.
	 */
	public boolean isNameValid()
	{
		if (this.name.length() > 8)
		{
			// Initialize the regex..
			String regex = "^[a-zA-Z_ ]*";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object.
			Matcher matcher = pattern.matcher(name);

			return matcher.matches();
		}

		return false;
	}

	/**
	 * Test if the email is valid.
	 * 
	 * @return true is the email is valid, false if the email is not valid.
	 */
	public boolean isEmailValid()
	{
		if (this.email.length() >= 8)
		{
			// Initialize the regex..
			String regex = "^(.+)@(.+)$";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object.
			Matcher matcher = pattern.matcher(email);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Test if the password is valid.
	 * 
	 * @return true is the password is valid, false if the password is not valid.
	 */
	public boolean isPasswordValid()
	{
		if (password.length() > 8 && confirmPassword.length() > 8 && password.equals(confirmPassword))
			return true;
		return false;
	}

	/**
	 * Test if the creditCardNumber is valid.
	 * 
	 * @return true is the creditCardNumber is valid, false if the creditCardNumber
	 *         is not valid.
	 */
	public boolean isCreditCardNumberValid()
	{
		if (creditCardNumber.length() == 16)
		{
			// Initialize the regex..
			String regex = "[0-9]+";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object.
			Matcher matcher = pattern.matcher(creditCardNumber);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Test if the expirationDate is valid.
	 * 
	 * @return true is the expirationDate is valid, false if the expirationDate is
	 *         not valid.
	 */
	public boolean isexpirationDateValid()
	{
		if (expirationDate.length() == 5)
		{
			// Initialize the regex..
			String regex = "[0-9]+\\/+[0-9]+";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object.
			Matcher matcher = pattern.matcher(expirationDate);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Test if the cvv is valid.
	 * 
	 * @return true is the cvv is valid, false if the cvv is not valid.
	 */
	public boolean isCvvValid()
	{
		if (cvv.length() == 3)
		{
			// Initialize the regex..
			String regex = "[0-9]+";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object.
			Matcher matcher = pattern.matcher(cvv);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Test if the all the form inputs are valid.
	 * 
	 * @return true is the all the form inputs are valid, false if the all the form
	 *         inputs are not valid.
	 */
	public boolean isValid()
	{
		if (isNameValid() && isEmailValid() && isPasswordValid() && isCreditCardNumberValid() && isexpirationDateValid()
				&& isCvvValid())
		{
			return true;
		}
		return false;
	}

	/**
	 * Create a new account.
	 */
	public void createAccount()
	{
		customer = new Customer(name, email, password, creditCardNumber, expirationDate, cvv);
		customerDatabase = new CustomerDatabase(customer);
		customerDatabase.createANewAccount();
	}

}
