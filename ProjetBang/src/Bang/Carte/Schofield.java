package Bang.Carte;

public class Schofield extends Arme {
	/**
	 * Constructeur de l'arme schofield
	 */
	public Schofield() {
		super("Schofield","portee 2", 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Schofield [porteeBonus=" + porteeBonus + ", nom=" + nom
				+ ", description=" + description + "]";
	}

}
