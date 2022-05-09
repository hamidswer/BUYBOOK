package models;

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
