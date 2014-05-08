package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Convois extends ActionSurjoueur {
	/**
	 * Constructeur d'un convois
	 */
	public Convois() {
		super("Convois", "Permet de piocher deux cartes");
	}

	/**
	 * Permet au joueur de piocher deux cartes
	 * @param j joueur qui pioche les cartes
	 * @param jeu jeu
	 */
	public void capacite(Joueur j, Jeu jeu){
		j.donnerAction(jeu.piocher());
		j.donnerAction(jeu.piocher());
	}

}
