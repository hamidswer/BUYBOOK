import views.pages.PageView;

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
 *         public static void main(String[] args) – Java main method.
 *         https://www.journaldev.com/12552/public-static-void-main-string-args-java-main-method
 * 
 *         Java How to create objects of class without name.
 *         https://stackoverflow.com/questions/31908895/java-how-to-create-objects-of-class-without-name
 * 
 *         Responsibilities of class:
 * 
 *         The Main class has a static main method. Java main method is the entry
 *         point of any java program. When we execute the BUYBOOK application,
 *         Java runtime starts the application by calling the main method. the
 *         main method creates a new PageView instance without assigning to a
 *         local variable.
 * 
 *         Version/date: 1.3 / 05/12/2022
 * 
 * 
 */

public class Main
{

	// It's public, so java runtime can execute this method.
	public static void main(String[] args)
	{
		// The Main class has-a PageView.
		// Creating a new PageView instance without assigning to a local variable.
		new PageView();

	}

}
