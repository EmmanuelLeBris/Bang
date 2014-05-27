package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VueArme extends JPanel {

	private Image bg;

	public VueArme(String s) {
		
		bg = new ImageIcon(s+".png").getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}
