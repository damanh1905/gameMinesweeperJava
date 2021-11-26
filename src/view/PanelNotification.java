package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNotification extends JPanel {
	private JPanel p11,p12,p13;
	private LableNumber lbTime,lbBoom;
	private ButtonSmile buttonSmile;
	private GamePanel gamePanel;
	public PanelNotification(GamePanel gamePanel) {
		this.gamePanel=gamePanel;
		buttonSmile=gamePanel.getWorld().getButtonSmile();
		lbTime=gamePanel.getWorld().getLbTime();
		lbBoom=gamePanel.getWorld().getLbBoom();
		 setLayout(new BorderLayout());
		setBorder(BorderFactory.createLoweredBevelBorder());
		add(p11=new JPanel(),BorderLayout.WEST);
			add(p12=new JPanel(),BorderLayout.EAST);
			add(p13=new JPanel(),BorderLayout.CENTER);
			p11.add(lbBoom=new LableNumber(this,"000"));
			p12.add(lbTime=new LableNumber(this,"000"));
			p13.add(buttonSmile=new ButtonSmile(this));
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

}
