import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SquareGamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Square square = new Square();
	Timer timer = new Timer(1000 / 60, (ActionListener) this);
	Barriers barrier = new Barriers();

	SquareGamePanel() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);

		} else if (currentState == GAME_STATE) {
			drawGameState(g);

		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 700, 600);
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("Game Over :D", 100, 100);
		g.drawString("This window is happy", 10, 200);
		g.drawString("so you don't get mad ;)", 10, 300);
	}

	private void drawGameState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 700, 600);
		square.draw(g);
		barrier.draw(g);
	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 600);
		g.setColor(Color.GRAY);
		g.drawString("Square Survivor", 300, 300);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyCode());
		// TODO Auto-generated method stub

		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState == 3) {
				currentState = 0;
			}
			System.out.println(currentState);
			repaint();
		}

		// moving code

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			square.squareX += 3;
			square.isMoving=true;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			square.squareX -= 3;
			square.isMoving=true;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			square.squareY -= 3;
			square.isMoving=true;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			square.squareY += 3;
			square.isMoving=true;
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		 if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			square.isMoving=false;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			square.isMoving=false;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			square.isMoving=false;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			square.isMoving=false;
			repaint();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Timer

		square.drop();
		repaint();
		
	}
}
