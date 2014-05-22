package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VueBonusLunette extends JPanel {

	private Image bg;
	private String s;
	private boolean up;

	public VueBonusLunette(boolean a) {
		if (a) {
			s = "./lunetteb.png";
		} else {
			s = "";
		}
		bg = new ImageIcon(s).getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}
