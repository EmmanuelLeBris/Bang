package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VueArme extends JPanel {

	private Image bg;
	private Graphics graphics;
	
	public VueArme(String s) {
		
		bg = new ImageIcon(s+".png").getImage();
	}

	public void paintComponent(Graphics g) {
		graphics = g;
		g.drawImage(bg, 0, 0, null);
	}
	
	public void change(String s){
		bg = new ImageIcon(s+".png").getImage();
		graphics.drawImage(bg, 0, 0, null);
	}
}
