package vueInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bang.Jeu.Joueur;

public class VueAdversaire extends JPanel {

	public ArrayList<VuePointDeVie> listePdv = new ArrayList<VuePointDeVie>(5);
	public VueCartesAdv cartes;
	public VuePortrait portrait;
	public VueSherif panelEtoile;
	public VueBonusMustang bonus1;
	public VueBonusLunette bonus2;
	public JLabel nomPerso;
	public JLabel labelnbCartes;
	public int nbCartes=5;
	public JPanel panelArme;
	private VueArme colt;
	private VueArme schofield;
	private JComponent remington;
	private VueArme volcanic;
	public JPanel panelVies;
	
	public VueAdversaire(String perso, String role) {
		setOpaque(false);
		//bg = new ImageIcon("fond.png").getImage();
		bonus1 = new VueBonusMustang();
		bonus1.setVisible(false);
		bonus2 = new VueBonusLunette();
		bonus2.setVisible(false);
		cartes = new VueCartesAdv();
		nomPerso = new JLabel(perso, JLabel.CENTER);
		labelnbCartes = new JLabel();
		portrait = new VuePortrait(perso);
		panelEtoile = new VueSherif(role.equals("SHERIF"));
		colt = new VueArme("Colt");
		colt.setVisible(true);
		schofield = new VueArme("Schofieldb");
		schofield.setVisible(false);
		remington = new VueArme("Remingtonb");
		remington.setVisible(false);
		volcanic = new VueArme("Volcanicb");
		volcanic.setVisible(false);
		VuePointDeVie panelVie1 = new VuePointDeVie(role.equals("SHERIF"));
		VuePointDeVie panelVie2 = new VuePointDeVie(true);
		VuePointDeVie panelVie3 = new VuePointDeVie(true);
		VuePointDeVie panelVie4 = new VuePointDeVie(true);
		VuePointDeVie panelVie5 = new VuePointDeVie(true);

		listePdv.add(panelVie1);
		listePdv.add(panelVie2);
		listePdv.add(panelVie3);
		listePdv.add(panelVie4);
		listePdv.add(panelVie5);
		
		setLayout(new GridLayout(1, 2));
		JPanel panelPerso = new JPanel();
		panelPerso.setOpaque(false);
		JPanel sherifvie = new JPanel();
		sherifvie.setOpaque(false);
		add(sherifvie);
		add(panelPerso);

		JPanel panelportrait = new JPanel();
		panelportrait.setOpaque(false);
		JPanel panelcartes = new JPanel();
		panelcartes.setOpaque(false);
		GridLayout gridlay = new GridLayout(2, 1);
		panelPerso.setLayout(gridlay);
		panelPerso.add(panelportrait);
		panelPerso.add(panelcartes);
		cartes.setPreferredSize(new Dimension(80, 120));
		JPanel ecarteur = new JPanel();
		ecarteur.setOpaque(false);
		ecarteur.setPreferredSize(new Dimension(25, 30));
		labelnbCartes.setPreferredSize(new Dimension(20,30));
		panelcartes.setLayout(new BorderLayout());
		panelcartes.add(ecarteur, BorderLayout.WEST);
		panelcartes.add(cartes, BorderLayout.NORTH);
		panelcartes.add(labelnbCartes,BorderLayout.CENTER);
		nomPerso.setFont(new Font("Gungsuh", Font.BOLD, 10));
		nomPerso.setPreferredSize(new Dimension(50,45));
		labelnbCartes.setFont(new Font("Gungsuh", Font.BOLD, 15));
		panelcartes.add(nomPerso, BorderLayout.SOUTH);

		GridBagConstraints contrainte = new GridBagConstraints();
		panelportrait.setLayout(new GridBagLayout());

		portrait.setPreferredSize(new Dimension(123, 123));
		JPanel inters = new JPanel();
		inters.setOpaque(false);

		inters.setPreferredSize(new Dimension(1, 20));

		creercontrainte(contrainte, 0, 0, 1, GridBagConstraints.REMAINDER, 0,
				0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH);
		panelportrait.add(portrait, contrainte);

		creercontrainte(contrainte, 0, 1, 1, GridBagConstraints.REMAINDER, 0,
				38, GridBagConstraints.NONE, GridBagConstraints.CENTER);
		panelportrait.add(inters, contrainte);

		JPanel panelHautGauche = new JPanel();
		panelHautGauche.setOpaque(false);

		JPanel panelBasGauche = new JPanel();
		panelBasGauche.setOpaque(false);
		

		sherifvie.setLayout(gridlay);
		sherifvie.add(panelHautGauche);
		sherifvie.add(panelBasGauche);

		JPanel panelSherif = new JPanel();
		panelSherif.setOpaque(false);
		panelVies = new JPanel();
		panelVies.setOpaque(false);

		panelEtoile.setPreferredSize(new Dimension(50, 50));
		panelSherif.add(panelEtoile);

		panelVies.setLayout(new GridLayout(7, 1));
		panelVies.add(panelVie1);
		panelVies.add(panelVie2);
		panelVies.add(panelVie3);
		panelVies.add(panelVie4);
		panelVies.add(panelVie5);

		panelHautGauche.setLayout(new GridLayout(1, 2));
		panelHautGauche.add(panelSherif);
		panelHautGauche.add(panelVies);

		panelArme = new JPanel();
		panelArme.setOpaque(false);
		JPanel panelBonus = new JPanel();
		panelBonus.setOpaque(false);
		panelBasGauche.setLayout(gridlay);
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
		bonus1.setPreferredSize(new Dimension(35, 60));
		panelBonus1.add(bonus1);
		panelBonus2.add(bonus2);

		panelBasGauche.add(panelArme);
		panelBasGauche.add(panelBonus);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 4));
	}

	public static void creercontrainte(GridBagConstraints c, int gridx,
			int gridy, int gridheight, int gridwidth, int ipadx, int ipady,
			int fill, int anchor) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridheight = gridheight;
		c.gridwidth = gridwidth;
		c.ipady = ipady;
		c.ipadx = ipadx;
		c.fill = fill;
		c.anchor = anchor;
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
	public void majpdv(Joueur joueur) {
		// TODO Auto-generated method stub
		panelVies.removeAll();
		listePdv.set(0,new VuePointDeVie(false));
		listePdv.set(1,new VuePointDeVie(false));
		listePdv.set(2,new VuePointDeVie(false));
		listePdv.set(3,new VuePointDeVie(false));
		listePdv.set(4,new VuePointDeVie(false));
		
		for(int k=0;k<joueur.getPdv();k++)
		{
			listePdv.set(4-k, new VuePointDeVie(true));

		}

		panelVies.add(listePdv.get(0));
		panelVies.add(listePdv.get(1));
		panelVies.add(listePdv.get(2));
		panelVies.add(listePdv.get(3));
		panelVies.add(listePdv.get(4));
	}
}

