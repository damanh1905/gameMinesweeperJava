package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelNotification extends JPanel {
	private JPanel p11,p12,p13;
	private LableNumber lbTime,lbBoom;
	private ButtonSmile buttonSmile;
	private GamePanel gamePanel;
	private Timer time; 
	private int nowTime;
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
			upDate();
			p12.add(lbTime=new LableNumber(this,"000"));
			time =new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					nowTime++;
					updatelbTime();
					
				}
			});
			p13.add(buttonSmile=new ButtonSmile(this));
			buttonSmile.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					buttonSmile.setStage(buttonSmile.now);
					buttonSmile.repaint();
					int option = JOptionPane.showConfirmDialog(null,"are you play new game?","notification",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						gamePanel.getGameFrame().setVisible(false);
						new gameFrame(gamePanel.getW(), gamePanel.getH(),gamePanel.getBoom());
					}
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					buttonSmile.setStage(buttonSmile.press);
					buttonSmile.repaint();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	}
	public void updatelbTime() {
		if(nowTime > 999) {
			lbTime.setNumber("vocung");
		}else {
			String cTime = String.valueOf(nowTime);
			if(cTime.length() ==1 ) { 
				lbTime.setNumber("00"+ nowTime);
				
			}else if(cTime.length() ==2) {
				lbTime.setNumber("0"+ nowTime);
				
			}else {
				lbTime.setNumber("0"+ nowTime);
			}
			lbTime.repaint();
		}
		
	}
	public void upDate() {
		String number = String .valueOf(gamePanel.getBoom()- gamePanel.getWorld().getCo());
		if(number.length() ==1 ) { 
			lbBoom.setNumber("00"+ number);
			
		}else if(number.length() ==2) {
			lbBoom.setNumber("0"+ number);
			
		}else {
			lbBoom.setNumber("0"+ number);
		}
		lbBoom.repaint();
		
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	public Timer getTime() {
		return time;
	}
	public void setTime(Timer time) {
		this.time = time;
	}
	public ButtonSmile getButtonSmile() {
		return buttonSmile;
	}
	public void setButtonSmile(ButtonSmile buttonSmile) {
		this.buttonSmile = buttonSmile;
	}

}
