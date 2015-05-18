package theOnlyPackage;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatchphraseGUI extends JFrame implements ActionListener {

	/** Title of window */
	private static final String TITLE = "Catch Phrase";

	/** Frame Dimensions */
	private static final int WIDTH = 1250;
	private static final int HEIGHT = 400;

	/** Button labels */
	private static final String ADD_SCORE_1 = "Team 1+";
	private static final String ADD_SCORE_2 = "Team 2+";
	private static final String DECREASE_SCORE_1 = "Team 1-";
	private static final String DECREASE_SCORE_2 = "Team 2-";

	/** Buttons */
	private JButton btnAddOne = new JButton(ADD_SCORE_1);
	private JButton btnAddTwo = new JButton(ADD_SCORE_2);
	private JButton btnDecreaseOne = new JButton(DECREASE_SCORE_1);
	private JButton btnDecreaseTwo = new JButton(DECREASE_SCORE_2);

	/** JPanels */
	private JPanel panel = new JPanel(new GridBagLayout());

	/**
	 * In case file is not loaded
	 */
	public CatchphraseGUI() {
		setUpGUI();

	}

	private void setUpGUI() {
		setTitle(TITLE);
		Container c = getContentPane();
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.add(panel);

		setVisible(true);

	}

	/**
	 * Used if file name pre-specified
	 * 
	 * @param sc
	 */
	public CatchphraseGUI(Scanner sc) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new CatchphraseGUI();
	}

}
