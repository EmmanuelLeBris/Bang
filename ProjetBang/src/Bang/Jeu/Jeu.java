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
		Personnage persoJoueur;

		if (personnage.equals("ROSE DOOLAN")) persoJoueur=roseDoolan;
		else if (personnage.equals("BART CASSIDY")) persoJoueur=bartCassidy;
		else if (personnage.equals("SUZY LAFAYETTE")) persoJoueur=suzyLafayette;
		else if (personnage.equals("JESSE JONES")) persoJoueur=jesseJones;
		else if (personnage.equals("SLAB LE FLINGUEUR")) persoJoueur=slabLeFlingueur;
		//Si le joueur n'a pas choisi de personnage on en tire un au hasard
		else persoJoueur =  personnages.get((int)Math.random()*(1+personnages.size()));

		personnages.remove(persoJoueur);
		participants.add(new Joueur(persoJoueur,roles.get(4)));

		// Init des personnages non humains
		for(int i=0; i <4; i++)
			this.participants.add(new Joueur(personnages.get(i),roles.get(i)));

		// on ajoute les cartes dans la pioche (cf cahier des charges pour le nombre)
		for(int i = 0; i<3; i++) this.pioche.add(new Schofield());
		for(int i = 0; i<2; i++) this.pioche.add(new Mustang());
		for(int i = 0; i<2; i++) this.pioche.add(new Remington());
		this.pioche.add(new Lunette());
		for(int i = 0; i<2; i++) this.pioche.add(new Volcanic());
		for(int i = 0; i<3; i++) this.pioche.add(new Schofield());
		for(int i = 0; i<25; i++) this.pioche.add(new Biere());
		// -> reste à ajouter les bangs,rate (toutes les cartes actions)
		// on mélange la pioche ;)
		Collections.shuffle(pioche);

		// on detecte le shériff et on met en place les joueurs
		int index = roles.indexOf(sherif);
		if (index!=0)
		{
			participants.add(0, participants.get(index));
			participants.remove(index);
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
		// une carte en plus pour le shériff ;)
		Joueur s = participants.get(0);
		Action a = piocher();
		s.donnerAction(a);


	}
	public void tourDeJeu()
	{
		for (int i=0; i<5;i++)
			if (!finJeu())
			{
				System.out.println("Début tour joueur"+i);
				Joueur s=this.participants.get(i);
				/*Action a = Piocher();
				s.donnerAction(a);
				a = Piocher();
				s.donnerAction(a);
				 */
				if (s instanceof IA)
				{
					// technique particulière
				}
				else
				{
					System.out.println(s.getRole().getNom());
					System.out.println(s.getMain());
					System.out.println("yop man ! Quelle carte ?");

					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(System.in);
					String choix = scanner.nextLine();
					Action actionchoix = s.getAction(choix);
					this.faireAction(actionchoix, s);
				}

			}
	}

	public Action piocher() {
		Action a =null;
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
	public boolean finJeu() {
		// sherif mort ? -> return true
		// hors-la-loi et renegat mort ?-> return true
		// tout le monde sauf renegat ? -> return true
		// sinon -> return false
		return false;
	}
	// méthode permetant de gerer les actions
	public void faireAction(Action a,Joueur jCourant)
	{
		String nomAction = a.getNom();
		if (a instanceof ActionBonus) // partie carte bonus -> 100 % implémenté
		{
			ActionBonus action = (ActionBonus) a;
			boolean carteEquipee = false;

			// Le bonus est déjà équipé?
			for (ActionBonus ab : jCourant.getBonus())
				if (ab.getNom().equals(nomAction)) carteEquipee=true;

			if(carteEquipee) this.defausser(a); //on defausse donc la carte
			else
			{//On equipe le nouveau bonus
				if (a instanceof Arme)
				{//Si c'est une arme on remplace l'ancienne
					if (jCourant.getArme()!=null)
					{
						jCourant.getArme().enleveBonus(jCourant);
						this.defausser(jCourant.getArme());
					}
					jCourant.setArme(a);
					action.donBonus(jCourant);
				}
				else
				{
					action.donBonus(jCourant);
					jCourant.ajouterBonus(action);
				}
			}
		}
		else{
			Joueur cible = null;
			if(a instanceof ActionSurAdversaire){
				System.out.println("Choisir un joueur cible : ");
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				String choix = scanner.nextLine();
				for(Joueur j : participants){
					if(j.getPerso().getNom().equals(choix)) cible=j; 
				}
			}
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
			case "Bang" : ((Bang) a).capacite(this, cible, jCourant);
			}
		}
	}
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

}
