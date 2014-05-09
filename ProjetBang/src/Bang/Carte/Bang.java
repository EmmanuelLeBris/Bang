package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Bang extends ActionSurAdversaire {
	/**
	 * Constructeur de la carte bang
	 */
	public Bang() {
		super("Bang", "Ôter un point de vie à un autre joueur");
	}

	/**
	 * Bang un joueur (enleve un point de vie)
	 * @param jeu jeu
	 * @param cible joueur cible du bang
	 * @param jCourant joueur qui donne la carte
	 */
	public void capacite(Jeu jeu, Joueur cible, Joueur jCourant) {
		System.out.println("BANG : "+cible.getRole().getNom()+"->"+cible.getRole().getNom());
		int nbRate = 1;
		if(jCourant.getPerso().getNom().equals("SLAB LE FLINGUEUR")) nbRate++;
		if(cible.peutEsquiver(nbRate)){
			System.out.println("La cible a esquivé");
			//A FAIRE oui non
			//On défausse les cartes raté
			for(int i =0; i<nbRate;i++) jeu.defausser(cible.prendreAction("Rate"));
		}else{
			System.out.println("La cible a pas esquivé");
			cible.setPdv(cible.getPdv()-1);
		}
	}

}
