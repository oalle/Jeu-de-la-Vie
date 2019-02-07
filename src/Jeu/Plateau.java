package Jeu;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Plateau 
{
	private MonPanneau p;
	final int nbcase=20;
	protected int nbpersonne;
	protected int nbbois;
	protected int nbpierre;
	protected int nbminerai;
	protected int stock;
	protected int popmax;
	protected int valrecoltebois;
	protected int valrecolteminerai;
	protected int valrecoltepierre;
	int urbain=0;
	ArrayList<Mairie> tabMairie;
	ArrayList<Entrepot> tabEntrepot;
	 ArrayList<Scierie> tabScierie;
	ArrayList<Carriere> tabCarriere;
	ArrayList<Mine> tabMine;
	 ArrayList<Personnage> tabPersonnage;
	String Plateau[][];
	
	public Plateau() 
	{
		Plateau =new String [nbcase][nbcase];
		for(int x=0;x<nbcase;x++)
		{
			for(int y=0;y<nbcase;y++)
			{
				if(x==0||x==nbcase-1||y==nbcase-1||y==0)
				{
					Plateau[x][y]="D";
				}
				else
				{
					Plateau[x][y]="0";
				}
				if(x==0&&y==1)
				{
					Plateau[x][y]="B";
				}
				if(x==0&&y==2)
				{
					Plateau[x][y]="P";
				}
				if(x==0&&y==3)
				{
					Plateau[x][y]="M";
				}
			}
		}
	}
	
	public String[][] getPlateau()
	{
		return Plateau;
	}
	public String getPos(int x,int y)
	{
		return Plateau[x][y];
	}
	public void setPlateau(int x,int y,String s)
	{
		Plateau[x][y]=s;
	}
	
}
