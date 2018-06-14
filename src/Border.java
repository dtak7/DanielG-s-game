import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Border extends SquareGameObject implements ActionListener {
	boolean isActive = false;
	
	float countDown= 500;
	public Border(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void draw(Graphics g) {
		if (isActive) {
			super.draw(g);
			g.setColor(Color.magenta);
			g.fillRect(x, y, width, height);
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
		System.out.println("active");
		isActive = true;
		}
		else {
			countDown--;
		}
	}
}
