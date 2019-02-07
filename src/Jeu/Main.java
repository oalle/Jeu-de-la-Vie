package Jeu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) throws InterruptedException 
		{
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			MaFenetre f = new MaFenetre("Stratégie", 0, 0, d.width/2, d.height/2);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setLocationRelativeTo(null);
			//f.lancerJeu();
		}

	

}
