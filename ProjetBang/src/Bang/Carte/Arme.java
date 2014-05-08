package Bang.Carte;

import Bang.Jeu.Joueur;

public abstract class Arme extends ActionBonus {
	protected int porteeBonus;
	/**
	 * Constructeur d'une arme qui donne un bonus 
	 * @param nom nom de l'arme
	 * @param description description de l'arme
	 * @param porteeBonus bnus de portee
	 */
	public Arme(String nom, String description, int porteeBonus) {
		super(nom, description);
		this.porteeBonus=porteeBonus;
	}

	/**
	 * Récupère la portée bonus
	 * @return portée bonus
	 */
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
