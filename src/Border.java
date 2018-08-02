import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Border extends SquareGameObject implements ActionListener {
	boolean isActive = false;
	public BufferedImage bordershipImg;
	float countDown= 500;
	public Border(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		try {
			bordershipImg = ImageIO.read(this.getClass().getResourceAsStream("bordership.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		System.out.println("image not found");
		}
	}
	
	void draw(Graphics g) {
		if (isActive) {
			super.draw(g);
			if(bordershipImg==null) {
			g.setColor(Color.magenta);
			g.fillRect(x, y, width, height);
		}
			else {
				g.drawImage(bordershipImg, x, y, width, height, null);
			}
	}
	}
	void update() {
		if(isActive) {
			super.update();
			width++;
		}
	}
	void resetCountdown() {	
	countDown=500;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(countDown==0) {
		//System.out.println("active");
		isActive = true;
		}
		else {
			countDown--;
		}
	}
}
