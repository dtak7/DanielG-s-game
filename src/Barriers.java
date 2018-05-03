import java.awt.Graphics;
import java.awt.Color;


public class Barriers {
int barrierX=200;
int barrierY=280;


void draw (Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(barrierX, barrierY, 70, 300);
	
}
}
