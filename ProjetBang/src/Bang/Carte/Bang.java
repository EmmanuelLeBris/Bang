package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;
import Bang.Jeu.PlusDeCartesException;

public class Bang extends ActionSurAdversaire {
	/**
	 * Constructeur de la carte bang
	 */
	public Bang() {
		super("Bang");
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
			System.out.println("esquive");
			//A FAIRE oui non
			//On d�fausse les cartes rat�
			for(int i =0; i<nbRate;i++) jeu.defausser(cible.prendreAction("Rate"));
		}else{
			cible.setPdv(cible.getPdv()-1);
			if(cible.getPerso().getNom().equals("BART CASSIDY"))
			{
				try {
					cible.donnerAction(jeu.piocher());
				} catch (PlusDeCartesException e) {
					e.getMessage();
				}
			}
		}
	}
	
	

}
