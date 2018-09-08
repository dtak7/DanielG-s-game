import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MovingBarrier extends SquareGameObject {
	public BufferedImage shipImg;
int ogX;
int speed= 1;
	public MovingBarrier(int x, int y, int width, int height) {
		
		super(x, y, width, height);
		ogX=x;
		// TODO Auto-generated constructor stub
		try {

			shipImg = ImageIO.read(this.getClass().getResourceAsStream("ship.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			System.out.println("can't find ship image");

		}
	}

	void move() {
		x+=speed;
		if(x>=650||x<=530) {
			speed*=-1;
		}
	}

	void draw(Graphics g) {
	//	super.draw(g);
		if (shipImg == null) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		} else {
			g.drawImage(shipImg, x, y, width, height, null);
		}

	}
}
