import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Square  {
	int squareX =20;
	int squareY =100;
	boolean isMoving = false;
	
	void drop() {
		squareY++;
	}
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(squareX, squareY, 50, 50);	
	}


}
