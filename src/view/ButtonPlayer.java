package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonPlayer extends JButton {
	private PanelPlayer panelPlayer;
	private int number;
	public ButtonPlayer(PanelPlayer panelPlayer) {
		this.number=-1;
		this.panelPlayer=panelPlayer;
		setPreferredSize(new Dimension(30,30));
	}
	@Override
	public void paint(Graphics g) {
		switch (number) {
		case -1:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("nouse"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 0:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b0"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 1:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b1"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 2:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b2"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 3:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b3"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 4:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b4"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 5:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b5"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 6:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b6"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 7:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b7"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
			break;
		case 8:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("b8"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
				break;
		case 9:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("co"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
				break;
		case 10:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("boom"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
				break;
		case 11:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("boomRed"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
				break;
		case 12:
			g.drawImage(panelPlayer.getGamePanel().getGameFrame().getData().getListImage().get("bommX"), 0, 0,getPreferredSize().width,getPreferredSize().height, null);
				break;
		default:
			break;
		}
		
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
