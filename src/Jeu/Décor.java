package Jeu;

public class Décor 
{
	int pos_x;
	int pos_y;
	Décor(int x,int y,Plateau p)
	{
		this.pos_x=x;
		this.pos_y=y;
		p.setPlateau(x, y, "D");
	}
}
