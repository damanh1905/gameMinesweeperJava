package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPlayer extends JPanel {
	private ButtonPlayer[][] arrayButton;
	private GamePanel gamePanel;
	public PanelPlayer( GamePanel gamePanel) {
		this.gamePanel=gamePanel;
	
		setLayout(new GridLayout(gamePanel.getW(),gamePanel.getH()));
	this.arrayButton=gamePanel.getWorld().getArrayButton(); 
		setBorder(BorderFactory.createLoweredBevelBorder());
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				add(arrayButton[i][j]=new ButtonPlayer(this));
				arrayButton[i][j].addMouseListener(gamePanel);
			}
		}
		
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	public ButtonPlayer[][] getArrayButton() {
		return arrayButton;
	}
	public void setArrayButton(ButtonPlayer[][] arrayButton) {
		this.arrayButton = arrayButton;
	}
	
}
