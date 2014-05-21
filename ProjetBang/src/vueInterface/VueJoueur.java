package vueInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VueJoueur extends MyPanel {

	public VuePointDeVie ptVie1;
	public VuePointDeVie ptVie2;
	public VuePointDeVie ptVie3;
	public VuePointDeVie ptVie4;
	public VuePointDeVie ptVie5;
	public VuePortrait imagePerso;
	public VueArme arme;	
	public VueBonusMustang bonus1;
	public VueBonusLunette bonus2;
	public VueCarteJoueur carte1;
	public VueCarteJoueur carte2;
	public VueCarteJoueur carte3;
	public VueCarteJoueur carte4;
	public VueCarteJoueur carte5;
	public VueCarteJoueur carte6;
	public VueCarteJoueur carte7;
	public VueCarteJoueur carte8;
	public VueCarteJoueur carte9;
	public VueCarteJoueur carte10;
	public VueCarteJoueur carte11;
	public VueCarteJoueur carte12;
	public VueRoleJoueur panelRole;
	public JButton finDeTour;
	public JButton bouttonOk;


	public VueJoueur(String s, boolean sher,String RoleJ) {

		JLabel nomPersoJoueur = new JLabel(s);
		ptVie1 = new VuePointDeVie(false);
		ptVie2 = new VuePointDeVie(sher);
		ptVie3 = new VuePointDeVie(true);
		ptVie4 = new VuePointDeVie(true);
		ptVie5 = new VuePointDeVie(true);
		imagePerso = new VuePortrait(s);
		arme = new VueArme("schofield");
		bonus1 = new VueBonusMustang();
		bonus2 = new VueBonusLunette(true);
		panelRole = new VueRoleJoueur(RoleJ);

		BorderLayout layoutJoueur = new BorderLayout();
		MyPanel cartesPanel = new MyPanel();
		MyPanel role = new MyPanel();
		MyPanel nomPerso = new MyPanel();
		MyPanel personnage = new MyPanel();
		setLayout(layoutJoueur);
		add(cartesPanel, BorderLayout.CENTER);
		role.setPreferredSize(new Dimension(160, 20));
		personnage.setPreferredSize(new Dimension(200, 20));
		nomPerso.setPreferredSize(new Dimension(900, 100));
		add(role, BorderLayout.WEST);
		add(nomPerso, BorderLayout.SOUTH);
		add(personnage, BorderLayout.EAST);

		BorderLayout layoutcartes = new BorderLayout();
		cartesPanel.setLayout(layoutcartes);

		MyPanel cartes = new MyPanel();
		MyPanel marge = new MyPanel();
		marge.setPreferredSize(new Dimension(50, 50));
		cartesPanel.add(marge, BorderLayout.NORTH);
		cartesPanel.add(cartes, BorderLayout.CENTER);

		cartes.setLayout(new GridLayout(2, 6));
		carte1 = new VueCarteJoueur("bang");
		carte2 = new VueCarteJoueur("rate");
		carte3 = new VueCarteJoueur("holdup");
		carte4 = new VueCarteJoueur("mustangb");
		carte5 = new VueCarteJoueur("lunetteb");
		carte6 = new VueCarteJoueur("colt");
		carte7 = new VueCarteJoueur("magasin");
		carte8 = new VueCarteJoueur("volcanic");
		carte9 = new VueCarteJoueur("biere");
		carte10 = new VueCarteJoueur("remington");
		carte11 = new VueCarteJoueur("schofield");
		carte12 = new VueCarteJoueur("saloon");

		cartes.add(carte1);
		cartes.add(carte2);
		cartes.add(carte3);
		cartes.add(carte4);
		cartes.add(carte5);
		cartes.add(carte6);
		cartes.add(carte7);
		cartes.add(carte8);
		cartes.add(carte9);
		cartes.add(carte10);
		cartes.add(carte11);
		cartes.add(carte12);

		role.setLayout(new BorderLayout());
		MyPanel panelNordRole = new MyPanel();
		MyPanel panelSudRole = new MyPanel();

		panelRole.setPreferredSize(new Dimension(115, 70));
		panelRole.setBackground(Color.magenta);
		role.add(panelRole, BorderLayout.WEST);
		panelSudRole.setPreferredSize(new Dimension(50, 50));
		role.add(panelSudRole, BorderLayout.SOUTH);
		panelNordRole.setPreferredSize(new Dimension(50, 80));
		role.add(panelNordRole, BorderLayout.NORTH);

		nomPersoJoueur.setFont(new Font("Gungsuh", Font.BOLD, 16));

		BorderLayout nomPersoLayout = new BorderLayout();
		nomPerso.setLayout(nomPersoLayout);
		MyPanel nomPersonnageJoueur = new MyPanel();
		nomPerso.add(nomPersonnageJoueur, BorderLayout.WEST);

		MyPanel panelFinTour = new MyPanel();
		panelFinTour.setLayout(new BorderLayout());

		MyPanel eastFin = new MyPanel();
		eastFin.setPreferredSize(new Dimension(50, 30));
		panelFinTour.add(eastFin, BorderLayout.EAST);

		MyPanel westFin = new MyPanel();
		westFin.setPreferredSize(new Dimension(50, 30));
		panelFinTour.add(westFin, BorderLayout.WEST);

		MyPanel northFin = new MyPanel();
		northFin.setPreferredSize(new Dimension(50, 25));
		panelFinTour.add(northFin, BorderLayout.NORTH);

		MyPanel southFin = new MyPanel();
		southFin.setPreferredSize(new Dimension(50, 25));
		panelFinTour.add(southFin, BorderLayout.SOUTH);

		finDeTour = new JButton(new ImageIcon("fintour.png"));
		Font fontBouton = new Font("Gungsuh", Font.BOLD, 14);
		finDeTour.setMargin(new Insets(0, 0, 0, 0));
		finDeTour.setBackground(new Color(0,0,0,0));
		finDeTour.setFont(fontBouton);
		finDeTour.setPreferredSize(new Dimension(100, 10));
		panelFinTour.add(finDeTour, BorderLayout.CENTER);

		nomPerso.add(panelFinTour, BorderLayout.EAST);

		MyPanel name = new MyPanel();
		MyPanel northName = new MyPanel();
		northName.setPreferredSize(new Dimension(20, 40));
		nomPersonnageJoueur.setLayout(new BorderLayout());
		nomPersonnageJoueur.add(name, BorderLayout.CENTER);
		nomPersonnageJoueur.add(northName, BorderLayout.NORTH);

		nomPersonnageJoueur.add(nomPersoJoueur);

		MyPanel panelExplication = new MyPanel();

		
		panelExplication.setPreferredSize(new Dimension(50, 50));
		
		JPanel panelText = new JPanel();
		panelText.setLayout(new BorderLayout());
		panelText.setBackground(Color.white);
		
		JTextArea textExplicatif = new JTextArea("Hello");
		textExplicatif.setFont(fontBouton);
		textExplicatif.setPreferredSize(new Dimension(582, 50));
		panelText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		textExplicatif.setEditable(false);
		
		bouttonOk = new JButton("OK");
		bouttonOk.setFont(fontBouton);
		bouttonOk.setPreferredSize(new Dimension(50, 30));
		bouttonOk.setMargin(new Insets(0, 0, 0, 0));
		bouttonOk.setFont(fontBouton);

		JPanel panelBouttonOk = new JPanel();
		panelBouttonOk.setBackground(Color.white);
		panelBouttonOk.setLayout(new BorderLayout());
		panelBouttonOk.add(bouttonOk,BorderLayout.EAST);

		panelText.add(panelBouttonOk,BorderLayout.SOUTH);
		
		panelText.add(textExplicatif,BorderLayout.CENTER);

		panelExplication.add(panelText,BorderLayout.SOUTH);


		nomPerso.add(panelExplication, BorderLayout.CENTER);

		personnage.setLayout(new BorderLayout());
		MyPanel panelSouthPersonnage = new MyPanel();
		MyPanel panelNorthPersonnage = new MyPanel();
		panelSouthPersonnage.setPreferredSize(new Dimension(50, 147));
		panelNorthPersonnage.setPreferredSize(new Dimension(127, 127));

		MyPanel ptsViesPerso = new MyPanel();

		imagePerso.setPreferredSize(new Dimension(128, 127));
		ptsViesPerso.setPreferredSize(new Dimension(77, 30));
		panelNorthPersonnage.setLayout(new BorderLayout());

		ptsViesPerso.setLayout(new GridLayout(5, 1));
		ptsViesPerso.add(ptVie1);
		ptsViesPerso.add(ptVie2);
		ptsViesPerso.add(ptVie3);
		ptsViesPerso.add(ptVie4);
		ptsViesPerso.add(ptVie5);

		MyPanel westVies = new MyPanel();
		westVies.setPreferredSize(new Dimension(11, 20));

		panelNorthPersonnage.add(westVies, BorderLayout.WEST);
		panelNorthPersonnage.add(ptsViesPerso, BorderLayout.CENTER);
		panelNorthPersonnage.add(imagePerso, BorderLayout.EAST);
		personnage.add(panelNorthPersonnage, BorderLayout.CENTER);
		personnage.add(panelSouthPersonnage, BorderLayout.SOUTH);

		MyPanel panelArme = new MyPanel();
		MyPanel panelBonus = new MyPanel();
		panelSouthPersonnage.setLayout(new GridLayout(2, 1));

		arme.setPreferredSize(new Dimension(95, 60));
		panelArme.add(arme);

		panelBonus.setLayout(new GridLayout(1, 2));
		MyPanel panelBonus1 = new MyPanel();
		MyPanel panelBonus2 = new MyPanel();
		panelBonus.add(panelBonus1);
		panelBonus.add(panelBonus2);

		bonus2.setPreferredSize(new Dimension(35, 60));
		bonus2.setBackground(Color.red);
		bonus1.setPreferredSize(new Dimension(35, 60));
		bonus1.setBackground(Color.red);
		panelBonus1.add(bonus1);
		panelBonus2.add(bonus2);


		panelSouthPersonnage.add(panelArme);
		panelSouthPersonnage.add(panelBonus);
	}
}
