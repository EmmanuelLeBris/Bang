package vueInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Bang.Carte.Action;

public class VueCarteJoueeAdv extends JPanel{
	Image bg;
	public VueCarteJoueeAdv(Action a) {
		JButton bouton = new JButton();
		bouton.setIcon(new ImageIcon(a.getNom()+".png"));
		bouton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(bouton);
	}

}
