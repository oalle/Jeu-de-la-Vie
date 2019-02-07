package Jeu;

public class Mairie  extends Bâtiment
{
	private int popmax;
	protected int prixboix=30;
	protected int prixminerai=30;
	protected int prixpierre=30;
	
	public Mairie(int x,int y,Plateau p)
	{
		super(x,y,p);
		p.setPlateau(x, y, "Ma");
		p.setPlateau(x+1, y, "Ma");
		p.setPlateau(x, y+1, "Ma");
		p.setPlateau(x+1, y+1, "Ma");
		popmax=10;
		p.popmax=p.popmax+popmax;
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
			popmax=popmax+10;
		}
		p.popmax=p.popmax+popmax;
	}
	public boolean droitConstruire(Plateau p) 
	{
		if(p.nbminerai<prixminerai||p.nbbois<prixboix||p.nbpierre<prixpierre)
			return false;
		else
			return true;
	}
}