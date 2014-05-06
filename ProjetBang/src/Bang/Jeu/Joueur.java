package Bang.Jeu;

import java.util.ArrayList;

import Bang.Carte.Action;
import Bang.Carte.ActionBonus;
import Bang.Carte.Arme;

public class Joueur {
	private int distance;
	private int portee;
	private int pdv;
	private int pdvmax;
	private boolean Atire;
	private ArrayList<Action> main;
	private ArrayList<ActionBonus> bonus;
	private boolean tireIllimite;
	private Personnage perso;
	private Role role;
	private Arme arme;
		
	public Joueur(Personnage perso, Role role) {
		this.perso = perso;
		this.role = role;
		this.main=new ArrayList<Action>();
		this.distance = 1;
		if (this.perso.getNom().equals("ROSE DOOLAN"))
		this.portee = 2;
		else
		this.portee = 1;
		this.pdv = perso.getPdv()+role.getPdvBonus();
		this.pdvmax = perso.getPdv()+role.getPdvBonus();
		Atire = false;
		this.tireIllimite=false;
		this.bonus=new  ArrayList<ActionBonus>();
		this.arme=null;
		
	}

	public void donnerAction(Action a)
	{
		this.main.add(a);
	}
	
	public boolean esquiver(int nombreRateRequis) // capable d'esquiver
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
			if (a.getNom().equals(action))
				return a;
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

	public boolean isAtire() {
		return Atire;
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
	public void ajouterBonus(Action a)
	{
		this.bonus.add((ActionBonus) a);
	}
	

	
	
	

}
