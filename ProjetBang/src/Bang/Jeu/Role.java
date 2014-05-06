package Bang.Jeu;

public class Role {
	private String nom;
	private int pdvBonus;
	private String description;
	
	public Role(String nom, int pdvBonus, String description) {
		this.nom = nom;
		this.pdvBonus = pdvBonus;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public int getPdvBonus() {
		return pdvBonus;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Role [nom=" + nom + ", pdvBonus=" + pdvBonus + ", description="
				+ description + "]";
	}
	
		

}
