
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
 *         Responsibilities of class: It creates the creditCard. It gets the
 *         creditCardNumber, expirationDate, and cvv.
 * 
 *         Version/date: 1.4 / 05/15/2022
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
		// Assign the creditCardNumber value.
		this.creditCardNumber = creditCardNumber;

		// Assign the expirationDate value.
		this.expirationDate = expirationDate;

		// Assign the cvv value.
		this.cvv = cvv;
	}

	/**
	 * Purpose: Get creditCardNumber.
	 * 
	 * @return creditCardNumber.
	 */
	public String getCreditCardNumber()
	{
		return creditCardNumber;
	}

	/**
	 * Purpose: Get expirationDate.
	 * 
	 * @return expirationDate.
	 */
	public String getExpirationDate()
	{
		return expirationDate;
	}

	/**
	 * Purpose: Get cvv.
	 * 
	 * @return cvv.
	 */
	public String getCvv()
	{
		return cvv;
	}
}
