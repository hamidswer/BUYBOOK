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
 *         Version/date: 1.4 / 05/12/2022
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
		this.name = name;
		this.email = email;
		this.password = password;
		this.creditCard = new CreditCard(creditCardNumber, expirationDate, cvv);
	}

	/**
	 * Get name.
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Get email.
	 * 
	 * @return email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Get password.
	 * 
	 * @return password.
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Get creditCard.
	 * 
	 * @return creditCard.
	 */
	public CreditCard getCreditCard()
	{
		return creditCard;
	}

}
