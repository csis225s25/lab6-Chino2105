import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class MousePresscounter extends MouseAdapter implements Runnable,ActionListener {
   
    private int counter = 0;
   private JLabel display = new JLabel("Presses: " + counter);
   private JPanel panel;
   private JButton resetButton = new JButton("Reset");







    @Override
	public void run() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Mouse Press Counter");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		 panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				String text = "Mouse Press Count:" + counter;
				int stringWidth = fm.stringWidth(text);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(text, xStart, yStart);
			}
		};

		
		panel.addMouseListener(this);
		resetButton.addActionListener(this);

		JPanel buttonJPanel = new JPanel();
		buttonJPanel.add(resetButton);
		

		frame.add(panel, BorderLayout.CENTER);
		frame.add(buttonJPanel, BorderLayout.SOUTH);

		
		

		// display the window we've created
		frame.pack();
		frame.setVisible(true);

	}



	@Override
	public void mouseClicked(MouseEvent e) {
		counter++;
        display.setText("Mouse Pressed counter: " + counter);
		panel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == resetButton) {
			counter = 0;
			display.setText("Mouse Pressed counter: " + counter);
			panel.repaint();
		}
	}

	

	


	



	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePresscounter());
	}
}

