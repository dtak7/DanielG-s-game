import javax.swing.JFrame;

public class SquareSurvivor {
	JFrame frame;
	Square square;
	SquareGamePanel panel;
	final static int frameWidth =700;
	final static int frameHeight=600;
	
	public static void main(String[] args) {
		SquareSurvivor squareSurvivor = new SquareSurvivor();
		squareSurvivor.setup();
		
	}

	void setup() {
		frame = new JFrame();
		panel = new SquareGamePanel();
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(frameWidth,frameHeight);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
