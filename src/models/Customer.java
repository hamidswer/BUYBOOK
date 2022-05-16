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
 *         Responsibilities of class: It creates customer. It gets the name,
 *         email, password and creditCard of a customer.
 * 
 *         Version/date: 1.5 / 05/15/2022
 * 
 * 
 */
public class Customer
{
	// A Customer has-a name.
	private String name;

	// A Customer has-an email.
	private String email;

	// A Customer has-a password.
	private String password;

	// A Customer has-a creditCard.
	private CreditCard creditCard;

	public Customer(String name, String email, String password, String creditCardNumber, String expirationDate,
			String cvv)
	{
		// Assign the name value.
		this.name = name;

		// Assign the email value.
		this.email = email;

		// Assign the password value.
		this.password = password;

		// Create a new CreditCard.
		this.creditCard = new CreditCard(creditCardNumber, expirationDate, cvv);
	}

	/**
	 * Purpose: Get name.
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Purpose: Get email.
	 * 
	 * @return email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Purpose: Get password.
	 * 
	 * @return password.
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Purpose: Get creditCard.
	 * 
	 * @return creditCard.
	 */
	public CreditCard getCreditCard()
	{
		return creditCard;
	}

}
