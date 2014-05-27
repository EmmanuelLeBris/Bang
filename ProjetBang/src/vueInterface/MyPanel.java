package vueInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	protected Image bg;
	Graphics graph;

	public MyPanel()
	{
		
	}
	@Override
	public void setBackground(Color arg0) {
		super.setBackground(new Color(0, 0, 0, 0));
	}

	public MyPanel(String s) {
		bg = new ImageIcon(s).getImage();
	}

	public void paintComponent(Graphics g) {
		graph = g;
		g.drawImage(bg, 0, 0, null);
	}
}
