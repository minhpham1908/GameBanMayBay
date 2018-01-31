import core.GameObject;

import java.awt.*;


public class Main {

        public static void main(String[] args) {

            StdDraw.setCanvasSize(400, 600);
            StdDraw.setXscale(0, 400);
            StdDraw.setYscale(0, 600);
            StdDraw.enableDoubleBuffering();
            StdDraw.picture(200, 400, "resources/background/background.png");
            StdDraw.setPenColor(StdDraw.RED);
            Font font = new Font("Impact", Font.BOLD, 34);
            StdDraw.setFont(font);
            StdDraw.text(200, 200, "Click to Start");
            Font font1 = new Font("Impact", Font.BOLD, 34);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.setFont(font1);
            StdDraw.text(200, 400, "Geo Arcade Master");

            while(true) {
                StdDraw.show();
                if (StdDraw.mousePressed()) {
                    GameWindow gameWindow = new GameWindow();
                    gameWindow.gameLoop();
                }
            }


    }
}
