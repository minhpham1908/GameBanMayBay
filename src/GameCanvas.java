import core.GameObject;
import game.*;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static game.Bullet.diemso;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    GameOver gameOver;
    GameOver gameOver2;
    Graphics2D graphics2D;
    Player player;
    public int positionX = 0;
    public int positionY = 0;

    public GameCanvas() {
        this.setupBackBuffer();
        this.setSize(400, 600);
        this.setVisible(true);
        gameOver = new GameOver();
        gameOver2 = new GameOver(2);
        gameOver.isAlive = false;
        this.player = new Player();
        GameObject.add(new Background());
        GameObject.add(this.player);
        GameObject.add(new SquareSpawner());
        GameObject.add(new MedSquareSpawner());
        GameObject.add(new BossSpawner());


    }

    private void setupBackBuffer() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics2D = (Graphics2D) this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
        g.drawString("POINT: " + diemso, 10, 10);
    }

    public void render() {
        GameObject.renderAll(this.graphics2D);
        this.repaint();
    }

    public  void rendergo() {
        gameOver.render(graphics2D);
        gameOver2.render(graphics2D);
    }
    public void run() {
        this.player.position.set(this.positionX, this.positionY -20);

        GameObject.runAll();
    }
}
