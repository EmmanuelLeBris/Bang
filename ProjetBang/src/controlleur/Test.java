package controlleur;

import Bang.Jeu.Jeu;

public class Test {

	public static void main(String[] args) {
		Jeu mapartie = new Jeu();
		Controlleur c =new Controlleur(mapartie);
		mapartie.Init("ROSE DOOLAN", c);
		mapartie.lancerJeu();
		
	}

}
