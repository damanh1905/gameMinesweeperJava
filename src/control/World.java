package control;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;

import view.ButtonPlayer;
import view.ButtonSmile;
import view.GamePanel;
import view.LableNumber;

public class World {
	private Random rd;
	private ButtonPlayer[][] arrayButton;
	private boolean[][] arrayCamCo;
	private int[][] arrayBoom;// boom la so -1
	private boolean isComplete;
	private boolean isEnd;
	private int co;

	private boolean[][] arrayBoolean;
	private ButtonSmile buttonSmile;
	private LableNumber lbTime, lbBoom;
	private int boom;
	private GamePanel gamePanel;

	public World(int w, int h, int boom, GamePanel gamePanel) {
		this.boom = boom;
		this.gamePanel = gamePanel;
		arrayButton = new ButtonPlayer[w][h];
		arrayBoom = new int[w][h];
		arrayBoolean = new boolean[w][h];
		arrayCamCo = new boolean[w][h];
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

	public boolean doubleClick(int i, int j) {
		boolean coMin = false;
		for (int l = i - 1; l <= i + 1; l++) {
			for (int k = j - 1; k <= j + 1; k++) {
				if (l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k <= arrayBoom[i].length - 1) {
					if (!arrayCamCo[l][k]) {
						if (arrayBoom[l][k] == -1) {
							coMin = true;
							arrayButton[l][k].setNumber(12);
							arrayButton[l][k].repaint();
							arrayBoolean[l][k] = true;
						} else if (!arrayBoolean[l][k]) {
							arrayButton[l][k].setNumber(arrayBoom[l][k]);
							arrayButton[l][k].repaint();
							arrayBoolean[l][k] = true;
						}
					}

				}
			}
		}
		if (coMin) {
			for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
				for (int k = 0; k < arrayBoolean[i].length; k++) {
					if (arrayBoom[j2][k] == -1 && !arrayBoolean[j2][k]) {
						arrayButton[j2][k].setNumber(10);
						arrayButton[j2][k].repaint();

					}
				}
			}
			return false;
		}
		return true;
	}

	public void fullTrue() {
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					arrayBoolean[i][j] = true;
				}
			}
		}

	}

	public void camCo(int i, int j) {
		if (!arrayBoolean[i][j]) {
			if (arrayCamCo[i][j]) {
				co--;
				arrayCamCo[i][j] = false;
				arrayButton[i][j].setNumber(-1);
				arrayButton[i][j].repaint();
				gamePanel.getNotification().upDate();
			} else if (co < boom) {
				co++;
				arrayCamCo[i][j] = true;
				arrayButton[i][j].setNumber(9);
				arrayButton[i][j].repaint();
				gamePanel.getNotification().upDate();
			}

		}
	}

	public boolean open(int i, int j) {

		if (!isComplete && !isEnd) {

			if (!arrayBoolean[i][j]) {
				if (arrayBoom[i][j] == 0) {
					arrayBoolean[i][j] = true;
					arrayButton[i][j].setNumber(0);
					arrayButton[i][j].repaint();
					if (checkWin()) {
						isEnd = true;
						
						return false;
					}

					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k <= arrayBoom[i].length - 1) {
								if (!arrayBoolean[l][k]) {
									open(l, k);

								}
							}
						}
					}
					if (checkWin()) {
						isEnd = true;
					
						return false;
					}
				} else {

					arrayBoolean[i][j] = true;
					int number = arrayBoom[i][j];
					if (checkWin()) {
						isEnd = true;
					
						return false;
					}
					if (number != -1) {
						arrayButton[i][j].setNumber(number);
						arrayButton[i][j].repaint();

						return true;
					}

				}
			}
			if (arrayBoom[i][j] == -1) {
				arrayButton[i][j].setNumber(11);
				arrayButton[i][j].repaint();
				isComplete = true;
				for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
					for (int k = 0; k < arrayBoolean.length; k++) {
						if (arrayBoom[j2][k] == -1 && !arrayBoolean[j2][k]) {
							arrayButton[j2][k].setNumber(10);
							arrayButton[j2][k].repaint();
						}
					}
				}
				return false;
			} else {
				return true;
			}
		} else
			return false;

	}

//	check win
	public boolean checkWin() {
		int count = 0;
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					count++;
				}
			}
		}
		if (count == boom)
			return true;
		else
			return false;
	}

	// dem so boom
	public void demso() {
		for (int i = 0; i < arrayBoom.length; i++) {
			for (int j = 0; j < arrayBoom[i].length; j++) {
				if (arrayBoom[i][j] == 0) {
					int count = 0;
					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k <= arrayBoom[i].length - 1) {
								if (arrayBoom[l][k] == -1) {
									count++;
								}
							}
						}
					}
					arrayBoom[i][j] = count;
				}
			}
		}
	}

	// tao bang min
	public void createArrayMin(int w, int h, int boom) {
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

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean[][] getArrayCamCo() {
		return arrayCamCo;
	}

	public void setArrayCamCo(boolean[][] arrayCamCo) {
		this.arrayCamCo = arrayCamCo;
	}

	public boolean[][] getArrayBoolean() {
		return arrayBoolean;
	}

	public void setArrayBoolean(boolean[][] arrayBoolean) {
		this.arrayBoolean = arrayBoolean;
	}

	public int getCo() {
		return co;
	}

	public void setCo(int co) {
		this.co = co;
	}

}
