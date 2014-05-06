package Bang.Carte;

import Bang.Jeu.ActionSurAdversaire;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class CoupDeFoudre extends ActionSurAdversaire {

	public CoupDeFoudre() {
		super("Coup de foudre", "Défausser une carte à un joueur");
	}

	public void capacite(Jeu jeu, Joueur cible) {
		//A FAIRE le joueur peut choisir de défausser une carte bonus
		Action defausse = cible.defausserRand();
		if(defausse!=null) jeu.defausser(defausse);
	}

}
