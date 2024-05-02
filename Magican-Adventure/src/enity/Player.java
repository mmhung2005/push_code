package enity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Enity{

	GamePanel gp;
	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH) {

		this.gp = gp;
		this.keyH = keyH;

		setDefaultValues();
		getPlayerImage();
	}
	// SET UP GTRI MẶC ĐỊNH
	public void setDefaultValues() {

		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	// SET UP ẢNH MAIN-CHAR
	public void getPlayerImage() {

		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/main_player/Up - Left.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/main_player/Up - Right.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/main_player/Down - Left.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/main_player/Down - Right.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/main_player/Right - Left.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/main_player/Right - Right.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/main_player/Left - Left.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/main_player/Left - Right.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		if(keyH.upPressed == true ||
				keyH.downPressed == true ||
				keyH.leftPressed == true ||
				keyH.rightPressed == true) {

			if(keyH.upPressed == true) {
				direction = "up";
				y -= speed;
			}
			else if(keyH.downPressed == true) {
				direction = "down";
				y += speed;
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
				x -= speed;
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}

			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}			
		}		
	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}			
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		default:
			break;
		}
		g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
	}

}
