package vueInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueCarteJoueur extends JPanel {
	private Image bg;
	public int i = 0;
	public JButton bouton;
	public JLabel panelNomCartes;
	
	public VueCarteJoueur(String s) {
		panelNomCartes = new JLabel(s+" x"+i);
		panelNomCartes.setForeground(Color.white);
		panelNomCartes.setFont(new Font("Gungsuh",Font.BOLD,11));
		bouton = new JButton();
		bouton.setMargin(new Insets(0,0,0,0));
		bouton.setIcon(new ImageIcon(s+".png"));
		bouton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		bouton.setFont(new Font("Gungsuh", Font.BOLD, 14));

		bouton.setPreferredSize(new Dimension(109, 85));
		add(panelNomCartes);
		bouton.setHorizontalAlignment(SwingConstants.RIGHT);
		bouton.setVerticalAlignment(SwingConstants.BOTTOM);
		add(bouton);
		bg = new ImageIcon("plaque.png").getImage();	
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}