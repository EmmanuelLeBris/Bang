package Bang.Jeu;

public class PlusDeCartesException extends Exception {
	private static final long serialVersionUID = 1888199015941435308L;

	public PlusDeCartesException() {
		super("Plus de cartes dans la pioche");
	}
}
