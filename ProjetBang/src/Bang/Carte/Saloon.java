package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Saloon extends ActionSurjoueur {
	/**
	 * Constructeur de l'action saloon
	 */
	public Saloon() {
		super("Saloon", "Rend un point de vie à tout le monde");
	}

	/**
	 * Capacité de la carte. Rend un point de vie à tous les personnages.
	 * @param jeu jeu
	 */
	public void capacite(Jeu jeu){
		for(Joueur j : jeu.getJoueursEnJeu()){
			j.ajouterPV(1);
		}
	}

}
