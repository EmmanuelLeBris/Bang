package vueInterface;

import java.awt.GridLayout;

public class Windows2 {

	public VueAdversaire VueAdv1;
	public VueAdversaire VueAdv2;
	public VueAdversaire VueAdv3;
	public VueAdversaire VueAdv4;
	public VueJoueur VueJoueur;
	public Windows2() {
		FenetrePrincipale fenetre = new FenetrePrincipale("./fond.jpg");
		fenetre.setLayout(new GridLayout(2, 1));
		MyPanel panelhaut = new MyPanel();

		// Vue des adversaires

		VueAdv1 = new VueAdversaire("Slab le Flingueur", false);
		VueAdv2 = new VueAdversaire("Jesse James", false);
		VueAdv3 = new VueAdversaire("Bart Cassidy", true);
		VueAdv4 = new VueAdversaire("Lucky-Luke", false);
		panelhaut.setLayout(new GridLayout(1, 4));
		panelhaut.add(VueAdv1);
		panelhaut.add(VueAdv2);
		panelhaut.add(VueAdv3);
		panelhaut.add(VueAdv4);

		// Vue du joueur
		VueJoueur = new VueJoueur("Joe Dalton", true, "adjoint");

		fenetre.add(panelhaut);
		fenetre.add(VueJoueur);
		fenetre.setVisible(true);
	}

}
