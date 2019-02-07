package Jeu;

public class Entrepot extends Bâtiment
{
	private int stockmax;
	protected int prixboix=20;
	protected int prixminerai=20;
	protected int prixpierre=20;
	public Entrepot(int x,int y,Plateau p)
	{
		super(x,y,p);
		p.setPlateau(x, y, "E");
		p.setPlateau(x+1, y, "E");
		p.setPlateau(x, y+1, "E");
		p.setPlateau(x+1, y+1, "E");
		stockmax=20;
		p.stock=p.stock+stockmax;
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
			
			stockmax=stockmax+20;
		}
		p.stock=p.stock+stockmax;
	}
	public boolean droitConstruire(Plateau p) 
	{
		if(p.nbminerai<prixminerai||p.nbbois<prixboix||p.nbpierre<prixpierre)
			return false;
		else
			return true;
	}
}