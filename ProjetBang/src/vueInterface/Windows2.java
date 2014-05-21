package vueInterface;

import java.awt.GridLayout;

public class Windows2 {

	public VueAdversaire VueAdv1;
	public VueAdversaire VueAdv2;
	public VueAdversaire VueAdv3;
	public VueAdversaire VueAdv4;
	public VueJoueur VueJoueur;
	public Windows2(VueJoueur vueJoueur, VueAdversaire vueAdv1, VueAdversaire vueAdv2, VueAdversaire vueAdv3, VueAdversaire vueAdv4) {
		FenetrePrincipale fenetre = new FenetrePrincipale("./fond.jpg");
		fenetre.setLayout(new GridLayout(2, 1));
		MyPanel panelhaut = new MyPanel();

		// Vue des adversaires

		this.VueAdv1 = vueAdv1;
		this.VueAdv2 = vueAdv2;
		this.VueAdv3 = vueAdv3;
		this.VueAdv4 = vueAdv4;
		panelhaut.setLayout(new GridLayout(1, 4));
		panelhaut.add(this.VueAdv1);
		panelhaut.add(this.VueAdv2);
		panelhaut.add(this.VueAdv3);
		panelhaut.add(this.VueAdv4);

		// Vue du joueur
		this.VueJoueur = vueJoueur;

		fenetre.add(panelhaut);
		fenetre.add(VueJoueur);
		fenetre.setVisible(true);
	}

}
