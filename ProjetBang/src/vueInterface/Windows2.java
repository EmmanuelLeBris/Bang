package vueInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import Bang.Carte.Action;
import Bang.Carte.Magasin;
import controlleur.Controlleur;

public class Windows2 {

	public VueAdversaire VueAdv[] = new VueAdversaire[4];
	public VueJoueur VueJoueur;
	public FenetrePrincipale fenetre;
	public MyPanel PanelPrincipal;
	public JPanel panel;
	public JPanel panelVueCarte;
	public Controlleur control;
	
	public Windows2(VueJoueur vueJoueur, VueAdversaire vueAdv[], Controlleur controlleur) {//Jwindow pour le splashscreen
		fenetre = new FenetrePrincipale();
		control = controlleur;
		PanelPrincipal =new  MyPanel("./fond.png");
		PanelPrincipal.setLayout(new GridLayout(2, 1));
		JPanel panelhaut = new JPanel();
		panelhaut.setOpaque(false);
	    panel = new JPanel();
	    LayoutManager overlay = new OverlayLayout(panel);
	    
	    panelVueCarte =new JPanel();
	    LayoutManager overlayAdv = new OverlayLayout(panelVueCarte);
	    
	    panel.setLayout(overlay);
	    panel.add(PanelPrincipal);
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
		PanelPrincipal.add(panelhaut);
		PanelPrincipal.add(VueJoueur);
		fenetre.setVisible(true);
		fenetre.pack();
	}


}
