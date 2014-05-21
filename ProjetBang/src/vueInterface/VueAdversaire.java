package vueInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class VueAdversaire extends MyPanel {

	public VuePointDeVie panelVie1;
	public VuePointDeVie panelVie2;
	public VuePointDeVie panelVie3;
	public VuePointDeVie panelVie4;
	public VuePointDeVie panelVie5;
	public VueCartesAdv cartes;
	public VuePortrait portrait;
	public VueArme arme;
	public VueSherif panelEtoile;
	public VueBonusMustang bonus1;
	public VueBonusLunette bonus2;

	public VueAdversaire(String s, String role) {
		bonus1 = new VueBonusMustang();
		bonus2 = new VueBonusLunette(true);
		cartes = new VueCartesAdv();
		JLabel nomPerso = new JLabel(s, JLabel.CENTER);
		portrait = new VuePortrait(s);
		panelEtoile = new VueSherif(role.equals("SHERIF"));
		arme = new VueArme("colt");
		panelVie1 = new VuePointDeVie(role.equals("SHERIF"));
		panelVie2 = new VuePointDeVie(true);
		panelVie3 = new VuePointDeVie(true);
		panelVie4 = new VuePointDeVie(true);
		panelVie5 = new VuePointDeVie(true);

		setLayout(new GridLayout(1, 2));
		MyPanel panelPerso = new MyPanel();
		MyPanel sherifvie = new MyPanel();
		add(sherifvie);
		add(panelPerso);

		MyPanel panelportrait = new MyPanel();
		MyPanel panelcartes = new MyPanel();
		GridLayout gridlay = new GridLayout(2, 1);
		panelPerso.setLayout(gridlay);
		panelPerso.add(panelportrait);
		panelPerso.add(panelcartes);

		cartes.setPreferredSize(new Dimension(80, 120));
		MyPanel lol = new MyPanel();
		lol.setPreferredSize(new Dimension(25, 30));
		panelcartes.setLayout(new BorderLayout());
		panelcartes.add(lol, BorderLayout.WEST);
		panelcartes.add(cartes, BorderLayout.CENTER);

		nomPerso.setFont(new Font("Gungsuh", Font.BOLD, 10));

		panelcartes.add(nomPerso, BorderLayout.SOUTH);

		GridBagConstraints contrainte = new GridBagConstraints();
		panelportrait.setLayout(new GridBagLayout());

		portrait.setPreferredSize(new Dimension(123, 123));
		MyPanel inters = new MyPanel();

		inters.setPreferredSize(new Dimension(1, 20));

		creercontrainte(contrainte, 0, 0, 1, GridBagConstraints.REMAINDER, 0,
				0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH);
		panelportrait.add(portrait, contrainte);

		creercontrainte(contrainte, 0, 1, 1, GridBagConstraints.REMAINDER, 0,
				38, GridBagConstraints.NONE, GridBagConstraints.CENTER);
		panelportrait.add(inters, contrainte);

		MyPanel panelHautGauche = new MyPanel();

		MyPanel panelBasGauche = new MyPanel();

		sherifvie.setLayout(gridlay);
		sherifvie.add(panelHautGauche);
		sherifvie.add(panelBasGauche);

		MyPanel panelSherif = new MyPanel();
		MyPanel panelVies = new MyPanel();

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

		MyPanel panelArme = new MyPanel();
		MyPanel panelBonus = new MyPanel();
		panelBasGauche.setLayout(gridlay);
		arme.setPreferredSize(new Dimension(95, 60));
		panelArme.add(arme);

		panelBonus.setLayout(new GridLayout(1, 2));
		MyPanel panelBonus1 = new MyPanel();
		MyPanel panelBonus2 = new MyPanel();
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
}
