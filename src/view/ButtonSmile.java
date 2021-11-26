package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonSmile  extends JButton {
	private PanelNotification notification;
	public ButtonSmile(PanelNotification notification) {
		this.notification=notification;
		setPreferredSize(new Dimension(50,50));
	}
@Override
public void paint(Graphics g) {
	g.drawImage(notification.getGamePanel().getGameFrame().getData().getListImage().get("Smile"),0,0,getPreferredSize().width, getPreferredSize().height,null);
}
}
