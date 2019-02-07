package Jeu;

public class Scierie extends Bâtiment
{
	private int valrecoltebois;
	protected int prixboix=10;
	protected int prixminerai=30;
	protected int prixpierre=50;
	public Scierie(int x,int y,Plateau p)
	{
		super(x,y,p);
		p.setPlateau(x, y, "S");
		p.setPlateau(x+1, y, "S");
		p.setPlateau(x, y+1, "S");
		p.setPlateau(x+1, y+1, "S");
		valrecoltebois=10;
		p.valrecoltebois=p.valrecoltebois+valrecoltebois;
		niveau=0;
	}
	public void améliorer(Plateau p)
	{
		if (niveau<3)
		{
			niveau++;
			if(niveau==1)
				p.setPlateau(pos_x+1, pos_y, "*");
			if(niveau==2)
				p.setPlateau(pos_x, pos_y+1, "*");
			if(niveau==3)
				p.setPlateau(pos_x+1, pos_y+1, "*");
			
			valrecoltebois=valrecoltebois+10;
		}
		p.valrecoltebois=p.valrecoltebois+valrecoltebois;
	}
	public boolean droitConstruire(Plateau p) 
	{
		if(p.nbminerai<prixminerai||p.nbbois<prixboix||p.nbpierre<prixpierre)
			return false;
		else
			return true;
	}
}
