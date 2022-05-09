
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.1 / 05/05/2022
 * 
 */
package views.widgets;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Text extends JLabel
{

	public Text(String text, Font font, Color color)
	{
		// initialize the text.
		super(text);

		// Set the font.
		setFont(font);

		// Set the text color.
		setForeground(color);
	}
}
