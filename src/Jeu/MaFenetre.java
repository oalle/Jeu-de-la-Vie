package Jeu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MaFenetre extends JFrame 
{
	private MonPanneau pan;
	private MonPanneau2 pan2;
	private Plateau plat;
	
	private int cpt=0;
	private int a=2;
	private int b=2;
	public MaFenetre(String s, int x, int y, int largeur, int hauteur)
	{
		plat=new Plateau();
		pan2=new MonPanneau2();
		
		JButton Strat1=new JButton("Rurale");
		JButton Strat2=new JButton("Urbain");
		pan2.add(Strat2);
		pan2.add(Strat1);
		MonBouton r=new MonBouton(this,plat,"Rurale");
		Strat1.addActionListener(r);
		MonBouton u=new MonBouton(this,plat,"Urbain");
		Strat2.addActionListener(u);
		setBounds(x, y, largeur, hauteur);
		setTitle(s);
		add(pan2);
	}
	public MaFenetre(String s, int x, int y, int largeur, int hauteur,Plateau plat) throws InterruptedException 
	{
		this.plat=plat;
		pan=new MonPanneau(plat);
		setTitle(s);
		plat.tabMairie=new ArrayList<>();
		plat.tabEntrepot=new ArrayList<>();
		plat.tabScierie=new ArrayList<>();
		plat.tabCarriere=new ArrayList<>();
		plat.tabMine=new ArrayList<>();
		plat.tabPersonnage=new ArrayList<>();
		setBounds(x, y, largeur, hauteur);		
		Mairie m=new Mairie(10,10,plat);
		plat.tabMairie.add(m);
		Entrepot e=new Entrepot(12,12,plat);
		plat.tabEntrepot.add(e);
		Adulte p1=new Adulte(2,2,plat);
		Adulte p2=new Adulte(2,2,plat);
		Enfant e1=new Enfant (2,2,plat);
		plat.tabPersonnage.add(p2);
		plat.tabPersonnage.add(p1);
		plat.tabPersonnage.add(e1);
		add(pan);
		pan.misajour(plat);
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		if (cpt!=500)
		{
		    executorService.scheduleAtFixedRate(new Runnable() {
		        @Override
		        public void run() {
		            jouer();
		            cpt++;
		        }
		    }, 1, 3, TimeUnit.SECONDS);
		}
	}
	public void jouer()
	{
		
		if(plat.popmax<plat.nbpersonne+2&&TestConstr()&&droitConstruire(30-plat.urbain,30-plat.urbain,30-plat.urbain))
		{
			boolean stop=true;
			for(Mairie m:plat.tabMairie)
			{
				if(m.getniveau()!=3)
				{
					m.améliorer(plat);
					stop=false;
					plat.nbbois-=30-plat.urbain;
					plat.nbminerai-=30-plat.urbain;
					plat.nbpierre-=30-plat.urbain;
				}
			}
			
			for(Personnage p:plat.tabPersonnage)
			{
				if(p.mission==false&&stop)
				{
					stop=false;
					p.mission=true;
					p.déplacer(a,b-1);
					p.construire("Mairie", a, b,plat);
					plat.nbbois-=30-plat.urbain;
					plat.nbminerai-=30-plat.urbain;
					plat.nbpierre-=30-plat.urbain;
				}
			}
		}
		if((plat.stock*0.9<plat.nbminerai||plat.stock*0.9<plat.nbbois||plat.stock*0.9<plat.nbpierre)&&TestConstr()&&droitConstruire(20-plat.urbain,20-plat.urbain,20-plat.urbain))
		{
			boolean stop=true;
			for(Entrepot e:plat.tabEntrepot)
			{
				if(e.getniveau()!=3)
				{
					e.améliorer(plat);
					stop=false;
					plat.nbbois-=20-plat.urbain;
					plat.nbminerai-=20-plat.urbain;
					plat.nbpierre-=20-plat.urbain;
				}
			}
			for(Personnage p:plat.tabPersonnage)
			{
				if(p.mission==false&&stop)
				{
					stop=false;
					p.mission=true;
					p.déplacer(a,b-1);
					p.construire("Entrepot", a, b,plat);
					plat.nbbois-=20-plat.urbain;
					plat.nbminerai-=20-plat.urbain;
					plat.nbpierre-=20-plat.urbain;
				}
			}
		}
		if(plat.valrecoltebois<=plat.valrecolteminerai&&plat.valrecoltebois<=plat.valrecoltepierre&&TestConstr()&&droitConstruire(10-plat.urbain,30-plat.urbain,50-plat.urbain))
		{
			boolean stop=true;
			for(Scierie e:plat.tabScierie)
			{
				if(e.getniveau()!=3)
				{
					e.améliorer(plat);
					stop=false;
					plat.nbbois-=10-plat.urbain;
					plat.nbminerai-=50-plat.urbain;
					plat.nbpierre-=30-plat.urbain;
				}
			}
			for(Personnage p:plat.tabPersonnage)
			{
				if(p.mission==false&&stop)
				{
					stop=false;
					p.mission=true;
					p.déplacer(a,b-1);
					p.construire("Scierie", a, b,plat);
					plat.nbbois-=10-plat.urbain;
					plat.nbminerai-=50-plat.urbain;
					plat.nbpierre-=30-plat.urbain;
				}
			}
		}
		else if(plat.valrecoltepierre<plat.valrecolteminerai&&plat.valrecoltepierre<plat.valrecoltebois&&TestConstr()&&droitConstruire(50-plat.urbain,10-plat.urbain,30-plat.urbain))
		{
			boolean stop=true;
			for(Carriere e:plat.tabCarriere)
			{
				if(e.getniveau()!=3)
				{
					e.améliorer(plat);
					stop=false;
					plat.nbbois-=50-plat.urbain;
					plat.nbminerai-=30-plat.urbain;
					plat.nbpierre-=10-plat.urbain;
				}
			}
			for(Personnage p:plat.tabPersonnage)
			{
				if(p.mission==false&&stop)
				{
					stop=false;
					p.mission=true;
					p.déplacer(a,b-1);
					p.construire("Carriere", a, b,plat);
					plat.nbbois-=50-plat.urbain;
					plat.nbminerai-=30-plat.urbain;
					plat.nbpierre-=10-plat.urbain;
				}
			}
		}
		else if(TestConstr()&&droitConstruire(30-plat.urbain,50-plat.urbain,10-plat.urbain))
		{
			boolean stop=true;
			for(Mine e:plat.tabMine)
			{
				if(e.getniveau()!=3)
				{
					e.améliorer(plat);
					stop=false;
					plat.nbbois-=30-plat.urbain;
					plat.nbminerai-=10-plat.urbain;
					plat.nbpierre-=50-plat.urbain;
				}
			}
			for(Personnage p:plat.tabPersonnage)
			{
				if(p.mission==false&&stop)
				{
					stop=false;
					p.mission=true;
					p.déplacer(a,b-1);
					p.construire("Mine", a, b,plat);
					plat.nbbois-=30-plat.urbain;
					plat.nbminerai-=10-plat.urbain;
					plat.nbpierre-=50-plat.urbain;
				}
			}
		}
		if (plat.nbpersonne<plat.popmax&&Testperso())
		{
			int index1=0;
			boolean vrai=true;
			while(index1<plat.tabPersonnage.size()&&vrai)
			{
				if(plat.tabPersonnage.get(index1).mission==false)
				{
					plat.tabPersonnage.get(index1).mission=true;
					int index2=index1;
					while(index2<plat.tabPersonnage.size()&&vrai)
					{
						if(plat.tabPersonnage.get(index2).mission==false)
						{
							plat.tabPersonnage.get(index2).mission=true;
							plat.tabPersonnage.get(index2).déplacer(a,b);
							plat.tabPersonnage.get(index1).déplacer(a,b);
							
							vrai=false;
							
						}
						else
							index2++;
					}
				}
				else
					index1++;
			}
			Enfant e=new Enfant(a,b,plat);
			plat.tabPersonnage.add(e);
		}
		int compteur=0;
		for(Personnage p:plat.tabPersonnage)
		{
			
			if (compteur<2)
			{
				if(p.mission==false)
				{
					compteur++;
				}
				else
				{
					
					if (p.getClass()==plat.tabPersonnage.get(0).getClass())
						p.mission=false;
					else
					{
						p.incremente();
						if(p.age==5)
						{
							plat.tabPersonnage.set(plat.tabPersonnage.indexOf(p), p.passageadulte(plat));
						}
						p.mission=true;
					}
				}
			}
			else
			{
				if(p.mission==false)
				{
					if(plat.valrecoltebois<=plat.valrecolteminerai&&plat.valrecoltebois<=plat.valrecoltepierre&&Testperso())
					{
						p.récolter(1,1);
					}
					else if(plat.valrecoltebois>plat.valrecolteminerai&&plat.valrecolteminerai<plat.valrecoltepierre&&Testperso())
					{
						p.récolter(1,3);
					}
					else if(plat.valrecoltepierre<plat.valrecolteminerai&&plat.valrecoltebois>plat.valrecoltepierre&&Testperso())
					{
						p.récolter(1,2);
					}
					else if(Testperso())
					{
						p.récolter(1,2);
					}
				}
				else
				{
					
					if (p.getClass()==plat.tabPersonnage.get(0).getClass())
						p.mission=false;
					else
					{
						p.incremente();
						if(p.age==5)
						{
							plat.tabPersonnage.set(plat.tabPersonnage.indexOf(p), p.passageadulte(plat));
						}
						p.mission=true;
					}
				}
			}
		}
		if(plat.nbpierre+plat.valrecoltepierre>plat.stock)
			plat.nbpierre=plat.stock;
		else
			plat.nbpierre=plat.nbpierre+plat.valrecoltepierre;
		
		if(plat.nbminerai+plat.valrecolteminerai>plat.stock)
			plat.nbminerai=plat.stock;
		else
			plat.nbminerai=plat.nbminerai+plat.valrecolteminerai;
		if(plat.nbbois+plat.valrecoltebois>plat.stock)
			plat.nbbois=plat.stock;
		else
			plat.nbbois=plat.nbbois+plat.valrecoltebois;
	
		pan.misajour(plat);
	}
	public boolean TestCase(int x,int y)
	{
		String[][] tabs=plat.getPlateau();
		if(tabs[x][y]=="0"&&tabs[x+1][y]=="0"&&tabs[x][y+1]=="0"&&tabs[x+1][y+1]=="0"&&tabs[x][y-1]=="0")
			return true;
		else
			return false;
	}
	public boolean TestConstr()
	{
		boolean m=false;
		for(int x=2;x<plat.nbcase;x++)
		{
			for(int y=2;y<plat.nbcase;y++)
			{
				m=TestCase(x,y);
				if (m==true)
				{
					this.a=x;
					this.b=y;
					return m;
				}
			}
		}
		return m;
	}
	public boolean Testperso()
	{
		boolean m=false;
		String[][] tabs=plat.getPlateau();
		for(int x=2;x<plat.nbcase;x++)
		{
			for(int y=0;y<plat.nbcase;y++)
			{
				m=tabs[x][y]=="0";
				if (m==true)
				{
					this.a=x;
					this.b=y;
					return m;
				}
			}
		}
		return m;
	}
	public boolean droitConstruire(int valboix,int valpierre,int valminerai)
	{
		if(plat.nbminerai<valminerai||plat.nbbois<valboix||plat.nbpierre<valpierre)
			return false;
		else
			return true;
	}
}
