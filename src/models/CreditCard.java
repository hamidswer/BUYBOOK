
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 * 
 */
package models;

public class CreditCard
{
	// A CreditCard has-a creditCardNumber.
	private String creditCardNumber;

	// A CreditCard has-an expirationDate. 
	private String expirationDate;

	// A CreditCard has-a cvv.
	private String cvv;

	public CreditCard(String creditCardNumber, String expirationDate, String cvv)
	{
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	/**
	 * Get creditCardNumber.
	 * 
	 * @return creditCardNumber.
	 */
	public String getCreditCardNumber()
	{
		return creditCardNumber;
	}

	/**
	 * Get expirationDate.
	 * 
	 * @return expirationDate.
	 */
	public String getExpirationDate()
	{
		return expirationDate;
	}

	/**
	 * Get cvv.
	 * 
	 * @return cvv.
	 */
	public String getCvv()
	{
		return cvv;
	}
}
