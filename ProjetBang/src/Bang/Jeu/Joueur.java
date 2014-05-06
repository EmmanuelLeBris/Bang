package Bang.Jeu;

import java.util.ArrayList;

import Bang.Carte.Action;
import Bang.Carte.ActionBonus;
import Bang.Carte.Arme;

public class Joueur {
	private int distance = 1;
	private int portee = 1;
	private int pdv;
	private int pdvmax;
	private boolean aTire = false;
	private ArrayList<Action> main = new ArrayList<Action>();
	private ArrayList<ActionBonus> bonus = new  ArrayList<ActionBonus>();
	private boolean tireIllimite = false;
	private Personnage perso;
	private Role role;
	private Arme arme = null;

	public Joueur(Personnage perso, Role role) {
		this.perso = perso;
		this.role = role;
		this.pdv = perso.getPdv()+role.getPdvBonus();
		this.pdvmax = perso.getPdv()+role.getPdvBonus();

		if (this.perso.getNom().equals("ROSE DOOLAN")) portee++;
	}

	public void donnerAction(Action a)
	{
		this.main.add(a);
	}

	public boolean peutEsquiver(int nombreRateRequis) // capable d'esquiver
	{
		boolean resultat= false;
		for(int i=0;i<nombreRateRequis;i++)
		{
			if(this.getAction("Rate")!= null)
				resultat= true;
			else
				resultat= false;
		}
		return resultat;
	}
	
	
	public Action getAction(String action)
	{
		for (Action a : main) {
			if (a.getNom().equals(action)){
				main.remove(a);
				return a;
			}	
		}
		return null;
	}
	
	public Action defausserRand()
	{
		if (main.isEmpty()!=true)
		{
			int indexrandom = (int) ((this.main.size()+1)*Math.random());
			return this.main.get(indexrandom);
		}
		else
			return null;
	}
	
	public void enleverPV(int nbPV){
		pdv-=nbPV;
	}

	public void ajouterPV(int nbPV){
		if(pdv<pdvmax)	pdv+=nbPV;
	}
	
	public int getDistance() {
		return distance;
	}

	public int getPortee() {
		return portee;
	}

	public int getPdv() {
		return pdv;
	}

	public int getPdvmax() {
		return pdvmax;
	}

	public boolean aTire() {
		return aTire;
	}

	public ArrayList<Action> getMain() {
		return main;
	}


	public void setPortee(int portee) {
		this.portee = portee;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isTireIllimite() {
		return tireIllimite;
	}


	public void setTireIllimite(boolean tireIllimite) {
		this.tireIllimite = tireIllimite;
	}



	@Override
	public String toString() {
		return "Joueur [portee=" + portee + ", perso=" + perso + ", role="
				+ role + "]";
	}

	public Personnage getPerso() {
		return perso;
	}

	public Role getRole() {
		return role;
	}

	public ArrayList<ActionBonus> getBonus() {
		return bonus;
	}

	public void setBonus(ArrayList<ActionBonus> bonus) {
		this.bonus = bonus;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Action a) {
		this.arme = (Arme) a;
	}
	public void ajouterBonus(ActionBonus a)
	{
		this.bonus.add(a);
	}






}
