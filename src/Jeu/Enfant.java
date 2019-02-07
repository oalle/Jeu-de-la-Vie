package Jeu;

public class Enfant extends Personnage
{
	public Plateau p;
	
	public Enfant(int x,int y,Plateau p)
	{
		super(x,y,p);
		mission=true;
	}
	public void incremente()
	{
		age++;
	}
	public Adulte passageadulte(Plateau p)
	{
		int nb=Integer.parseInt( p.getPos(this.x,this.y));
		
		nb--;
		String s=String.valueOf(nb);
		p.setPlateau(this.x, this.y, s);
		p.nbpersonne--;
		Adulte a=new Adulte(x,y,p);
		return a;
	}
	@Override
	public void construire(String s, int x, int y,Plateau p) {
		
		
	}

	@Override
	public void déplacer(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void concevoir(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void récolter(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
