package Jeu;

public abstract class B�timent extends D�cor
{
	protected int niveau;
	B�timent(int x,int y,Plateau p)
	{
		super(x,y,p);
		
	}
	public int getniveau()
	{
		return niveau;
	}
	public abstract void am�liorer(Plateau p);
	public abstract boolean droitConstruire(Plateau p);
}
