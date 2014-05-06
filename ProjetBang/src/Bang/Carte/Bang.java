package Bang.Carte;

import Bang.Jeu.ActionSurAdversaire;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Bang extends ActionSurAdversaire {

	public Bang() {
		super("Bang", "Ôter un point de vie à un autre joueur");
	}
	
	public void capacite(Jeu jeu, Joueur cible, Joueur jCourant) {
		int nbRate = 1;
		if(jCourant.getPerso().getNom().equals("SLAB LE FLINGUEUR")) nbRate++;
		if(cible.peutEsquiver(nbRate)){
			System.out.println("Voulez vous esqiver");
			//A FAIRE oui non
			//On défausse les cartes raté
			for(int i =0; i<nbRate;i++) jeu.defausser(cible.getAction("Rate"));
		}
	}
	
}
