package My2DGame.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// this class is for setting up the game window and the game loop
// as well as sprites
public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // frames per second
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // set players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    } // end of GamePanel

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    } // end of startGameThread

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1) {
                
                update();
                repaint();
                delta--;
            
            }
        }
    } // end of run

    // method for updating on screen information in real time (60 FPS)
    // reads changes
    public void update() {

        if(keyH.upPressed == true) {

            playerY -= playerSpeed;

        }

        else if(keyH.downPressed == true) {

            playerY += playerSpeed;

        }

        else if(keyH.leftPressed == true) {

            playerX -= playerSpeed;

        }
        
        else if(keyH.rightPressed == true) {

            playerX += playerSpeed;

        }
    } // end of update

    // other method for updating on screen information in real time (60 FPS)
    // visualizes changes
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();

    } // end of paintComponent
} // end of class
