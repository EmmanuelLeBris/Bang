package Bang.Carte;

import Bang.Jeu.Joueur;

public class Biere extends ActionSurjoueur {

	/**
	 * Constructeur de la carte biere
	 */
	public Biere() {
		super("Biere");
	}

	/**
	 * Execute la capacité de la biere (donne un point de vie)
	 * @param joueur qui prend la biere
	 */
	public void capacite(Joueur j){
		j.ajouterPV(1);
	}
}
