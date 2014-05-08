package Bang.Carte;

public abstract class Action {
	protected String nom;
	protected String description;

	/**
	 * Constructeur d'une action à jouer par un joueur
	 * @param nom nom de la carte
	 * @param description description de la carte
	 */
	public Action(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	/**
	 * Récupère la description de l'action
	 * @return description de l'action
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Accesseur nom de l'action
	 * @return nom de l'action
	 */
	public String getNom() {
		return nom;
	}



}
