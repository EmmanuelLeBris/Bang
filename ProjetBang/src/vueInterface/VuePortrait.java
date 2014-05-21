package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VuePortrait extends JPanel {

	private Image bg;
	private String s;

	public VuePortrait(String s) {
		this.s=s+".jpg";
		bg = new ImageIcon(this.s).getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}
