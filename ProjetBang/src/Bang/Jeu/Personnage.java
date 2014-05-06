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
		return "Personnage [nom=" + nom + ", pdv=" + pdv + ", description="
				+ description + "]";
	}	

}
