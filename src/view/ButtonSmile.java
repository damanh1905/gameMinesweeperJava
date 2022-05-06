package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonSmile extends JButton {
	public static final int win = 0;
	public static final int lose = 1;
	public static final int press = 2;
	public static final int wow = 3;
	public static final int now = 4;
	private int stage;
	private PanelNotification notification;

	public ButtonSmile(PanelNotification notification) {
		this.notification = notification;
		setPreferredSize(new Dimension(50, 50));
		this.stage = now;
	}

	@Override
	public void paint(Graphics g) {
		switch (stage) {
		case win:
			g.drawImage(notification.getGamePanel().getGameFrame().getData().getListImage().get("SmileWin"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case lose:
			g.drawImage(notification.getGamePanel().getGameFrame().getData().getListImage().get("SmileLose"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case press:
			g.drawImage(notification.getGamePanel().getGameFrame().getData().getListImage().get("SmilePress"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case wow:
			g.drawImage(notification.getGamePanel().getGameFrame().getData().getListImage().get("SmilePressPlay"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case now:
			g.drawImage(notification.getGamePanel().getGameFrame().getData().getListImage().get("Smile"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		default:
			break;
		}
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
	
}
