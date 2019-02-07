package Jeu;

public class Mine extends Bâtiment
{
	private int valrecolteminerai;
	protected int prixboix=30;
	protected int prixminerai=10;
	protected int prixpierre=50;
	public Mine(int x,int y,Plateau p)
	{
		super(x,y,p);
		p.setPlateau(x, y, "Mi");
		p.setPlateau(x+1, y, "Mi");
		p.setPlateau(x, y+1, "Mi");
		p.setPlateau(x+1, y+1, "Mi");
		valrecolteminerai=10;
		p.valrecolteminerai=p.valrecolteminerai+valrecolteminerai;
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
			
			valrecolteminerai=valrecolteminerai+10;
		}
		p.valrecolteminerai=p.valrecolteminerai+valrecolteminerai;
	}
	public boolean droitConstruire(Plateau p) 
	{
		if(p.nbminerai<prixminerai||p.nbbois<prixboix||p.nbpierre<prixpierre)
			return false;
		else
			return true;
	}
}
