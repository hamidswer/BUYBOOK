package models;

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

public class Login
{

	// Login has-a isACustomerExist.
	private boolean isACustomerExist;

	public Login(String email, String password)
	{

		// Initialize a customerDatabase.
		CustomerDatabase customerDatabase = new CustomerDatabase();

		// Initialize a isACustomerExist.
		isACustomerExist = customerDatabase.isCustomer(email, password);
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
