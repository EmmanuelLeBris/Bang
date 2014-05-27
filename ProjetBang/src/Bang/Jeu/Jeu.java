package Bang.Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Scanner;

import Bang.Carte.Action;
import Bang.Carte.ActionBonus;
import Bang.Carte.ActionSurAdversaire;
import Bang.Carte.Arme;
import Bang.Carte.Bang;
import Bang.Carte.Biere;
import Bang.Carte.Convoi;
import Bang.Carte.CoupDeFoudre;
import Bang.Carte.Lunette;
import Bang.Carte.Magasin;
import Bang.Carte.Mustang;
import Bang.Carte.PasserTour;
import Bang.Carte.Rate;
import Bang.Carte.Remington;
import Bang.Carte.Saloon;
import Bang.Carte.Schofield;
import Bang.Carte.Volcanic;
import Bang.IA.IA;
import controlleur.Controlleur;

public class Jeu extends Observable{
	private ArrayList<Action> pioche = new ArrayList<Action>();
	private ArrayList<Action> defausse = new ArrayList<Action>();
	private ArrayList<Joueur> joueursEnJeu = new ArrayList<Joueur>();
	private ArrayList<Joueur> participants = new ArrayList<Joueur>();
	private Joueur joueurHumain;
	private Controlleur controlleur;
	private boolean joueurciblee =false;
	private String nomjoueurcible="";


	private int indexJHumain;
	/**
	 * Initialisation d'une partie
	 * @param personnage personnage choisi par le joueur
	 */
	public void initJoueurs(String personnage)
	{
		Action a;
		Joueur tmp;
		// Init Rôles
		Role sherif = new Role("SHERIF",1,"Tuez tous les Hors-la-loi et le Renégat !");
		Role adjoint = new Role("ADJOINT",0,"Protegez le Shérif et tuez tous les Hors-la-loi et le Renégat !");
		Role renegat = new Role("RENEGAT",0,"Soyez le dernier en jeu !");
		Role  horslaloi1 = new Role("HORS-LA-LOI",0,"tuez le Shérif");
		Role  horslaloi2 = new Role("HORS-LA-LOI",0,"tuez le Shérif");

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(sherif);
		roles.add(adjoint);
		roles.add(renegat);
		roles.add(horslaloi1);
		roles.add(horslaloi2);

		Collections.shuffle(roles);

		//Init Personnages
		Personnage roseDoolan = new Personnage("ROSE DOOLAN",4,"Voit tous les autres joueurs à une distance réduite de 1");
		Personnage bartCassidy = new Personnage("BART CASSIDY",4,"Tire une carte a chaque fois qu’il est touché");
		Personnage suzyLafayette = new Personnage("SUZY LAFAYETTE",4,"Pioche une carte lorsque sa main est vide(une fois par tour)");
		Personnage jesseJones = new Personnage("JESSE JONES",4,"Peut tirer sa première carte de la main d’un joueur");
		Personnage slabLeFlingueur = new Personnage("SLAB LE FLINGUEUR",4,"Il faut deux cartes raté pour annuler ses bangs");

		ArrayList<Personnage> personnages = new ArrayList<Personnage>();
		personnages.add(slabLeFlingueur);
		personnages.add(jesseJones);
		personnages.add(suzyLafayette);
		personnages.add(bartCassidy);
		personnages.add(roseDoolan);

		Collections.shuffle(personnages);

		// Init du personnage du joueur
		Personnage persoJoueur = null;

		for(Personnage p : personnages){
			if(p.getNom().equals(personnage)) persoJoueur = p;
		}
		
		int rand = (int)(Math.random()*(personnages.size()));
		//Si le joueur n'a pas choisi de personnage on en tire un au hasard
		if(persoJoueur == null) persoJoueur =  personnages.get(rand);

		personnages.remove(persoJoueur);
		
		int indexPerso = 0;
		// Init des personnages non humains
		for(int i=0; i <5; i++){
			if(i==rand){
				joueursEnJeu.add(joueurHumain = new Joueur(persoJoueur,roles.get(i)));
				indexPerso--;
			}
			else this.joueursEnJeu.add(new IA(personnages.get(indexPerso),roles.get(i)));
			indexPerso++;
		}
		
		// on ajoute les cartes dans la pioche (cf cahier des charges pour le nombre)
		//Armes
		for(int i = 0; i<3; i++) this.pioche.add(new Schofield());
		for(int i = 0; i<2; i++) this.pioche.add(new Volcanic());
		for(int i = 0; i<2; i++) this.pioche.add(new Remington());

		//Bonus
		for(int i = 0; i<2; i++) this.pioche.add(new Mustang());
		this.pioche.add(new Lunette());

		// Cartes jouables
		for(int i = 0; i<25; i++) this.pioche.add(new Bang());
		for(int i = 0; i<12; i++) this.pioche.add(new Rate());
		for(int i = 0; i<4; i++) this.pioche.add(new CoupDeFoudre());
		for(int i = 0; i<6; i++) this.pioche.add(new Biere());
		for(int i = 0; i<2; i++) this.pioche.add(new Convoi());
		for(int i = 0; i<2; i++) this.pioche.add(new Magasin());
		this.pioche.add(new Saloon());

		//Autre
		PasserTour passerTour = new PasserTour();

		// on mélange la pioche ;)
		Collections.shuffle(pioche);
		
		// on detecte le shériff et on met en place les joueurs
		int index = roles.indexOf(sherif);
		if (index!=0)
		{
			joueursEnJeu.add(0, joueursEnJeu.get(index));
			joueursEnJeu.remove(index+1);
		}
		
		// ensuite on distribue carte par carte
		for (int l=0;l<4;l++)
		{
			for (int k=0;k<5;k++)
			{
				tmp=this.joueursEnJeu.get(k);
				try {
					a = piocher();
					tmp.donnerAction(a);
				} catch (PlusDeCartesException e) {
					e.getMessage();
				}
			}
		}
		for (int i = 0; i < joueursEnJeu.size(); i++) {
			Joueur j = joueursEnJeu.get(i);
			j.donnerAction(passerTour);
			if(j instanceof IA) ((IA) j).init(joueursEnJeu);
			else setIndexJHumain(i);
		}
		// une carte en plus pour le shériff ;)
		tmp = joueursEnJeu.get(0);
		try {
			a = piocher();
			tmp.donnerAction(a);
		} catch (PlusDeCartesException e) {
			e.getMessage();
		}
		participants.addAll(joueursEnJeu);
	}

	/**
	 * Lance les tours de jeu
	 * @throws InterruptedException 
	 */
	public void lancerJeu() throws InterruptedException
	{
		Action a;
		boolean suzyAPioche = false;
		while(!finJeu()){
			for (Joueur joueurCourant : participants){
				if (!finJeu() && joueursEnJeu.contains(joueurCourant)) //Si le joueur est encore en jeu
				{
					
					//PIOCHE
					if(joueurCourant.getRole().getNom().equals("JESSE JONES")){
						//A FAIRE Demander si il veut piocher la carte dans la main d'un joueur ou pas.
						try {
							a = piocher();
							joueurCourant.donnerAction(a);
						} catch (PlusDeCartesException e) {
							System.out.println(e.getMessage());
						}
					}else{
						try {
							a = piocher();
							joueurCourant.donnerAction(a);
						} catch (PlusDeCartesException e) {
							System.out.println(e.getMessage());
						}

					}
					try {
						a = piocher();
						joueurCourant.donnerAction(a);
					} catch (PlusDeCartesException e) {
						System.out.println(e.getMessage());
					}
					
					Joueur cible= null;
					System.out.println("\n\n /////////////TOUR "+joueurCourant);
					do{
						//Maj Vue
						setChanged();
						notifyObservers();
						
						//On demande l'action à jouer
						if (joueurCourant instanceof IA)
						{
							a = ((IA) joueurCourant).jouerAction(this,piocheVide());
							//On demande la cible si il y en a une
							if(a instanceof ActionSurAdversaire){
								cible = ((IA) joueurCourant).demanderCible(a, this);
							}
						}
						else
						{
							System.out.println(joueurCourant.getMain());
							while(controlleur.getCarteJouee().equals("")){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							System.out.println("J'ai recu : "+controlleur.getCarteJouee());
							if(controlleur.getCarteJouee().equals("Passer Tour"))
								a= joueurCourant.getAction("Passer Tour");
							else a = joueurCourant.prendreAction(controlleur.getCarteJouee());
							controlleur.setCarteJouee("");
							controlleur.setCarteSelectionnee("");

							//On demande la cible si il faut
							if(a instanceof ActionSurAdversaire){
								System.out.println("Choisir un joueur cible : ");

								while(!joueurciblee)
								{
									Thread.sleep(50);
								}
								String nomEnnemis = this.nomjoueurcible;
								this.nomjoueurcible="";
								this.joueurciblee=false;
								for(Joueur j : joueursEnJeu){
									if(j.getPerso().getNom().equals(nomEnnemis)) cible=j; 
									
								}
								
							}
						}

						System.out.println("\tCarte jouée : "+a);

						//On fait l'action

						if(!a.getNom().equals("Passer Tour"))
							this.faireAction(a, joueurCourant,cible);
						
						else break;
						if(finJeu()) System.exit(0);

						//Update des amis et ennemis et des joueurs en jeu
						for(Joueur j :participants){
							if(j.getPdv()<=0 && joueursEnJeu.contains(j)){
								for (Action act : j.getMain()) defausser(act);
								joueursEnJeu.remove(j);
							}
						}
						for(Joueur j :joueursEnJeu){
							if(j instanceof IA) ((IA) j).notifierAction(a, joueurCourant, cible, joueursEnJeu);
							System.out.println(j.getRole().getNom()+" pdv :"+j.getPdv());
						}

						//Capacité de SUZY LAFAYETTE

						if(!suzyAPioche && joueurCourant.getPerso().getNom().equals("SUZY LAFAYETTE") && joueurCourant.getMain().size()==0){
							try {
								joueurCourant.donnerAction(piocher());
								suzyAPioche =true;
							} catch (PlusDeCartesException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}while(true);
					joueurCourant.setATire(false);
					suzyAPioche = false;
				}
			}
		}
	}

	/**
	 * Permet de savoir si la pioche est vide
	 * @return piocheVide
	 */
	private boolean piocheVide() {
		return pioche.size()+defausse.size()<joueursEnJeu.size();
	}

	/**
	 * Pioche une carte dans la pioche
	 * @return action piochée
	 * @throws PlusDeCartesException 
	 */
	public Action piocher() throws PlusDeCartesException {
		Action a = null;
		if (this.pioche.isEmpty()) //pioche vide ??
		{
			if(defausse.isEmpty()) throw new PlusDeCartesException();
			this.pioche.addAll(defausse);  // on copie !
			this.defausse.removeAll(defausse); // on supprime la défausse !
			Collections.shuffle(pioche); // on mélange la pioche
			a = this.pioche.get(0);
			this.pioche.remove(0);
		}
		else
		{
			a = this.pioche.get(0);
			this.pioche.remove(0);
		}
		return a;
	}

	/**
	 * Vérifie si la partie est terminée
	 * @return si je jeu est terminé
	 */
	public boolean finJeu() {
		if(joueurHumain.getPdv()<=0){
			System.out.println("Perdu!");
			return true;
		}

		boolean sherifMort = false;
		boolean adjointMort = false;
		boolean renegatMort = false;
		int nbHLMort = 0;
		for(Joueur j : participants){
			if(j.getPdv()<=0){
				if(j.getRole().getNom().equals("SHERIF")) sherifMort = true;
				else if(j.getRole().getNom().equals("RENEGAT")) renegatMort = true;
				else if(j.getRole().getNom().equals("ADJOINT")) adjointMort = true;
				else nbHLMort++;
			}	
		}
		if(sherifMort){
			if(joueurHumain.getRole().getNom().equals("RENEGAT") || joueurHumain.getRole().getNom().equals("ADJOINT")) System.out.println("Perdu!");
			else System.out.println("Gagné!");
			return true;
		}
		if(nbHLMort==2 && renegatMort){
			System.out.println("Gagné!");
			return true;
		}
		if(nbHLMort==2 && sherifMort && adjointMort){
			System.out.println("Gagné!");
			return true;
		}
		return false;
	}

	/**
	 * Joue une action 
	 * @param a action a faire
	 * @param jCourant joueur qui demande l'action
	 */
	public void faireAction(Action a,Joueur jCourant, Joueur cible)
	{
		String nomAction = a.getNom();

		if (a instanceof ActionBonus) // partie carte bonus -> 100 % implémenté
		{
			ActionBonus action = (ActionBonus) a;

			if(jCourant.getBonus().contains(action)){
				this.defausser(a); //on defausse donc la carte
			}
			else
			{//On equipe le nouveau bonus
				if (a instanceof Arme)
				{//Si c'est une arme on remplace l'ancienne
					ArrayList<ActionBonus> bonus = jCourant.getBonus();
					ActionBonus aSuppr = null;
					for(ActionBonus ab : bonus){
						if(ab instanceof Arme){
							ab.enleveBonus(jCourant);
							aSuppr = ab;
							defausser(ab);
						}
					}
					if(aSuppr!=null) bonus.remove(aSuppr);
				}
				action.donBonus(jCourant);
				jCourant.ajouterBonus(action);

			}
		}
		else{
			switch(nomAction){
			case "Biere" : ((Biere)a).capacite(jCourant);
			break;
			case "Magasin" : try {
					((Magasin) a).capacite(this);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			case "Convoi" : ((Convoi) a).capacite(jCourant, this);
			break;
			case "Saloon" : ((Saloon) a).capacite(this);
			break;
			case "HoldUp" : ((CoupDeFoudre) a).capacite(this, cible);
			break;
			case "Bang" : 
				if((!jCourant.aTire() || jCourant.isTireIllimite()) && calculerDistance(jCourant, cible)<=jCourant.getPortee()){
					((Bang) a).capacite(this, cible, jCourant);
					jCourant.setATire(true);
				}
				break;
			}

			defausser(a);
		}
	}

	/**
	 * Ajouter carte à la défausse
	 * @param a action a défausser
	 */
	public void defausser(Action a)
	{
		this.defausse.add(a);
	}

	@Override
	public String toString() {
		return "Jeu [participants=" + joueursEnJeu + "]";
	}

	/**
	 * Donne les joueurs encore en jeu.
	 * @return
	 */
	public ArrayList<Joueur> getJoueursEnJeu() {
		return joueursEnJeu;
	}

	/**
	 * Calcul la distance réelle pour un joueur afin d'atteindre l'autre joueur
	 * @param j1 veut atteindre j2
	 * @param j2 est atteint par j1
	 * @return distance
	 */
	public int calculerDistance(Joueur j1, Joueur j2) {
		Joueur cherche1 = null, cherche2 = null;
		int distance=-1;
		int placeJ1 = joueursEnJeu.indexOf(j1);
		int placeJ2 = joueursEnJeu.indexOf(j2);
		int nbJ = joueursEnJeu.size();
		do{//On avance de pas en pas
			distance++;
			cherche1 = joueursEnJeu.get((placeJ2+distance)%nbJ);
			cherche2 = joueursEnJeu.get((placeJ1+distance)%nbJ);
		}
		while(!cherche1.equals(j1) && !cherche2.equals(j2));
		return distance;
	}
	
	public Controlleur getControlleur() {
		return controlleur;
	}

	public void setControlleur(Controlleur controlleur) {
		this.controlleur = controlleur;
	}

	public ArrayList<Action> getPioche() {
		return pioche;
	}

	public ArrayList<Action> getDefausse() {
		return defausse;
	}

	public ArrayList<Joueur> getParticipants() {
		return participants;
	}

	public Joueur getJoueurHumain() {
		return joueurHumain;
	}

	public int getIndexJHumain() {
		return indexJHumain;
	}

	public void setIndexJHumain(int indexJHumain) {
		this.indexJHumain = indexJHumain;
	}
	public boolean isJoueurciblee() {
		return joueurciblee;
	}

	public void setJoueurciblee(boolean joueurciblee) {
		this.joueurciblee = joueurciblee;
	}

	public String getNomjoueurcible() {
		return nomjoueurcible;
	}

	public void setNomjoueurcible(String nomjoueurcible) {
		this.nomjoueurcible = nomjoueurcible;
	}

}
