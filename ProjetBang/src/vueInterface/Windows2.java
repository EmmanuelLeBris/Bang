package vueInterface;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controlleur.Controlleur;

public class Windows2 {

	public VueAdversaire VueAdv[] = new VueAdversaire[4];
	public VueJoueur VueJoueur;
	public Windows2(VueJoueur vueJoueur, VueAdversaire vueAdv[], Controlleur controlleur) {
		FenetrePrincipale fenetre = new FenetrePrincipale("./fond.jpg");
		fenetre.setLayout(new GridLayout(2, 1));
		MyPanel panelhaut = new MyPanel();

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

		fenetre.add(panelhaut);
		fenetre.add(VueJoueur);
		fenetre.setVisible(true);
	}

}
