
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/04/2022
 * 
 * 
 */
import controllers.CreateAccountButtonListener;
import controllers.FormFieldListener;
import controllers.LoginButtonListener;
import views.pages.LoginPageView;

public class Main
{

	public static void main(String[] args)
	{
		LoginPageView view = new LoginPageView(); // create a new view
		new FormFieldListener(view);
		new LoginButtonListener(view);
		new CreateAccountButtonListener(view);

	}

}
