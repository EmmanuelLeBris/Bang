package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;
import Bang.Jeu.PlusDeCartesException;

public class Convoi extends ActionSurjoueur {
	/**
	 * Constructeur d'un convois
	 */
	public Convoi() {
		super("Convoi");
	}

	/**
	 * Permet au joueur de piocher deux cartes
	 * @param j joueur qui pioche les cartes
	 * @param jeu jeu
	 */
	public void capacite(Joueur j, Jeu jeu){
		try {
			j.donnerAction(jeu.piocher());
		} catch (PlusDeCartesException e) {
			e.getMessage();
		}
		try {
			j.donnerAction(jeu.piocher());
		} catch (PlusDeCartesException e) {
			e.getMessage();
		}
	}

}
