import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SquareGamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int WINNING_STATE = 3;
	ArrayList<Barriers> barriers = new ArrayList<Barriers>();
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Square square = new Square(20, 100, 25, 25);
	Timer timer = new Timer(1000 / 60, (ActionListener) this);
	Barriers barrier = new Barriers(90, 120, 50, 700);
	Barriers barrier2 = new Barriers(190, 0, 240, 470);
	Barriers barrier3 = new Barriers(480,120,50,490);
	Barriers barrier4 = new Barriers(580,130,50,25);
	Barriers barrier5 = new Barriers(540,230,50,25);
	Barriers barrier6 = new Barriers(620,330,50,25);
	Lander lander = new Lander(600, 500, 50, 50);

	SquareGamePanel() {
		timer.start();
		barriers.add(barrier);
		barriers.add(barrier2);
		barriers.add(barrier3);
		barriers.add(barrier4);
		barriers.add(barrier5);
		barriers.add(barrier6);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);

		} else if (currentState == GAME_STATE) {
			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);
		}else if(currentState==WINNING_STATE) {
			drawWinningState(g);
		}
		
	}

	void endGame() {
		if (!square.isAlive) {
			currentState = END_STATE;
		}
	}
	private void drawWinningState(Graphics g) {
		g.drawString("You Won :o", 350, 300);
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 600);
		square.draw(g);
		for (Barriers b : barriers) {
			b.draw(g);
		}
		lander.draw(g);
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
			if (currentState > END_STATE) {

				square = new Square(20, 100, 25, 25);

				currentState = MENU_STATE;
				System.out.println(currentState);
				repaint();
			}
		}
		// moving code

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			square.x += 3;
			// square.isMoving=true;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			square.x -= 3;
			// square.isMoving=true;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			square.y -= 3;
			square.isMoving = true;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			square.y += 3;
			square.isMoving = true;
			repaint();
		}

		if (currentState == GAME_STATE) {
			checkCollision();
			checkBounds();
		}
	}

	void checkBounds() {
		square.update();
		for (Barriers b : barriers) {
			b.update();
		}
		if (square.x >= 700 || square.x <= 0 || square.y >= 595 || square.y <= 0) {
			square.isAlive = false;
			endGame();
		}
	}

	void checkCollision() {
		for (Barriers b : barriers) {
			b.update();
		}
		square.update();
		for (Barriers b : barriers) {

			if (square.collisionBox.intersects(b.collisionBox)) {
				// System.out.println("death");
				square.isAlive = false;
				endGame();

			}
		}
		if (square.collisionBox.intersects(lander.collisionBox)) {
			currentState=WINNING_STATE;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			square.isMoving = false;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			square.isMoving = false;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			square.isMoving = false;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			square.isMoving = false;
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Timer

		square.drop();
		checkCollision();
		repaint();

	}
}
