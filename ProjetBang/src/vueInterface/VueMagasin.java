package vueInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VueMagasin extends JPanel {

	public VueMagasin(int i,String s1,String s2,String s3,String s4,String s5)// Nombre de joueurs encore en jeu
	{
		setMaximumSize(new Dimension(i * 109, 85));
		setBackground(Color.black);
		setLayout(new GridLayout(1, i));
		JButton bouton1;
		JButton bouton2;
		JButton bouton3;
		JButton bouton4;
		JButton bouton5;
		switch (i) {
		case 1:
			bouton1 = new JButton();
			bouton1.setIcon(new ImageIcon(s1+".png"));
			bouton1.setPressedIcon(new ImageIcon(s1+"app.png"));
			bouton1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton1);
			break;
		case 2:
			bouton1 = new JButton();
			bouton1.setIcon(new ImageIcon(s1+".png"));
			bouton1.setPressedIcon(new ImageIcon(s1+"app.png"));
			bouton1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton1);
			bouton2 = new JButton();
			bouton2.setIcon(new ImageIcon(s2+".png"));
			bouton2.setPressedIcon(new ImageIcon(s2+"app.png"));
			bouton2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton2);
			break;
		case 3:
			bouton1 = new JButton();
			bouton1.setIcon(new ImageIcon(s1+".png"));
			bouton1.setPressedIcon(new ImageIcon(s1+"app.png"));
			bouton1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton1);
			bouton2 = new JButton();
			bouton2.setIcon(new ImageIcon(s2+".png"));
			bouton2.setPressedIcon(new ImageIcon(s2+"app.png"));
			bouton2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton2);
			bouton3 = new JButton();
			bouton3.setIcon(new ImageIcon(s3+".png"));
			bouton3.setPressedIcon(new ImageIcon(s3+"app.png"));
			bouton3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton3);
			break;
		case 4:
			bouton1 = new JButton();
			bouton1.setIcon(new ImageIcon(s1+".png"));
			bouton1.setPressedIcon(new ImageIcon(s1+"app.png"));
			bouton1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton1);
			bouton2 = new JButton();
			bouton2.setIcon(new ImageIcon(s2+".png"));
			bouton2.setPressedIcon(new ImageIcon(s2+"app.png"));
			bouton2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton2);
			bouton3 = new JButton();
			bouton3.setIcon(new ImageIcon(s3+".png"));
			bouton3.setPressedIcon(new ImageIcon(s3+"app.png"));
			bouton3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton3);
			bouton4 = new JButton();
			bouton4.setIcon(new ImageIcon(s4+".png"));
			bouton4.setPressedIcon(new ImageIcon(s4+"app.png"));
			bouton4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton4);
			break;
		case 5:
			bouton1 = new JButton();
			bouton1.setIcon(new ImageIcon(s1+".png"));
			bouton1.setPressedIcon(new ImageIcon(s1+"app.png"));
			bouton1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton1);
			bouton2 = new JButton();
			bouton2.setIcon(new ImageIcon(s2+".png"));
			bouton2.setPressedIcon(new ImageIcon(s2+"app.png"));
			bouton2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton2);
			bouton3 = new JButton();
			bouton3.setIcon(new ImageIcon(s3+".png"));
			bouton3.setPressedIcon(new ImageIcon(s3+"app.png"));
			bouton3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton3);
			bouton4 = new JButton();
			bouton4.setIcon(new ImageIcon(s4+".png"));
			bouton4.setPressedIcon(new ImageIcon(s4+"app.png"));
			bouton4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton4);
			bouton5 = new JButton();
			bouton5.setIcon(new ImageIcon(s5+".png"));
			bouton5.setPressedIcon(new ImageIcon(s5+"app.png"));
			bouton5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			add(bouton5);
			break;
		}
	}

}
