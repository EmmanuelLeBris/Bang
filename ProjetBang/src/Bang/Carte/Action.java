package Bang.Carte;

public abstract class Action {
	protected String nom;

	/**
	 * Constructeur d'une action à jouer par un joueur
	 * @param nom nom de la carte
	 * @param description description de la carte
	 */
	public Action(String nom) {
		this.nom = nom;

	}

	/**
	 * Accesseur nom de l'action
	 * @return nom de l'action
	 */
	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {/*
		return "[ nom=" + nom + ", description=" + description + "]";
		*/return nom;
	}

}
