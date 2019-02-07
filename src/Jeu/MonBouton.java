package Jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class MonBouton implements ActionListener
{
	private MaFenetre p;
	private String c;
	private Plateau plat;
	public MonBouton(MaFenetre x,Plateau plat,String s)
	{
		p=x;
		c=s;
		this.plat=plat;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(c=="Rurale")
		{
			plat.valrecoltebois=2;
			plat.valrecolteminerai=2;
			plat.valrecoltepierre=2;
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			MaFenetre f;
			try {
				f = new MaFenetre("Jeu", 0, 0, d.width, d.height,plat);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				f.setLocationRelativeTo(null);
				p.setVisible(false);
				p.dispose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			plat.urbain=10;
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			MaFenetre f;
			try {
				f = new MaFenetre("Test", 0, 0, d.width, d.height,plat);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				f.setLocationRelativeTo(null);
				p.setVisible(false);
				p.dispose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
