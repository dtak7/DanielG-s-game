import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lander extends SquareGameObject {
	public BufferedImage PortalImg;
	public Lander(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		try {
			PortalImg = ImageIO.read(this.getClass().getResourceAsStream("Portal.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("portal image not found");
		}
	}

	void draw(Graphics g) {
		super.draw(g);
		if(PortalImg==null) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		}
		else {
			g.drawImage(PortalImg, x, y, width, height, null);
		}
	}
}
