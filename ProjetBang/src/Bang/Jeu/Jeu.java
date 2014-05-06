package Bang.Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Bang.Carte.*;
import Bang.IA.IA;

public class Jeu {
	private ArrayList<Action> pioche;
	private ArrayList<Action> defausse;
	private ArrayList<Joueur> participants;
	
	public Jeu()
	{
		// initialisation des tableaux
		this.pioche = new ArrayList<Action>();
		this.defausse = new ArrayList<Action>();
		this.participants = new ArrayList<Joueur>(); 
	}
	public void Init(String personnage)
	{
		Role sherif = new Role("SHERIF",1,"Tuez tous les Hors-la-loi et le Renégat !");
		Role adjoint = new Role("ADJOINT",0,"Protegez le Shérif et tuez tous les Hors-la-loi et le Renégat !");
		Role renegat = new Role("RENEGAT",0,"Soyez le dernier en jeu !");
		Role  horslaloi1 = new Role("HORS-LA-LOI",0,"tuez le Shérif");
		Role  horslaloi2 = new Role("HORS-LA-LOI",0,"tuez le Shérif");
		
		ArrayList<Role> lesroles = new ArrayList<Role>();
		lesroles.add(sherif);
		lesroles.add(adjoint);
		lesroles.add(renegat);
		lesroles.add(horslaloi1);
		lesroles.add(horslaloi2);

		Personnage roseDoolan = new Personnage("ROSE DOOLAN",4,"Voit tous les autres joueurs à une distance réduite de 1");
		Personnage bartCassidy = new Personnage("BART CASSIDY",4,"Tire une carte a chaque fois qu’il est touché");
		Personnage suzyLafayette = new Personnage("SUZY LAFAYETTE",4,"Pioche une carte lorsque sa main est vide(une fois par tour)");
		Personnage jesseJones = new Personnage("JESSE JONES",4,"Peut tirer sa première carte de la main d’un joueur");
		Personnage slabLeFlingueur = new Personnage("SLAB LE FLINGUEUR",4,"Il faut deux cartes raté pour annuler ses bangs");
		
		ArrayList<Personnage> lespersos = new ArrayList<Personnage>();
		Personnage perso= null;
		
		if (personnage.equals("ROSE DOOLAN"))
		{
			perso=roseDoolan;
			lespersos.add(slabLeFlingueur);
			lespersos.add(jesseJones);
			lespersos.add(suzyLafayette);
			lespersos.add(bartCassidy);

			
		}
		if (personnage.equals("BART CASSIDY"))
		{
			perso=bartCassidy;
			lespersos.add(slabLeFlingueur);
			lespersos.add(jesseJones);
			lespersos.add(suzyLafayette);
			lespersos.add(roseDoolan);
		}
		if (personnage.equals("SUZY LAFAYETTE"))
		{
			perso=suzyLafayette;
			lespersos.add(slabLeFlingueur);
			lespersos.add(jesseJones);
			lespersos.add(bartCassidy);
			lespersos.add(roseDoolan);
		}
		if (personnage.equals("JESSE JONES"))
		{
			perso=jesseJones;
			lespersos.add(slabLeFlingueur);
			lespersos.add(suzyLafayette);
			lespersos.add(bartCassidy);
			lespersos.add(roseDoolan);
		}
		if (personnage.equals("SLAB LE FLINGUEUR"))
		{
			perso=slabLeFlingueur;
			lespersos.add(jesseJones);
			lespersos.add(suzyLafayette);
			lespersos.add(bartCassidy);
			lespersos.add(roseDoolan);
		}
		
		
		
		if (perso==null)
		{
			lespersos.add(slabLeFlingueur);
			lespersos.add(jesseJones);
			lespersos.add(suzyLafayette);
			lespersos.add(bartCassidy);
			lespersos.add(roseDoolan);
			
			for (int i =0; i <5; i++)
			{
				int role = (int) (Math.random()*(1+lesroles.size()));
				int pers = (int) (Math.random()*(1+lespersos.size()));
				this.participants.add(new Joueur(lespersos.get(pers),lesroles.get(role)));
				lesroles.remove(role);
				lespersos.remove(pers);
				
			}
			
		}
		else
		{
			int role = (int) (Math.random()*(lesroles.size()));
			
			this.participants.add(new Joueur(perso,lesroles.get(role)));
			lesroles.remove(role);
			
			for (int i =0; i <4; i++)
			{
				role = (int) (Math.random()*(lesroles.size()));
				int pers = (int) (Math.random()*(lespersos.size()));
				this.participants.add(new Joueur(lespersos.get(pers),lesroles.get(role)));
				lesroles.remove(role);
				lespersos.remove(pers);
				
			}
			
		}
		// Le code d'avant sert a attribuer les personnages/roles (cela fonctionne bien)
		
		// on ajoute les cartes dans la pioche (cf cahier des charges pour le nombre)
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Mustang());
		this.pioche.add(new Mustang());
		this.pioche.add(new Remington());
		this.pioche.add(new Remington());
		this.pioche.add(new Lunette());
		this.pioche.add(new Volcanic());
		this.pioche.add(new Volcanic());
		
		
		/* a supprimer quand tu mettera tes nouvelles cartes ;) */
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Mustang());
		this.pioche.add(new Mustang());
		this.pioche.add(new Remington());
		this.pioche.add(new Remington());
		this.pioche.add(new Lunette());
		this.pioche.add(new Volcanic());
		this.pioche.add(new Volcanic());
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Mustang());
		this.pioche.add(new Mustang());
		this.pioche.add(new Remington());
		this.pioche.add(new Remington());
		this.pioche.add(new Lunette());
		this.pioche.add(new Volcanic());
		this.pioche.add(new Volcanic());
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Schofield());
		this.pioche.add(new Mustang());
		this.pioche.add(new Mustang());
		this.pioche.add(new Remington());
		this.pioche.add(new Remington());
		this.pioche.add(new Lunette());
		this.pioche.add(new Volcanic());
		this.pioche.add(new Volcanic());
		
		// -> reste à ajouter les bangs,rate (toutes les cartes actions)
		
		// on mélange la pioche ;)
		
		Collections.shuffle(pioche);
		
		// on detecte le shériff et on met en place les joueurs
		int index=0;
		for (int i=0;i<5;i++)
		{
			if (this.participants.get(i).getRole().getNom().equals("SHERIF"))
			index=i;
				
		}
		if (index==0)
		{
			// on fait rien ! c'est parfait
		}
		else
		{
		for (int j=0;j<index;j++)
		{
			Joueur tmp =this.participants.get(0);
			this.participants.remove(0);
			this.participants.add(tmp);
		}
		}	
	
		
		// ensuite on distribue carte par carte
		for (int l=0;l<4;l++)
		{
		for (int k=0;k<5;k++)
		{
			Joueur s=this.participants.get(k);
			Action a = Piocher();
			s.donnerAction(a);
		}
		}
		// une carte en plus pour le shériff ;)
		Joueur s=this.participants.get(0);
		Action a = Piocher();
		s.donnerAction(a);
		
		
	}
	public void tourDeJeu()
	{
		for (int i=0; i<5;i++)
			if (this.finJeu()==false)
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
					this.faireAction(actionchoix, s, null);
					
		
				}
				
			}
	}
	
	private Action Piocher() {
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
	public void faireAction(Action a,Joueur s,Joueur c)
	{
		if (a instanceof ActionBonus) // partie carte bonus -> 100 % implémenté
		{
			boolean dejapose=false;
			// présence carte ?
			for (ActionBonus ab : s.getBonus()) {
				if (ab.getNom().equals(a.getNom()))
					dejapose=true;
				
			}
			
			if(dejapose==true)
			{
			this.defausser(a); //on defausse donc la carte
			}
			else
			{
				
				if (a instanceof Arme)
				{
					
				if (s.getArme()!=null)
				{
				s.getArme().enleveBonus(s);
				this.defausser(s.getArme());
				}
				
				s.setArme(a);
				((ActionBonus) a).donBonus(s);
				}
				else
				{
				
				((ActionBonus) a).donBonus(s);
				s.ajouterBonus(a);
				}
				
			}
		}
		// else if () -> carte action 
		// if bierre && s.getpdv < pdv max -> s.gagner un point de vie 
	}
	public void defausser(Action a)
	{
		this.defausse.add(a);
	}
	
	@Override
	public String toString() {
		return "Jeu [participants=" + participants + "]";
	}
	

}
