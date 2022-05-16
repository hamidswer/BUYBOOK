package views.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.widgets.TextLabel;

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
 *         Responsibilities of class: It creates ErrorView to show more details
 *         about the wrong credentials provided by the customer.
 * 
 *         Version/date: 1.1 / 05/15/2022
 * 
 * 
 */
// An ErrorPanel is-a JFrame.
public class ErrorView extends JFrame
{

	/**
	 * Serialization is a mechanism of converting the state of an object into a byte
	 * stream, and it can be used to make it eligible for saving its state into a
	 * file. If you are serializing objects and deserializing them in a different
	 * place (or time) where (when) the class has changed, without creating
	 * serialVersionUID, you could be faced with InvalidClassException. The JFrame
	 * class implements java.io.Serializable interface so the it's subclass
	 * (ErrorPanel).
	 */
	private static final long serialVersionUID = 2938602949431699542L;

	// An ErrorPanel has-a multiLineErrorMessage.
	private String multiLineErrorMessage;

	public ErrorView(String errorTitle, String errorMessage)
	{

		// Initialize the errorImage.
		ImageIcon errorImage = new ImageIcon("src/views/images/error.png");

		// Set this window's icon.
		setIconImage(errorImage.getImage());

		// Set error page window's title.
		setTitle(errorTitle);

		// Closes the frame when the close button is clicked.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		GridLayout grid = new GridLayout(1, 1, 0, 10);

		// Set the grid layout for the frame.
		setLayout(grid);

		// Set the size of this window.
		setSize(400, 400);

		// Move the window to the center position of the screen.
		setLocationRelativeTo(null);

		// Display the window.
		setVisible(true);

		// Set resizeable to false.
		setResizable(false);

		// Set the Inkwell color as the application background color.
		getContentPane().setBackground(new Color(54, 57, 69));

		JPanel errorPanel = new JPanel();

		// Make the panel transparent.
		errorPanel.setOpaque(false);

		errorPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

		// Set the grid layout for the errorPanel.
		errorPanel.setLayout(grid);

		Font font = new Font("Times New Roman", Font.PLAIN, 20);

		// Convert errorMessage to multiLine error message in HTML format.
		multiLineErrorMessage = convertToMultiLine(errorMessage);

		TextLabel errorLabel = new TextLabel(multiLineErrorMessage, font, new Color(240, 85, 87));

		errorPanel.add(errorLabel);

		add(errorPanel);

	}

	/**
	 * Purpose: Convert errorMessage to multiLine error message in HTML format.
	 * 
	 * @param errorMessage it's an error message that we want to convert it to
	 *                     multiLine message.
	 * @return errorMessage to be converted in multiLine HTML format.
	 */
	public String convertToMultiLine(String errorMessage)
	{
		String multiLineErrorMessage = errorMessage.replaceAll("\\.", "\\.<br>");
		return "<html>" + multiLineErrorMessage + "</html>";
	}
}
