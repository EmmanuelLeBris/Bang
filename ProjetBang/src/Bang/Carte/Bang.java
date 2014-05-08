package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Bang extends ActionSurAdversaire {
	/**
	 * Constructeur de la carte bang
	 */
	public Bang() {
		super("Bang", "�ter un point de vie � un autre joueur");
	}

	/**
	 * Bang un joueur (enleve un point de vie)
	 * @param jeu jeu
	 * @param cible joueur cible du bang
	 * @param jCourant joueur qui donne la carte
	 */
	public void capacite(Jeu jeu, Joueur cible, Joueur jCourant) {
		int nbRate = 1;
		if(jCourant.getPerso().getNom().equals("SLAB LE FLINGUEUR")) nbRate++;
		if(cible.peutEsquiver(nbRate)){
			System.out.println("Voulez vous esqiver");
			//A FAIRE oui non
			//On d�fausse les cartes rat�
			for(int i =0; i<nbRate;i++) jeu.defausser(cible.prendreAction("Rate"));
		}
	}

}
