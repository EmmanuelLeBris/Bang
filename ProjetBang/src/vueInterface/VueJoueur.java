package vueInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VueJoueur extends JPanel {

	
	public ArrayList<VuePointDeVie> listePdv = new ArrayList<VuePointDeVie>(5);
	public JPanel ptsViesPerso;
	public VuePortrait imagePerso;
	public VueBonusMustang bonus1;
	public ArrayList<VueCarteJoueur> vueCarteJoueur=new ArrayList<VueCarteJoueur>(12);
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
	public JTextArea textExplicatif;
	private VueArme colt;
	private VueArme schofield;
	private VueArme remington;
	private VueArme volcanic;


	public VueJoueur(String s, String roleJ) {
		setOpaque(false);
		JLabel nomPersoJoueur = new JLabel(s);
		imagePerso = new VuePortrait(s);
		colt = new VueArme("Colt");
		colt.setVisible(true);
		schofield = new VueArme("Schofieldb");
		schofield.setVisible(false);
		remington = new VueArme("Remingtonb");
		remington.setVisible(false);
		volcanic = new VueArme("Volcanicb");
		volcanic.setVisible(false);
		bonus1 = new VueBonusMustang();
		bonus1.setVisible(false);
		bonus2 = new VueBonusLunette();
		bonus2.setVisible(false);
		panelRole = new VueRoleJoueur(roleJ);

		VuePointDeVie ptVie1 = new VuePointDeVie(false);
		VuePointDeVie ptVie2 = new VuePointDeVie(false);
		VuePointDeVie ptVie3 = new VuePointDeVie(false);
		VuePointDeVie ptVie4 = new VuePointDeVie(false);
		VuePointDeVie ptVie5 = new VuePointDeVie(false);
		listePdv.add(ptVie1);
		listePdv.add(ptVie2);
		listePdv.add(ptVie3);
		listePdv.add(ptVie4);
		listePdv.add(ptVie5);		
		BorderLayout layoutJoueur = new BorderLayout();
		JPanel cartesPanel = new JPanel();
		cartesPanel.setOpaque(false);
		JPanel role = new JPanel();
		role.setOpaque(false);
		JPanel nomPerso = new JPanel();
		nomPerso.setOpaque(false);
		JPanel personnage = new JPanel();
		personnage.setOpaque(false);
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

		JPanel cartes = new JPanel();
		cartes.setOpaque(false);
		JPanel marge = new JPanel();
		marge.setOpaque(false);
		marge.setPreferredSize(new Dimension(50, 50));
		cartesPanel.add(marge, BorderLayout.NORTH);
		cartesPanel.add(cartes, BorderLayout.CENTER);

		cartes.setLayout(new GridLayout(2, 6));
		carte1 = new VueCarteJoueur("Bang",0);
		carte2 = new VueCarteJoueur("Rate",0);
		carte3 = new VueCarteJoueur("Holdup",0);
		carte4 = new VueCarteJoueur("Mustang",0);
		carte5 = new VueCarteJoueur("Lunette",0);
		carte6 = new VueCarteJoueur("Convoi",0);
		carte7 = new VueCarteJoueur("Magasin",0);
		carte8 = new VueCarteJoueur("Volcanic",0);
		carte9 = new VueCarteJoueur("Biere",0);
		carte10 = new VueCarteJoueur("Remington",0);
		carte11 = new VueCarteJoueur("Schofield",0);
		carte12 = new VueCarteJoueur("Saloon",0);

		vueCarteJoueur.add(carte1);
		vueCarteJoueur.add(carte2);
		vueCarteJoueur.add(carte3);
		vueCarteJoueur.add(carte4);
		vueCarteJoueur.add(carte5);
		vueCarteJoueur.add(carte6);
		vueCarteJoueur.add(carte7);
		vueCarteJoueur.add(carte8);
		vueCarteJoueur.add(carte9);
		vueCarteJoueur.add(carte10);
		vueCarteJoueur.add(carte11);
		vueCarteJoueur.add(carte12);
		
		for(VueCarteJoueur v : vueCarteJoueur)
		{
			cartes.add(v);
		}

		role.setLayout(new BorderLayout());
		JPanel panelNordRole = new JPanel();
		panelNordRole.setOpaque(false);
		JPanel panelSudRole = new JPanel();
		panelSudRole.setOpaque(false);

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
		JPanel nomPersonnageJoueur = new JPanel();
		nomPersonnageJoueur.setOpaque(false);
		nomPerso.add(nomPersonnageJoueur, BorderLayout.WEST);

		JPanel panelFinTour = new JPanel();
		panelFinTour.setOpaque(false);
		panelFinTour.setLayout(new BorderLayout());

		JPanel eastFin = new JPanel();
		eastFin.setOpaque(false);
		eastFin.setPreferredSize(new Dimension(50, 30));
		panelFinTour.add(eastFin, BorderLayout.EAST);

		JPanel westFin = new JPanel();
		westFin.setOpaque(false);
		westFin.setPreferredSize(new Dimension(50, 30));
		panelFinTour.add(westFin, BorderLayout.WEST);

		JPanel northFin = new JPanel();
		northFin.setOpaque(false);
		northFin.setPreferredSize(new Dimension(50, 25));
		panelFinTour.add(northFin, BorderLayout.NORTH);

		JPanel southFin = new JPanel();
		southFin.setOpaque(false);
		southFin.setPreferredSize(new Dimension(50, 25));
		panelFinTour.add(southFin, BorderLayout.SOUTH);

		finDeTour = new JButton(new ImageIcon("fintour.png"));
		Font fontBouton = new Font("Gungsuh", Font.BOLD, 14);
		finDeTour.setMargin(new Insets(0, 0, 0, 0));
		finDeTour.setBackground(new Color(0,0,0,0));
		finDeTour.setFont(fontBouton);
		finDeTour.setPreferredSize(new Dimension(100, 10));
		finDeTour.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panelFinTour.add(finDeTour, BorderLayout.CENTER);

		nomPerso.add(panelFinTour, BorderLayout.EAST);

		JPanel name = new JPanel();
		name.setOpaque(false);
		JPanel northName = new JPanel();
		northName.setOpaque(false);
		northName.setPreferredSize(new Dimension(20, 40));
		nomPersonnageJoueur.setLayout(new BorderLayout());
		nomPersonnageJoueur.add(name, BorderLayout.CENTER);
		nomPersonnageJoueur.add(northName, BorderLayout.NORTH);

		nomPersonnageJoueur.add(nomPersoJoueur);

		JPanel panelExplication = new JPanel();
		panelExplication.setOpaque(false);

		
		panelExplication.setPreferredSize(new Dimension(50, 50));
		
		JPanel panelText = new JPanel();
		panelText.setOpaque(false);
		panelText.setLayout(new BorderLayout());
		panelText.setBackground(Color.white);
		
		textExplicatif = new JTextArea("");
		textExplicatif.setFont(fontBouton);
		textExplicatif.setPreferredSize(new Dimension(582, 50));
		panelText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		textExplicatif.setColumns(20);
		textExplicatif.setEditable(false);
		
		bouttonOk = new JButton("OK");
		bouttonOk.setFont(fontBouton);
		bouttonOk.setPreferredSize(new Dimension(50, 30));
		bouttonOk.setMargin(new Insets(0, 0, 0, 0));
		bouttonOk.setFont(fontBouton);
		bouttonOk.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		JPanel panelBouttonOk = new JPanel();
		panelBouttonOk.setBackground(Color.white);
		panelBouttonOk.setLayout(new BorderLayout());
		panelBouttonOk.add(bouttonOk,BorderLayout.EAST);
		panelBouttonOk.setBackground(Color.white);
		panelText.add(panelBouttonOk,BorderLayout.SOUTH);
		
		panelText.add(textExplicatif,BorderLayout.CENTER);

		panelExplication.add(panelText,BorderLayout.SOUTH);


		nomPerso.add(panelExplication, BorderLayout.CENTER);

		personnage.setLayout(new BorderLayout());
		JPanel panelSouthPersonnage = new JPanel();
		panelSouthPersonnage.setOpaque(false);
		JPanel panelNorthPersonnage = new JPanel();
		panelNorthPersonnage.setOpaque(false);
		panelSouthPersonnage.setPreferredSize(new Dimension(50, 147));
		panelNorthPersonnage.setPreferredSize(new Dimension(127, 127));

		ptsViesPerso = new JPanel();
		ptsViesPerso.setOpaque(false);

		imagePerso.setPreferredSize(new Dimension(128, 127));
		ptsViesPerso.setPreferredSize(new Dimension(77, 30));
		panelNorthPersonnage.setLayout(new BorderLayout());

		ptsViesPerso.setLayout(new GridLayout(5, 1));
		ptsViesPerso.add(ptVie1);
		ptsViesPerso.add(ptVie2);
		ptsViesPerso.add(ptVie3);
		ptsViesPerso.add(ptVie4);
		ptsViesPerso.add(ptVie5);

		JPanel westVies = new JPanel();
		westVies.setOpaque(false);
		westVies.setPreferredSize(new Dimension(11, 20));

		panelNorthPersonnage.add(westVies, BorderLayout.WEST);
		panelNorthPersonnage.add(ptsViesPerso, BorderLayout.CENTER);
		panelNorthPersonnage.add(imagePerso, BorderLayout.EAST);
		personnage.add(panelNorthPersonnage, BorderLayout.CENTER);
		personnage.add(panelSouthPersonnage, BorderLayout.SOUTH);

		JPanel panelArme = new JPanel();
		panelArme.setOpaque(false);
		JPanel panelBonus = new JPanel();
		panelBonus.setOpaque(false);
		panelSouthPersonnage.setLayout(new GridLayout(2, 1));

		volcanic.setPreferredSize(new Dimension(95, 60));
		schofield.setPreferredSize(new Dimension(95, 60));
		colt.setPreferredSize(new Dimension(95, 60));
		remington.setPreferredSize(new Dimension(95, 60));
		panelArme.add(volcanic);
		panelArme.add(colt);
		panelArme.add(remington);
		panelArme.add(schofield);

		panelBonus.setLayout(new GridLayout(1, 2));
		JPanel panelBonus1 = new JPanel();
		panelBonus1.setOpaque(false);
		JPanel panelBonus2 = new JPanel();
		panelBonus2.setOpaque(false);
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
	
	public void change(String nom) {
		remington.setVisible(false);
		schofield.setVisible(false);
		volcanic.setVisible(false);
		colt.setVisible(false);
		if(nom.equals("Remington")) remington.setVisible(true);
		else if(nom.equals("Schofield")) schofield.setVisible(true);
		else if(nom.equals("Volcanic")) volcanic.setVisible(true);
		
	}
}

