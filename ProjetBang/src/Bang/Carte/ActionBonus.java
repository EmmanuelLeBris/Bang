package Bang.Carte;
import Bang.Jeu.*;

public abstract class ActionBonus extends Action {

	public ActionBonus(String nom, String description) {
		super(nom, description);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void donBonus(Joueur j);
	public abstract void enleveBonus(Joueur j);

}
