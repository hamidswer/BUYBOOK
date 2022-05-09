
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/05/2022
 * 
 * 
 */
package models;

public class Login
{

	// Login has-an email.
	private String email;

	// Login has-a password.
	private String password;

	// Login has-a isACustomerExist.
	private boolean isACustomerExist;

	// Login has-a customerDatabase.
	private CustomerDatabase customerDatabase;

	public Login(String email, String password)
	{
		// Initialize email.
		this.email = email;

		// Initialize password.
		this.password = password;

		// Initialize a customerDatabase.
		this.customerDatabase = new CustomerDatabase();

		// Initialize a isACustomerExist.
		isACustomerExist = customerDatabase.isCustomer(this.email, this.password);
	}

	/**
	 * Check the customer can access to the system.
	 * 
	 * @return true/false
	 */
	public boolean getIsACustomerExist()
	{
		// if the email, and password matches a customer return true, otherwise return false.
		return isACustomerExist;
	}

}
