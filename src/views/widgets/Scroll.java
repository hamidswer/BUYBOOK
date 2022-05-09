
/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab.
 * 
 *         Resources:
 * 
 *         Class BasicScrollBarUI Retrieved from
 *         https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/plaf/basic/BasicScrollBarUI.html
 * 
 *         How to hide the arrow buttons in a JScrollBar Retrieved from
 *         https://stackoverflow.com/questions/7633354/how-to-hide-the-arrow-buttons-in-a-jscrollbar
 * 
 *         Version/date: 1.1 / 05/07/2022
 * 
 * 
 */
package views.widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

@SuppressWarnings("serial")
public class Scroll extends JScrollPane
{
	public Scroll(Component view)
	{
		super(view);
		// Make the panel transparent.
		setOpaque(false);
		getViewport().setOpaque(false);

		// Set Inkwell color as scroll bar's background color.
		getVerticalScrollBar().setBackground(new Color(54, 57, 69));

		// Set the scroll speed.
		getVerticalScrollBar().setUnitIncrement(16);

		// Set custom scroll bar design
		getVerticalScrollBar().setUI(new BasicScrollBarUI()
		{
			@Override
			protected void configureScrollBarColors()
			{
				// Set the thumb color.
				this.thumbColor = new Color(210, 56, 108);

				// Set the scroll bar width.
				this.scrollBarWidth = 20;
			}

			@Override
			protected JButton createDecreaseButton(int orientation)
			{
				return createZeroButton();
			}

			@Override
			protected JButton createIncreaseButton(int orientation)
			{
				return createZeroButton();
			}

			/**
			 * Remove the button.
			 * 
			 * @return button with size zero.
			 */
			private JButton createZeroButton()
			{
				// Initialize a button.
				JButton button = new JButton();

				// Set preferrred size of button to zero.
				button.setPreferredSize(new Dimension(0, 0));

				// Set minimum size of button to zero.
				button.setMinimumSize(new Dimension(0, 0));

				// Set maximum size of button to zero.
				button.setMaximumSize(new Dimension(0, 0));

				return button;
			}
		});

	}

}
