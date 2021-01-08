package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class FNumSurface extends Surface {

	ExpressionSetup expression;
	String exp;
	boolean gameStarted;

	public FNumSurface() {
		expression = new ExpressionSetup();
		exp = "";
		gameStarted = false;
		new Timer().scheduleAtFixedRate(new increment(), 0, 1000);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String input = String.valueOf(e.getKeyChar());
		if (!gameStarted) {
			switch(input) {
				case "b":
					expression.reset();
					exp = "";
					Main.changeCard("main");
				break;
				case "s":
				gameStarted = true;
				break;
			}
		}
		else {
			if (expression.check(input)) {
				exp = expression.add(input);
				repaint();
			}

			switch(input) {
				case "b":
					expression.reset();
					exp = "";
					repaint();
				break;
				case "s":
					expression.reset();
					exp = "";
					Main.changeCard("main");
				break;
			}
		}
	}

	public class increment extends TimerTask {
		@Override
		public void run() {
			System.out.println("hiya!!");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();

		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, w, h);
		g2d.setPaint(Color.blue);
		g2d.fillRect(0, 0, w, 50);
		g2d.setPaint(Color.green);
		g2d.fillRect(0, 50, w, 50);
		g2d.setPaint(Color.red);
		g2d.fillRect(0, 100, w, 50);

		BasicStroke bs1 = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs1);
		g2d.setColor(new Color(247, 245, 116));
		g2d.fillRect(w/2-500, 10, 1000, 125);
		g2d.setPaint(Color.black);
		g2d.drawRect(w/2-500, 10, 1000, 125);

		g2d.setFont(new Font("Ebrima Bold", Font.PLAIN, 80));
		g2d.drawString("TIMER", 25, 100);
		g2d.drawString(exp, 375, 100);
		g2d.drawString("SCORE", w-285, 100);
		

		g2d.dispose();
	}


}
