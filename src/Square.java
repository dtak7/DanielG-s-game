import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Square extends SquareGameObject {

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	boolean isMoving = false;
	
	void drop() {
		if(!isMoving) {
		y++;
		}
	}
	void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 25, 25);	
	}

}
