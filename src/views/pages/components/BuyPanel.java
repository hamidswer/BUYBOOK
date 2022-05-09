
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 * 
 *         Version/date: 1.1 / 05/08/2022
 * 
 */
package views.pages.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import views.pages.PageView;
import views.widgets.Text;

@SuppressWarnings("serial")
public class BuyPanel extends JPanel
{
	// BuyPanel has-a nameText.
	private Text message;

	// BuyPanel has-a bgColor.
	private Color bgColor;

	// BuyPanel has-a font.
	private Font font;

	public BuyPanel(PageView view, String text)
	{
		// 1 row and 1 column, Horizontal gap == 10, Vertical gap == 0.
		setLayout(new GridLayout(1, 1, 10, 0));

		// border => top == 0, left == 35, bottom == 0, right == 50.
		setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 50));

		// Initialize Raspberry Sorbet Shade as bgColor.
		bgColor = new Color(131, 56, 87);

		// Set background color.
		setBackground(bgColor);

		// Initialize the font for nameButton.
		font = new Font("Times New Roman", Font.PLAIN, 18);

		// Initialize nameText.
		message = new Text(text, font, Color.white);

		// Add the message.
		add(message);

	}
}
