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
 *         Responsibilities of class: It creates aboutView and adds information
 *         about the BUYBOOK store to it.
 * 
 *         Version/date: 1.1 / 05/15/2022
 * 
 * 
 */

// An AboutView is-a JFrame.
public class AboutView extends JFrame
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

	// An AboutView has-a multiLineAboutMessage.
	private String multiLineAboutMessage;

	public AboutView(String AboutText)
	{

		// Initialize the logoImage.
		ImageIcon logoImage = new ImageIcon("src/views/images/logo.png");

		// Set this window's icon.
		setIconImage(logoImage.getImage());

		// Set about page window's title.
		setTitle("About the BUYBOOK");

		// Closes the frame when the close button is clicked.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		GridLayout grid = new GridLayout(1, 1, 0, 10);

		// Set the grid layout for this frame.
		setLayout(grid);

		// Set the size of the frame.
		setSize(400, 550);

		// Move the frame to the center position of the screen.
		setLocationRelativeTo(null);

		// Display the frame.
		setVisible(true);

		// Set resizeable to false.
		setResizable(false);

		// Set the Inkwell color as the application background color.
		getContentPane().setBackground(new Color(54, 57, 69));

		JPanel aboutPanel = new JPanel();

		// Make the panel transparent.
		aboutPanel.setOpaque(false);

		aboutPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

		// Set the grid layout for aboutPanel.
		aboutPanel.setLayout(grid);

		Font font = new Font("Times New Roman", Font.PLAIN, 16);

		// Convert AboutText to multiLine about message in HTML format.
		multiLineAboutMessage = convertToMultiLine(AboutText);

		// Creates the aboutLabel.
		TextLabel aboutLabel = new TextLabel(multiLineAboutMessage, font, new Color(255, 255, 255));

		aboutPanel.add(aboutLabel);

		add(aboutPanel);

	}

	/**
	 * Purpose: Convert aboutMessage to multiLine about message in HTML format.
	 * 
	 * @param aboutMessage it's a message that we want to convert it to multiLine
	 *                     message.
	 * @return aboutMessage for converting it in multiLine HTML format.
	 */
	public String convertToMultiLine(String aboutMessage)
	{
		// Replace all dots in the aboutMessage with dot and a new line in html format, 
		// and assign the value to the replacedDotInAboutMessage.
		String replacedDotInAboutMessage = aboutMessage.replaceAll("\\.", "\\.<br>");

		// Replace History: in the replacedDotInAboutMessage with History: and an empty line in html format,
		// and assign the value to the replacedHistoryInAboutMessage.
		String replacedHistoryInAboutMessage = replacedDotInAboutMessage.replace("History:", "History:<br>");

		// Replace Members: in the replacedHistoryInAboutMessage with two empty lines and Members: and an empty line in html format,
		// and assign the value to the replacedMembersInAboutMessage.
		String replacedMembersInAboutMessage = replacedHistoryInAboutMessage.replace("Members:",
				"<br><br>Members:<br>");

		// Replace Address: in the replacedMembersInAboutMessage with an empty line and Address: and an empty line in html format,
		// and assign the value to the replacedAddressInAboutMessage.
		String replacedAddressInAboutMessage = replacedMembersInAboutMessage.replace("Address:",
				"<br>Address:<br>");

		return "<html>" + replacedAddressInAboutMessage + "</html>";
	}
}
