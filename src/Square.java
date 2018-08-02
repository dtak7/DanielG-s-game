import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Square extends SquareGameObject {
	public BufferedImage UFOImg;
boolean isMoving = false;
//SquareGamePanel panel = new SquareGamePanel();
boolean isUp,isDown,isLeft,isRight=false;
private int speedVar = 1;
private int speed=speedVar;



	public Square(int x, int y) {
		
		super(x, y, 40, 40);
		// TODO Auto-generated constructor stub
		try {

			UFOImg = ImageIO.read(this.getClass().getResourceAsStream("UFO.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			System.out.println("can't find UFO image");

		}
	}
		void restartSquare() {
			x=20;
			y=100;
			
		}
	void goFaster() {
		speed+=1;
		System.out.println("faster " +speed);
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	void move() {
		if(isUp) {
			y-=speed;
		}
		if(isDown) {
			y+=speed;
		}
		if(isLeft) {
			x-=speed;
			
		}
		if(isRight) {
			x+=speed;
			//System.out.println(x+","+speed);
		}
	}
	void drop() {
		if (!isMoving) {
			y++;
		}
	}

	void draw(Graphics g) {

		super.draw(g);
		if(UFOImg==null) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		}
		else {
			g.drawImage(UFOImg, x, y, width, height, null);
		}
	}

}
