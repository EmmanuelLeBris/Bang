package vueInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private Image bg;

	public MyPanel()
	{
		
	}
	@Override
	public void setBackground(Color arg0) {
		// TODO Auto-generated method stub
		super.setBackground(new Color(0, 0, 0, 0));
	}

	public MyPanel(String s) {
		// TODO Auto-generated constructor stub
		bg = new ImageIcon(s).getImage();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);

	}
}