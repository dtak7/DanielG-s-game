import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;


public class Barriers extends SquareGameObject{

public BufferedImage laserImg;
public Barriers(int x, int y, int width, int height) {
		super(x, y, width, height);
		try {
			laserImg = ImageIO.read(this.getClass().getResourceAsStream("laser.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("laser image not found");
		}
	}


void draw (Graphics g){
	
	if(laserImg==null) {
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
	}
	else {
		g.drawImage(laserImg, x, y, width, height, null);
	}
	super.draw(g);
}
}
