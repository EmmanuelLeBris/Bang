package Bang.Carte;

import Bang.Jeu.ActionSurAdversaire;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Bang extends ActionSurAdversaire {

	public Bang() {
		super("Bang", "�ter un point de vie � un autre joueur");
	}
	
	public void capacite(Jeu jeu, Joueur cible, Joueur jCourant) {
		int nbRate = 1;
		if(jCourant.getPerso().getNom().equals("SLAB LE FLINGUEUR")) nbRate++;
		if(cible.peutEsquiver(nbRate)){
			System.out.println("Voulez vous esqiver");
			//A FAIRE oui non
			//On d�fausse les cartes rat�
			for(int i =0; i<nbRate;i++) jeu.defausser(cible.getAction("Rate"));
		}
	}
	
}
