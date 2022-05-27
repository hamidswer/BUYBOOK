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
 *         Responsibilities of class: It gets the email and password provided by
 *         user and checks if those credentials are exist in the Customer
 *         database or not.
 * 
 *         Version/date: 1.5 / 05/26/2022
 * 
 * 
 */

public class Login {
	// A Login has-an email.
	private String email;

	// A Login has-a password.
	private String password;

	// A Login has-a customerDatabase.
	private CustomerDatabase customerDatabase;

	public Login(String email, String password) {
		// Assign the email value.
		this.email = email;

		// Assign the password value.
		this.password = password;

		// Initialize a customerDatabase.
		customerDatabase = new CustomerDatabase();
	}

	/**
	 * Purpose: Check if there is any customer with the provided email and password
	 * address exist in the Customer database.
	 * 
	 * @return true if there is a customer exist. false if there isn't.
	 */
	public boolean getIsACustomerExist() {
		// Initialize a isACustomerExist.
		boolean isACustomerExist = customerDatabase.isCustomer(email, password);

		// if the email, and password matches a customer return true, otherwise return
		// false.
		return isACustomerExist;
	}

	/**
	 * Get database file error message.
	 * 
	 * @return
	 */
	public String getDatabaseFileErrorMessage() {
		
		return customerDatabase.getErrorMessage();
	}
	
	/**
	 * is database throw an error when tries to find the user.
	 * 
	 * @return
	 */
	public boolean isError() {
		
		return customerDatabase.isError();
	}

}
