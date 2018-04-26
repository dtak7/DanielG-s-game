import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SquareGamePanel extends JPanel implements KeyListener{
	Square square = new Square();
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = GAME_STATE;
	boolean isMoving=false;
	

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
		
	}

	private void drawGameState(Graphics g) {
		// TODO Auto-generated method stub
		square.draw(g);
	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		// TODO Auto-generated method stub
		isMoving=true;
		if(isMoving) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				square.squareX++;
				repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	}

