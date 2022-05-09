
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/05/2022
 * 
 * 
 */
package views.widgets;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton
{
	public Button(String text, Font font, Color bgcolor, Color fgColor)
	{
		// Set text.
		super(text);

		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(fgColor);

		// Set background color.
		setBackground(bgcolor);


		// Remove border around a button.
		setBorder(BorderFactory.createEmptyBorder());
		
		// Remove border around a button's text after mouse clicking.
		setFocusable(false);
	}
}
