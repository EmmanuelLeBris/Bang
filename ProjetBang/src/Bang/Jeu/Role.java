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
		return "[nom=" + nom + ", pdvBonus=" + pdvBonus + ", description="
				+ description + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
}
