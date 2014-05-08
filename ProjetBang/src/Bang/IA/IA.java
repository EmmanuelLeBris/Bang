package Bang.IA;

import java.util.ArrayList;
import java.util.HashSet;

import Bang.Carte.Action;
import Bang.Carte.ActionBonus;
import Bang.Carte.Arme;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;
import Bang.Jeu.Personnage;
import Bang.Jeu.Role;

public class IA extends Joueur {

	private HashSet<Joueur> amis= new  HashSet<Joueur>();
	private  HashSet<Joueur> ennemis= new  HashSet<Joueur>();

	public IA(Personnage perso, Role role) {
		super(perso, role);

	}
	/**
	 * Initialisation des amis et ennemis d'un joueur (un joueur est son propre amis)
	 * @param participant tableau des joueurs participants
	 */
	public void init(ArrayList<Joueur> participant)
	{
		amis.add(this);
		if(this.role.getNom().equals("RENEGAT")) //N'a que des ennemis
		{
			for (Joueur j : participant)
				if (!j.equals(this)) ennemis.add(j);
		}
		else if(this.role.getNom().equals("ADJOINT")) //N'a que des ennemis sauf le sh�rif
			for (Joueur j : participant){
				if (j.getRole().getNom().equals("SHERIF")) amis.add(j);
				else if(!j.equals(this)) ennemis.add(j);	
			}
		else if(this.role.getNom().equals("HORS-LA-LOI")) //Ne connait que le sh�rif en ennemis
			ennemis.add(participant.get(0)); // sheriff en premi�re position ! 
	}

	/**
	 * Ajoute un ennemis au joueur
	 * @param p joueur
	 */
	public void addEnnemis(Joueur p){
		if(amis.contains(p)) amis.remove(p);
		ennemis.add(p); // sheriff en premi�re position ! 
	}

	/**
	 * Ajoute un amis au joueur
	 * @param p joueur
	 */
	public void addAmis(Joueur p){
		if(ennemis.contains(p)) ennemis.remove(p);
		amis.add(p); // sheriff en premi�re position ! 
	}

	/**
	 * IA pour detecter les amis et les ennemis
	 * @param participant joueurs encore en jeu
	 */
	public void udpateRelation(ArrayList<Joueur> participant)
	{
		if(this.role.getNom().equals("SHERIF") || this.role.getNom().equals("HORS-LA-LOI")){ // Les autres connaissent d�j� tous les alli�s et ennemis
			if(amis.size()>1 && ennemis.size()!=3) //Si il connait son alli� et pas tous ses ennemis
				for (Joueur joueur : participant) if (!amis.contains(joueur)) ennemis.add(joueur);
			if(ennemis.size()== 3) //Si il connait ses ennemis et pas son alli�
				for (Joueur joueur : participant) if (!ennemis.contains(joueur)) amis.add(joueur);
		}
	}

	/**
	 * Fait des d�ductions de l'action jou�e � un tour
	 * @param a action jou�e
	 * @param joueur joueur qui a fait l'action
	 * @param cible joueur cible de l'action
	 */
	public void notifierAction(Action a, Joueur joueur, Joueur cible){
		if(a.getNom().equals("Bang")){
			if(this.role.getNom().equals("ADJOINT") || this.role.getNom().equals("RENEGAT")){ // Ils n'ont rien � regarder sur leurs ennemis/amis
				if(cible.equals(this)) ennemis.add(joueur);
				else if(amis.contains(cible)) addEnnemis(joueur);
				else if(amis.contains(joueur)) addEnnemis(cible);
			}
			if(cible.getPdv()==0){ //Si la cible est morte on la retire de nos relations
				amis.remove(cible);
				ennemis.remove(cible);
			}
		}
	}

	/**
	 * D�duit la meilleure carte � jouer pendant le tour.
	 * @param jeu jeu en cours
	 * @return l'action � jouer
	 */
	public Action jouerAction(Jeu jeu)
	{
		Action meilleure;
		
		boolean amisNeedHelp = true;
		boolean peutTuerEnnemi = false;
		
		//SE BOOSTER
		for(Action a : main){
			if(a instanceof ActionBonus){
				if(a instanceof Arme){
					for(ActionBonus ab : bonus){
						if(ab instanceof Arme && ((Arme) a).getPorteeBonus()>((Arme) ab).getPorteeBonus()) return getAction(a);
					}
				}
				else return getAction(a);
			}
		}
		
		//FRAGILISER ENNEMIS
		if(aLAction("Coup de foudre")) return getAction("Coup de foudre");
			
		//TAPER
		for(Joueur j : ennemis){
			if(j.getPdv()==1 || (tireIllimite && j.getPdv()<=nbAction("Bang")) && jeu.calculerDistance(this,j)<=portee) peutTuerEnnemi = true;
		}
		if(peutTuerEnnemi) return getAction("Bang");
		
		//PIOCHER
		if(aLAction("Convois")) return getAction("Convois");
		if(aLAction("Magasin")) return getAction("Magasin");
		
		//SOINS
			//Alliers en situation urgente
		for(Joueur j : amis){
			if(j.getPdv()==1) amisNeedHelp = false;
		}
		if(aLAction("Saloon") && amisNeedHelp) return getAction("Saloon");
			
			//Soi meme (et alliers si besoin)	
		if(pdv<pdvmax){
			if(aLAction("Saloon")){
				for(Joueur j : amis){
					if(j.getPdv()==j.getPdvmax()) amisNeedHelp = false;
				}
				if(amisNeedHelp || (!aLAction("Biere") && pdv<=2)) return getAction("Saloon"); //Saloon que si les alli�s en ont besoin ou on est proche de la mort
			}
			if(aLAction("Biere")) return getAction("Biere");
		}
		
	}
}
