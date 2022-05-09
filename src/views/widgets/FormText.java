
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

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

@SuppressWarnings("serial")
public class FormText extends JTextField
{

	public FormText(String text, Font font, int margin)
	{

		// Set text font.
		setFont(font);

		// Set text color.
		setForeground(new Color(147, 149, 151));

		// Set text.
		setText(text);
		
		// Set the cursor color to white.
		setCaretColor(Color.WHITE);

		// Set margin for a text field (The space between text and border).
		setMargin(new Insets(margin, margin, margin, margin));

		// Make a text field transparent.
		setOpaque(false);
	}

}
