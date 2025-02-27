import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class MousePresscounter extends MouseAdapter implements Runnable{
   
    int counter = 0;
   JLabel display = new JLabel("Presses: " + counter);






    @Override
	public void run() {
       
	
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(display, xStart, yStart);
			}
		};
		frame.add(panel);
		panel.addMouseListener(this);
		

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		counter++;
        toDisplay.setText("Mouse Pressed counter: " + counter);
	}

	

	


	



	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MouseDemo());
	}
}

