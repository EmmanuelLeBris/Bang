package Bang.Carte;
import java.util.ArrayList;
import java.util.Collections;

import Bang.IA.IA;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Magasin extends ActionSurjoueur {
	/**
	 * Constructeur de l'action magasin
	 */
	public Magasin() {
		super("Magasin", "Révèle autant de carte qu’il y a de joueurs, chaque joueur en pioche une (ordre de jeu à partir de celui qui a posé la carte)");
	}

	/**
	 * Chaque joueur pioche une carte
	 * @param jeu
	 */
	public void capacite(Jeu jeu) {
		ArrayList<Action> magasin = new ArrayList<Action>();
		ArrayList<Joueur> participants = jeu.getParticipants();
		for (int i = 0; i < participants.size(); i++) {
			magasin.add(jeu.piocher());
		}
		System.out.println("Cartes en magasin : "+magasin);
		Collections.shuffle(magasin);
		for(Joueur j : jeu.getParticipants()){
			if(j instanceof IA){
				j.donnerAction(magasin.get(0));
				magasin.remove(0);
			}
			else{
				//A FAIRE le joueur doit choisir une carte
			}
		}
	}

}
