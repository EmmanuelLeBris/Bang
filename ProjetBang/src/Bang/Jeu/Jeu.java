package Bang.Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Bang.Carte.*;
import Bang.IA.IA;

public class Jeu {
	private ArrayList<Action> pioche = new ArrayList<Action>();
	private ArrayList<Action> defausse = new ArrayList<Action>();
	private ArrayList<Joueur> joueursEnJeu = new ArrayList<Joueur>();
	private ArrayList<Joueur> participants = new ArrayList<Joueur>();
	private Joueur joueurHumain;
	/**
	 * Initialisation d'une partie
	 * @param personnage personnage choisi par le joueur
	 */
	public void Init(String personnage)
	{
		Action a;
		Joueur tmp;
		// Init R�les
		Role sherif = new Role("SHERIF",1,"Tuez tous les Hors-la-loi et le Ren�gat !");
		Role adjoint = new Role("ADJOINT",0,"Protegez le Sh�rif et tuez tous les Hors-la-loi et le Ren�gat !");
		Role renegat = new Role("RENEGAT",0,"Soyez le dernier en jeu !");
		Role  horslaloi1 = new Role("HORS-LA-LOI",0,"tuez le Sh�rif");
		Role  horslaloi2 = new Role("HORS-LA-LOI",0,"tuez le Sh�rif");

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(sherif);
		roles.add(adjoint);
		roles.add(renegat);
		roles.add(horslaloi1);
		roles.add(horslaloi2);

		Collections.shuffle(roles);

		//Init Personnages
		Personnage roseDoolan = new Personnage("ROSE DOOLAN",4,"Voit tous les autres joueurs � une distance r�duite de 1");
		Personnage bartCassidy = new Personnage("BART CASSIDY",4,"Tire une carte a chaque fois qu�il est touch�");
		Personnage suzyLafayette = new Personnage("SUZY LAFAYETTE",4,"Pioche une carte lorsque sa main est vide(une fois par tour)");
		Personnage jesseJones = new Personnage("JESSE JONES",4,"Peut tirer sa premi�re carte de la main d�un joueur");
		Personnage slabLeFlingueur = new Personnage("SLAB LE FLINGUEUR",4,"Il faut deux cartes rat� pour annuler ses bangs");

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
		//Si le joueur n'a pas choisi de personnage on en tire un au hasard
		if(persoJoueur == null) persoJoueur =  personnages.get((int)Math.random()*(1+personnages.size()));

		personnages.remove(persoJoueur);
		joueursEnJeu.add(joueurHumain = new IA(persoJoueur,roles.get(4)));

		// Init des personnages non humains
		for(int i=0; i <4; i++)
			this.joueursEnJeu.add(new IA(personnages.get(i),roles.get(i)));

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
		for(int i = 0; i<2; i++) this.pioche.add(new Biere());
		for(int i = 0; i<2; i++) this.pioche.add(new Convois());
		for(int i = 0; i<2; i++) this.pioche.add(new Magasin());
		this.pioche.add(new Saloon());

		//Autre
		PasserTour passerTour = new PasserTour();

		// on m�lange la pioche ;)
		Collections.shuffle(pioche);

		// on detecte le sh�riff et on met en place les joueurs
		int index = (roles.indexOf(sherif)+1)%5;

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
		//Autre 
		for(Joueur j :joueursEnJeu){
			j.donnerAction(passerTour);
			if(j instanceof IA) ((IA) j).init(joueursEnJeu);
		}
		// une carte en plus pour le sh�riff ;)
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
	 */
	public void lancerJeu()
	{
		Action a;
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
						//On demande l'action � jouer
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
							System.out.println("yop man ! Quelle carte ?");

							@SuppressWarnings("resource")
							Scanner scanner = new Scanner(System.in);
							String choix = scanner.nextLine();
							a = joueurCourant.prendreAction(choix);

							//On demande la cible si il faut
							if(a instanceof ActionSurAdversaire){
								System.out.println("Choisir un joueur cible : ");
								@SuppressWarnings("resource")
								Scanner scan = new Scanner(System.in);
								String nomEnnemis = scan.nextLine();
								for(Joueur j : joueursEnJeu){
									if(j.getPerso().getNom().equals(nomEnnemis)) cible=j; 
								}
							}
						}

						System.out.println("\tCarte jou�e : "+a);

						//On fait l'action
						
						if(!a.getNom().equals("Passer Tour"))
							this.faireAction(a, joueurCourant,cible);
						else break;
						if(finJeu()) System.exit(0);

						//Update des amis et ennemis et des joueurs en jeu
						for(Joueur j :participants){
							if(j.getPdv()<=0) joueursEnJeu.remove(j);
						}
						for(Joueur j :joueursEnJeu){
							if(j instanceof IA) ((IA) j).notifierAction(a, joueurCourant, cible, joueursEnJeu);
							System.out.println(j.getRole().getNom()+" pdv :"+j.getPdv());
						}

					}while(true);
					joueurCourant.setATire(false);
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
	 * @return action pioch�e
	 * @throws PlusDeCartesException 
	 */
	public Action piocher() throws PlusDeCartesException {
		Action a = null;
		if (this.pioche.isEmpty()) //pioche vide ??
		{
			if(defausse.isEmpty()) throw new PlusDeCartesException();
			this.pioche.addAll(defausse);  // on copie !
			this.defausse.removeAll(defausse); // on supprime la d�fausse !
			Collections.shuffle(pioche); // on m�lange la pioche
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
	 * V�rifie si la partie est termin�e
	 * @return si je jeu est termin�
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
			else System.out.println("Gagn�!");
			return true;
		}
		if(nbHLMort==2 && renegatMort){
			System.out.println("Gagn�!");
			return true;
		}
		if(nbHLMort==2 && sherifMort && adjointMort){
			System.out.println("Gagn�!");
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

		if (a instanceof ActionBonus) // partie carte bonus -> 100 % impl�ment�
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
			case "Magasin" : ((Magasin) a).capacite(this);
			break;
			case "Convois" : ((Convois) a).capacite(jCourant, this);
			break;
			case "Saloon" : ((Saloon) a).capacite(this);
			break;
			case "Coup de foudre" : ((CoupDeFoudre) a).capacite(this, cible);
			break;
			case "Bang" : 
				if(!jCourant.aTire()){
					((Bang) a).capacite(this, cible, jCourant);
					jCourant.setATire(true);
				}
				break;
			}

			defausser(a);
		}
	}

	/**
	 * Ajouter carte � la d�fausse
	 * @param a action a d�fausser
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
	 * Calcul la distance r�elle pour un joueur afin d'atteindre l'autre joueur
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

}
