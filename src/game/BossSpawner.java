package game;

import core.Framecounter;
import core.GameObject;

public class BossSpawner extends GameObject {
    Framecounter framecounter;

    public BossSpawner() {
        framecounter = new Framecounter(1000);
    }

    @Override
    public void run() {
        super.run();
        if (framecounter.bossrun()) {
            Boss boss = new Boss();
            boss.position.set(200, 0);
            boss.velocity.set(0.0f, 1.0f);
            GameObject.add(boss);
        }
    }
}
