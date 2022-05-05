
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

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class FormPasswordField extends JPasswordField
{
	public FormPasswordField(String text, Font font, int margin)
	{
		super(text);
		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(new Color(147, 149, 151));

		// Set the cursor color to white.
		setCaretColor(Color.WHITE);

		// Set margin for a password field (The space between text and border).
		setMargin(new Insets(margin, margin, margin, margin));

		// Make a password field transparent.
		setOpaque(false);
	}
}
