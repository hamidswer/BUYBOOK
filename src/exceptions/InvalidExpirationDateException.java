package exceptions;

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
 *         What does it mean: The serializable class does not declare a static
 *         final serialVersionUID field?
 *         https://stackoverflow.com/questions/2288937/what-does-it-mean-the-serializable-class-does-not-declare-a-static-final-serial
 * 
 *         Responsibilities of class: It's a custom exception which helps to
 *         throw an exception with custom message whenever the customer provides
 *         an invalid expiration date.
 * 
 *         Version/date: 1.1 / 05/15/2022
 * 
 * 
 */

// An invalidExpirationDateException is-a Exception.
public class InvalidExpirationDateException extends Exception
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The
	 * Exception class implements java.io.Serializable interface so the it's
	 * subclass (invalidExpirationDateException).
	 */
	private static final long serialVersionUID = -7058629051978903057L;
	

	public InvalidExpirationDateException()
	{
		// calling the constructor of parent Exception.
		super("The expiration date is not valid, it must be in mm/yy format.");
	}
}