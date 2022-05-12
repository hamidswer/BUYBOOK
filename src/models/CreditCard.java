
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
 *         Version/date: 1.3 / 05/12/2022
 * 
 * 
 */

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
