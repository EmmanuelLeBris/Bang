package Bang.Carte;
import java.util.ArrayList;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Magasin extends ActionSurjoueur {

	public Magasin() {
		super("Magasin", "Révèle autant de carte qu’il y a de joueurs, chaque joueur en pioche une (ordre de jeu à partir de celui qui a posé la carte)");
	}

	public void capacite(Jeu jeu) {
		ArrayList<Action> magasin = new ArrayList<Action>();
		for(Joueur j : jeu.getParticipants())
			magasin.add(jeu.piocher());
		System.out.println("Cartes en magasin : "+magasin);
		
		//Chaque joueur doit choisir une carte
		//A FAIRE
	}

}
