package enity;

import java.awt.image.BufferedImage;

public class Enity {
	public int x, y;
	public int speed;
	
				// 1: TRÁI	  2: PHẢI
	public BufferedImage up1, up2, right1, right2,
						down1, down2, left1, left2;
	public String direction;
	
			//BIẾN CHAR MOVE
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
