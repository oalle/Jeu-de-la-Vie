package Jeu;

public class D�cor 
{
	int pos_x;
	int pos_y;
	D�cor(int x,int y,Plateau p)
	{
		this.pos_x=x;
		this.pos_y=y;
		p.setPlateau(x, y, "D");
	}
}
