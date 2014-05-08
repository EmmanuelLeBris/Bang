package Bang.Application;

import Bang.Jeu.*;

public class Test {
	public static void main(String[] args) {
		Jeu mapartie = new Jeu();
		mapartie.Init("ROSE DOOLAN");
		mapartie.tourDeJeu();
	}
}
