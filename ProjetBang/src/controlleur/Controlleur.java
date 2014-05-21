package controlleur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import vueInterface.Windows2;

public class Controlleur {

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

	public Controlleur() {
		this.v = new Windows2();
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
			System.out.println("Action Bang !");
		}

	}

	public class ActionRate extends AbstractAction {
		public ActionRate() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Rate !");

		}

	}

	public class ActionHoldUp extends AbstractAction {
		public ActionHoldUp() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Hold up!");

		}

	}

	public class ActionMustang extends AbstractAction {
		public ActionMustang() {

		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Mustang !");
		}

	}

	public class ActionLunette extends AbstractAction {
		public ActionLunette() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Lunette !");

		}

	}

	public class ActionColt extends AbstractAction {
		public ActionColt() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Colt !");

		}

	}

	public class ActionMagasin extends AbstractAction {
		public ActionMagasin() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Magasin !");

		}

	}

	public class ActionVolcanic extends AbstractAction {
		public ActionVolcanic() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Volvanic !");

		}

	}

	public class ActionBiere extends AbstractAction {
		public ActionBiere() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Biere!");

		}

	}

	public class ActionRemington extends AbstractAction {
		public ActionRemington() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Remington!");

		}

	}

	public class ActionSchofield extends AbstractAction {
		public ActionSchofield() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Schofield !");

		}

	}

	public class ActionSaloon extends AbstractAction {
		public ActionSaloon() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Saloon !");

		}

	}

	public class ActionFinDeTour extends AbstractAction {
		public ActionFinDeTour() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action FinDeTour !");

		}

	}

	public class ActionOk extends AbstractAction {
		public ActionOk() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Action Ok !");

		}

	}

	public final void initButton()
	{
		v.VueJoueur.carte1.bouton.setIcon(new ImageIcon("bang.png"));
		v.VueJoueur.carte2.bouton.setIcon(new ImageIcon("rate.png"));
		v.VueJoueur.carte3.bouton.setIcon(new ImageIcon("holdup.png"));
		v.VueJoueur.carte4.bouton.setIcon(new ImageIcon("mustangb.png"));
		v.VueJoueur.carte5.bouton.setIcon(new ImageIcon("lunetteb.png"));
		v.VueJoueur.carte6.bouton.setIcon(new ImageIcon("colt.png"));
		v.VueJoueur.carte7.bouton.setIcon(new ImageIcon("magasin.png"));
		v.VueJoueur.carte8.bouton.setIcon(new ImageIcon("volcanic.png"));
		v.VueJoueur.carte9.bouton.setIcon(new ImageIcon("biere.png"));
		v.VueJoueur.carte10.bouton.setIcon(new ImageIcon("remington.png"));
		v.VueJoueur.carte11.bouton.setIcon(new ImageIcon("schofield.png"));
		v.VueJoueur.carte12.bouton.setIcon(new ImageIcon("saloon.png"));
		v.VueJoueur.finDeTour.setIcon(new ImageIcon("fintour.png"));
		v.VueJoueur.carte1.bouton.setPressedIcon(new ImageIcon("bangapp.png"));
		v.VueJoueur.carte2.bouton.setPressedIcon(new ImageIcon("rateapp.png"));
		v.VueJoueur.carte3.bouton.setPressedIcon(new ImageIcon("holdupapp.png"));
		v.VueJoueur.carte4.bouton.setPressedIcon(new ImageIcon("mustangbapp.png"));
		v.VueJoueur.carte5.bouton.setPressedIcon(new ImageIcon("lunettebapp.png"));
		v.VueJoueur.carte6.bouton.setPressedIcon(new ImageIcon("coltapp.png"));
		v.VueJoueur.carte7.bouton.setPressedIcon(new ImageIcon("magasinapp.png"));
		v.VueJoueur.carte8.bouton.setPressedIcon(new ImageIcon("volcanicapp.png"));
		v.VueJoueur.carte9.bouton.setPressedIcon(new ImageIcon("biereapp.png"));
		v.VueJoueur.carte10.bouton.setPressedIcon(new ImageIcon("remingtonapp.png"));
		v.VueJoueur.carte11.bouton.setPressedIcon(new ImageIcon("schofieldapp.png"));
		v.VueJoueur.carte12.bouton.setPressedIcon(new ImageIcon("saloonapp.png"));

	}
}
