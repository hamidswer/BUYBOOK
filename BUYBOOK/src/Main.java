
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/03/2022
 * 
 * 
 */
import controllers.FormFieldListener;
import controllers.LoginButtonListener;
import views.pages.LoginPageView;

public class Main
{

	public static void main(String[] args)
	{
		LoginPageView view = new LoginPageView(); // create a new view
		new LoginButtonListener(view);
		new FormFieldListener(view);
		

	}

}
