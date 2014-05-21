package controlleur;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;
import vueInterface.VueAdversaire;
import vueInterface.VueJoueur;
import vueInterface.Windows2;

public class Controlleur implements Observer{

	private String carteSelectionnee = "";
	private String carteJouee = "";

	private Jeu j;
	private Windows2 v;
	private ActionBang actionBang;
	private ActionRate actionRate;
	private ActionHoldUp actionHoldUp;
	private ActionMustang actionMustang;
	private ActionLunette actionLunette;
	private ActionColt actionColt;
	private ActionMagasin actionMagasin;
	private ActionVolcanic actionVolcanic;
	private ActionBiere actionBiere;
	private ActionRemington actionRemington;
	private ActionSchofield actionSchofield;
	private ActionSaloon actionSaloon;
	private ActionFinDeTour actionFinDeTour;
	private ActionOk actionOk;

	public Controlleur(Jeu mapartie) {
		this.j = mapartie;
		ArrayList<Joueur> joueurs = j.getParticipants();
		VueAdversaire vueAdv[] = new VueAdversaire[5];
		int k = 0;
		for(int i = 1; i<joueurs.size(); i++){
			k = (j.getIndexJHumain()+i)%joueurs.size();
			vueAdv[i-1] = new VueAdversaire(joueurs.get(k).getPerso().getNom(), joueurs.get(k).getRole().getNom());
		}
		VueJoueur vueJoueur = new VueJoueur(j.getJoueurHumain().getPerso().getNom(), j.getJoueurHumain().getRole().getNom());
		this.v = new Windows2(vueJoueur , vueAdv[0],vueAdv[1],vueAdv[2],vueAdv[3]);
		this.actionBang = new ActionBang();
		this.actionRate = new ActionRate();
		this.actionHoldUp = new ActionHoldUp();
		this.actionMustang = new ActionMustang();
		this.actionLunette = new ActionLunette();
		this.actionColt = new ActionColt();
		this.actionMagasin = new ActionMagasin();
		this.actionVolcanic = new ActionVolcanic();
		this.actionBiere = new ActionBiere();
		this.actionRemington = new ActionRemington();
		this.actionSchofield = new ActionSchofield();
		this.actionSaloon = new ActionSaloon();
		this.actionFinDeTour = new ActionFinDeTour();
		this.actionOk = new ActionOk();

		
		v.VueJoueur.carte1.bouton.setAction(actionBang);
		v.VueJoueur.carte2.bouton.setAction(actionRate);
		v.VueJoueur.carte3.bouton.setAction(actionHoldUp);
		v.VueJoueur.carte4.bouton.setAction(actionMustang);
		v.VueJoueur.carte5.bouton.setAction(actionLunette);
		v.VueJoueur.carte6.bouton.setAction(actionColt);
		v.VueJoueur.carte7.bouton.setAction(actionMagasin);
		v.VueJoueur.carte8.bouton.setAction(actionVolcanic);
		v.VueJoueur.carte9.bouton.setAction(actionBiere);
		v.VueJoueur.carte10.bouton.setAction(actionRemington);
		v.VueJoueur.carte11.bouton.setAction(actionSchofield);
		v.VueJoueur.carte12.bouton.setAction(actionSaloon);
		v.VueJoueur.finDeTour.setAction(actionFinDeTour);
		v.VueJoueur.bouttonOk.setAction(actionOk);
		initButton();
	}

	public class ActionBang extends AbstractAction {
		public ActionBang() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Ôter un point de vie à un autre joueur");
			carteSelectionnee = "Bang";
		}

	}

	public class ActionRate extends AbstractAction {
		public ActionRate() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Permet d'esquiver un bang");
			carteSelectionnee = "Rate";
		}

	}

	public class ActionHoldUp extends AbstractAction {
		public ActionHoldUp() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Défausser une carte à un joueur");
			carteSelectionnee = "HoldUp";
		}

	}

	public class ActionMustang extends AbstractAction {
		public ActionMustang() {

		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Augmente votre distance de 1");
			carteSelectionnee = "Mustang";
		}

	}

	public class ActionLunette extends AbstractAction {
		public ActionLunette() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Augmente de 1 la portée de votre arme");
			carteSelectionnee = "Lunette";
		}

	}

	public class ActionColt extends AbstractAction {
		public ActionColt() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Permet de piocher deux cartes");
			carteSelectionnee = "Convoi";
		}

	}

	public class ActionMagasin extends AbstractAction {
		public ActionMagasin() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Révèle autant de carte qu’il y a de joueurs, chaque joueur en pioche une\n(ordre de jeu à partir de celui qui a posé la carte puis dans le sens\nhorraire)");
			carteSelectionnee = "Magasin";
		}

	}

	public class ActionVolcanic extends AbstractAction {
		public ActionVolcanic() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Votre portée devient de 1 mais votre nombre de tirs n'est plus limité");
			carteSelectionnee = "Volvanic";
		}

	}

	public class ActionBiere extends AbstractAction {
		public ActionBiere() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Rend un point de vie");
			carteSelectionnee = "Biere";
		}

	}

	public class ActionRemington extends AbstractAction {
		public ActionRemington() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Votre portée devient de 3");
			carteSelectionnee = "Remington";
		}

	}

	public class ActionSchofield extends AbstractAction {
		public ActionSchofield() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Votre portée devient de 2");
			carteSelectionnee = "Schofield";
		}

	}

	public class ActionSaloon extends AbstractAction {
		public ActionSaloon() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v.VueJoueur.textExplicatif.setText("Rend un point de vie à tous les personnages");
			carteSelectionnee = "Saloon";
		}

	}

	public class ActionFinDeTour extends AbstractAction {
		public ActionFinDeTour() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			carteJouee = "Passer Tour";
		}

	}

	public class ActionOk extends AbstractAction {
		public ActionOk() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			carteJouee = carteSelectionnee;
			v.VueJoueur.textExplicatif.setText("");
		}

	}

	public final void initButton()
	{
		v.VueJoueur.carte1.bouton.setIcon(new ImageIcon("bang.png"));
		v.VueJoueur.carte2.bouton.setIcon(new ImageIcon("rate.png"));
		v.VueJoueur.carte3.bouton.setIcon(new ImageIcon("holdup.png"));
		v.VueJoueur.carte4.bouton.setIcon(new ImageIcon("mustangb.png"));
		v.VueJoueur.carte5.bouton.setIcon(new ImageIcon("lunetteb.png"));
		v.VueJoueur.carte6.bouton.setIcon(new ImageIcon("convoi.png"));
		v.VueJoueur.carte7.bouton.setIcon(new ImageIcon("magasin.png"));
		v.VueJoueur.carte8.bouton.setIcon(new ImageIcon("volcanicb.png"));
		v.VueJoueur.carte9.bouton.setIcon(new ImageIcon("biere.png"));
		v.VueJoueur.carte10.bouton.setIcon(new ImageIcon("remingtonb.png"));
		v.VueJoueur.carte11.bouton.setIcon(new ImageIcon("schofieldb.png"));
		v.VueJoueur.carte12.bouton.setIcon(new ImageIcon("saloon.png"));
		v.VueJoueur.finDeTour.setIcon(new ImageIcon("fintour.png"));
		v.VueJoueur.bouttonOk.setIcon(new ImageIcon("ok.png"));
		v.VueJoueur.carte1.bouton.setPressedIcon(new ImageIcon("bangapp.png"));
		v.VueJoueur.carte2.bouton.setPressedIcon(new ImageIcon("rateapp.png"));
		v.VueJoueur.carte3.bouton.setPressedIcon(new ImageIcon("holdupapp.png"));
		v.VueJoueur.carte4.bouton.setPressedIcon(new ImageIcon("mustangbapp.png"));
		v.VueJoueur.carte5.bouton.setPressedIcon(new ImageIcon("lunettebapp.png"));
		v.VueJoueur.carte6.bouton.setPressedIcon(new ImageIcon("convoiapp.png"));
		v.VueJoueur.carte7.bouton.setPressedIcon(new ImageIcon("magasinapp.png"));
		v.VueJoueur.carte8.bouton.setPressedIcon(new ImageIcon("volcanicbapp.png"));
		v.VueJoueur.carte9.bouton.setPressedIcon(new ImageIcon("biereapp.png"));
		v.VueJoueur.carte10.bouton.setPressedIcon(new ImageIcon("remingtonbapp.png"));
		v.VueJoueur.carte11.bouton.setPressedIcon(new ImageIcon("schofieldbapp.png"));
		v.VueJoueur.carte12.bouton.setPressedIcon(new ImageIcon("saloonapp.png"));
		v.VueJoueur.finDeTour.setPressedIcon(new ImageIcon("fintourapp.png"));
		v.VueJoueur.bouttonOk.setPressedIcon(new ImageIcon("okapp.png"));

	}
	
	public String getCarteJouee() {
		return carteJouee;
	}
	

	public void setCarteSelectionnee(String carteSelectionnee) {
		this.carteSelectionnee = carteSelectionnee;
	}

	public void setCarteJouee(String carteJouee) {
		this.carteJouee = carteJouee;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
			
	}

}
