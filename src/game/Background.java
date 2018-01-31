package game;

import core.GameObject;
import core.Utils;

public class Background extends GameObject {
    public Background() {
        this.image = Utils.loadImage("resources/background/background.png");
        this.position.set(200,300);
    }
}
