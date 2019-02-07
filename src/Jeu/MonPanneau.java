package Jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MonPanneau extends JPanel
{
	private Plateau p;
	
	public MonPanneau(Plateau p)
	{
		this.p=p;
	}
	
	public void misajour(Plateau p)
	{
		this.p=p;
		this.repaint();
	}
	
	
	public void paintComponent(Graphics g)
	{
		int d=580;
		super.paintComponent(g);
		String tab[][]=p.getPlateau();
		g.setFont(new Font("Arial",0,15));
		g.drawString("Minerai :", 0+d, 100);
		String s1=String.valueOf(p.nbminerai);
		g.drawString(s1,80+d, 100);
		g.drawString("/", 130+d, 100);
		String s2=String.valueOf(p.stock);
		g.drawString(s2, 140+d, 100);
		g.drawString("Pierre :", 180+d, 100);
		String s3=String.valueOf(p.nbpierre);
		g.drawString(s3, 260+d, 100);
		g.drawString("/", 310+d, 100);
		String s4=String.valueOf(p.stock);
		g.drawString(s4, 320+d, 100);
		g.drawString("Bois :", 370+d, 100);
		String s5=String.valueOf(p.nbbois);
		g.drawString(s5, 450+d, 100);
		g.drawString("/", 500+d, 100);
		String s6=String.valueOf(p.stock);
		g.drawString(s6, 510+d, 100);
		g.drawString("Personne :", 560+d, 100);
		String s7=String.valueOf(p.nbpersonne);
		g.drawString(s7, 640+d, 100);
		g.drawString("/", 690+d, 100);
		String s8=String.valueOf(p.popmax);
		g.drawString(s8, 700+d, 100);
		g.setFont(new Font("Arial",0,20));
		for(int a=0;a<20;a++)
		{
			for(int b=0;b<20;b++)
			{
				String s=tab[a][b];
				if(s=="B")
					g.setColor(Color.GREEN);
				else if(s=="M")
					g.setColor(Color.YELLOW);
				else if(s=="P")
					g.setColor(Color.GRAY);
				else if(s=="D")
					g.setColor(Color.RED);
				else if(s=="E")
					g.setColor(Color.ORANGE);
				else if(s=="Ma")
					g.setColor(Color.BLUE);
				else if(s=="S")
					g.setColor(Color.MAGENTA);
				else if(s=="C")
					g.setColor(Color.PINK);
				else if(s=="Mi")
					g.setColor(Color.DARK_GRAY);
				else
					g.setColor(Color.BLACK);
				g.drawString(s, a*35+600, b*35+200);
			}
		}
	}
}
