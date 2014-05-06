package Bang.Carte;

public abstract class Action {
	protected String nom;
	protected String description;

	public Action(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public String getNom() {
		return nom;
	}
	
	
	
}
