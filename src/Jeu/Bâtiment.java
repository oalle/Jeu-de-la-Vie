package Jeu;

public abstract class Bâtiment extends Décor
{
	protected int niveau;
	Bâtiment(int x,int y,Plateau p)
	{
		super(x,y,p);
		
	}
	public int getniveau()
	{
		return niveau;
	}
	public abstract void améliorer(Plateau p);
	public abstract boolean droitConstruire(Plateau p);
}
