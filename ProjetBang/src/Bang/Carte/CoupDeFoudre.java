package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class CoupDeFoudre extends ActionSurAdversaire {
	/**
	 * Constructeur d'un coup de foudre
	 */
	public CoupDeFoudre() {
		super("Coup de foudre");
	}

	/**
	 * Defausse une carte au joueur cible
	 * @param jeu jeu
	 * @param cible joueur cible qui se voit défaussé d'une carte
	 */
	public void capacite(Jeu jeu, Joueur cible) {
		Action defausse = cible.defausserRand();
		if(defausse!=null) jeu.defausser(defausse);
	}

}
