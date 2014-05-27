package vueInterface;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

	public FenetrePrincipale() {
		setTitle("Bang!");
		setPreferredSize(new Dimension(1024, 768));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
