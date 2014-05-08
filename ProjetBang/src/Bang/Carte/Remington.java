package Bang.Carte;

public class Remington extends Arme {
	/**
	 * Constructeur de l'arme remington
	 */
	public Remington() {
		super("Remington","portee 3", 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Remington [porteeBonus=" + porteeBonus + ", nom=" + nom
				+ ", description=" + description + "]";
	}


}