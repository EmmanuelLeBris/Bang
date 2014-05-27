package vueInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VuePointDeVie extends JPanel {

	private Image bg;
	private String s="";

	public VuePointDeVie(boolean a) {
		if (a) {
			 s="./pdvUpBois.png";
		} else {
			s="./pdvDownBois.png";
		}
		bg = new ImageIcon(s).getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}

}
