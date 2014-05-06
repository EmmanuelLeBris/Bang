package Bang.Carte;

import Bang.Jeu.Joueur;

public abstract class Arme extends ActionBonus {
	protected int porteeBonus;

	public Arme(String nom, String description, int porteeBonus) {
		super(nom, description);
		this.porteeBonus=porteeBonus;
		// TODO Auto-generated constructor stub
	}

	public int getPorteeBonus() {
		return porteeBonus;
	}

	@Override
	public void donBonus(Joueur j) {
		if (j.getPortee()==1)
		j.setPortee(this.porteeBonus);
		else
			j.setPortee(this.porteeBonus+j.getPortee()-1);
		
	}

	@Override
	public void enleveBonus(Joueur j) {
		j.setPortee(j.getPortee()-(this.porteeBonus-1));
		
	}
	

}
