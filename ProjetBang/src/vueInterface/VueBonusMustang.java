package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VueBonusMustang extends JPanel {

	private Image bg;
	private String s;
	public boolean up=true;

	public VueBonusMustang() {
		if (up) {
			s = "mustangb.png";
		} 
		bg = new ImageIcon(s).getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}
