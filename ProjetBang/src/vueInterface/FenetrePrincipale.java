package vueInterface;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetrePrincipale extends JFrame {

	public FenetrePrincipale(String s) {
		setTitle("Bang!");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(s)));
	}

}
