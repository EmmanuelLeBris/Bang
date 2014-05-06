package Bang.Carte;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Saloon extends ActionSurjoueur {

	public Saloon() {
		super("Saloon", "Rend un point de vie à tout le monde");
	}
	
	public void capacite(Jeu jeu){
		for(Joueur j : jeu.getParticipants()){
			j.ajouterPV(1);
		}
	}

}
