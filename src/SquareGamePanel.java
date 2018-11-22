import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SquareGamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int WINNING_STATE = 3;
	final int INFO_STATE = 4;
	ArrayList<Barriers> barriers = new ArrayList<Barriers>();
	ArrayList<MovingBarrier> movingBarriers = new ArrayList<MovingBarrier>();
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font infoFont = new Font("Arial", Font.PLAIN, 20);
	Square square = new Square(20, 100);
	Timer timer = new Timer(1000 / 60, (ActionListener) this);
	Border border = new Border(0, 0, 0, 700);
	Timer borderTimer;
	/*
	 * Barriers barrier4 = new Barriers(580, 130, 50, 25); Barriers barrier5 = new
	 * Barriers(540, 230, 50, 25); Barriers barrier6 = new Barriers(620, 330, 50,
	 * 25);
	 */
	Lander lander = new Lander(600, 500, 75, 75);
	AudioClip sound = JApplet.newAudioClip(getClass().getResource("cheerfulSong.wav"));
	AudioClip sound2 = JApplet.newAudioClip(getClass().getResource("explosion.wav"));

	SquareGamePanel() {
		timer.start();
		setBorderTimer();
		barriers.add(new Barriers(90, 120, 50, 700));
		barriers.add(new Barriers(190, 0, 240, 470));
		barriers.add(new Barriers(480, 120, 50, 490));
		movingBarriers.add(new MovingBarrier(580, 130, 55, 25));
		movingBarriers.add(new MovingBarrier(540, 250, 55, 25));
		movingBarriers.add(new MovingBarrier(620, 380, 55, 25));
	}

	void setBorderTimer() {
		// borderTimer.stop();
		borderTimer = new Timer(100, (border));
		// borderTimer.start();

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);

		} else if (currentState == GAME_STATE) {
			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);
		} else if (currentState == WINNING_STATE) {
			drawWinningState(g);

		} else if (currentState == INFO_STATE) {
			drawInfoState(g);
		}

	}

	void endGame() {
		if (!square.isAlive) {
			currentState = END_STATE;
		}
	}

	private void drawWinningState(Graphics g) {
		sound.stop();
		sound2.stop();
		g.drawString("You Won :o", 350, 300);
	}

	private void drawInfoState(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, SquareSurvivor.frameWidth, SquareSurvivor.frameHeight);
		g.setColor(Color.BLACK);
		g.setFont(infoFont);
		g.drawString("watch out for the border, don't dillydally", 250, 350);
		g.drawString("use arrow keys to move (down is an arrow too)", 250, 400);
		g.drawString("you can press more than one key at once", 250,425);
		g.drawString("enter to restart", 250, 450);
		g.drawString("hit ENTER to proceed to the game", 250, 500);
		g.drawString("if things get rough hit O", 250, 550);
		g.setFont(null);
		g.drawString("cheater", 0, 575);
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

		borderTimer.start();
		sound2.play();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 600);
		square.draw(g);
		for (Barriers b : barriers) {
			b.draw(g);
		}
		for (MovingBarrier m : movingBarriers) {
			m.draw(g);
		}
		lander.draw(g);
		border.draw(g);
		g.setFont(infoFont);
		String count = String.valueOf(border.countDown / 100);
		// count= count.substring(0, 4);
		g.drawString(count, SquareSurvivor.frameWidth - 650, 20);

	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		square.restartSquare();

		sound.stop();
		sound.play();
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 600);
		g.setColor(Color.GRAY);
		g.setFont(titleFont);
		g.drawString("UFO Survivor", 250, 300);
		g.setFont(infoFont);
		g.drawString("hit CONTROL to see further instructions", 300, 450);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyCode());
		// TODO Auto-generated method stub

		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {

				square.restartSquare();
				// square = new Square(20, 100);
				border.width = 0;
				border.resetCountdown();
				border.isActive = false;

				currentState = MENU_STATE;
				// System.out.println(currentState);

			}
		} else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			currentState = 4;

		}
		// moving code
		else {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				square.isRight = true;
				// square.isMoving=trplayue;

			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				square.isLeft = true;
				// square.isMoving=true;-

			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				square.isUp = true;
				square.isMoving = true;

			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				square.isDown = true;
				// square.isMoving = true;

			}
			if (e.getKeyCode() == KeyEvent.VK_O) {
				square.x = 600;
				square.y = 450;
			}

			if (currentState == GAME_STATE) {
				checkCollision();
				checkBounds();
			}

		}
		// repaint();
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
		for (MovingBarrier m : movingBarriers) {
			m.update();
		}
		square.update();
		border.update();
		for (Barriers b : barriers) {

			if (square.collisionBox.intersects(b.collisionBox)) {
				// System.out.println("death");
				square.isAlive = false;
				endGame();

			}
		}
		if (square.collisionBox.intersects(lander.collisionBox)) {
			currentState = WINNING_STATE;
			square.goFaster();
			square.setSquare();
		}
		if (border.isActive && square.collisionBox.intersects(border.collisionBox)) {
			square.isAlive = false;
			endGame();

		}
		for (MovingBarrier m : movingBarriers) {

			if (square.collisionBox.intersects(m.collisionBox)) {
				square.isAlive = false;
				endGame();

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			square.isRight = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			square.isLeft = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			square.isUp = false;
			square.isMoving = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			square.isDown = false;
		}
		// repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Timer
		square.move();
		square.drop();
		borderTimer.start();
		for (MovingBarrier m : movingBarriers) {
			m.move();
		}
		checkCollision();
		repaint();

	}
}
