package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VueCartesAdv extends JPanel {

	private Image bg = new ImageIcon("./doscarte.png").getImage();

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}
