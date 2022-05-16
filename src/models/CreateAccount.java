
package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 *         RegExr: Learn, Build, Test RegEx. https://regexr.com/
 * 
 *         Responsibilities of class: It creates the new customer in the
 *         customer databse. It checks all user input for creating a new
 *         account. It sets the create new account form data.
 * 
 *         Version/date: 1.5 / 05/15/2022
 * 
 * 
 */
public class CreateAccount
{
	// A CreateAccount has-a name.
	private String name;

	// A CreateAccount has-an email.
	private String email;

	// A CreateAccount has-a password.
	private String password;

	// A CreateAccount has-a confirmPassword.
	private String confirmPassword;

	// A CreateAccount has-a creditCardNumber.
	private String creditCardNumber;

	// A CreateAccount has-a expirationDate.
	private String expirationDate;

	// A CreateAccount has-a cvv.
	private String cvv;

	/**
	 * Purpose: get the name.
	 * 
	 * @return the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Purpose: Set the name.
	 * 
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Purpose: Set the email.
	 * 
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Purpose: Set the password.
	 * 
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Purpose: Set the confirmPassword.
	 * 
	 */
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Purpose: Set the creditCardNumber.
	 * 
	 */
	public void setCreditCardNumber(String creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * Purpose: Set the expirationDate.
	 * 
	 */
	public void setExpirationDate(String expirationDate)
	{
		this.expirationDate = expirationDate;
	}

	/**
	 * Purpose: Set the cvv.
	 * 
	 */
	public void setCvv(String cvv)
	{
		this.cvv = cvv;
	}

	/**
	 * Purpose: Test if the name is valid.
	 * 
	 * @return true is the name is valid, false if the name is not valid.
	 */
	public boolean isNameValid()
	{
		if (this.name.length() > 8)
		{
			// Initialize the regex. It matches only with text and space.
			String regex = "^[a-zA-Z_ ]*";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object to see if name matches by the regex pattern.
			Matcher matcher = pattern.matcher(name);

			// return true if it's matches, false if it's not.
			return matcher.matches();
		}

		return false;
	}

	/**
	 * Purpose: Test if the email is valid.
	 * 
	 * @return true is the email is valid, false if the email is not valid.
	 */
	public boolean isEmailValid()
	{
		if (this.email.length() >= 8)
		{
			// Initialize the regex It matches only with text1@text2.text3 => text3 couldn't have digits. 
			String regex = ".+@.+\\.[^0-9]*";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object to see if email matches by the regex pattern.
			Matcher matcher = pattern.matcher(email);

			// return true if it's matches, false if it's not.
			return matcher.matches();
		}
		return false;
	}

	/**
	 * Purpose: Test if the password is valid.
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
	 * Purpose: Test if the creditCardNumber is valid.
	 * 
	 * @return true is the creditCardNumber is valid, false if the creditCardNumber
	 *         is not valid.
	 */
	public boolean isCreditCardNumberValid()
	{
		if (creditCardNumber.length() == 16)
		{
			// Initialize the regex. It matches only with digits.
			String regex = "[0-9]+";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object to see if creditCardNumber matches by the regex pattern.
			Matcher matcher = pattern.matcher(creditCardNumber);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Purpose: Test if the expirationDate is valid.
	 * 
	 * @return true is the expirationDate is valid, false if the expirationDate is
	 *         not valid.
	 */
	public boolean isexpirationDateValid()
	{
		if (expirationDate.length() == 5)
		{
			// Initialize the regex. It matches only with two digits followed by slash and two other digits.
			String regex = "[0-9]{2}\\/+[0-9]{2}";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object to see if expirationDate matches by the regex pattern.
			Matcher matcher = pattern.matcher(expirationDate);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Purpose: Test if the cvv is valid.
	 * 
	 * @return true is the cvv is valid, false if the cvv is not valid.
	 */
	public boolean isCvvValid()
	{
		if (cvv.length() == 3)
		{
			// Initialize the regex. It matches only with digits.
			String regex = "[0-9]+";

			// Initialize the Pattern object.
			Pattern pattern = Pattern.compile(regex);

			// Initialize the Matcher object to see if cvv matches by the regex pattern.
			Matcher matcher = pattern.matcher(cvv);

			return matcher.matches();
		}
		return false;
	}

	/**
	 * Purpose: Test if the all the form inputs are valid.
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
	 * Purpose: Create a new account in the Customer database.
	 */
	public void addNewCustomer()
	{
		// Initialize a customer.
		Customer customer = new Customer(name, email, password, creditCardNumber, expirationDate, cvv);

		// Initialize customerDatabase. 
		CustomerDatabase customerDatabase = new CustomerDatabase(customer);

		// Create a new account in the Customer database.
		customerDatabase.createANewAccount();
	}

}
