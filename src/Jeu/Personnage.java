package Jeu;

public abstract class Personnage implements Cloneable
{
	boolean mission;
	public int x;
	public int y;
	public int age=0;
	public abstract Adulte passageadulte(Plateau p);
	public abstract void déplacer(int x,int y);
	public abstract void concevoir(int x,int y);
	public abstract void  construire(String s,int x,int y,Plateau p);
	public abstract void incremente();
	public Personnage(int x,int y,Plateau p)
	{
		this.x=x;
		this.y=y;
		int nb=Integer.parseInt( p.getPos(x,y));
		nb++;
		String s=String.valueOf(nb);
		p.nbpersonne=p.nbpersonne+1;
		p.setPlateau(x, y, s);
	}
	public abstract void récolter(int x,int y);
}
