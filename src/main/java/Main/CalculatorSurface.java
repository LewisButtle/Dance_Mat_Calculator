package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CalculatorSurface extends Surface {

	public CalculatorSurface() {
	}

	@Override
	public void keyPressed(KeyEvent e){
		switch(e.getKeyChar()) {
			case '2': 
				Main.changeCard("calculator");
				break;
			case '3': 
				Main.changeCard("float");
				break;
			case '4': 
				Main.changeCard("speed");
				break;
			case '5': 
				Main.changeCard("score");
				break;

		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();
		//rectangles
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, w, h);
		g2d.setPaint(Color.blue);
		g2d.fillRect(0, h-100, w, 100);
		g2d.fillRect(0, 0, w, 100);
		g2d.setPaint(Color.green);
		g2d.fillRect(0, h-200, w, 100);
		g2d.fillRect(0, 100, w, 100);
		g2d.setPaint(Color.red);
		g2d.fillRect(0, h-300, w, 100);
		g2d.fillRect(0, 200, w, 100);

		//Expression Box
		BasicStroke bs1 = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs1);
		g2d.setColor(new Color(247, 245, 116));
		g2d.fillRect(w/2-700, h/2-75, 1300, 150);
		g2d.setPaint(Color.black);
		g2d.drawRect(w/2-700, h/2-75, 1300, 150);

		//Text
		g2d.setFont(new Font("Ebrima Bold", Font.PLAIN, 80));
		g2d.drawString("EXPRESSION PLACEHOLDER", w/2-700, h/2+25);

		g2d.setFont(new Font("Ebrima Bold", Font.PLAIN, 20));
		g2d.setPaint(new Color(0, 204, 255));
		g2d.drawString("Press 'Start' to return to Main Menu", 5, 20);

		g2d.dispose();
	}


}