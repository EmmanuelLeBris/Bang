package Bang.Carte;

import Bang.Jeu.Joueur;

public class Biere extends ActionSurjoueur {

	public Biere() {
		super("Biere", "Rend un point de vie");
	}
	
	public void capacite(Joueur j){
		j.ajouterPV(1);
	}
}
