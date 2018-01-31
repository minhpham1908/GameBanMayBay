

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    public GameCanvas gameCanvas;

    private long lastTime = 0;

    public GameWindow() {
        this.setupWindow();
        setTitle("Geo Arcade~~");
    }

    private void setupWindow() {
        this.setSize(400, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.setVisible(true);
        this.eventWindow();
    }

    private void eventWindow() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.positionX = e.getX();
                gameCanvas.positionY = e.getY();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        this.lastTime = System.nanoTime();
        while (true) {
            long currentTime = System.nanoTime();

            if (currentTime - this.lastTime >= 16_000_000) {
                if (gameCanvas.player.isAlive) {
                    this.gameCanvas.run();
                    this.gameCanvas.render();
                }
                if (!(gameCanvas.player.isAlive)) {
                    gameCanvas.rendergo();
                    this.addMouseListener(new MouseInputAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            GameWindow.super.dispose();
                        }
                    });
                }
                this.lastTime = currentTime;
            }


        }
    }
}
