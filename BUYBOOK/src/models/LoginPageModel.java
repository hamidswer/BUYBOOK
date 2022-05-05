
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/03/2022
 * 
 * 
 */
package models;

public class LoginPageModel
{

	private String email;
	private String password;

	public LoginPageModel(String email, String password)
	{
		this.email = email;
		this.password = password;
		logToCs();
	}

	public void logToCs()
	{
		System.out.println(this.email + " " + this.password);
	}
}
