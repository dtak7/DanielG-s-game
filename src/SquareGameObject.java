import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SquareGameObject {
	
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox;
	
	public SquareGameObject(int x, int y, int width, int height) {
		collisionBox = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
	//	g.setColor(Color.red);
		g.drawRect(x, y, width, height);
	}
	
}

