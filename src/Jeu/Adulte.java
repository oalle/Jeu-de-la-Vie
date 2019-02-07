package Jeu;

public class Adulte extends Personnage
{
	
	Plateau p;
	public Adulte(int x,int y,Plateau p)
	{
		super(x,y,p);
		mission=false;
		this.p=p;
	}
	public void déplacer(int x,int y)
	{
		int nb=Integer.parseInt( p.getPos(this.x,this.y));
		nb--;
		String s=String.valueOf(nb);
		
		p.setPlateau(this.x, this.y, s);
		
		int nb1=Integer.parseInt( p.getPos(x,y));
		nb1++;
		String s1=String.valueOf(nb1);
		p.setPlateau(x, y, s1);
		
		this.x=x;
		this.y=y;
	}
	public void récolter(int x,int y)
	{
		mission=true;
		String [][]tabs=p.getPlateau();
		this.déplacer(x, y);
		if(tabs[x-1][y]=="B")
			p.valrecoltebois+=2;
		if(tabs[x-1][y]=="P")
			p.valrecoltepierre+=2;
		if(tabs[x-1][y]=="M")
			p.valrecolteminerai+=2;
	}
	public void construire(String s,int x,int y,Plateau p)
	{
		
		
		
		if(s=="Mairie")
		{
			Mairie m=new Mairie(x,y,p);
			p.tabMairie.add(m);
		}
		else if(s=="Scierie")
		{
			Scierie s1=new Scierie(x,y,p);
			p.tabScierie.add(s1);
		}
		else if(s=="Mine")
		{
			Mine mi=new Mine(x,y,p);
			p.tabMine.add(mi);
		}
		else if(s=="Carriere")
		{
			Carriere c=new Carriere(x,y,p);
			p.tabCarriere.add(c);
		}
		else if(s=="Entrepot")
		{
			Entrepot e=new Entrepot(x,y,p);
			p.tabEntrepot.add(e);
		}
	}
	public void concevoir(int x,int y)
	{
		
	}
	@Override
	public Adulte passageadulte(Plateau p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void incremente() {
		// TODO Auto-generated method stub
		
	}
}
