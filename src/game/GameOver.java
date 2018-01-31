package game;

import core.GameObject;
import core.Utils;

import java.awt.*;

public class GameOver extends GameObject {
    public GameOver() {
        this.image = Utils.loadImage("resources/background/gameover.png");
        this.position.set(200,300);
    }
    public GameOver(int a) {
        this.image = Utils.loadImage("resources/background/replay.png");
        this.position.set(200, 400);
    }
}
