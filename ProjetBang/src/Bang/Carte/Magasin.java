package Bang.Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observer;


import Bang.IA.IA;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;
import Bang.Jeu.PlusDeCartesException;

public class Magasin extends ActionSurjoueur {
	/**
	 * Constructeur de l'action magasin
	 */
	
	public boolean achoisi =false;
	public int choix;


	public Magasin() {
		super("Magasin");
	}

	/**
	 * Chaque joueur pioche une carte
	 * 
	 * @param jeu
	 * @throws InterruptedException
	 */
	public void capacite(Jeu jeu) throws InterruptedException {
		ArrayList<Action> magasin = new ArrayList<Action>() ;
		ArrayList<Joueur> joueurs = jeu.getJoueursEnJeu();
		for (int i = 0; i < joueurs.size(); i++) {
			try {
				magasin.add(jeu.piocher());
			} catch (PlusDeCartesException e) {
				e.getMessage();
			}
		}
		System.out.println("Cartes en magasin : " + magasin);
		Collections.shuffle(magasin);
		for (Joueur j : jeu.getJoueursEnJeu()) {
				j.donnerAction(magasin.get(0));
				magasin.remove(0);
		}
		
	}


	

}
