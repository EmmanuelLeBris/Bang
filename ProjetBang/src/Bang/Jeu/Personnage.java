package Bang.Jeu;

public class Personnage {

	private String nom;
	private int pdv;
	private String description;
	
	public Personnage(String nom, int pdv, String description) {
		this.nom = nom;
		this.pdv = pdv;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public int getPdv() {
		return pdv;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "[ nom=" + nom + ", pdv=" + pdv + ", description="
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
		Personnage other = (Personnage) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	

}
