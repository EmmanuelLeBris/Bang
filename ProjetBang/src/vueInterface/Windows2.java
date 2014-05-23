package vueInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import controlleur.Controlleur;

public class Windows2 {

	public VueAdversaire VueAdv[] = new VueAdversaire[4];
	public VueJoueur VueJoueur;
	public VueMagasin fondMagasin;
	public FenetrePrincipale fenetre;
	public MyPanel panelPrincipal;
	public Windows2(VueJoueur vueJoueur, VueAdversaire vueAdv[], Controlleur controlleur) {//Jwindow pour le splashscreen
		fenetre = new FenetrePrincipale();
		panelPrincipal = new  MyPanel("fond.png");
		panelPrincipal.setLayout(new GridLayout(2, 1));
		MyPanel panelhaut = new MyPanel();
	    JFrame frame = new JFrame("Overlay Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    LayoutManager overlay = new OverlayLayout(panel);
	    panel.setLayout(overlay);
	    fondMagasin = new VueMagasin(2,"Mustang","Rate",null,null,null);
	    fondMagasin.setVisible(false);
	    panel.add(fondMagasin,BorderLayout.NORTH);    
	    panel.add(panelPrincipal);
	    panel.setBackground(Color.red);
		// Vue des adversaires

		this.VueAdv = vueAdv;
		panelhaut.setLayout(new GridLayout(1, 4));
		panelhaut.add(this.VueAdv[0]);
		panelhaut.add(this.VueAdv[1]);
		panelhaut.add(this.VueAdv[2]);
		panelhaut.add(this.VueAdv[3]);
	for (int i = 0; i < 4; i++) {
		VueAdversaire v = vueAdv[i];
		v.addMouseListener(controlleur);
	}

		// Vue du joueur
		this.VueJoueur = vueJoueur;
		fenetre.add(panel);
		panelPrincipal.add(panelhaut);
		panelPrincipal.add(VueJoueur);
		fenetre.setVisible(true);
	}

}
