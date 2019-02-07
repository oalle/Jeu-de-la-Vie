package Jeu;

public class Carriere  extends Bâtiment 
{
	protected int valrecoltepierre;
	protected int prixboix=50;
	protected int prixminerai=30;
	protected int prixpierre=10;
	public Carriere(int x,int y,Plateau p)
	{
		super(x,y,p);
		p.setPlateau(x, y, "C");
		p.setPlateau(x+1, y, "C");
		p.setPlateau(x, y+1, "C");
		p.setPlateau(x+1, y+1, "C");
		valrecoltepierre=10;
		p.valrecoltepierre=p.valrecoltepierre+valrecoltepierre;
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
			
			valrecoltepierre=valrecoltepierre+10;
		}
		p.valrecoltepierre=p.valrecoltepierre+valrecoltepierre;
	}
	@Override
	public boolean droitConstruire(Plateau p) 
	{
		if(p.nbminerai<prixminerai||p.nbbois<prixboix||p.nbpierre<prixpierre)
			return false;
		else
			return true;
	}
}