package controlleur;

import Bang.Jeu.Jeu;

public class Test {

	public static void main(String[] args) {
		Jeu mapartie = new Jeu();
		mapartie.initJoueurs("ROSE DOOLAN");
		Controlleur c =new Controlleur(mapartie);
		mapartie.setControlleur(c);
		mapartie.lancerJeu();
		
	}

}
