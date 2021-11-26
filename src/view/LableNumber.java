package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class LableNumber extends JLabel {
	private PanelNotification panelNotification;
	private String number;
	public LableNumber(PanelNotification panelNotification,String number) {
		this.panelNotification =panelNotification;
		this.number=number;
		setPreferredSize(new Dimension(78,46));
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(panelNotification.getGamePanel().getGameFrame().getData().getListImage().get(String.valueOf(number.charAt(0))), 0, 0,26,46, null);
		g.drawImage(panelNotification.getGamePanel().getGameFrame().getData().getListImage().get(String.valueOf(number.charAt(1))), 26, 0,26,46, null);
		g.drawImage(panelNotification.getGamePanel().getGameFrame().getData().getListImage().get(String.valueOf(number.charAt(2))), 52, 0,26,46, null);
	}
}
