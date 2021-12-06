package control;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;

import view.ButtonPlayer;
import view.ButtonSmile;
import view.LableNumber;

public class World {
	private Random rd;
	private ButtonPlayer[][] arrayButton;
	private int[][] arrayBoom;// boom la so -1
	private boolean isComplete;
	private boolean [][] arrayBoolean;
	private ButtonSmile buttonSmile;
	private LableNumber lbTime, lbBoom;

	public World(int w, int h, int boom) {
		arrayButton = new ButtonPlayer[w][h];
		arrayBoom = new int[w][h];
		arrayBoolean=new boolean[w][h];
		rd = new Random();
		createArrayMin(w, h, boom);
		demso();
		System.out.println(boom);
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				System.out.print(arrayBoom[i][j] + " ");
			}
			System.out.println();
		}

	}
	public void fullTrue() {
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if(!arrayBoolean[i][j]) {
					arrayBoolean[i][j]=true;
				}
			}
		}
		isComplete=true;
	}
	public boolean open(int w,int h) {
		if(!isComplete) {
		if(!arrayBoolean[w][h]) {
			arrayBoolean[w][h]=true;
			int number=arrayBoom[w][h];
				if(number!=-1) {
					arrayButton[w][h].setNumber(number);
					arrayButton[w][h].repaint();
					
					return true;
			}
		}
		if(arrayBoom[w][h]==-1) {
		return false;
	}else {
		return true;
	}}
		else {
			return false;
		}
		
	}
	
	//dem so boom
	public void demso() {
		for (int i = 0; i < arrayBoom.length; i++) {
			for (int j = 0; j < arrayBoom[i].length; j++) {
				if(arrayBoom[i][j]==0) {
					int count=0;
					for (int l = i-1; l <= i+1; l++) {
						for (int k = j-1; k <= j+1; k++) {
							if(l>=0 && l<=arrayBoom.length-1 && k>=0 && k<=arrayBoom[i].length-1) {
							if(arrayBoom[l][k]==-1) {
								count++;
							}}
						}
					}
				arrayBoom[i][j]=count;
				}
			}
		}
	}

	// tao bang min
	public void createArrayMin( int w, int h,int boom) {
		int locationX = rd.nextInt(w);
		int locationY = rd.nextInt(h);
		arrayBoom[locationX][locationY] = -1;
		int count = 1;
		while (count != boom) {
			locationX = rd.nextInt(w);
			locationY = rd.nextInt(h);
			if (arrayBoom[locationX][locationY] != -1) {
				arrayBoom[locationX][locationY] = -1;
				count = 0;
				for (int i = 0; i < arrayBoom.length; i++) {
					for (int j = 0; j < arrayBoom[i].length; j++) {
						if (arrayBoom[i][j] == -1) {
							count++;
						}
					}
				}
			}
		}
	}

	public ButtonPlayer[][] getArrayButton() {
		return arrayButton;
	}

	public void setArrayButton(ButtonPlayer[][] arrayButton) {
		this.arrayButton = arrayButton;
	}

	public ButtonSmile getButtonSmile() {
		return buttonSmile;
	}

	public void setButtonSmile(ButtonSmile buttonSmile) {
		this.buttonSmile = buttonSmile;
	}

	public LableNumber getLbTime() {
		return lbTime;
	}

	public void setLbTime(LableNumber lbTime) {
		this.lbTime = lbTime;
	}

	public LableNumber getLbBoom() {
		return lbBoom;
	}

	public void setLbBoom(LableNumber lbBoom) {
		this.lbBoom = lbBoom;
	}

}
