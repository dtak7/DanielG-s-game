import java.awt.Graphics;
import java.awt.Color;


public class Barriers extends SquareGameObject{


public Barriers(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}


void draw (Graphics g){
	super.draw(g);
	g.setColor(Color.BLUE);
	g.fillRect(x, y, 70, 300);
	
}
}
