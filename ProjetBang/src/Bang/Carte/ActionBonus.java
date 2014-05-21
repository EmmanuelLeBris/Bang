package Bang.Carte;
import Bang.Jeu.*;

public abstract class ActionBonus extends Action {
	/**
	 * Constructeur d'une action bonus qui permet d'améliorer le personnage d'un joueur
	 * @param nom nom de l'action
	 */
	public ActionBonus(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Donne le bonus a un joueur
	 * @param joueur a qui donner le bonus de la carte
	 */
	public abstract void donBonus(Joueur j);

	/**
	 * Enleve bonus à un joueur
	 * @param joueur à qui enlever le bonus
	 */
	public abstract void enleveBonus(Joueur j);

}
