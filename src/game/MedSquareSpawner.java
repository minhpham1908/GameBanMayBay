package game;

import core.Framecounter;
import core.GameObject;

public class MedSquareSpawner extends GameObject {

    private int count = 0;
    Framecounter framecounter;

    public MedSquareSpawner() {
        framecounter = new Framecounter(40);
    }

    @Override
    public void run() {
        super.run();
        if (framecounter.run()){
            MedSquare medSquare = new MedSquare();
            medSquare.position.set((int) (Math.random()*360 +20), 0);
            medSquare.velocity.set(0, (float) (Math.random()*4+1));
            GameObject.add(medSquare);
            framecounter.reset();
            this.deactiveIfNeeded();

        }
    }

    private void deactiveIfNeeded() {
        if (this.position.y >600)
            this.isAlive = false;
    }
}
