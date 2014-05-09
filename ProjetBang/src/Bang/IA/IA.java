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

	/**
	 * Constructeur de joueur
	 * @param perso personnage du joueur
	 * @param role role du joueur
	 */
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
		else if(this.role.getNom().equals("ADJOINT")) //N'a que des ennemis sauf le shérif
			for (Joueur j : participant){
				if (j.getRole().getNom().equals("SHERIF")) amis.add(j);
				else if(!j.equals(this)) ennemis.add(j);	
			}
		else if(this.role.getNom().equals("HORS-LA-LOI")) //Ne connait que le shérif en ennemis
			ennemis.add(participant.get(0)); // sheriff en première position ! 
	}

	/**
	 * Ajoute un ennemis au joueur
	 * @param p joueur
	 */
	public void addEnnemis(Joueur p){
		if(amis.contains(p)) amis.remove(p);
		ennemis.add(p); // sheriff en première position ! 
	}

	/**
	 * Ajoute un amis au joueur
	 * @param p joueur
	 */
	public void addAmis(Joueur p){
		if(ennemis.contains(p)) ennemis.remove(p);
		amis.add(p); // sheriff en première position ! 
	}

	/**
	 * IA pour detecter les amis et les ennemis
	 * @param participant joueurs encore en jeu
	 */
	public void udpateRelation(ArrayList<Joueur> participant)
	{
		if(this.role.getNom().equals("SHERIF") || this.role.getNom().equals("HORS-LA-LOI")){ // Les autres connaissent déjà tous les alliés et ennemis
			if(amis.size()>1 && ennemis.size()!=3) //Si il connait son allié et pas tous ses ennemis
				for (Joueur joueur : participant) if (!amis.contains(joueur)) ennemis.add(joueur);
			if(ennemis.size()== 3) //Si il connait ses ennemis et pas son allié
				for (Joueur joueur : participant) if (!ennemis.contains(joueur)) amis.add(joueur);
		}
	}

	/**
	 * Fait des déductions de l'action jouée à un tour
	 * @param a action jouée
	 * @param joueur joueur qui a fait l'action
	 * @param cible joueur cible de l'action
	 * @param participant 
	 */
	public void notifierAction(Action a, Joueur joueur, Joueur cible, ArrayList<Joueur> joueursEnJeu){
		if(a.getNom().equals("Bang")){
			if(!this.role.getNom().equals("ADJOINT") && !this.role.getNom().equals("RENEGAT")){ // Ils n'ont rien à regarder sur leurs ennemis/amis
				if(cible.equals(this)) ennemis.add(joueur);
				else if(amis.contains(cible)) addEnnemis(joueur);
				else if(amis.contains(joueur)) addEnnemis(cible);
			}
			if(cible.getPdv()==0){ //Si la cible est morte on la retire de nos relations
				amis.remove(cible);
				ennemis.remove(cible);
			}
			udpateRelation(joueursEnJeu);
		}
	}

	/**
	 * Déduit la meilleure carte à jouer pendant le tour.
	 * @param jeu jeu en cours
	 * @return l'action à jouer
	 */
	public Action jouerAction(Jeu jeu, boolean piocheVide)
	{	
		boolean amisNeedHelp = false;
		boolean peutTuerEnnemi = false;
		System.out.println("\tennemis : "+ennemis+"\n\tamis : "+amis+"\n");

		//PIOCHER
		if(aLAction("Convois") && !piocheVide) return prendreAction("Convois");

		//SE BOOSTER
		for(Action a : main){
			if(a instanceof ActionBonus){
				if(!bonus.contains(a)){
					if(a instanceof Arme){
						if(bonus.isEmpty()) return prendreAction(a);
						for(ActionBonus ab : bonus){
							if(ab instanceof Arme && !ab.getNom().equals("Volcanic")){
								if(a.getNom().equals("Volcanic")) return prendreAction(a);
								else if(((Arme) a).getPorteeBonus()>((Arme) ab).getPorteeBonus()) return prendreAction(a);
							}
						}
					}
					else return prendreAction(a);
				}
			}
		}

		//FRAGILISER ENNEMIS
		if(!ennemis.isEmpty() && aLAction("Coup de foudre")) return prendreAction("Coup de foudre");

		//TAPER
		for(Joueur j : ennemis){ //On regarde si le joueur a e quoi tuer un ennemis
			if(aLAction("Bang") && ((j.getPdv()==1 && !aTire) || (tireIllimite && j.getPdv()<=nbAction("Bang"))) && jeu.calculerDistance(this,j)<=portee) peutTuerEnnemi = true;
		}
		if(peutTuerEnnemi) return prendreAction("Bang");

		//PIOCHER
		if(aLAction("Magasin") && !piocheVide) return prendreAction("Magasin");

		//SOINS
		//Alliers en situation urgente
		for(Joueur j : amis){
			if(j.getPdv()<=2 && !j.equals(this)) amisNeedHelp = true;
		}
		if(aLAction("Saloon") && amisNeedHelp) return prendreAction("Saloon");

		//Soi meme (et alliers si besoin)	
		if(pdv<pdvmax){
			if(aLAction("Saloon")){
				for(Joueur j : amis){
					if(j.getPdv()<=j.getPdvmax() && !j.equals(this)) amisNeedHelp = true;
				}
				if(amisNeedHelp || (!aLAction("Biere") && pdv<=2)) return prendreAction("Saloon"); //Saloon que si les alliés en ont besoin ou on est proche de la mort
			}
			if(aLAction("Biere")) return prendreAction("Biere");
		}

		//TAPER
		if(!ennemis.isEmpty() && aLAction("Bang") && !aTire) return prendreAction("Bang");

		return getAction("Passer Tour");
	}
	
	/**
	 * Demander l'action a faire
	 * @param a action
	 * @param jeu partie en cours
	 * @return joueur à cibler
	 */
	public Joueur demanderCible(Action a, Jeu jeu) {
		ArrayList<Joueur> ennemisPossibles = new ArrayList<>();
		Joueur meilleurEnnemis = null, tmp;
		for(Joueur j :ennemis)
			if(portee-jeu.calculerDistance(this, j)>=0) ennemisPossibles.add(j);
		if(!ennemisPossibles.isEmpty()){
			meilleurEnnemis = ennemisPossibles.get(0);
			for(int i = 1; i<ennemisPossibles.size(); i++) {
				tmp = ennemisPossibles.get(i);
				if(meilleurEnnemis.getPdv()<tmp.getPdv()) meilleurEnnemis = tmp;
				else if(meilleurEnnemis.getPdv()==tmp.getPdv() && meilleurEnnemis.getBonus().size()==tmp.getBonus().size()) meilleurEnnemis = tmp;
			}
			return meilleurEnnemis;
		}else{
			for(Joueur j : jeu.getJoueursEnJeu())
				if(!amis.contains(j)) return j;
		}
		return null;
	}
}
