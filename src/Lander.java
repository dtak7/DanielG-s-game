import java.awt.Color;
import java.awt.Graphics;

public class Lander extends SquareGameObject {

	public Lander(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

	}
}
