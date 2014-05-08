package Bang.Carte;

import Bang.Jeu.Joueur;

public class Mustang extends ActionBonus {
	private int distanceBonus = 1;
	public Mustang() {
		super("Mustang", "augmente votre distance de 1");		
	}
	
	@Override
	public void donBonus(Joueur j) {
		j.setDistance(j.getDistance()+this.distanceBonus);
		
	}
	@Override
	public void enleveBonus(Joueur j) {
		j.setDistance(j.getDistance()-this.distanceBonus);
		
	}
	
	@Override
	public String toString() {
		return "Mustang [distanceBonus=" + distanceBonus + ", nom=" + nom
				+ ", description=" + description + "]";
	}
	



}
