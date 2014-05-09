package Bang.Jeu;

import java.util.ArrayList;

import Bang.Carte.Action;
import Bang.Carte.ActionBonus;

public class Joueur {
	protected int bonusDistance = 0;
	protected int portee = 1;
	protected int pdv;
	protected int pdvmax;
	protected boolean aTire = false;
	protected ArrayList<Action> main = new ArrayList<Action>();
	protected ArrayList<ActionBonus> bonus = new  ArrayList<ActionBonus>();
	protected boolean tireIllimite = false;
	protected Personnage perso;
	protected Role role;

	/**
	 * Constructeur d'un joueur
	 * @param perso du joueur
	 * @param role du joueur
	 */
	public Joueur(Personnage perso, Role role) {
		this.perso = perso;
		this.role = role;
		this.pdv = perso.getPdv()+role.getPdvBonus();
		this.pdvmax = perso.getPdv()+role.getPdvBonus();

		if (this.perso.getNom().equals("ROSE DOOLAN")) portee++;
		if (this.role.getNom().equals("SHERIF")){
			pdv = ++pdvmax;
		}
	}

	/**
	 * Ajoute une action a la main du joueur
	 * @param action a donner
	 */
	public void donnerAction(Action a)
	{
		this.main.add(a);
	}

	/**
	 * Test pour savoir si le joueur peut esquiver un bang
	 * @param nombreRateRequis nombre ratés pour esquiver le bang
	 * @return si oui ou non le joueur peut esquiver
	 */
	public boolean peutEsquiver(int nombreRateRequis) // capable d'esquiver
	{
		int nbRate = 0;
		for(Action a : main)
			if(a.getNom().equals("Rate")) nbRate++;
		return nbRate>=nombreRateRequis;
	}
	
	/**
	 * Supprimer une action de la main du joueur
	 * @param nom de l'action a récupérer
	 * @return l'action suppérimée de la main
	 */
	public Action prendreAction(String action)
	{
		for (Action a : main) {
			if (a.getNom().equals(action)){
				main.remove(a);
				return a;
			}	
		}
		return null;
	}
	
	/**
	 * Supprimer une action de la main du joueur
	 * @param action a récupérer
	 * @return l'action suppérimée de la main
	 */
	public Action prendreAction(Action action)
	{
		if(main.remove(action)) return action;	
		return null;
	}
	
	/**
	 * Récupère une action dans la main du joueur
	 * @param nom de l'action a récupérer
	 * @return action 
	 */
	public Action getAction(String action)
	{
		for (Action a : main) {
			if (a.getNom().equals(action)){
				return a;
			}	
		}
		return null;
	}
	
	/**
	 * Vérifie si une action existe dan la main d'un joueur
	 * @param action
	 * @return vrai ou faux
	 */
	public boolean aLAction(String action)
	{
		for (Action a : main) {
			if (a.getNom().equals(action)){
				return true;
			}	
		}
		return false;
	}
	
	/**
	 * Retourne le nombre d'occurences d'une action dans la main du joueur
	 * @param action a rechercher
	 * @return nombre d'occurences
	 */
	public int nbAction(String action) {
		int res = 0;
		for (Action a : main) {
			if (a.getNom().equals(action)) res++;
		}
		return res;
	}
	
	/**
	 * Défausse une carte au hasard
	 * @return action défaussée
	 */
	public Action defausserRand()
	{
		if (main.isEmpty()!=true)
		{
			int indexrandom = (int) ((this.main.size())*Math.random());
			return this.main.get(indexrandom);
		}
		else
			return null;
	}
	
	/**
	 * Enleve des points de vie au joueur
	 * @param nbPV nombre de points de vie à enlever
	 */
	public void enleverPV(int nbPV){
		pdv-=nbPV;
	}

	/**
	 * Ajouter des points de vie au joueur
	 * @param nbPV nombre de point de vie à ajouter
	 */
	public void ajouterPV(int nbPV){
		if(pdv<pdvmax)	pdv+=nbPV;
	}
	
	/**
	 * Getter de la distance bonus d'un joueur
	 * @return distance
	 */
	public int getDistance() {
		return bonusDistance;
	}
	
	/**
	 * Getter portée d'un joueur
	 * @return portée
	 */
	public int getPortee() {
		return portee;
	}

	/**
	 * Getter nb points de vie d'un joueur
	 * @return points de vie
	 */
	public int getPdv() {
		return pdv;
	}

	/**
	 * Getter nb points de vie max d'un joueur
	 * @return nb points de vie max
	 */
	public int getPdvmax() {
		return pdvmax;
	}

	/**
	 * Getter du booléen permettant de savoir si un joueur a tiré ou pas
	 * @return a tiré?
	 */
	public boolean aTire() {
		return aTire;
	}

	/**
	 * Getter main du joueur
	 * @return main du joueur
	 */
	public ArrayList<Action> getMain() {
		return main;
	}

	/**
	 * Setter portée du joueur
	 * @param portee
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}

	/**
	 * Setter distance bonus d'un joueur
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.bonusDistance = distance;
	}

	/**
	 * Permet de savoir si le joueur a la capacité de tirer à l'infini
	 * @return tire illimité?
	 */
	public boolean isTireIllimite() {
		return tireIllimite;
	}

	/**
	 * Permet de modifier si le joueur est limité à un bang par tour ou non
	 * @param tire Illimite?
	 */
	public void setTireIllimite(boolean tireIllimite) {
		this.tireIllimite = tireIllimite;
	}

	@Override
	public String toString() {
		return perso.getNom()+" "+role.getNom()+" bonusDistance=" + bonusDistance + ", portee=" + portee
				+ ", pdv=" + pdv + ", pdvmax=" + pdvmax + ", tireIllimite="
				+ tireIllimite;
	}

	/**
	 * Getter personnage du joueur
	 * @return personnage
	 */
	public Personnage getPerso() {
		return perso;
	}

	/**
	 * Getter Role du joueur
	 * @return role du joueur
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Accesseur de tous les bonus dont le joueur dispose
	 * @return bonus joués
	 */
	public ArrayList<ActionBonus> getBonus() {
		return bonus;
	}

	/**
	 * Setter des bonnus activés du joueur
	 * @param bonus
	 */
	public void setBonus(ArrayList<ActionBonus> bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * Ajouter bonus au joueur
	 * @param a
	 */
	public void ajouterBonus(ActionBonus a)
	{
		this.bonus.add(a);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perso == null) ? 0 : perso.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (perso == null) {
			if (other.perso != null)
				return false;
		} else if (!perso.equals(other.perso))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	/**
	 * Setter de a Tire permet de savoir si un joueur a déjà tiré ou pas
	 * @param booléen
	 */
	public void setATire(boolean b) {
		aTire = b;		
	}
	
	/**
	 * Setter de points de vie
	 * @param booléen
	 */
	public void setPdv(int i) {
		pdv = i;		
	}
	
	
}
