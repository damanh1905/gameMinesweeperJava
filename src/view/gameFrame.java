package view;

import javax.swing.JFrame;

import model.loadData;

public class gameFrame extends JFrame {
	private loadData data;
	private GamePanel gamePanel;

	public gameFrame(int w,int h,int boom ) {
		add(gamePanel = new GamePanel(w, h, boom,this));
		setResizable(false);
		data = new loadData();
		setIconImage(data.getListImage().get("title"));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new gameFrame(9,9,10);
	}

	public loadData getData() {
		return data;
	}

	public void setData(loadData data) {
		this.data = data;
	}

}
