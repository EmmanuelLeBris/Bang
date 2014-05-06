package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Convois extends ActionSurjoueur {

	public Convois() {
		super("Convois", "Permet de piocher deux cartes");
	}
	
	public void capacite(Joueur j, Jeu jeu){
		j.donnerAction(jeu.piocher());
		j.donnerAction(jeu.piocher());
	}

}
