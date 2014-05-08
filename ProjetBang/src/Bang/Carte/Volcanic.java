package Bang.Carte;

import Bang.Jeu.Joueur;

public class Volcanic extends Arme {
	/**
	 * Constructeur de l'arme volcanic
	 */
	public Volcanic() {
		super("Volcanic", "portee 1 mais tirs illimités", 1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void donBonus(Joueur j) {
		if (j.getPortee()==1)
			j.setPortee(this.porteeBonus);
		else
			j.setPortee(this.porteeBonus+j.getPortee()-1);

		j.setTireIllimite(true);

	}

	@Override
	public void enleveBonus(Joueur j) {
		j.setPortee(1);
		j.setTireIllimite(false);
	}
	@Override
	public String toString() {
		return "Volcanic [porteeBonus=" + porteeBonus + ", nom=" + nom
				+ ", description=" + description + "]";
	}


}
