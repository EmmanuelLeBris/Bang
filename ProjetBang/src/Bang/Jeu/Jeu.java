package Bang.Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Bang.Carte.*;
import Bang.IA.IA;

public class Jeu {
	private ArrayList<Action> pioche = new ArrayList<Action>();
	private ArrayList<Action> defausse = new ArrayList<Action>();
	private ArrayList<Joueur> participants = new ArrayList<Joueur>();
	private Joueur joueurHumain;
	/**
	 * Initialisation d'une partie
	 * @param personnage personnage choisi par le joueur
	 */
	public void Init(String personnage)
	{
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
		//Si le joueur n'a pas choisi de personnage on en tire un au hasard
		if(persoJoueur == null) persoJoueur =  personnages.get((int)Math.random()*(1+personnages.size()));

		personnages.remove(persoJoueur);
		participants.add(joueurHumain = new IA(persoJoueur,roles.get(4)));

		// Init des personnages non humains
		for(int i=0; i <4; i++)
			this.participants.add(new IA(personnages.get(i),roles.get(i)));

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
		for(int i = 0; i<2; i++) this.pioche.add(new Convois());
		for(int i = 0; i<2; i++) this.pioche.add(new Magasin());
		this.pioche.add(new Saloon());

		//Autre
		PasserTour passerTour = new PasserTour();

		// on mélange la pioche ;)
		Collections.shuffle(pioche);

		// on detecte le shériff et on met en place les joueurs
		int index = (roles.indexOf(sherif)+1)%5;

		if (index!=0)
		{
			participants.add(0, participants.get(index));
			participants.remove(index+1);
		}

		// ensuite on distribue carte par carte
		for (int l=0;l<4;l++)
		{
			for (int k=0;k<5;k++)
			{
				Joueur s=this.participants.get(k);
				Action a = piocher();
				s.donnerAction(a);
			}
		}
		//Autre 
		for(Joueur j :participants){
			j.donnerAction(passerTour);
			if(j instanceof IA) ((IA) j).init(participants);
		}
		// une carte en plus pour le shériff ;)
		Joueur s = participants.get(0);
		Action a = piocher();
		s.donnerAction(a);
	}

	/**
	 * Lance les tours de jeu
	 */
	public void lancerJeu()
	{
		Action a;
		Joueur jCourant;
		while(!finJeu()){
			for (int i=0; i<5;i++)
				if (!finJeu())
				{
					jCourant = this.participants.get(i);

					//PIOCHE
					if(jCourant.getRole().getNom().equals("JESSE JONES")){
						//A FAIRE Demander si il veut piocher la carte dans la main d'un joueur ou pas.
					}else{
						a = piocher();
						jCourant.donnerAction(a);
					}
					a = piocher();
					jCourant.donnerAction(a);

					Joueur cible= null;
					do{
						System.out.println("Tour joueur "+i+", "+jCourant);
						//On demande l'action à jouer
						if (jCourant instanceof IA)
						{
							a = ((IA) jCourant).jouerAction(this);
							System.out.println("Carte jouée : "+a);
							
							//On demande la cible si il faut
							if(a instanceof ActionSurAdversaire){
								cible = ((IA) jCourant).demanderCible(a, this);
							}
						}
						else
						{
							System.out.println("yop man ! Quelle carte ?");

							@SuppressWarnings("resource")
							Scanner scanner = new Scanner(System.in);
							String choix = scanner.nextLine();
							a = jCourant.prendreAction(choix);
							
							//On demande la cible si il faut
							if(a instanceof ActionSurAdversaire){
								System.out.println("Choisir un joueur cible : ");
								@SuppressWarnings("resource")
								Scanner scan = new Scanner(System.in);
								String ch = scan.nextLine();
								for(Joueur j : participants){
									if(j.getPerso().getNom().equals(ch)) cible=j; 
								}
							}
						}
						this.faireAction(a, jCourant,cible);

					}while(!a.getNom().equals("Passer Tour"));
					jCourant.setATire(false);
					//Update des amis et ennemis
					for(Joueur j :participants){
						if(j instanceof IA) ((IA) j).notifierAction(a, jCourant, cible, participants);
					}
				}
		}
	}

	/**
	 * Pioche une carte dans la pioche
	 * @return action piochée
	 */
	public Action piocher() {
		Action a = null;
		if (this.pioche.isEmpty()) //pioche vide ??
		{
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
				if(j.getRole().getNom().equals("Sherif")) sherifMort = true;
				else if(j.getRole().getNom().equals("Renegat")) renegatMort = true;
				else if(j.getRole().getNom().equals("Adjoint")) adjointMort = true;
				else nbHLMort++;
			}	
		}
		if(sherifMort){
			if(joueurHumain.getRole().getNom().equals("Renegat")) System.out.println("Perdu!");
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
	 * Ajouter carte à la défausse
	 * @param a action a défausser
	 */
	public void defausser(Action a)
	{
		this.defausse.add(a);
	}

	@Override
	public String toString() {
		return "Jeu [participants=" + participants + "]";
	}
	public ArrayList<Joueur> getParticipants() {
		return participants;
	}

	/**
	 * Calcul la distance réelle pour un joueur afin d'atteindre l'autre joueur
	 * @param j1 veut atteindre j2
	 * @param j2 est atteint par j1
	 * @return distance
	 */
	public int calculerDistance(Joueur j1, Joueur j2) {
		int plusCourteD = 2;
		if(participants.indexOf(j1)-participants.indexOf(j2)==1) plusCourteD = 1;
		return (plusCourteD+j2.getDistance());
	}

}
