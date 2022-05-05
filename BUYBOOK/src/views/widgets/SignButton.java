
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Version/date: 1.0 / 05/03/2022
 * 
 * 
 */
package views.widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SignButton extends JButton
{
	public SignButton(String text, Font font, Color color, int margin)
	{
		// Set text.
		super(text);

		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(Color.white);

		// Set background color.
		setBackground(color);

		// Set margin a button (The space between text and border).
		setMargin(new Insets(margin, margin, margin, margin));

		// Remove border around a button.
		setBorder(BorderFactory.createEmptyBorder());
		
		// Remove border around a button's text after mouse clicking.
		setFocusable(false);
	}
}
