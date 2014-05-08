package Bang.Carte;

import Bang.Jeu.Joueur;

public class Lunette extends ActionBonus {
	private int porteeBonus = 1;

	public Lunette() {
		super("Lunette","augmente de 1 la portee de votre arme");
		
	}

	@Override
	public void donBonus(Joueur j) {
		j.setPortee(this.porteeBonus+j.getPortee());

	}

	@Override
	public void enleveBonus(Joueur j) {
		j.setPortee(j.getPortee()-this.porteeBonus);

	}

	@Override
	public String toString() {
		return "Lunette [porteeBonus=" + porteeBonus + ", nom=" + nom
				+ ", description=" + description + "]";
	}
	

}
