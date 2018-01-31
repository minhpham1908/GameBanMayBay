package game;

import core.Framecounter;
import core.GameObject;
import java.util.Random;

public class SquareSpawner extends GameObject {

    Framecounter framecounter;

    public SquareSpawner() {
        framecounter = new Framecounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (framecounter.run()) {
            Random random = new Random();
            Square square = new Square();
            square.position.set((int) (Math.random()*380+10), 0.0f);
            square.velocity.set(0.0f, random.nextInt(4) + 1);
            GameObject.add(square);
            framecounter.reset();
            this.deactiveIfNeeded();

        }
    }

    private void deactiveIfNeeded() {
        if (this.position.y >600)
            this.isAlive = false;
    }
}
