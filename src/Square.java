import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Square  {
	int squareX = 100;
	int squareY = 100;
	
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(squareX, squareY, 50, 50);	
	}


}
