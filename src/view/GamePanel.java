package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.World;

public class GamePanel extends JPanel implements MouseListener {

	private World world;
	private PanelNotification notification;
	private PanelPlayer panelPlayer;
	private gameFrame gameFrame;

	private int w, h, boom;

	public GamePanel(int w, int h, int boom, gameFrame gameFrame) {
		this.w = w;
		this.h = h;
		this.boom = boom;
		this.gameFrame = gameFrame;
		world = new World(w, h, boom, this);
		setLayout(new BorderLayout(20, 20));

		add(notification = new PanelNotification(this), BorderLayout.NORTH);

		add(panelPlayer = new PanelPlayer(this), BorderLayout.CENTER);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		ButtonPlayer[][] arrayButton = panelPlayer.getArrayButton();
		getNotification().getButtonSmile().setStage(ButtonSmile.wow);
		getNotification().getButtonSmile().repaint();
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				if (e.getSource() == arrayButton[i][j] && e.getButton() == 1 && !world.getArrayCamCo()[i][j]) {
					if (!getNotification().getTime().isRunning()) {
						getNotification().getTime().start();
					}
					if (!world.open(i, j)) {
						if (world.isComplete()) {
							getNotification().getTime().stop();
							getNotification().getButtonSmile().setStage(ButtonSmile.lose);
							getNotification().getButtonSmile().repaint();
							int option = JOptionPane.showConfirmDialog(this, "You lose,play again?", "notification",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								gameFrame.setVisible(false);
								new gameFrame(w, h, boom);
							} else {
								world.fullTrue();
							}

						} else if (world.isEnd()) {
							getNotification().getButtonSmile().setStage(ButtonSmile.win);
							getNotification().getButtonSmile().repaint();
							int option = JOptionPane.showConfirmDialog(this, "You win,play again?", "notification",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								gameFrame.setVisible(false);
								new gameFrame(w, h, boom);
							}
						}
					}
				} else if (e.getSource() == arrayButton[i][j] && e.getButton() == 3) {
					world.camCo(i, j);
				}
				if (e.getSource() == arrayButton[i][j] && e.getClickCount() == 2 && world.getArrayBoolean()[i][j]) {
					getNotification().getTime().stop();
					if (!world.doubleClick(i, j)) {
						int option = JOptionPane.showConfirmDialog(this, "You lose,play again?", "notification",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							gameFrame.setVisible(false);
							new gameFrame(w, h, boom);
						} else {
							world.fullTrue();
						}
					}

				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		getNotification().getButtonSmile().setStage(ButtonSmile.now);
		getNotification().getButtonSmile().repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public gameFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(gameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public int getBoom() {
		return boom;
	}

	public void setBoom(int boom) {
		this.boom = boom;
	}

	public PanelNotification getNotification() {
		return notification;
	}

	public void setNotification(PanelNotification notification) {
		this.notification = notification;
	}

	public PanelPlayer getPanelPlayer() {
		return panelPlayer;
	}

	public void setPanelPlayer(PanelPlayer panelPlayer) {
		this.panelPlayer = panelPlayer;
	}

}
