package controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import vueInterface.VueAdversaire;
import vueInterface.VueArme;
import vueInterface.VueBonusLunette;
import vueInterface.VueBonusMustang;
import vueInterface.VueCarteJoueur;
import vueInterface.VueJoueur;
import vueInterface.VuePointDeVie;
import vueInterface.Windows2;
import Bang.Carte.Action;
import Bang.Carte.ActionBonus;
import Bang.Carte.Arme;
import Bang.Carte.Bang;
import Bang.Carte.Biere;
import Bang.Carte.Convoi;
import Bang.Carte.CoupDeFoudre;
import Bang.Carte.Lunette;
import Bang.Carte.Magasin;
import Bang.Carte.Mustang;
import Bang.Carte.Rate;
import Bang.Carte.Remington;
import Bang.Carte.Saloon;
import Bang.Carte.Schofield;
import Bang.Carte.Volcanic;
import Bang.Jeu.Jeu;
import Bang.Jeu.Joueur;

public class Controlleur implements Observer,MouseListener{

	private String carteSelectionnee = "";
	private String carteJouee = "";
	private String joueurSelectionne= "";
	private Jeu j;
	public Windows2 v;
	private ActionBang actionBang;
	private ActionRate actionRate;
	private ActionHoldUp actionHoldUp;
	private ActionMustang actionMustang;
	private ActionLunette actionLunette;
	private ActionConvoi actionConvoi;
	public ActionMagasin actionMagasin;
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
		this.v = new Windows2(vueJoueur , vueAdv, this);
		this.actionBang = new ActionBang();
		this.actionRate = new ActionRate();
		this.actionHoldUp = new ActionHoldUp();
		this.actionMustang = new ActionMustang();
		this.actionLunette = new ActionLunette();
		this.actionConvoi = new ActionConvoi();
		this.actionMagasin = new ActionMagasin();
		this.actionVolcanic = new ActionVolcanic();
		this.actionBiere = new ActionBiere();
		this.actionRemington = new ActionRemington();
		this.actionSchofield = new ActionSchofield();
		this.actionSaloon = new ActionSaloon();
		this.actionFinDeTour = new ActionFinDeTour();
		this.actionOk = new ActionOk();

		j.addObserver(this);
		
		v.VueJoueur.carte1.bouton.setAction(actionBang);
		v.VueJoueur.carte2.bouton.setAction(actionRate);
		v.VueJoueur.carte3.bouton.setAction(actionHoldUp);
		v.VueJoueur.carte4.bouton.setAction(actionMustang);
		v.VueJoueur.carte5.bouton.setAction(actionLunette);
		v.VueJoueur.carte6.bouton.setAction(actionConvoi);
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
			majLines();
			v.VueJoueur.textExplicatif.setText("Ôter un point de vie à un autre joueur");
			joueurSelectionne="";
			carteSelectionnee = "Bang";
			v.VueJoueur.carte1.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionRate extends AbstractAction {
		public ActionRate() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Permet d'esquiver un bang");
			carteSelectionnee = "Rate";
			v.VueJoueur.carte2.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));
		}

	}

	public class ActionHoldUp extends AbstractAction {
		public ActionHoldUp() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Défausser une carte à un joueur");
			joueurSelectionne="";
			carteSelectionnee = "HoldUp";
			v.VueJoueur.carte3.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionMustang extends AbstractAction {
		public ActionMustang() {

		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Augmente votre distance de 1");
			carteSelectionnee = "Mustang";
			v.VueJoueur.carte4.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionLunette extends AbstractAction {
		public ActionLunette() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Augmente de 1 la portée de votre arme");
			carteSelectionnee = "Lunette";
			v.VueJoueur.carte5.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionConvoi extends AbstractAction {
		public ActionConvoi() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Permet de piocher deux cartes");
			carteSelectionnee = "Convoi";
			v.VueJoueur.carte6.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionMagasin extends AbstractAction {
		public ActionMagasin() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Révèle autant de carte qu’il y a de joueurs, chaque joueur en pioche une\n(ordre de choix à partir de celui qui a posé la carte puis dans le sens\nhorraire)");
			carteSelectionnee = "Magasin";
			v.VueJoueur.carte7.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionVolcanic extends AbstractAction {
		public ActionVolcanic() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Votre portée devient de 1 mais votre nombre de tirs par tour n'est plus \nlimité");
			carteSelectionnee = "Volcanic";
			v.VueJoueur.carte8.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionBiere extends AbstractAction {
		public ActionBiere() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Rend un point de vie");
			carteSelectionnee = "Biere";
			v.VueJoueur.carte9.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));			
		}

	}

	public class ActionRemington extends AbstractAction {
		public ActionRemington() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Votre portée devient de 3");
			carteSelectionnee = "Remington";
			v.VueJoueur.carte10.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionSchofield extends AbstractAction {
		public ActionSchofield() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Votre portée devient de 2");
			carteSelectionnee = "Schofield";
			v.VueJoueur.carte11.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
		}

	}

	public class ActionSaloon extends AbstractAction {
		public ActionSaloon() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			majLines();
			v.VueJoueur.textExplicatif.setText("Rend un point de vie à tous les personnages");
			carteSelectionnee = "Saloon";
			v.VueJoueur.carte12.bouton.setBorder(BorderFactory.createLineBorder(Color.red, 2));		
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
			majLines();
		}

	}

	public final void initButton()
	{
		v.VueJoueur.carte1.bouton.setIcon(new ImageIcon("Bang.png"));
		v.VueJoueur.carte2.bouton.setIcon(new ImageIcon("Rate.png"));
		v.VueJoueur.carte3.bouton.setIcon(new ImageIcon("Holdup.png"));
		v.VueJoueur.carte4.bouton.setIcon(new ImageIcon("Mustang.png"));
		v.VueJoueur.carte5.bouton.setIcon(new ImageIcon("Lunette.png"));
		v.VueJoueur.carte6.bouton.setIcon(new ImageIcon("Convoi.png"));
		v.VueJoueur.carte7.bouton.setIcon(new ImageIcon("Magasin.png"));
		v.VueJoueur.carte8.bouton.setIcon(new ImageIcon("Volcanic.png"));
		v.VueJoueur.carte9.bouton.setIcon(new ImageIcon("Biere.png"));
		v.VueJoueur.carte10.bouton.setIcon(new ImageIcon("Remington.png"));
		v.VueJoueur.carte11.bouton.setIcon(new ImageIcon("Schofield.png"));
		v.VueJoueur.carte12.bouton.setIcon(new ImageIcon("Saloon.png"));
		v.VueJoueur.finDeTour.setIcon(new ImageIcon("fintour.png"));
		v.VueJoueur.bouttonOk.setIcon(new ImageIcon("ok.png"));
		v.VueJoueur.carte1.bouton.setPressedIcon(new ImageIcon("Bangapp.png"));
		v.VueJoueur.carte2.bouton.setPressedIcon(new ImageIcon("Rateapp.png"));
		v.VueJoueur.carte3.bouton.setPressedIcon(new ImageIcon("Holdupapp.png"));
		v.VueJoueur.carte4.bouton.setPressedIcon(new ImageIcon("Mustangapp.png"));
		v.VueJoueur.carte5.bouton.setPressedIcon(new ImageIcon("Lunetteapp.png"));
		v.VueJoueur.carte6.bouton.setPressedIcon(new ImageIcon("Convoiapp.png"));
		v.VueJoueur.carte7.bouton.setPressedIcon(new ImageIcon("Magasinapp.png"));
		v.VueJoueur.carte8.bouton.setPressedIcon(new ImageIcon("Volcanicbapp.png"));
		v.VueJoueur.carte9.bouton.setPressedIcon(new ImageIcon("Biereapp.png"));
		v.VueJoueur.carte10.bouton.setPressedIcon(new ImageIcon("Remingtonapp.png"));
		v.VueJoueur.carte11.bouton.setPressedIcon(new ImageIcon("Schofielapp.png"));
		v.VueJoueur.carte12.bouton.setPressedIcon(new ImageIcon("Saloonapp.png"));
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		j.setNomjoueurcible(joueurSelectionne=((VueAdversaire)(arg0.getSource())).nomPerso.getText());
		j.setJoueurciblee(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ArrayList<Joueur> joueurs = j.getParticipants();
		majPdvJ(j.getJoueurHumain().getPdv());
		int k = 0;
		for(int i = 1; i<joueurs.size(); i++){
			k = (j.getIndexJHumain()+i)%joueurs.size();
			v.VueAdv[i-1].majpdv(joueurs.get(k));
			for(ActionBonus b : joueurs.get(k).getBonus()){
				if(b instanceof Arme) v.VueAdv[i-1].change(b.getNom());
				else if(b instanceof Mustang) v.VueAdv[i-1].bonus1.setVisible(true);
				else if(b instanceof Lunette) v.VueAdv[i-1].bonus2.setVisible(true);
			}
			
			v.VueAdv[i-1].labelnbCartes.setText(joueurs.get(k).getMain().size()+"");
			System.out.println("TAILLE DE LA MAIN "+joueurs.get(k).getMain().size());
		}
		for(ActionBonus b : j.getJoueurHumain().getBonus()){
			if(b instanceof Arme) v.VueJoueur.change(b.getNom());
			else if(b instanceof Mustang) v.VueJoueur.bonus1.setVisible(true);
			else if(b instanceof Lunette) v.VueJoueur.bonus2.setVisible(true);
		}
		int bang=0,rate=0, holdup=0, mustang=0, lunette=0, convoi=0, magasin=0, volcanic=0, biere=0, remington=0, schofield=0, saloon=0;
		for(Action a : j.getJoueurHumain().getMain()){
			if(a instanceof Bang) bang++;
			else if(a instanceof Rate) rate++;
			else if(a instanceof CoupDeFoudre) holdup++;
			else if(a instanceof Mustang) mustang++;
			else if(a instanceof Lunette) lunette++;
			else if(a instanceof Convoi) convoi++;
			else if(a instanceof Magasin) magasin++;
			else if(a instanceof Volcanic) volcanic++;
			else if(a instanceof Biere) biere++;
			else if(a instanceof Remington) remington++;
			else if(a instanceof Schofield) schofield++;
			else if(a instanceof Saloon) saloon++;
		}
		System.out.println("Main:"+j.getJoueurHumain().getMain());
		v.VueJoueur.carte1.maj(bang);
		v.VueJoueur.carte2.maj(rate);
		v.VueJoueur.carte3.maj(holdup);
		v.VueJoueur.carte4.maj(mustang);
		v.VueJoueur.carte5.maj(lunette);
		v.VueJoueur.carte6.maj(convoi);
		v.VueJoueur.carte7.maj(magasin);
		v.VueJoueur.carte8.maj(volcanic);
		v.VueJoueur.carte9.maj(biere);
		v.VueJoueur.carte10.maj(remington);
		v.VueJoueur.carte11.maj(schofield);
		v.VueJoueur.carte12.maj(saloon);
		if(j.getJoueurHumain().aTire() && !j.getJoueurHumain().isTireIllimite())
		{
			v.VueJoueur.carte1.bouton.setEnabled(false);
		}
	}
	
	public void majLines()
	{
		for(VueCarteJoueur t : v.VueJoueur.vueCarteJoueur)
		{
			t.bouton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}
	}
	
	public void majPdvJ (int i)
	{
		v.VueJoueur.ptsViesPerso.removeAll();
		v.VueJoueur.listePdv.set(0,new VuePointDeVie(false));
		v.VueJoueur.listePdv.set(1,new VuePointDeVie(false));
		v.VueJoueur.listePdv.set(2,new VuePointDeVie(false));
		v.VueJoueur.listePdv.set(3,new VuePointDeVie(false));
		v.VueJoueur.listePdv.set(4,new VuePointDeVie(false));
		
		for(int k=0;k<i;k++)
		{
			v.VueJoueur.listePdv.set(4-k, new VuePointDeVie(true));

		}

		v.VueJoueur.ptsViesPerso.add(v.VueJoueur.listePdv.get(0));
		v.VueJoueur.ptsViesPerso.add(v.VueJoueur.listePdv.get(1));
		v.VueJoueur.ptsViesPerso.add(v.VueJoueur.listePdv.get(2));
		v.VueJoueur.ptsViesPerso.add(v.VueJoueur.listePdv.get(3));
		v.VueJoueur.ptsViesPerso.add(v.VueJoueur.listePdv.get(4));
	}
	
}
